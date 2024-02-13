package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value="api/cliente/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return clienteService.getClienteById(id);
    }

    @GetMapping("api/cliente")
    public List<Cliente> getClientes(){
        return  clienteService.getClientes();
    }

    @PostMapping("api/cliente/alta")
    public String post(@RequestBody Cliente cliente){
        return clienteService.altaCliente(cliente);
    }

    @PutMapping("api/cliente/modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.modificarCliente(id, cliente);
    }

    @DeleteMapping("api/baja/{id}")
    public String delete(@PathVariable Long id){
        clienteService.eliminarCliente(id);
        return "Eliminado";
    }



}
