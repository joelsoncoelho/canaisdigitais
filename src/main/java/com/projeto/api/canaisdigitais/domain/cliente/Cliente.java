package com.projeto.api.canaisdigitais.domain.cliente;

import com.projeto.api.canaisdigitais.domain.endereco.DadosEndereco;
import com.projeto.api.canaisdigitais.domain.endereco.Endereco;
import com.projeto.api.canaisdigitais.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Cliente")
@Table(name = "clientes")
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    @OneToMany(mappedBy = "cliente")
   private List<Produto> produtos;

    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroCliente dados, DadosEndereco dadosEndereco) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dadosEndereco);
    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
         if (dados.endereco() != null)
            endereco.atualizarInformacoes(dados.endereco());
    }

}
