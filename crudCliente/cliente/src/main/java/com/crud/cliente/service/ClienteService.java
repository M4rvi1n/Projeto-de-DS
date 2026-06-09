package com.crud.cliente.service;


import com.crud.cliente.entity.ClienteEntity;


import com.crud.cliente.repository.ClienteRepository;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import java.util.List;


@Service

public class ClienteService {

    @Autowired
   
    private ClienteRepository repository;

    // LISTAR TODOS
    public List<ClienteEntity> listarTodos() {
        return repository.findAll();
        
    }

    // BUSCAR POR ID
    public ClienteEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
       
        
    }

    // SALVAR
    public ClienteEntity salvar(ClienteEntity cliente) {
        return repository.save(cliente);
       
    }

    // ATUALIZAR
    public ClienteEntity atualizar(Long id, ClienteEntity cliente) {

        ClienteEntity existente = buscarPorId(id);
      

        existente.setNome(cliente.getNome());
        existente.setSobrenome(cliente.getSobrenome());
        existente.setEmail(cliente.getEmail());
        existente.setTelefone(cliente.getTelefone());
        existente.setCpf(cliente.getCpf());
        existente.setEndereco(cliente.getEndereco());
        existente.setCidade(cliente.getCidade());
        existente.setEstado(cliente.getEstado());
        existente.setCep(cliente.getCep());
     

        return repository.save(existente);
       
    }

    // DELETAR
    public void deletar(Long id) {
        repository.deleteById(id);
       
    }
}