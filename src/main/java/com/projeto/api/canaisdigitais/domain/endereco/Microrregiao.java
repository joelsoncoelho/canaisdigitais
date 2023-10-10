package com.projeto.api.canaisdigitais.domain.endereco;

public record Microrregiao(
        Long id,
        String nome,
        Mesorregiao mesorregiao
) {
}
