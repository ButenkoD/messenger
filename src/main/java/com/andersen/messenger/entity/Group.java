package com.andersen.messenger.entity;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashMap;

public class Group extends BaseEntity implements MessageListener {
    @NotNull(message = "Id should not be empty")
    private Integer id;
    @NotNull(message = "Name should not be empty")
    private String name;
    private HashMap<Integer, Device> devices = new HashMap<>();

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

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
    }
    public void removeDevice(Integer id) {
        devices.remove(id);
    }

    public Collection<Device> getDevices() {
        return devices.values();
    }

    @Override
    public String toString() {
        String devicesString = "";
        for (Device device: devices.values()) {
            devicesString += device.toString();
        }
        return "Group id :" + id + ", name: " + name + "\n"
                + "Devices:\n" + devicesString + "\n";
    }

    public void onMessage(Message m) {
        try {
            TextMessage msg = (TextMessage)m;

            System.out.println("following message is received:"+msg.getText());
        }
        catch (JMSException e){
            System.out.println(e);
        }
    }
}
