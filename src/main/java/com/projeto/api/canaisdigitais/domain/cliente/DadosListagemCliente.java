package com.projeto.api.canaisdigitais.domain.cliente;

import com.projeto.api.canaisdigitais.domain.produto.Produto;

import java.util.List;

public record DadosListagemCliente(Long id, String nome, String email, String cpf) {

    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf());
    }
}
