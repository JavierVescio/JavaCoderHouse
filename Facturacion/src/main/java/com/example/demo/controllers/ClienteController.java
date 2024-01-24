package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository repo;

    @GetMapping("api/cliente")
    public List<Cliente> getClientes(){
        return  repo.findAll();
    }

    @PostMapping("api/cliente")
    public String post(@RequestBody Cliente cliente){
        repo.save(cliente);
        return "Guardado";
    }

    @PutMapping("api/cliente/{id}")
    public String update(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente updateCliente = repo.findById(id).get();
        updateCliente.setNombre(cliente.getNombre());
        updateCliente.setEmail(cliente.getEmail());
        repo.save(updateCliente);
        return "Modificado";
    }

    @DeleteMapping("api/cliente/{id}")
        public String delete(@PathVariable Long id){

        Cliente deleteCliente = repo.findById(id).get();
        repo.delete(deleteCliente);
        return "Eliminado";
    }



}
