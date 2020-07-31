package br.com.leangua.cartao.repositories;

import br.com.leangua.cartao.models.Cartao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartaoRepository extends CrudRepository<Cartao, Integer> {
	Optional<Cartao> findByNumero(String numero);
	
}
