package com.firecode.app.controller.dto;

import com.firecode.app.controller.util.FormatLocalDatetUtil;
import com.firecode.app.model.entity.CycleGenerateEntity;
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

        return generate;

    }

}
