package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.CoacheeDto;
import com.firecode.app.controller.dto.CycleGenerateDto;
import com.firecode.app.controller.security.AppUserSecurity;
import com.firecode.app.model.service.CoacheeService;
import com.firecode.app.model.service.ContactService;
import com.firecode.app.model.service.PersonService;
import com.firecode.app.controller.util.AppUtil;
import com.firecode.app.controller.util.MessageValidationUtil;
import com.firecode.app.controller.util.PathUtil;
import com.firecode.app.controller.util.UploadMultipartFileUtil;
import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.ContactEntity;
import com.firecode.app.model.entity.CycleEntity;
import com.firecode.app.model.entity.CycleGenerateEntity;
import com.firecode.app.model.entity.PersonEntity;
import com.firecode.app.model.entity.SessionEntity;
import com.firecode.app.model.entity.SessionStepMappingEntity;
import com.firecode.app.model.entity.UserEntity;
import com.firecode.app.model.repository.filter.RepositoryFilter;
import com.firecode.app.model.service.CycleGenerateService;
import com.firecode.app.model.service.SessionStepMappingService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CoacheeRule {

    private static final Logger log = LoggerFactory.getLogger(CoacheeRule.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private CoacheeService coacheeService;

    @Autowired
    private MessageValidationUtil messageValidationUtil;

    @Autowired
    private CookieRule cookieRule;

    @Autowired
    private UploadRule uploadRule;

    private CoacheeDto coacheeDto;

    @Autowired
    private PathUtil pathUtil;

    @Autowired
    private SessionStepMappingService sessionStepMappingService;

    @Autowired
    private CycleGenerateService cycleGenerateService;

    public CoacheeDto init(HttpServletRequest request, HttpServletResponse response) {
        if (cookieRule.readerCookie(request, response) == null) {
            return coacheeDto = new CoacheeDto();
        }
        return coacheeDto;
    }

    public String pathAvatar() {
        return pathUtil.getPathUpload() + pathUtil.getPathAvatarCoachee();
    }

    public String create(CoacheeDto dto, BindingResult result, RedirectAttributes attributes, UploadMultipartFileUtil upload, HttpServletRequest request, HttpServletResponse response, AppUserSecurity appUserSecurity) {

        String redirect = "redirect:/coachees/create";

        /* Verifica se os campos obrigatorios foram preenchidos */
        if (result.hasErrors()) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorRequired());
            return this.errorRedirect(dto, request, response);
        }

        /* Verifica se o cpf/cnpj ja existe */
        PersonEntity person = personService.findBycpfCnpj(AppUtil.removeSpecialCharacters(dto.getCpf()));
        if (person != null) {
            if (person.getCoacheeEntity() != null) {
                attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), "O CPF informado já está cadastrado!");
                return this.errorRedirect(dto, request, response);
            }
        }

        /* Verifica se o email ja esta cadastrado */
        ContactEntity contact = contactService.findByEmail(dto.getEmail());
        if (contact != null) {
            if (contact.getIdPerson().getCoacheeEntity() != null) {
                attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), "O email informado já está cadastrado!");
                return this.errorRedirect(dto, request, response);
            }
        }

        long size = 0;
        long total = pathUtil.getFileSizeTotal();
        MultipartFile[] files = upload.getFileDatas();

        /* Soma o tamanho de todas as imagens anexadas */
        for (MultipartFile multipartFile : files) {
            String name = multipartFile.getOriginalFilename();
            if (name != null && name.length() > 0) {
                size = size + multipartFile.getSize();
            }
        }

        /* Verifica se as imagens anexadas ultrapassam o limite de upload informada no arquivo application.properties */
        if (size > total) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), "Tamanho da imagem exedido. Tamanho máximo de 1MB");
            return this.errorRedirect(dto, request, response);
        }

        String fileName = this.saveImage(files, dto.getIdGender(), false);

        try {
            coacheeDto = new CoacheeDto();
            personService.create(coacheeDto.create(dto, new UserEntity(appUserSecurity.getIdUser()), fileName));
            attributes.addFlashAttribute(messageValidationUtil.getAttributeSuccess(), messageValidationUtil.getSuccessCreate());
            cookieRule.deleteCookie(request, response);
        } catch (DataIntegrityViolationException ex) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), ex.getMessage());
        }

        return redirect;

    }

    public String update(int id, CoacheeDto dto, BindingResult result, RedirectAttributes attributes, UploadMultipartFileUtil upload, HttpServletRequest request, HttpServletResponse response, AppUserSecurity appUserSecurity) {

        String redirect = "redirect:/coachees/update/" + id;

        if (result.hasErrors()) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorRequired());
            return this.errorRedirect(dto, request, response);
        }

        CoacheeEntity coachee = coacheeService.findById(id);
        if (coachee == null) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorNotFound());
            return "redirect:/coachees";
        }

        long size = 0;
        long total = pathUtil.getFileSizeTotal();
        String fileName = null;
        MultipartFile[] files = upload.getFileDatas();

        for (MultipartFile multipartFile : files) {
            String name = multipartFile.getOriginalFilename();
            if (name != null && name.length() > 0) {
                size = size + multipartFile.getSize();
            }
        }

        if (size > total) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), "Tamanho da imagem exedido. Tamanho máximo de 1MB");
            return this.errorRedirect(dto, request, response);
        }

        if (size > 0) {
            fileName = this.saveImage(files, dto.getIdGender(), true);
        }

        try {
            coacheeDto = new CoacheeDto();
            PersonEntity person = coacheeDto.update(coachee.getIdPerson(), dto, new UserEntity(appUserSecurity.getIdUser()));
            personService.create(person);
            attributes.addFlashAttribute(messageValidationUtil.getAttributeSuccess(), messageValidationUtil.getSuccessCreate());
        } catch (DataIntegrityViolationException ex) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), "O CPF ou email já está cadastrado.");
        }

        return redirect;

    }

    private String errorRedirect(CoacheeDto dto, HttpServletRequest request, HttpServletResponse response) {
        String redirect = "redirect:/coachees/create";
        coacheeDto = dto;
        cookieRule.createCookie(request, response);
        return redirect;
    }

    public Page<CoacheeDto> findAllPaginator(RepositoryFilter filter, Pageable pageable) {
        return coacheeService.findAllPaginator(filter, pageable).map(CoacheeDto::converterObject);
    }

    public CoacheeDto findById(int id) {

        CoacheeEntity coachee = coacheeService.findById(id);

        if (coachee == null) {
            return null;
        }

        return CoacheeDto.converterObject(coachee);

    }

    public String delete(int id, RedirectAttributes attributes) {

        String redirect = "redirect:/coachees";

        CoacheeEntity coachee = coacheeService.findById(id);

        if (coachee == null) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorNotFound());
            return redirect;
        }

        try {
            personService.deleteById(coachee.getIdPerson().getId());
            attributes.addFlashAttribute(messageValidationUtil.getAttributeSuccess(), messageValidationUtil.getSuccessCreate());
        } catch (DataIntegrityViolationException ex) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), ex.getMessage());
        }
        return redirect;

    }

    public String createCycle(int idCoachee, RedirectAttributes attributes, AppUserSecurity appUserSecurity) {

        String redirect = "redirect:/coachees";

        int numberCycle = 0;

        /* Lista os ciclos do coachee e verifica se existe algum aberto. */
        for (CycleGenerateEntity cycleGenerate : cycleGenerateService.findByIdCoachee(new CoacheeEntity(idCoachee))) {
            /* Se houver um ciclo nao concluido */
            if (cycleGenerate.getDone() == false) {
                attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorCycleOpen());
                return redirect;
            }

            /* Se os ciclos listados estiverem concluidos, atribui o id do cliclo a variavel numberCycle */
            numberCycle = cycleGenerate.getIdCycle().getId();
        }

        /* Se houver o ciclo 10 gera um erro */
        if (numberCycle == 10) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorCycleClosed());
            return redirect;
        }

        /* Se nao houver o ciclo 10, pega o ultimo ciclo e adiciona mais 1 */
        int newCycle = numberCycle + 1;
        var user = new UserEntity(appUserSecurity.getIdUser());
        String cycleCoache = String.valueOf(newCycle) + String.valueOf(idCoachee);

        List<SessionStepMappingEntity> listSessionStep = sessionStepMappingService.findByIdSession(new SessionEntity(1));
        var cycleGenerate = new CycleGenerateDto().createCycle(listSessionStep, new CoacheeEntity(idCoachee), newCycle, Integer.parseInt(cycleCoache), user);

        try {
            cycleGenerateService.create(cycleGenerate);
            attributes.addFlashAttribute(messageValidationUtil.getAttributeSuccess(), messageValidationUtil.getSuccessCycleCreate());
            log.info(messageValidationUtil.getSuccessCycleCreate());
        } catch (DataIntegrityViolationException ex) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), ex.getMessage());
            log.error(ex.getMessage());
        }

        return redirect;

    }

    /* Busca o registro da tabela cycle_generate pelo idCoachee e idCycle */
    public CycleGenerateDto findCycleByCoachee(int idCoachee, int idCycle, RedirectAttributes attributes) {
     
        var cycleGenerate = cycleGenerateService.findByIdCoacheeAndIdCycle(new CoacheeEntity(idCoachee), new CycleEntity(idCycle));

        if (cycleGenerate == null) {
            return null;
        }

        return CycleGenerateDto.converterObject(cycleGenerate);

    }

    private String saveImage(MultipartFile[] files, int gender, boolean update) {

        String fileName = null;
        int number = 0;

        for (MultipartFile multipartFile : files) {
            if (multipartFile.getSize() == 0) {
                System.out.println(" entrou no if");
                fileName = uploadRule.copyFile(gender);
            } else {
                System.out.println(" entrou no else");
                number++;
                fileName = uploadRule.saveFileSingle(multipartFile, this.pathAvatar(), number, 700, 700, update);
            }
        }

        return fileName;

    }

    public String validationRedirect(String redirectSuccess, String redirectFailure, Object object, RedirectAttributes attributes) {

        if (object == null) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), messageValidationUtil.getErrorNotFound());
            return redirectFailure;
        }

        return redirectSuccess;
    }

}
