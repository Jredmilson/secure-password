package com.jred.ed.service;

import org.springframework.stereotype.Service;

@Service
public interface ValidatePasswordService {

    Boolean authenticatePassword(String password);
}
