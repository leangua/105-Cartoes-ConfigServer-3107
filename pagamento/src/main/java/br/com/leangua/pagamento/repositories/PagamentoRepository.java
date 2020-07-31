package br.com.leangua.pagamento.repositories;

import br.com.leangua.pagamento.models.Pagamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {
	List<Pagamento> findAllByCartaoId(int numero);
}
