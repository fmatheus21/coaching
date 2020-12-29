package com.firecode.app.controller.dto;

import com.firecode.app.model.entity.CycleGenerateEntity;
import com.firecode.app.model.entity.ExerciseMindfulnessEntity;
import com.firecode.app.model.entity.SessionGenerateEntity;
import com.firecode.app.model.entity.SessionGenerateMindfulnessEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fmatheus
 */
public class SessionGenerateMindfulnessDto {

    @Getter
    @Setter
    private int id;
    @NotNull
    @Getter
    @Setter
    private int idSessionGenerate;
    @NotNull
    @Getter
    @Setter
    private int idExerciseMindfulness;
    @NotNull
    @NotBlank
    @Getter
    @Setter
    private String learning;
    @Getter
    @Setter
    private String session;
    @Getter
    @Setter
    private String step;
    @Getter
    @Setter
    private String exercise;
    @Getter
    @Setter
    private boolean disabledComponent;
    @Getter
    @Setter
    private String file;
    private static String pathFileMindfulness = "/app/upload/media/audio/mindfulness/";

    public SessionGenerateMindfulnessEntity create(SessionGenerateMindfulnessDto dto) {

        var entity = new SessionGenerateMindfulnessEntity();
        entity.setIdSessionGenerate(new SessionGenerateEntity(dto.getIdSessionGenerate()));
        entity.setIdExerciseMindfulness(new ExerciseMindfulnessEntity(dto.getIdExerciseMindfulness()));
        entity.setLearning(dto.getLearning());

        return entity;

    }

    public List<SessionGenerateMindfulnessDto> listSessionGenerateMindfulnessDto(CycleGenerateEntity cycleGenerate) {

        List<SessionGenerateMindfulnessDto> list = new ArrayList<>();

        for (SessionGenerateEntity entity : cycleGenerate.getSessionGenerateEntityCollection()) {
            if (entity.getIdSessionStepMapping().getId() == 9) {

                list = entity.getSessionGenerateMindfulnessEntityCollection()
                        .stream().map(SessionGenerateMindfulnessDto::converterObject).collect(Collectors.toList());
                break;
            }
        }

        return list;

    }

    /* Cria uma instancia de SessionGenerateMindfulnessDto e adiciona os valores de IdSessionGenerate e IdExerciseMindfulness
    do coachee que esta sendo consultado
     */
    public SessionGenerateMindfulnessDto newSessionGenerateMindfulness(List<SessionGenerateMindfulnessDto> listSessionGenerateMindfulness) {

        var dto = new SessionGenerateMindfulnessDto();

        for (SessionGenerateMindfulnessDto mindfulness : listSessionGenerateMindfulness) {
            dto.setIdSessionGenerate(mindfulness.getIdSessionGenerate());
            if (mindfulness.getIdExerciseMindfulness() == 1) {
                dto.setFile(pathFileMindfulness + mindfulness.getFile());
                System.out.println("File 1: " + pathFileMindfulness + mindfulness.getFile());
            }
            //dto.setIdExerciseMindfulness(mindfulness.getIdExerciseMindfulness());
            break;
        }

        return dto;
    }

    public static SessionGenerateMindfulnessDto converterObject(SessionGenerateMindfulnessEntity entity) {

        var dto = new SessionGenerateMindfulnessDto();
        dto.setId(entity.getId());
        dto.setIdSessionGenerate(entity.getIdSessionGenerate().getId());
        dto.setIdExerciseMindfulness(entity.getIdExerciseMindfulness().getId());
        dto.setLearning(entity.getLearning());
        dto.setSession(entity.getIdSessionGenerate().getIdSession().getName());
        dto.setStep(entity.getIdSessionGenerate().getIdSessionStepMapping().getIdStep().getName());
        dto.setExercise(entity.getIdExerciseMindfulness().getName());
        dto.setDisabledComponent(entity.isDisabled());
        dto.setFile(pathFileMindfulness + entity.getIdExerciseMindfulness().getFileName());
        System.out.println("File 2: " + pathFileMindfulness + entity.getIdExerciseMindfulness().getFileName());

        return dto;

    }

}
