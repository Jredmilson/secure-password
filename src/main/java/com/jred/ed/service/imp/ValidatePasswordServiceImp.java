package com.jred.ed.service.imp;


import com.jred.ed.service.ValidatePasswordService;
import org.springframework.http.HttpStatus;

public class ValidatePasswordServiceImp implements ValidatePasswordService {


    @Override
    public Boolean authenticatePassword(String password) {

        boolean maisculo = validaMaisculo(password);
        boolean minusculo = validaMinusculo(password);
        boolean numerico = validaNumero(password);
        boolean caracter = validaCaracter(password);


    }

    private Boolean validaMaisculo(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private Boolean validaMinusculo(String password) {

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private Boolean validaNumero(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;

    }

    private Boolean validaCaracter(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;

    }
}
