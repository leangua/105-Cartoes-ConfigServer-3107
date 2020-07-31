package br.com.leangua.pagamento.clients;

import br.com.leangua.pagamento.exceptions.CartaoNaoEncontradoException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CartaoClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404){
            throw new CartaoNaoEncontradoException();
        }
        return null;
    }

}
