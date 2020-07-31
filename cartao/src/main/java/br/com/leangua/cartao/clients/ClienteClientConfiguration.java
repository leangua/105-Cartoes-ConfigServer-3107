package br.com.leangua.cartao.clients;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class ClienteClientConfiguration {

    @Bean
    public ErrorDecoder getErrorDecoder(){
        return new ClienteClientErrorDecoder();
    }
}
