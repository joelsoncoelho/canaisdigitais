package com.projeto.api.canaisdigitais.controller;

import com.projeto.api.canaisdigitais.domain.endereco.DadosEndereco;
import com.projeto.api.canaisdigitais.domain.endereco.DadosEstados;
import com.projeto.api.canaisdigitais.domain.endereco.DadosMunicipios;
import com.projeto.api.canaisdigitais.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consulta-enderecos")
public class ConsultaController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("{cep}")
    public DadosEndereco consultaCep(@PathVariable("cep") String cep){
        return enderecoService.consultaCep(cep);
    }

    @GetMapping("estado/{uf}")
    public DadosEstados consultaEstadosPorUf(@PathVariable("uf") String uf){
        return enderecoService.consultaEstadoPorUf(uf);
    }

    @GetMapping
    public List<DadosEstados> consultaEstados(){
        return enderecoService.consultaEstados();
    }

    @GetMapping("municipios/{uf}")
    public List<DadosMunicipios> consultaMunicipiosPorUf(@PathVariable("uf") String uf){
        return enderecoService.consultaMunicipiosPorUf(uf);
    }

}
