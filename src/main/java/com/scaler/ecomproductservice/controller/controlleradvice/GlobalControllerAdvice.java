package com.scaler.ecomproductservice.controller.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(value = NullPointerException.class)
    ResponseEntity<String> handleNullPointerException(Exception ex){
        String exceptionResponse =
                "error: " + ex.getMessage() + ", code: "+ HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.ok(exceptionResponse);
    }
}
