package com.spring.vendas.models;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "cpf",nullable = false, length = 11)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;

    public Cliente(){

    }

    public Cliente(Integer id,String nome){
        this.id = id;
        this.nome = nome;
       
    }


    public Cliente(String nome){
        this.nome = nome;
    }

    
    @Override
    public String toString() {
        
        return "nome = " + nome + " id = " + id.toString();
    }

}

