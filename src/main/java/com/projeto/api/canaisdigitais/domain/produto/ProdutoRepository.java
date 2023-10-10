package com.projeto.api.canaisdigitais.domain.produto;

import com.projeto.api.canaisdigitais.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllProdutoByClienteId(Long id);
}
