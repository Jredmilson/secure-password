package com.jred.ed.controller;

import com.jred.ed.model.PasswordDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController {


    @GetMapping("/validate-password")
    public void validatePassword(@RequestBody PasswordDTO passwordDTO) {


    }
}
