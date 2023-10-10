package com.projeto.api.canaisdigitais.domain.produto;

import com.projeto.api.canaisdigitais.domain.cliente.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
        @NotBlank(message = "O campo nome não pode estar em branco")
        String nome,

        String descricao,

        @NotNull(message = "O cliente não pode ser nulo")
        Long clienteId


) {
}
