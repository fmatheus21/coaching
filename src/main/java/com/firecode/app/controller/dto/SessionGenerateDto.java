package com.firecode.app.controller.dto;

import com.firecode.app.controller.enumerable.DoneEnum;
import com.firecode.app.model.entity.CycleGenerateEntity;
import com.firecode.app.model.entity.SessionGenerateEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fmatheus
 */
public class SessionGenerateDto {

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private int idCycleGenerate;
    @Getter
    @Setter
    private int idSessionStepMapping;
    @Getter
    @Setter
    private int idSession;
    @Getter
    @Setter
    private int idStep;
    @Getter
    @Setter
    private String step;
    @Getter
    @Setter
    private String session;
    @Getter
    @Setter
    private String done;
    @Getter
    @Setter
    private int order;

    public List<SessionGenerateDto> listSessionGenerate(CycleGenerateEntity cycleGenerate, int idSession) {

        /* Retorna uma lista da tabela session_generate filtrado pelo idSession informado */
        List<SessionGenerateEntity> list = cycleGenerate.getSessionGenerateEntityCollection()
                .stream()
                .filter(c -> c.getIdSession().getId() == idSession)
                .collect(Collectors.toList());

        list.stream().forEach(
                object
                -> System.out.println("Print: " + object.getIdSession().getName())
        );

        List<SessionGenerateDto> listSessionGenerateDto = list.stream().map(SessionGenerateDto::converterObject).collect(Collectors.toList());

        return listSessionGenerateDto;

    }

    public static SessionGenerateDto converterObject(SessionGenerateEntity sessionGenerate) {

        var sessionGenerateDto = new SessionGenerateDto();
        sessionGenerateDto.setId(sessionGenerate.getId());
        sessionGenerateDto.setIdSession(sessionGenerate.getIdSession().getId());
        sessionGenerateDto.setStep(sessionGenerate.getIdSessionStepMapping().getIdStep().getName());
        sessionGenerateDto.setOrder(sessionGenerate.getIdSessionStepMapping().getOrder());
        sessionGenerateDto.setIdStep(sessionGenerate.getIdSessionStepMapping().getIdStep().getId());
        sessionGenerateDto.setSession(sessionGenerate.getIdSession().getName());
        sessionGenerateDto.setIdSessionStepMapping(sessionGenerate.getIdSessionStepMapping().getId());
        if (sessionGenerate.getDone() == true) {
            sessionGenerateDto.setDone(DoneEnum.CONCLUIDO.getDescription());
        } else if (sessionGenerate.getDone() == false) {
            sessionGenerateDto.setDone(DoneEnum.ABERTO.getDescription());
        }

        return sessionGenerateDto;

    }

}
