package com.example.demo.Ecxeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * demoCache
 *
 * @author duongnch
 * @created_at 28/05/2020 - 1:27 PM
 * @created_by duongnch
 * @since 28/05/2020
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}