package com.andersen.messenger.api;


import com.andersen.messenger.repository.DeviceGroupRepository;
import com.andersen.messenger.repository.DeviceRepository;
import com.andersen.messenger.repository.GroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({ListenersController.class, DeviceRepository.class, GroupRepository.class})
public class ListenersControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    GroupRepository groupRepository;
    @MockBean
    DeviceGroupRepository deviceGroupRepository;

    @Test
    public void testAddDevice() throws Exception {
        mockMvc.perform(post("/device")
                .param("id", "1")
                .param("name", "Test name"))
                .andExpect(status().isOk());
        assertEquals(deviceRepository.findDevice(1).getName(), "Test name");
    }

    @Test
    public void testAddGroup() throws Exception {
        mockMvc.perform(post("/group")
                .param("id", "1")
                .param("name", "Test name"))
                .andExpect(status().isOk());
        assertEquals(groupRepository.findGroup(1).getName(), "Test name");
    }
}
