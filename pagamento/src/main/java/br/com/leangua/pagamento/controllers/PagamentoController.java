package br.com.leangua.pagamento.controllers;

import br.com.leangua.pagamento.dtos.*;
import br.com.leangua.pagamento.models.Pagamento;
import br.com.leangua.pagamento.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PagamentoController {
	
	@Autowired
	PagamentoService pagamentoService;

	@Autowired
	Mapper mapper;

	
	@PostMapping("/pagamento")
	public ResponseEntity<?> efetuaPagamento(@RequestBody PagamentoDto pagamentoDto) {
		Pagamento pagamento = new Pagamento();
		pagamento = mapper.paraPagamento(pagamentoDto);
		System.out.println("Postando Pagamento");

		try{
			return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.efetuaPagamento(pagamento));
		} catch (RuntimeException exception){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

	}
	
	@GetMapping("/pagamentos/{id_cartao}")
	public ResponseEntity<?> buscarPagamentos(@PathVariable int idCartao){

		try{
			return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.buscarPagamentos(idCartao));
		} catch (RuntimeException exception){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
		}

	}

}
