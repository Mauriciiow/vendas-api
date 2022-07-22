package com.spring.vendas.controllers;
import  java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vendas.models.Cliente;
import com.spring.vendas.repository.ClientesRepository;




@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
    
    @Autowired 
    private ClientesRepository clientesRepository;

    @GetMapping("{id}")
    public ResponseEntity<Object> getClienteById(@PathVariable("id") Integer id) {
       Optional<Cliente> cliente = clientesRepository.findById(id);

       if (cliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(cliente.get());
       }

       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found");
    }

    @PostMapping
    public ResponseEntity<Object> postCliente(@RequestBody Cliente cliente){
        
        clientesRepository.save(cliente);  
  
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable("id") Integer id){

        Optional<Cliente> cliente = clientesRepository.findById(id);

        if (!cliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");
        }

         clientesRepository.delete(cliente.get());  

         return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente deletado");
        
    } 

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizaCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente_dados) {

        Optional<Cliente> cliente = clientesRepository.findById(id);

        if (!cliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");
        }

        Cliente clienteUpdate = cliente.get();

        clienteUpdate.setNome(cliente_dados.getNome());
        clientesRepository.save(clienteUpdate);

        return ResponseEntity.status(HttpStatus.OK).body(clienteUpdate);

        
    }

    @GetMapping
    public ResponseEntity<Object> find(Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);

        List<Cliente> clientes = clientesRepository.findAll(example);
        
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }



 

    
    
}


