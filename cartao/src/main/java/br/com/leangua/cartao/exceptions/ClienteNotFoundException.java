package br.com.leangua.cartao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cliente nao encontrado")
public class ClienteNotFoundException extends RuntimeException {
}
