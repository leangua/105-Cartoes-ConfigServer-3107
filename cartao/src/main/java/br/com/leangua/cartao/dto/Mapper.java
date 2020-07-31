package br.com.leangua.cartao.dto;

import br.com.leangua.cartao.models.Cartao;
import br.com.leangua.cartao.models.Cliente;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Cartao paraCartao(CartaoEntradaDto cartaoEntradaDto){
        Cartao cartao = new Cartao();
        cartao.setNumero(cartaoEntradaDto.getNumero());
        cartao.setClienteId(cartaoEntradaDto.getClienteId());
        return cartao;
    }

    public CartaoDto paraCartaoDto(Cartao cartao){
        CartaoDto cartaoDto = new CartaoDto();
        cartaoDto.setClienteId(cartao.getClienteId());
        cartaoDto.setAtivo(cartao.getAtivo());
        cartaoDto.setId(cartao.getId());
        cartaoDto.setNumero(cartao.getNumero());
        return cartaoDto;
    }

}
