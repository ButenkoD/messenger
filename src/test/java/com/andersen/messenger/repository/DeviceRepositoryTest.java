package com.andersen.messenger.repository;

import com.andersen.messenger.entity.Device;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceRepositoryTest {
    @Autowired
    private DeviceRepository deviceRepository;

    @Test
    public void addDevice() {
        Device device = new Device();
        device.setId(1);
        device.setName("Test name");
        deviceRepository.addDevice(device);
        Device result = deviceRepository.findDevice(1);
        assertThat(result.toString(), containsString("Test name"));
    }

    @Test
    public void removeDevice() {
        Device device1 = new Device();
        device1.setId(1);
        device1.setName("Test name 1");
        Device device2 = new Device();
        device2.setId(2);
        device2.setName("Test name 2");
        deviceRepository.addDevice(device1);
        deviceRepository.addDevice(device2);
        assertEquals(deviceRepository.getAll().size(), 2);
        deviceRepository.removeDevice(1);
        assertEquals(deviceRepository.getAll().size(), 1);
    }
}
