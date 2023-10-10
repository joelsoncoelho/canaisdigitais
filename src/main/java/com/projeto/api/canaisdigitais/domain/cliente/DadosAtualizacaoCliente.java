package com.projeto.api.canaisdigitais.domain.cliente;

import com.projeto.api.canaisdigitais.domain.endereco.DadosEndereco;

public record DadosAtualizacaoCliente(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        DadosEndereco endereco) {
}
