package com.dio.controleponto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JornadaTrabalhoNotFoundException extends Exception{

    public JornadaTrabalhoNotFoundException(Long idJornada) {
        super("JornadaTrabalho not found with ID " + idJornada);
    }
}
