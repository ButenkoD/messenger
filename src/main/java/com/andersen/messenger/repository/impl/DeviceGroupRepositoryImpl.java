package com.andersen.messenger.repository.impl;

import com.andersen.messenger.entity.Device;
import com.andersen.messenger.entity.DeviceGroup;
import com.andersen.messenger.entity.Group;
import com.andersen.messenger.repository.DeviceGroupRepository;
import com.andersen.messenger.repository.DeviceRepository;
import com.andersen.messenger.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DeviceGroupRepositoryImpl implements DeviceGroupRepository {
    private final GroupRepository groupRepository;
    private final DeviceRepository deviceRepository;

    @Autowired
    DeviceGroupRepositoryImpl(
            GroupRepository groupRepository,
            DeviceRepository deviceRepository
    ) {
        this.groupRepository = groupRepository;
        this.deviceRepository = deviceRepository;
    }

    public boolean addDeviceToGroup(DeviceGroup deviceGroup) {
        Group group = groupRepository.findGroup(deviceGroup.getGroupId());
        Device device = deviceRepository.findDevice(deviceGroup.getDeviceId());
        if (group != null && device != null) {
            group.addDevice(device);
            System.out.println(group);
            return true;
        }
        System.out.println(group);
        return false;
    }

    public boolean removeDeviceFromGroup(DeviceGroup deviceGroup) {
        Group group = groupRepository.findGroup(deviceGroup.getGroupId());
        Device device = deviceRepository.findDevice(deviceGroup.getDeviceId());
        if (group != null && device != null) {
            group.removeDevice(device.getId());
            System.out.println(group);
            return true;
        }
        System.out.println(group);
        return false;
    }
}
