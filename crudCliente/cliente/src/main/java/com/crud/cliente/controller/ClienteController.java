package com.crud.cliente.controller;


import com.crud.cliente.entity.ClienteEntity;


import com.crud.cliente.service.ClienteService;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController


@RequestMapping("/api/clientes")

public class ClienteController {

    @Autowired
   
    private ClienteService service;

    
    @GetMapping
    // GET → http://localhost:8080/api/clientes
    public List<ClienteEntity> listarTodos() {
        return service.listarTodos();
      
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    // Mapeia GET com parâmetro → /api/clientes/1
    public ClienteEntity buscarPorId(@PathVariable Long id) {
      
        return service.buscarPorId(id);
      
    }

   
    @PostMapping
    
    public ClienteEntity salvar(@RequestBody ClienteEntity cliente) {
       
        return service.salvar(cliente);
      
    }

   
    @PutMapping("/{id}")
   
    public ClienteEntity atualizar(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
       
        return service.atualizar(id, cliente);
    
    }


    @DeleteMapping("/{id}")
  
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
      
    }
}