package com.projeto.api.canaisdigitais.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String cep,
        @NotBlank
        String logradouro,
        String complemento,
        @NotBlank
        String bairro,
        @NotBlank
        String localidade,
        @NotBlank
        String uf) {
}

