package com.projeto.api.canaisdigitais.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long > {
    Cliente findByCpf(String cpf);
}
