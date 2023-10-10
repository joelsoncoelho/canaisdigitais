package com.projeto.api.canaisdigitais.domain.cliente;

import com.projeto.api.canaisdigitais.domain.endereco.DadosEndereco;
import com.projeto.api.canaisdigitais.domain.endereco.Endereco;
import com.projeto.api.canaisdigitais.domain.produto.Produto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record DadosCadastroCliente(

        @NotBlank(message = "O campo nome não pode estar em branco")
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,
        @Email(message = "O email deve ser válido")
        @NotBlank(message = "O campo email não pode estar em branco")
        String email,
        @NotBlank(message = "O campo telefone não pode estar em branco")
        String telefone,

        @NotBlank(message = "O campo cep não pode estar em branco")
         String cep
) { }
