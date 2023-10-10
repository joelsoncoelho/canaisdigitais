package com.projeto.api.canaisdigitais.controller;

import com.projeto.api.canaisdigitais.domain.cliente.ClienteRepository;
import com.projeto.api.canaisdigitais.domain.produto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriComponentsBuilder){

        var cliente = clienteRepository.findById(dados.clienteId()).get();

        var produto = new Produto(null, dados.nome(), dados.descricao(), cliente);

        produtoRepository.save(produto);

        var uri = uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }

    @GetMapping
    public List<DadosListagemProduto> listar() {
        return produtoRepository.findAll().stream().map(DadosListagemProduto::new).toList();
    }

    @GetMapping("/{cpf}")
    public List<DadosDetalhamentoProduto> detalhar (@PathVariable String cpf){

        var cliente = clienteRepository.findByCpf(cpf);
        var produto = produtoRepository.findAllProdutoByClienteId(cliente.getId());

        return produto.stream().map(DadosDetalhamentoProduto::new).toList();
    }

}
