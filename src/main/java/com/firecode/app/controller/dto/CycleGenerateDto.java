package com.firecode.app.controller.dto;

import com.firecode.app.controller.util.FormatLocalDatetUtil;
import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.CycleEntity;
import com.firecode.app.model.entity.CycleGenerateEntity;
import com.firecode.app.model.entity.SessionGenerateEntity;
import com.firecode.app.model.entity.SessionStepMappingEntity;
import com.firecode.app.model.entity.UserEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

        generate.setUrlCycle("/coachees/" + cycleGenerate.getIdCoachee().getId() + "/cycle/" + cycleGenerate.getIdCycle().getId() + "/view");

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

}
