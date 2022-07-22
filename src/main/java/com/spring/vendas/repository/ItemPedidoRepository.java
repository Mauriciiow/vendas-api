package com.spring.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.vendas.models.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
    
}
