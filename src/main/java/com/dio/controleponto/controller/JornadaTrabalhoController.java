package com.dio.controleponto.controller;

import com.dio.controleponto.model.JornadaTrabalho;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {



    @PostMapping
    public JornadaTrabalho createJornada() {
        return null;
    }

}
