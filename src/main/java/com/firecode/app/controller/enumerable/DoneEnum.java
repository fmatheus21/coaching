package com.firecode.app.controller.enumerable;

/**
 *
 * @author fmatheus
 */
public enum DoneEnum {

    CONCLUIDO("Concluído"),
    ABERTO("Aberto");

    private String description;

    private DoneEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
