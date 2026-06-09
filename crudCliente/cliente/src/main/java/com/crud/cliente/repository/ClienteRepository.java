package com.crud.cliente.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;


import com.crud.cliente.entity.ClienteEntity;


@Repository

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{
    

   
}
