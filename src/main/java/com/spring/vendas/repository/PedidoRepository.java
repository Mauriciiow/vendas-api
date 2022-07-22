package com.spring.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.spring.vendas.models.Cliente;
import com.spring.vendas.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    List<Pedido> findByCliente(Cliente cliente);
}
