package br.com.leangua.cliente.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.leangua.cliente.models.Cliente;
import br.com.leangua.cliente.services.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/cliente")
    public ResponseEntity<?> CadastrarCliente(@Valid @RequestBody Cliente cliente){
        System.out.println("passando em cliente 2");
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.criar(cliente));
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @GetMapping("/cliente/{id}")
    public Cliente buscarCliente(@PathVariable int id) {
        return clienteService.buscaCliente(id);
//
    }

}