package com.dio.controleponto.model;

import lombok.*;

import javax.persistence.OneToMany;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Localidade {
    private long id;
    @OneToMany
    private NivelAcesso nivelAcesso;
    private String descricao;
}
