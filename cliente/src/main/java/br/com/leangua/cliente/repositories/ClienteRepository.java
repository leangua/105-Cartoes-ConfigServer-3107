package br.com.leangua.cliente.repositories;

import br.com.leangua.cliente.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
