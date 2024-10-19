package com.jred.ed.exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class PasswordExceptions extends Exception {

    public PasswordExceptions(List<Password> exceptions) {
        super("A sua senha está faltando campos obrigatórios como .: " + formatExceptions(exceptions));
    }

    private static String formatExceptions(List<Password> exceptions) {
        return exceptions.stream()
                .map(Password::toString) // ou qualquer método que você queira usar para representar o objeto
                .collect(Collectors.joining(", "));
    }


}
