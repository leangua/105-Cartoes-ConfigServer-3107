package br.com.leangua.cartao.dto;

public class CartaoEntradaDto {	
	
	private String numero;
	
	private int clienteId;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getClienteId() {
		return this.clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	
	
}
