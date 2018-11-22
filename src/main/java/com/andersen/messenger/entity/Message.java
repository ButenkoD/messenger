package com.andersen.messenger.entity;

import javax.validation.constraints.NotNull;

public class Message {
    @NotNull(message = "ext should not be empty")
    private String text;
    private Integer deviceId;
    private Integer groupId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
