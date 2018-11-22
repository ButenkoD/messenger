package com.andersen.messenger.entity;

import javax.validation.constraints.NotNull;

public class RemoveRequest {
    @NotNull(message = "Id should not be empty")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
