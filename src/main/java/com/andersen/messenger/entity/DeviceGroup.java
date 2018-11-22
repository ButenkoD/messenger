package com.andersen.messenger.entity;

import javax.validation.constraints.NotNull;

public class DeviceGroup {
    @NotNull(message = "deviceId should not be empty")
    private Integer deviceId;
    @NotNull(message = "groupId should not be empty")
    private Integer groupId;

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
