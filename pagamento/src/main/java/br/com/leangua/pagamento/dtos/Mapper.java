package br.com.leangua.pagamento.dtos;

import br.com.leangua.pagamento.models.Cartao;
import br.com.leangua.pagamento.models.Pagamento;
import org.springframework.stereotype.Component;

@Component
public class Mapper {


    public Pagamento paraPagamento(PagamentoDto pagamentoDto){
        Pagamento pagamento = new Pagamento();
        pagamento.setDescricao(pagamentoDto.getDescricao());
        pagamento.setValor(pagamentoDto.getValor());

        Cartao cartao = new Cartao();
        cartao.setId(pagamentoDto.getCartaoId());
        pagamento.setCartaoId(pagamentoDto.getCartaoId());
        return pagamento;
    }
}
