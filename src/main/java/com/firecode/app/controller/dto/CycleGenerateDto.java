package com.firecode.app.controller.dto;

import com.firecode.app.controller.util.FormatLocalDatetUtil;
import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.CycleEntity;
import com.firecode.app.model.entity.CycleGenerateEntity;
import com.firecode.app.model.entity.SessionGenerateEntity;
import com.firecode.app.model.entity.SessionStepMappingEntity;
import com.firecode.app.model.entity.UserEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fmatheus
 */
public class CycleGenerateDto {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String cycle;
    @Getter
    @Setter
    private String coachee;
    @Getter
    @Setter
    private String createdAt;
    @Getter
    @Setter
    private String done;
    @Getter
    @Setter
    private String urlCycle;
    @Getter
    @Setter
    private List<SessionDto> listSession;

    public static CycleGenerateDto converterObject(CycleGenerateEntity cycleGenerate) {

        var generate = new CycleGenerateDto();
        generate.setCycle(cycleGenerate.getIdCycle().getName());
        generate.setCoachee(cycleGenerate.getIdCoachee().getIdPerson().getNameCompanyname());
        generate.setCreatedAt(FormatLocalDatetUtil.converterLocalDateTimeToString(cycleGenerate.getCreatedAt()));
      
        if (cycleGenerate.getDone() == true) {
            generate.setDone("Fechado");
        } else if (cycleGenerate.getDone() == false) {
            generate.setDone("Aberto");
        }

        generate.setListSession(groupSession(cycleGenerate));

        generate.setUrlCycle("/coachees/" + cycleGenerate.getIdCoachee().getId() + "/cycle/" + cycleGenerate.getIdCycle().getId() + "/session/1/view");

        return generate;

    }

    public CycleGenerateEntity createCycle(List<SessionStepMappingEntity> listSessionStep, CoacheeEntity coachee, int newCycle, int cycleCoache, UserEntity user) {
        var cycleGenerate = new CycleGenerateEntity();
        cycleGenerate.setIdCycle(new CycleEntity(newCycle));
        cycleGenerate.setIdCoachee(coachee);
        cycleGenerate.setCycleCoache(cycleCoache);
        cycleGenerate.setIdCreatedUser(user);
        cycleGenerate.setIdUpdatedUser(user);
        cycleGenerate.setCreatedAt(FormatLocalDatetUtil.currentDateTime());
        cycleGenerate.setUpdatedAt(FormatLocalDatetUtil.currentDateTime());
        cycleGenerate.setDone(false);

        List<SessionGenerateEntity> listSessionGenerate = new ArrayList<>();

        for (SessionStepMappingEntity sessionStep : listSessionStep) {
            var sessionGenerate = new SessionGenerateEntity();
            sessionGenerate.setIdSessionStepMapping(sessionStep);
            sessionGenerate.setIdCreatedUser(user);
            sessionGenerate.setIdUpdatedUser(user);
            sessionGenerate.setCreatedAt(FormatLocalDatetUtil.currentDateTime());
            sessionGenerate.setUpdatedAt(FormatLocalDatetUtil.currentDateTime());
            sessionGenerate.setDone(false);
            sessionGenerate.setIdCycleGenerate(cycleGenerate);
            listSessionGenerate.add(sessionGenerate);
        }

        cycleGenerate.setSessionGenerateEntityCollection(listSessionGenerate);

        return cycleGenerate;
    }

    private static List<SessionDto> groupSession(CycleGenerateEntity cycleGenerate) {

        Collection<SessionGenerateEntity> list = cycleGenerate.getSessionGenerateEntityCollection();

        List<SessionDto> listSessionDto = new ArrayList<>();

        
        /* Lista os registros da tabela session_generate referente ao coachee selecionado.
        Verifica as sessoes que o coache tem e faz um switch para que a lista nao tenha
        sesoes repetidas. Esse lista servira para preencher um selec na view, por isso, 
        as sessoes nao podem se repetir.
        */
        OUTER:
        for (SessionGenerateEntity session : list) {

            if (null != session.getIdSession().getId()) {
                switch (session.getIdSession().getId()) {
                    case 1:
                        listSessionDto.add(SessionDto.converterObject(session.getIdSession()));
                        break OUTER;
                    case 2:
                        listSessionDto.add(SessionDto.converterObject(session.getIdSession()));
                        break OUTER;
                    case 3:
                        listSessionDto.add(SessionDto.converterObject(session.getIdSession()));
                        break OUTER;
                    case 4:
                        listSessionDto.add(SessionDto.converterObject(session.getIdSession()));
                        break OUTER;
                    case 5:
                        listSessionDto.add(SessionDto.converterObject(session.getIdSession()));
                        break OUTER;
                    case 6:
                        listSessionDto.add(SessionDto.converterObject(session.getIdSession()));
                        break OUTER;
                    case 7:
                        listSessionDto.add(SessionDto.converterObject(session.getIdSession()));
                        break OUTER;
                    case 8:
                        listSessionDto.add(SessionDto.converterObject(session.getIdSession()));
                        break OUTER;
                    case 9:
                        listSessionDto.add(SessionDto.converterObject(session.getIdSession()));
                        break OUTER;
                    case 10:
                        listSessionDto.add(SessionDto.converterObject(session.getIdSession()));
                        break OUTER;
                    default:
                        break;
                }
            }

        }

        return listSessionDto;
    }

}
