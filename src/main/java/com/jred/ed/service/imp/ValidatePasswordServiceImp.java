package com.jred.ed.service.imp;


import com.jred.ed.model.Password;
import com.jred.ed.model.PasswordResponseDTO;
import com.jred.ed.service.ValidatePasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidatePasswordServiceImp implements ValidatePasswordService {


    @Override
    public PasswordResponseDTO authenticatePassword(String password) {

        boolean maisculo = validaMaisculo(password);
        boolean minusculo = validaMinusculo(password);
        boolean numerico = validaNumero(password);
        boolean caracter = validaCaracter(password);
        boolean tamanho = validaTamanho(password);

        List<String> passwordList = new ArrayList<>();

        if (!maisculo) passwordList.add(Password.MAISCULO.getNome());
        if (!minusculo) passwordList.add(Password.MINUSCULO.getNome());
        if (!numerico) passwordList.add(Password.NUMERICO.getNome());
        if (!caracter) passwordList.add(Password.CARACTER_ESPECIAL.getNome());
        if (!tamanho) passwordList.add(Password.TAMANHO.getNome());

        if (!passwordList.isEmpty()) {
            return PasswordResponseDTO.builder()
                    .error("INVALID_PASSWORD")
                    .details(format(passwordList))
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
        return password.chars().anyMatch(ch -> "!@#$%^&*()_+".indexOf(ch) >= 0);
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
