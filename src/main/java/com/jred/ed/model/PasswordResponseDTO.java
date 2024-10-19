package com.jred.ed.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PasswordResponseDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    private String statusCode;

    private String details;
}
