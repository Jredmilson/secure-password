package com.jred.ed.service.imp;


import com.jred.ed.PasswordException.PasswordException;
import com.jred.ed.model.Password;
import com.jred.ed.model.PasswordResponseDTO;
import com.jred.ed.service.ValidatePasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ValidatePasswordServiceImp implements ValidatePasswordService {


    @Override
    public PasswordResponseDTO authenticatePassword(String password) {

        Map<String, Boolean> stringMap = new LinkedHashMap<>();

        stringMap.put(Password.MAISCULO.getNome(), validaMaisculo(password));
        stringMap.put(Password.MINUSCULO.getNome(), validaMinusculo(password));
        stringMap.put(Password.NUMERICO.getNome(), validaNumero(password));
        stringMap.put(Password.TAMANHO.getNome(), validaTamanho(password));
        stringMap.put(Password.CARACTER_ESPECIAL.getNome(), validaCaracter(password));

        List<String> test = stringMap.entrySet().stream()
                .filter(pass -> !pass.getValue())
                .map(Map.Entry::getKey)
                .toList();

        if (!test.isEmpty()) {
            return PasswordResponseDTO.builder()
                    .error("INVALID_PASSWORD")
                    .details(format(test))
                    .statusCode(String.valueOf(HttpStatus.BAD_REQUEST))
                    .build();
        }

        return PasswordResponseDTO.builder()
                .statusCode(String.valueOf(HttpStatus.OK))
                .build();
    }

    private boolean validaTamanho(String password) {
        return password.length() >= 8;
    }

    private boolean validaMaisculo(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }

    private boolean validaMinusculo(String password) {
        return password.chars().anyMatch(Character::isLowerCase);
    }

    private boolean validaNumero(String password) {
        return password.chars().anyMatch(Character::isDigit);
    }

    private boolean validaCaracter(String password) {
        return password.chars().anyMatch(ch -> ".,!@#$%".indexOf(ch) >= 0);
    }

    private String format(List<String> acceptances) {
        StringBuilder text = new StringBuilder("Critérios faltantes: ");

        for (int i = 0; i < acceptances.size(); i++) {
            text.append(acceptances.get(i));
            if (i < acceptances.size() - 1) {
                text.append(", ");
            }
        }

        return String.valueOf(text);
    }
}
