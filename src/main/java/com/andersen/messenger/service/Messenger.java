package com.andersen.messenger.service;

import com.andersen.messenger.entity.Device;
import com.andersen.messenger.entity.Group;
import com.andersen.messenger.entity.Message;
import com.andersen.messenger.repository.DeviceRepository;
import com.andersen.messenger.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Messenger {
    private final DeviceRepository deviceRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public Messenger(
            DeviceRepository deviceRepository,
            GroupRepository groupRepository
    ) {
        this.deviceRepository = deviceRepository;
        this.groupRepository = groupRepository;
    }
    public boolean applyMessage(Message message) {
        if (message.getDeviceId() != null) {
            return handleMessageToDevice(message);
        }
        if (message.getGroupId() != null) {
            return handleMessageToGroup(message);
        }
        return handleMessageToAll(message);
    }

    private boolean handleMessageToDevice(Message message) {
        Device device = deviceRepository.findDevice(message.getDeviceId());
        if (device != null) {
            device.onMessage(message);
            return true;
        }
        return false;
    }
    private boolean handleMessageToGroup(Message message) {
        Group group = groupRepository.findGroup(message.getGroupId());
        System.out.println(group);
        if (group != null) {
            for (Device device: group.getDevices()) {
                device.onMessage(message);
            }
            return true;
        }
        return false;

    }
    private boolean handleMessageToAll(Message message) {
        for (Device device: deviceRepository.getAll()) {
            device.onMessage(message);
        }
        return true;
    }
}
