package com.example.chiquita.model;

public record ErrorResponse(String message, ErrorCodes errorCode, Integer status) {
}
