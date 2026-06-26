package com.example.InsurTech.config;

import com.example.InsurTech.util.ApiResponse;
import com.example.InsurTech.util.ResponseBuilder;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Validation Error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationException(
            MethodArgumentNotValidException ex) {

        FieldError fieldError =
                ex.getBindingResult().getFieldError();

        String message =
                fieldError != null
                        ? fieldError.getDefaultMessage()
                        : "Validation failed";

        return ResponseEntity.badRequest()
                .body(ResponseBuilder.error(400, message));
    }

    // Bad Request
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<?>> handleBadRequestException(
            BadRequestException ex) {

        return ResponseEntity.badRequest()
                .body(ResponseBuilder.error(
                        400,
                        ex.getMessage()));
    }

    // Not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFoundException(
            ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseBuilder.error(
                        404,
                        ex.getMessage()));
    }

    // Duplicate Key
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<?>> handleDuplicateException(
            DataIntegrityViolationException ex) {

        String message = "Duplicate data found";

        String rootMessage =
                ex.getMostSpecificCause().getMessage();

        if (rootMessage != null &&
                rootMessage.toLowerCase().contains("email")) {

            message = "Email already exists";
        }

        return ResponseEntity.badRequest()
                .body(ResponseBuilder.error(
                        400,
                        message));
    }

    // Catch All Errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(
            Exception ex) {

        return ResponseEntity.status(
                        HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseBuilder.error(
                        500,
                        ex.getMessage()));
    }
}