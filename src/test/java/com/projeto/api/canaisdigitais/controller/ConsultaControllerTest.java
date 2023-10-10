package com.projeto.api.canaisdigitais.controller;

import com.projeto.api.canaisdigitais.domain.endereco.DadosEndereco;
import com.projeto.api.canaisdigitais.service.EnderecoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    @MockBean
    private EnderecoService cepService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve verificar se existe igualdade entre os valores")
    public void consumerTest(){
        var endereco = new DadosEndereco("72300-533", "Quadra 301 Conjunto 2", "",
                "Samambaia Sul (Samambaia)", "Brasilia", "DF");

        OngoingStubbing<DadosEndereco> dados = when(cepService.consultaCep("72300-533")).thenReturn(endereco);

        assertThat(dados.equals(endereco));
    }

}