package com.andersen.messenger.api;

import com.andersen.messenger.repository.DeviceGroupRepository;
import com.andersen.messenger.repository.DeviceRepository;
import com.andersen.messenger.repository.GroupRepository;
import com.andersen.messenger.service.Messenger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({
        MessageController.class,
        ListenersController.class,
        Messenger.class,
        DeviceRepository.class,
        GroupRepository.class,
        DeviceGroupRepository.class
})
public class MessageControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    Messenger messenger;

    @Autowired
    DeviceRepository deviceRepository;

    @Before
    public void prepareDevice() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        mockMvc.perform(post("/device")
                .param("id", "1")
                .param("name", "Device name"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/group")
                .param("id", "4")
                .param("name", "Group name"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/addDeviceToGroup")
                .param("deviceId", "1")
                .param("groupId", "4"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddDeviceMessage() throws Exception {
        mockMvc.perform(post("/message")
                .param("text", "Test message text")
                .param("deviceId", "1"))
                .andExpect(status().isOk());
        assertThat(outContent.toString(), containsString("following message is received:Test message text"));

    }

    @Test
    public void testAddGroupMessage() throws Exception {
        mockMvc.perform(post("/message")
                .param("text", "Test message text")
                .param("groupId", "4"))
                .andExpect(status().isOk());
        assertThat(outContent.toString(), containsString("following message is received:Test message text"));

    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
