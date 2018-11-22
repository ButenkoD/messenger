package com.andersen.messenger.entity;

import javax.validation.constraints.NotNull;

public class Device extends BaseEntity {
    @NotNull(message = "Id should not be empty")
    private Integer id;
    @NotNull(message = "Name should not be empty")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Device id :" + id + ", name: " + name;
    }

    public void onMessage(Message m) {
        System.out.println("following message is received:"+m.getText());
    }
}
