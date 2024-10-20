package com.jred.ed.controller;

import com.jred.ed.PasswordException.PasswordException;
import com.jred.ed.model.PasswordDTO;
import com.jred.ed.model.PasswordResponseDTO;
import com.jred.ed.service.imp.ValidatePasswordServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class ValidatorController {

    @Autowired
    private ValidatePasswordServiceImp passwordService;

    @PostMapping("/validate-password")
    public ResponseEntity<PasswordResponseDTO> validatePassword(
            @RequestBody PasswordDTO passwordDTO) {

        PasswordResponseDTO passwordResponseDTO = passwordService.authenticatePassword(passwordDTO.getPassword());

        if (Objects.equals(passwordResponseDTO.getStatusCode(), String.valueOf(HttpStatus.BAD_REQUEST))) {
            return ResponseEntity.badRequest().body(passwordResponseDTO);
        }
        return ResponseEntity.noContent().build();
    }
}
