package br.com.leangua.cartao.clients;

import br.com.leangua.cartao.models.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente", url = "http://localhost:8080/cliente", configuration = ClienteClientConfiguration.class)
public interface ClienteClient {

    @GetMapping("/{id}")
    Cliente getClienteById(@PathVariable int id);
}
