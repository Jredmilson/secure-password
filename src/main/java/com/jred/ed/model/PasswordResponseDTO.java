package com.jred.ed.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PasswordResponseDTO {

    private String error;

    private String statusCode;

    private String details;
}
