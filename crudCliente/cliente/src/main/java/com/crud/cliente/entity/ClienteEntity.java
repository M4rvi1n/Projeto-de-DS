package com.crud.cliente.entity;


import jakarta.persistence.*;


import lombok.Data;


import java.time.LocalDateTime;


@Data

@Entity

@Table(name = "tbl_cliente")

public class ClienteEntity {

    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long id;

    @Column(nullable = false)
   
    private String nome;

    private String sobrenome;
  

    @Column(unique = true, nullable = false)
    
    private String email;

    private String telefone;
    // Campo opcional

    @Column(unique = true)
    
    private String cpf;

    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
   
    private LocalDateTime dataCadastro;
 

    @PrePersist
   
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now();
        
    }
}