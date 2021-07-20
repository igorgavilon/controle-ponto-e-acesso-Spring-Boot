package com.dio.controleponto.service;

import com.dio.controleponto.dto.request.JornadaTrabalhoDTO;
import com.dio.controleponto.dto.response.MessageResponseDTO;
import com.dio.controleponto.exception.JornadaTrabalhoNotFoundException;
import com.dio.controleponto.model.JornadaTrabalho;
import com.dio.controleponto.repository.JornadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JornadaService {

    private JornadaRepository jornadaRepository;

    public MessageResponseDTO createJornada(JornadaTrabalhoDTO jornadaTrabalhoDTO) {
        JornadaTrabalho jornadaToSave = JornadaTrabalho.builder()
                .descricao(jornadaTrabalhoDTO.getDescricao())
                .build();

        JornadaTrabalho savedJornada = jornadaRepository.save(jornadaToSave);
        return MessageResponseDTO.builder()
                .message("Created JornadaTrabalho with ID " + savedJornada.getId()).build();
    }

    public List<JornadaTrabalhoDTO> findAll() {
        List<JornadaTrabalho> allJornadas =jornadaRepository.findAll();

        return allJornadas.stream().map((jornada) ->
            JornadaTrabalhoDTO.builder()
                    .id(jornada.getId())
                    .descricao(jornada.getDescricao())
                    .build()
        ).collect(Collectors.toList());
    }

    public JornadaTrabalhoDTO getById(long idJornada) throws JornadaTrabalhoNotFoundException {
        JornadaTrabalho jornadaTrabalho = jornadaRepository
                .findById(idJornada).orElseThrow(() -> new JornadaTrabalhoNotFoundException(idJornada));
        return JornadaTrabalhoDTO.builder()
                .id(jornadaTrabalho.getId())
                .descricao(jornadaTrabalho.getDescricao())
                .build();
    }

    public MessageResponseDTO updateById(Long idJornada, JornadaTrabalhoDTO jornadaTrabalhoDTO) throws JornadaTrabalhoNotFoundException{
        jornadaRepository.findById(idJornada).orElseThrow(() -> new JornadaTrabalhoNotFoundException(idJornada));

        JornadaTrabalho jornadaToUpdate = JornadaTrabalho.builder()
                .id(jornadaTrabalhoDTO.getId())
                .descricao(jornadaTrabalhoDTO.getDescricao())
                .build();

        JornadaTrabalho updatedJornada = jornadaRepository.save(jornadaToUpdate);
        return MessageResponseDTO.builder()
                .message("updated Jornada Trabalho with ID " + updatedJornada.getId())
                .build();
    }

    public void deleteJornada(long idJornada) throws JornadaTrabalhoNotFoundException{
        jornadaRepository.findById(idJornada).orElseThrow(() -> new JornadaTrabalhoNotFoundException(idJornada));

        jornadaRepository.deleteById(idJornada);
    }
}
