package com.crud.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crud.cliente.entity.ClienteEntity;
import com.crud.cliente.service.ClienteService;

@Controller
@RequestMapping("/clientes-html")
public class ClienteHtmlController {

    @Autowired
    private ClienteService service;

    @GetMapping("/")
    public String abrirClienteHtml() {
        return "redirect:/Cliente.html";
    }

    // CREATE
    @PostMapping("/salvar")
    public String salvarCliente(
            @RequestParam String nome,
            @RequestParam String sobrenome,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam String cpf,
            @RequestParam String endereco,
            @RequestParam String cidade,
            @RequestParam String estado,
            @RequestParam String cep
    ) {
        ClienteEntity cliente = new ClienteEntity();

        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setCidade(cidade);
        cliente.setEstado(estado);
        cliente.setCep(cep);

        service.salvar(cliente);

        return "redirect:/Cliente.html";
    }

    // READ
    @GetMapping("/buscar")
    @ResponseBody
    public ClienteEntity buscarCliente(@RequestParam Long id) {
        return service.buscarPorId(id);
    }

    // UPDATE
    @PostMapping("/atualizar")
    public String atualizarCliente(
            @RequestParam Long id,
            @RequestParam String nome,
            @RequestParam String sobrenome,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam String cpf,
            @RequestParam String endereco,
            @RequestParam String cidade,
            @RequestParam String estado,
            @RequestParam String cep
    ) {
        ClienteEntity cliente = new ClienteEntity();

        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setCidade(cidade);
        cliente.setEstado(estado);
        cliente.setCep(cep);

        service.atualizar(id, cliente);

        return "redirect:/Cliente.html";
    }

    // DELETE
    @PostMapping("/excluir")
    public String excluirCliente(@RequestParam Long id) {
        service.deletar(id);

        return "redirect:/Cliente.html";
    }
}