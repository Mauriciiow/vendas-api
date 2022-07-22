package com.spring.vendas.controllers;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vendas.models.Produto;
import com.spring.vendas.repository.ProdutoRepository;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @PostMapping
    public ResponseEntity<Object> postProduto(@RequestBody Produto produto) {
        produtoRepository.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getProduto(@PathParam("id") Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (!produto.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(produto);
    }
}
