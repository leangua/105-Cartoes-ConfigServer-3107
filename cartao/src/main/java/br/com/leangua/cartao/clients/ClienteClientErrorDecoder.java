package br.com.leangua.cartao.clients;

import br.com.leangua.cartao.exceptions.ClienteNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClienteClientErrorDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404) {
            throw new ClienteNotFoundException();
        }else{
            return errorDecoder.decode(s, response);
        }
    }

}
