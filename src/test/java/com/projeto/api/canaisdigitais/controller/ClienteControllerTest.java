package com.projeto.api.canaisdigitais.controller;

import com.projeto.api.canaisdigitais.domain.cliente.ClienteRepository;
import com.projeto.api.canaisdigitais.domain.cliente.DadosCadastroCliente;
import com.projeto.api.canaisdigitais.domain.cliente.DadosDetalhamentoCliente;
import com.projeto.api.canaisdigitais.domain.endereco.DadosEndereco;
import com.projeto.api.canaisdigitais.domain.endereco.Endereco;
import com.projeto.api.canaisdigitais.service.EnderecoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<DadosCadastroCliente> dadosCadastroClienteJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoCliente> dadosDetalhamentoClienteJson;

    @MockBean
    private ClienteRepository clienteRepository;
    @MockBean
    private EnderecoService cepService;

    @Test
    @DisplayName("Deve devolver códido http 400 quando informações estiverem invalidas")
    void cadastrarCenario1() throws Exception {
        var response = mockMvc.perform(post("/clientes"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver códido http 201 quando informações estiverem validas")
    void cadastrarCenario2() throws Exception {

        var endereco = new DadosEndereco("72300-533", "Quadra 301 Conjunto 2", "",
                "Samambaia Sul (Samambaia)", "Brasilia", "DF");

        when(cepService.consultaCep("72300-533")).thenReturn(endereco);

        var response = mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroClienteJson.write(
                                new DadosCadastroCliente("Joao", "411.832.420-26", "joao@bol.com", "6199997788", "72300-533")
                        ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        var jsonEsperado = dadosDetalhamentoClienteJson.write(
                new DadosDetalhamentoCliente(null , "Joao", "411.832.420-26", "joao@bol.com", "6199997788",
                        new Endereco(endereco))
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}