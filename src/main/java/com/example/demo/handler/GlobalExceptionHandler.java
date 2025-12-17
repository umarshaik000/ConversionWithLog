package com.example.demo.handler;

import com.example.demo.exception.InvalidRequestException;
import com.example.demo.model.output.StudentOutput;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger errorLog = LoggerFactory.getLogger("ERROR_LOG");

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public StudentOutput handleInvalidRequest(InvalidRequestException ex) {

        // ✅ ERROR LOG GOES HERE
        errorLog.error("Unhandled exception occurred", ex);

        return new StudentOutput(ex.getMessage(), LocalDateTime.now().toString());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public StudentOutput handleGeneric(Exception ex) {

        // ✅ ERROR LOG GOES HERE
        errorLog.error("Error occurred: {}", ex.getMessage(), ex);

        return new StudentOutput("Internal Server Error", LocalDateTime.now().toString());
    }
}
