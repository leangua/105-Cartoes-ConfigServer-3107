package br.com.leangua.cartao.services;

import br.com.leangua.cartao.clients.ClienteClient;
import br.com.leangua.cartao.dto.CartaoDto;
import br.com.leangua.cartao.exceptions.ValidacaoException;
import br.com.leangua.cartao.models.Cartao;
import br.com.leangua.cartao.models.Cliente;
import br.com.leangua.cartao.repositories.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {
	
	@Autowired
	CartaoRepository cartaoRepository;

	@Autowired
	ClienteClient clienteClient;
	
	public Cartao criar(Cartao cartao) {
		Cliente cliente = clienteClient.getClienteById(cartao.getClienteId());

		cartao.setClienteId(cliente.getId());
		cartao.setAtivo(false);

		cartaoRepository.save(cartao);
		
		return cartao;
	}
	
	public CartaoDto ativar(String numero) {
		Optional<Cartao> optional = cartaoRepository.findByNumero(numero);
		
		if (!optional.isPresent()) {
			throw new ValidacaoException("cartao", "cartao inexistente");
		}
		
		Cartao cartao = optional.get();
		
		if (cartao.getAtivo()) {
			throw new ValidacaoException("cartao", "cartao já está ativo");
		}
		
		cartao.setAtivo(true);
		
		cartaoRepository.save(cartao);
		
		return converter(cartao);
	}
	
	public Cartao buscar(String numero) {
		Optional<Cartao> optional = cartaoRepository.findByNumero(numero);
		
		if (!optional.isPresent()) {
			throw new ValidacaoException("cartao", "cartao inexistente");
		}
		
		Cartao cartao = optional.get();
		
		return cartao;
	}
	
	public Cartao buscarPorId(int id) {
		Optional<Cartao> optional = cartaoRepository.findById(id);

		if (!optional.isPresent()) {
			throw new ValidacaoException("cartao", "cartao inexistente");
		}

		Cartao cartao = optional.get();

		return cartao;
	}
	
	public CartaoDto converter(Cartao cartao) {
		CartaoDto cartaoDto = new CartaoDto();
		cartaoDto.setId(cartao.getId());
		cartaoDto.setNumero(cartao.getNumero());
		cartaoDto.setClienteId(cartao.getClienteId());
		cartaoDto.setAtivo(false);
		
		return cartaoDto;
	}

}
