package br.com.leangua.pagamento.models;

import javax.persistence.*;

@Entity
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int cartaoId;
	private String descricao;
	private double valor;
	
	public Pagamento() {
		
	}
	
	public Pagamento(int cartaoId, String descricao, double valor) {
		this.cartaoId = cartaoId;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCartaoId() {
		return cartaoId;
	}
	public void setCartaoId(int cartaoId) {
		this.cartaoId = cartaoId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
