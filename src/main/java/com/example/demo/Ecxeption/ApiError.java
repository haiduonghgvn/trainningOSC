package com.example.demo.Ecxeption;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

/**
 * demoCache
 *
 * @author duongnch
 * @created_at 28/05/2020 - 8:45 AM
 * @created_by duongnch
 * @since 28/05/2020
 */
@Getter
@Setter
@NoArgsConstructor
public class ApiError {
    private String status;
    private String message;
    private String descriptions;
    private List<String> errors;

    public ApiError(String status,String message,String descriptions,List<String> errors){
        super();
        this.status = status;
        this.message = message;
        this.descriptions = descriptions;
        this.errors = errors;
    }

    public ApiError(String status, String message, String descriptions, String error){
        super();
        this.status = status;
        this.message = message;
        this.descriptions = descriptions;
        errors = Arrays.asList(error);
    }
}
