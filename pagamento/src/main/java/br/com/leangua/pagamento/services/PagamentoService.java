package br.com.leangua.pagamento.services;

import br.com.leangua.pagamento.clients.CartaoClient;
import br.com.leangua.pagamento.exceptions.ValidacaoException;
import br.com.leangua.pagamento.models.Cartao;
import br.com.leangua.pagamento.models.Pagamento;
import br.com.leangua.pagamento.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
	
	@Autowired
	CartaoClient cartaoClient;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	
	public Pagamento efetuaPagamento(Pagamento pagamento) {

		Cartao cartao = cartaoClient.buscaPorId(pagamento.getCartaoId());

		pagamento.setCartaoId(cartao.getId());

	    return pagamentoRepository.save(pagamento);
	}
	
	public List<Pagamento> buscarPagamentos(int idCartao){

		return pagamentoRepository.findAllByCartaoId(idCartao);
	}

}
