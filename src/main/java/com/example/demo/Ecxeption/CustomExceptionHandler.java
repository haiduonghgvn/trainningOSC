
package com.example.demo.Ecxeption;
/**
 * demoCache
 *
 * @author duongnch
 * @created_at 28/05/2020 - 1:22 PM
 * @created_by duongnch
 * @since 28/05/2020
 */

import com.example.demo.Config.Translator;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler  {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> desciptions = new ArrayList<>();
        desciptions.add(ex.getLocalizedMessage());
        ApiError error = new ApiError(Translator.toLocale("INTERNAL_SERVER_ERROR_CODE"),ex.getLocalizedMessage(),Translator.toLocale("INTERNAL_SERVER_ERROR_DESCRIPTIONS"),desciptions);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> descriptions = new ArrayList<>();
        descriptions.add(ex.getLocalizedMessage());
        ApiError error = new ApiError(Translator.toLocale("NOT_FOUND_CODE"),ex.getLocalizedMessage(),Translator.toLocale("NOT_FOUND_DESCRIPTIONS"),descriptions);
        return ResponseEntity.ok(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> descriptions = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            descriptions.add(error.getDefaultMessage());
        }
        ApiError error = new ApiError(Translator.toLocale("BAD_REQUEST_CODE"),Translator.toLocale("error.message.notFound.mes"),Translator.toLocale("BAD_REQUEST_DESCRIPTIONS"),descriptions);
        return ResponseEntity.ok(error);
    }

}
