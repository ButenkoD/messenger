package com.andersen.messenger.repository.impl;

import com.andersen.messenger.entity.Device;
import com.andersen.messenger.repository.DeviceRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class DeviceRepositoryImpl extends BaseRepositoryImpl implements DeviceRepository {
    public Device findDevice(Integer id) {
        return (Device) findEntity(id);
    }
    public Collection<Device> getAll() {
        return map.values();
    }
    public boolean addDevice(Device device) {
        return addEntity(device);
    }

    public boolean removeDevice(Integer id) {
        return removeEntity(id);
    }
}
