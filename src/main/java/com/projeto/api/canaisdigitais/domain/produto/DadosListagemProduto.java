package com.projeto.api.canaisdigitais.domain.produto;

public record DadosListagemProduto(Long id, String nome, String descricao) {

    public DadosListagemProduto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao());
    }
}
