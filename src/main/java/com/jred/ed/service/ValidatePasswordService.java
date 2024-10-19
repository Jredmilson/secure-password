package com.jred.ed.service;

import com.jred.ed.model.PasswordResponseDTO;
import org.springframework.stereotype.Service;

public interface ValidatePasswordService {

    PasswordResponseDTO authenticatePassword(String password);
}
