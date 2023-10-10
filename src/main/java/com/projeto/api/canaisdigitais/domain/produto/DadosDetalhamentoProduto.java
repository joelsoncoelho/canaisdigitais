package com.projeto.api.canaisdigitais.domain.produto;

import com.projeto.api.canaisdigitais.domain.cliente.Cliente;

public record DadosDetalhamentoProduto(Long id, String nome, String descricao, Long idCliente) {

    public  DadosDetalhamentoProduto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getCliente().getId());
    }
}
