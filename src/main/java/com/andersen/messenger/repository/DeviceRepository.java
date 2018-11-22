package com.andersen.messenger.repository;

import com.andersen.messenger.entity.Device;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DeviceRepository {
    Device findDevice(Integer id);
    Collection<Device> getAll();
    boolean addDevice(Device device);
    boolean removeDevice(Integer id);
}
