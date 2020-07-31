package br.com.leangua.cliente.services;

import br.com.leangua.cliente.exceptions.ClienteNotFoundException;
import br.com.leangua.cliente.models.Cliente;
import br.com.leangua.cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente criar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente buscaCliente(int id){
		return clienteRepository.findById(id).orElseThrow(ClienteNotFoundException::new);
	}
}
