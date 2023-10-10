package com.projeto.api.canaisdigitais.domain.cliente;

import com.projeto.api.canaisdigitais.domain.endereco.DadosEndereco;
import com.projeto.api.canaisdigitais.domain.endereco.Endereco;
import com.projeto.api.canaisdigitais.domain.produto.Produto;

import java.util.List;
import java.util.Optional;

public record DadosDetalhamentoCliente(Long id, String nome, String cpf, String email, String telefone, Endereco endereco) {

    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
    }

}
