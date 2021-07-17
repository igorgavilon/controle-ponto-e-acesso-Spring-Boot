package com.dio.controleponto.service;

import com.dio.controleponto.model.JornadaTrabalho;
import com.dio.controleponto.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<JornadaTrabalho> getById(long idJornada) {
        return jornadaRepository.findById(idJornada);
    }

    public Optional<JornadaTrabalho> update(JornadaTrabalho jornadaTrabalho) {
        Optional<JornadaTrabalho> jornadaOptional = jornadaRepository.findById(jornadaTrabalho.getId());
        JornadaTrabalho jornadaUpdate;

        if(jornadaOptional.isPresent()) {
            jornadaUpdate = jornadaOptional.get();
            jornadaUpdate.setDescricao(jornadaTrabalho.getDescricao());
            jornadaRepository.save(jornadaUpdate);
            return Optional.of(jornadaUpdate);
        } else {
            return null;
        }

    }

    public void deleteJornada(long idJornada) {
        jornadaRepository.deleteById(idJornada);
    }
}
