package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.CoacheeDto;
import com.firecode.app.model.service.CoacheeService;
import com.firecode.app.model.service.ContactService;
import com.firecode.app.model.service.PersonService;
import com.firecode.app.model.service.UserService;
import com.firecode.app.controller.util.AppUtil;
import com.firecode.app.controller.util.MessageValidationUtil;
import com.firecode.app.controller.util.PathUtil;
import com.firecode.app.controller.util.UploadMultipartFileUtil;
import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.ContactEntity;
import com.firecode.app.model.entity.PersonEntity;
import com.firecode.app.model.repository.filter.RepositoryFilter;
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

@Component
public class CoacheeRule {

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
    private UserService userService;

    @Autowired
    private UploadRule uploadRule;
    
    @Autowired
    private SessionRule sessionRule;

    private CoacheeDto coacheeDto;

    @Autowired
    private PathUtil pathUtil;

    public CoacheeDto init(HttpServletRequest request, HttpServletResponse response) {
        if (cookieRule.readerCookie(request, response) == null) {
            return coacheeDto = new CoacheeDto();
        }
        return coacheeDto;
    }

    public String pathAvatar() {
        return pathUtil.getPathUpload() + pathUtil.getPathAvatarCoachee();
    }

    public String create(CoacheeDto dto, BindingResult result, RedirectAttributes attributes, UploadMultipartFileUtil upload, HttpServletRequest request, HttpServletResponse response) {

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

        String fileName = this.saveImage(files, dto.getIdGender());

        try {
            coacheeDto = new CoacheeDto();
            personService.create(coacheeDto.create(dto, sessionRule.storeUser().getId(), fileName));
            attributes.addFlashAttribute(messageValidationUtil.getAttributeSuccess(), messageValidationUtil.getSuccessCreate());
            cookieRule.deleteCookie(request, response);
        } catch (DataIntegrityViolationException ex) {
            attributes.addFlashAttribute(messageValidationUtil.getAttributeError(), ex.getMessage());
        }

        return redirect;

    }

    public String update(int id, CoacheeDto dto, BindingResult result, RedirectAttributes attributes, UploadMultipartFileUtil upload, HttpServletRequest request, HttpServletResponse response) {

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
            fileName = this.saveImage(files, dto.getIdGender());
        }

        try {
            coacheeDto = new CoacheeDto();
            PersonEntity person = coacheeDto.update(coachee.getIdPerson(), dto, userService.findByUser("fmatheus").orElse(null));
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
        //return coacheeService.findAll("id").stream().map(CoacheeDto::converterObject).collect(Collectors.toList());
    }

    public CoacheeDto findById(int id) {

        System.out.println("ID: " + id);

        CoacheeEntity coachee = coacheeService.findById(id);
        return coacheeDto.find(coachee, this.pathAvatar());

        /* coacheeDto = new CoacheeDto();
        CoacheeEntity coachee = coacheeService.findById(id);
        if (coachee == null) {
            return null;
        }
        return coacheeDto.find(coachee, this.pathAvatar());*/
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

    private String saveImage(MultipartFile[] files, int gender) {

        String fileName = null;
        int number = 0;

        for (MultipartFile multipartFile : files) {
            if (multipartFile.getSize() == 0) {
                fileName = uploadRule.copyFile(gender);
            } else {
                number++;
                fileName = uploadRule.saveFileSingle(multipartFile, this.pathAvatar(), number, 700, 700, false);
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
