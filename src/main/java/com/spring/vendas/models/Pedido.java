package com.spring.vendas.models;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Column(name = "data_pedido", nullable = false)
    private LocalDate data;
    @Column(name = "total", nullable = false, precision = 20, scale = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido" )
    private List<ItemPedido> itens;

    @Override
    public String toString(){
        return "Pedido { " + "id = " + id + " data = " + data + " total= " + total;
    }
}
