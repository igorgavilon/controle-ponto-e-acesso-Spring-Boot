package com.dio.controleponto.controller;

import com.dio.controleponto.dto.request.JornadaTrabalhoDTO;
import com.dio.controleponto.dto.response.MessageResponseDTO;
import com.dio.controleponto.exception.JornadaTrabalhoNotFoundException;
import com.dio.controleponto.service.JornadaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JornadaTrabalhoController {

    private JornadaService jornadaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createJornada(@RequestBody JornadaTrabalhoDTO jornadaTrabalhoDTO) {
        return jornadaService.createJornada(jornadaTrabalhoDTO);
    }

    @GetMapping
    public List<JornadaTrabalhoDTO> getJornadaList() {
        return jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    public JornadaTrabalhoDTO getJornadaByID(@PathVariable("idJornada") long idJornada) throws JornadaTrabalhoNotFoundException {
        return jornadaService.getById(idJornada);
    }

    @PutMapping("/{idJornada}")
    public MessageResponseDTO updateById(@PathVariable Long idJornada, @RequestBody JornadaTrabalhoDTO jornadaTrabalhoDTO) throws JornadaTrabalhoNotFoundException{
        return jornadaService.updateById(idJornada, jornadaTrabalhoDTO);
    }

    @DeleteMapping("/{idJornada}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long idJornada) throws JornadaTrabalhoNotFoundException{
        jornadaService.deleteJornada(idJornada);
    }



}
