package com.firtsappspring.tutospring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RutasHandler {

    private final Logger logger = LoggerFactory.getLogger(Rutas.class); 

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleNullPointerException(NullPointerException e) {
        logger.error(e.getMessage());
        return "internal error. Contact support";
    }
}
