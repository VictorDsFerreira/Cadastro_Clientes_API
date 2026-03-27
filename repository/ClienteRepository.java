package com.example.System.Clientes.repository;

import com.example.System.Clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public List<Cliente> findByNome(String nome);
    public List<Cliente> findByEmail(String email);
    public List<Cliente> findByNomeStartingWithIgnoreCase(String nome);
}
