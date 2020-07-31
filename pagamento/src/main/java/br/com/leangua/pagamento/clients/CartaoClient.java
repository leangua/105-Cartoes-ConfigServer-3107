package br.com.leangua.pagamento.clients;

import br.com.leangua.pagamento.models.Cartao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cartao", url = "http://localhost:8082/cartao")
public interface CartaoClient {

    @GetMapping("/id/{id}")
    Cartao buscaPorId(@PathVariable int id);
}
