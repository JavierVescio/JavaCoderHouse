package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /*@GetMapping(value="cliente/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return clienteService.getClienteById(id);
    }*/

    @GetMapping(value="cliente/{id}")
    public Map<String, Object> getClienteConEdad(@PathVariable Long id){
        return clienteService.getClienteConEdad(id);
    }

    @GetMapping("clientes")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @PostMapping("alta")
    public String altaCliente(@RequestBody Cliente cliente){
        return clienteService.altaCliente(cliente);
    }
}
