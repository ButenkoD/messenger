package com.andersen.messenger.repository;

import com.andersen.messenger.entity.DeviceGroup;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceGroupRepository {
    boolean addDeviceToGroup(DeviceGroup deviceGroup);
    boolean removeDeviceFromGroup(DeviceGroup deviceGroup);
}
