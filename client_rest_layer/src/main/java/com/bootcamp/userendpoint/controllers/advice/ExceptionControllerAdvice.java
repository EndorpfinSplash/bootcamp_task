package com.bootcamp.userendpoint.controllers.advice;

import com.bootcamp.userendpoint.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(InvalidEmailAddressException.class)
    public ResponseEntity<ErrorDetails> exceptionInvalidEmailAddressHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Получен не корректный адрес электронной почты!");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }


    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionRoleNotFoundHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Полученная роль отсутствует!");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}