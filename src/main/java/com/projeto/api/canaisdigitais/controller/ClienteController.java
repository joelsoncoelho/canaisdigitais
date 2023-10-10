package com.projeto.api.canaisdigitais.controller;

import com.projeto.api.canaisdigitais.domain.cliente.*;
import com.projeto.api.canaisdigitais.domain.endereco.DadosEndereco;
import com.projeto.api.canaisdigitais.service.EnderecoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService cepService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriComponentsBuilder){

        DadosEndereco dadosEndereco = cepService.consultaCep(dados.cep());

         var cliente = new Cliente(dados, dadosEndereco);

        clienteRepository.save(cliente);

        var uri = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public List<DadosListagemCliente> listar(){
        return clienteRepository.findAll().stream().map(DadosListagemCliente::new).toList();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity detalhar (@PathVariable String cpf){
        var cliente = clienteRepository.findByCpf(cpf);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados) {
        var cliente = clienteRepository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }


}
