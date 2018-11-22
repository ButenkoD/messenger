package com.andersen.messenger.api;

import com.andersen.messenger.entity.Message;
import com.andersen.messenger.service.Messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MessageController extends BaseController {
    private final Messenger messenger;

    @Autowired
    MessageController(Messenger messenger) {
        this.messenger = messenger;
    }
    @PostMapping("/message")
    public ResponseEntity addDevice(@Valid Message message, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return prepareErrorResponse(bindingResult);
        }
        return ResponseEntity.ok(messenger.applyMessage(message));
    }
}
