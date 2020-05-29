package com.example.demo.Model.APIResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * demoCache
 *
 * @author duongnch
 * @created_at 26/05/2020 - 4:08 PM
 * @created_by duongnch
 * @since 26/05/2020
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Status {
    private int code;
    private String message;
    private String description;

}
