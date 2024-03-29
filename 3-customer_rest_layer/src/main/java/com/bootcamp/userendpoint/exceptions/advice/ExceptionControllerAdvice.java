package com.bootcamp.userendpoint.exceptions.advice;

import com.bootcamp.userendpoint.exceptions.*;
import com.bootcamp.userendpoint.model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(InvalidEmailAddressException.class)
    public ResponseEntity<ErrorDetails> exceptionInvalidEmailAddressHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
//        errorDetails.setMessage("Получен не корректный адрес электронной почты!");
        errorDetails.setMessage("Please send the correct e-mail address!");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }


    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionRoleNotFoundHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
//        errorDetails.setMessage("Полученная роль отсутствует!");
        errorDetails.setMessage("Received role is absent! Please choose one of the roles from the list: " +
                Arrays.stream(Role.values()).map(Role::getRole)
                        .collect(Collectors.joining(", ")));
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(EmptyDataException.class)
    public ResponseEntity<ErrorDetails> exceptionEmptyDataHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Please enter a name.");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(NonLatinAlphabetException.class)
    public ResponseEntity<ErrorDetails> exceptionNonLatinAlphabetHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Please use only the Latin alphabet for your name details");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}