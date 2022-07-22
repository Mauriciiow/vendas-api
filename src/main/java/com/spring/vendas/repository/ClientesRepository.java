package com.spring.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.spring.vendas.models.Cliente;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer>{

    List<Cliente> findByNomeLike(String string);

    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    
    @Query(" select c from Cliente c left join fetch c.pedidos where c.id =:id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);

     Optional<Cliente> findById(Integer id);
    
}
