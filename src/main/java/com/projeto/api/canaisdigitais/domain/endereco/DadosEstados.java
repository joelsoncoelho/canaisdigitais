package com.projeto.api.canaisdigitais.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEstados(

        Long id,
        String sigla,
        String nome,
        DadosRegiao regiao) {
}


