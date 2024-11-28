package com.testing.boottesting.post;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

import static java.time.LocalTime.now;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationException(Exception ex, WebRequest request) {

        ErrorMessage customException = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                now(),
                ex.getMessage(),
                request.getDescription(false));
        return ResponseEntity.badRequest().body(customException);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleException(MethodArgumentNotValidException ex) {

        String errorsValid = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        ErrorMessage customException = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                now(),
                "Validation error",
                errorsValid
                );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customException);
    }
}