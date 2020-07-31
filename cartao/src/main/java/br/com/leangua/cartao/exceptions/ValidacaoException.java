package br.com.leangua.cartao.exceptions;

public class ValidacaoException extends RuntimeException {
	
	private String atributo;

	public String getAtributo() {
		return atributo;
	}
	
	public ValidacaoException(String atributo, String mensagem) {
		super(mensagem);
		this.atributo = atributo;
	}

}
