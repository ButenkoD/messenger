package com.andersen.messenger.api;

import com.andersen.messenger.entity.Device;
import com.andersen.messenger.entity.DeviceGroup;
import com.andersen.messenger.entity.Group;
import com.andersen.messenger.entity.RemoveRequest;
import com.andersen.messenger.repository.DeviceGroupRepository;
import com.andersen.messenger.repository.DeviceRepository;
import com.andersen.messenger.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ListenersController extends BaseController {
    private final DeviceRepository deviceRepository;
    private final GroupRepository groupRepository;
    private final DeviceGroupRepository deviceGroupRepository;

    @Autowired
    public ListenersController(
        DeviceRepository deviceRepository,
        GroupRepository groupRepository,
        DeviceGroupRepository deviceGroupRepository
    ) {
        this.deviceRepository = deviceRepository;
        this.groupRepository = groupRepository;
        this.deviceGroupRepository = deviceGroupRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/device")
    public ResponseEntity addDevice(@Valid Device device, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return prepareErrorResponse(bindingResult);
        }
        return ResponseEntity.ok(deviceRepository.addDevice(device));
    }

    @DeleteMapping("/device")
    public ResponseEntity removeDevice(@Valid RemoveRequest removeRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return prepareErrorResponse(bindingResult);
        }
        return ResponseEntity.ok(deviceRepository.removeDevice(removeRequest.getId()));
    }

    @PostMapping("/group")
    public ResponseEntity addGroup(@Valid Group group, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return prepareErrorResponse(bindingResult);
        }

        return ResponseEntity.ok(groupRepository.addGroup(group));
    }

    @DeleteMapping("/group")
    public ResponseEntity removeGroup(@Valid RemoveRequest removeRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return prepareErrorResponse(bindingResult);
        }
        return ResponseEntity.ok(groupRepository.removeGroup(removeRequest.getId()));
    }

    @PostMapping("/addDeviceToGroup")
    public ResponseEntity addDeviceToGroup(
            @Valid DeviceGroup deviceGroup,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return prepareErrorResponse(bindingResult);
        }

        return ResponseEntity.ok(deviceGroupRepository.addDeviceToGroup(deviceGroup));
    }

    @PostMapping("/removeDeviceFromGroup")
    public ResponseEntity removeDeviceFromGroup(
            @Valid DeviceGroup deviceGroup,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return prepareErrorResponse(bindingResult);
        }

        return ResponseEntity.ok(deviceGroupRepository.removeDeviceFromGroup(deviceGroup));
    }
}
