package com.example.demo.Model.Dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * demoCache
 *
 * @author duongnch
 * @created_at 25/05/2020 - 11:46 AM
 * @created_by duongnch
 * @since 25/05/2020
 */

@Data
public class StudentDto {

    @NotBlank(message ="{error.message.notFound.name}")
    private String name;

    @NotBlank(message = "{error.message.notFound.address}")
    private String address;

    @NotBlank(message = "{error.message.notFound.email}")
    private String email;

    @NotBlank(message = "{error.message.notFound.semester}")
    private String semester;
}
