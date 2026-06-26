package com.example.InsurTech.util;

public class ResponseBuilder {
    public static <T> ApiResponse<T> success(
            int status,
            String message,
            T data) {

        return new ApiResponse<>(status, message, data);
    }

    public static ApiResponse<?> successMessage(
            int status,
            String message) {

        return new ApiResponse<>(status, message, null);
    }

    public static ApiResponse<?> error(
            int status,
            String message) {

        return new ApiResponse<>(status, message, null);
    }
}
