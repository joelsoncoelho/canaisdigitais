package com.projeto.api.canaisdigitais.service;

import com.projeto.api.canaisdigitais.domain.endereco.DadosEndereco;
import com.projeto.api.canaisdigitais.domain.endereco.DadosEstados;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EnderecoService {

    public DadosEndereco consultaCep(String cep){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DadosEndereco> response = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json", cep), DadosEndereco.class);
        return response.getBody();
    }

    public DadosEstados consultaEstadoPorUf(String uf) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DadosEstados> response = restTemplate.getForEntity(String.format("https://servicodados.ibge.gov.br/api/v1/localidades/estados/%s", uf), DadosEstados.class);
        return response.getBody();
    }

    public List<DadosEstados> consultaEstados() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DadosEstados> entity = restTemplate.getForEntity("https://servicodados.ibge.gov.br/api/v1/localidades/estados/", DadosEstados.class);
        return Stream.of(entity.getBody()).toList();

    }
}
