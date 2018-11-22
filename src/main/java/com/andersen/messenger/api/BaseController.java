package com.andersen.messenger.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class BaseController {
    protected ResponseEntity prepareErrorResponse(BindingResult bindingResult) {
        String result = "";
        for (ObjectError error: bindingResult.getAllErrors()) {
            result += error.getDefaultMessage() + "\n";
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
