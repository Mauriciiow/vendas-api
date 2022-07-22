package com.spring.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.vendas.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
