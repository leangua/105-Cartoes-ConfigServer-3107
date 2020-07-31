package br.com.leangua.cartao.controllers;

import br.com.leangua.cartao.dto.*;
import br.com.leangua.cartao.dto.CartaoEntradaDto;
import br.com.leangua.cartao.models.Cartao;
import br.com.leangua.cartao.services.CartaoService;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;

@RestController
public class CartaoController {
	
	@Autowired
	CartaoService cartaoService;

	@Autowired
	Mapper mapper;
	
	@PostMapping("/cartao")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cartao criarCartao(@Valid @RequestBody CartaoEntradaDto cartaoEntradaDto) {
		Cartao cartao = mapper.paraCartao(cartaoEntradaDto);
		cartao = cartaoService.criar(cartao);
		System.out.println("chamando cartoes");
		return cartao;
	}
	
	@PatchMapping("/cartao/{numero}")
	public void ativaCartao(@PathVariable String numero, @RequestBody boolean ativo) {
		cartaoService.ativar(numero);
	}
	
	@GetMapping("cartao/{numero}")
	public Cartao buscaCartao(@PathVariable String numero) {
		return cartaoService.buscar(numero);
	}

	@GetMapping("/cartao/id/{id}")
	public Cartao buscaCartaoPorId(@PathVariable int id){
		return cartaoService.buscarPorId(id);
	}

}
