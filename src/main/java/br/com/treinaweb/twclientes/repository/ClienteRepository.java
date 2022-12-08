package br.com.treinaweb.twclientes.repository;

import br.com.treinaweb.twclientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
