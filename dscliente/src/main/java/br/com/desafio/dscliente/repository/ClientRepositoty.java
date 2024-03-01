package br.com.desafio.dscliente.repository;

import br.com.desafio.dscliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoty extends JpaRepository<Client, Long> {
}
