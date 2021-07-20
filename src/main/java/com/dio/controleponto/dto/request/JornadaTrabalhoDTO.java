package com.dio.controleponto.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JornadaTrabalhoDTO {

    private long id;
    private String descricao;

}
