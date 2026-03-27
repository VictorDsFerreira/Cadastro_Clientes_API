package com.example.System.Clientes.controller;

import com.example.System.Clientes.model.Cliente;
import com.example.System.Clientes.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    @GetMapping
    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    @GetMapping("{id}")
    public Cliente buscarPorId(@PathVariable Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public String deletarCliente(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return "Usuario deletado com sucesso";
    }

    @GetMapping("/porNome")
    public List<Cliente> buscarPorNome(@RequestParam String nome){
        return clienteRepository.findByNome(nome);
    }

    @GetMapping("/porNomeParcial")
    public List<Cliente> buscarPorNomeParcial(@RequestParam String nome){
        return clienteRepository.findByNomeStartingWithIgnoreCase(nome);
    }

    @GetMapping("/porEmail")
    public List<Cliente> buscarPorEmail(@RequestParam String email){
        return clienteRepository.findByEmail(email);
    }
}
