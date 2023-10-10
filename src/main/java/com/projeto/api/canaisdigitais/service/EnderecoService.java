package com.projeto.api.canaisdigitais.service;

import com.projeto.api.canaisdigitais.domain.endereco.DadosEndereco;
import com.projeto.api.canaisdigitais.domain.endereco.DadosEstados;
import com.projeto.api.canaisdigitais.domain.endereco.DadosMunicipios;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";

        DadosEstados[] response = restTemplate.getForObject(url, DadosEstados[].class);

        return Arrays.stream(response).sorted((p1, p2) -> p1.sigla().compareTo(p2.sigla())).toList();
    }

    public List<DadosMunicipios> consultaMunicipiosPorUf(String uf) {

        DadosEstados estado = consultaEstadoPorUf(uf);

        RestTemplate restTemplate = new RestTemplate();

        DadosMunicipios[] response = restTemplate.getForObject(String.format("https://servicodados.ibge.gov.br/api/v1/localidades/estados/%s/municipios ", estado.id()), DadosMunicipios[].class);

        return Arrays.stream(response).toList();


    }
}
