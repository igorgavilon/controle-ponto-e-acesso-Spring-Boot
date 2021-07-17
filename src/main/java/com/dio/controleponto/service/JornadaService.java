package com.dio.controleponto.service;

import com.dio.controleponto.model.JornadaTrabalho;
import com.dio.controleponto.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornadaService {

    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho) {
        return jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> findAll() {
        return jornadaRepository.findAll();
    }

    public JornadaTrabalho getById(long idJornada) throws Exception{
        return jornadaRepository.findById(idJornada).orElseThrow(() -> new Exception("jornada não encontrada."));
    }
}
