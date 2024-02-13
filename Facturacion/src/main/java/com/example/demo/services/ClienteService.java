package com.example.demo.services;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getClienteById(long id){
        return clienteRepository.findById(id).get();
    }

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public String altaCliente(Cliente cliente){
        clienteRepository.save(cliente);
        return "Guardado";
    }

    public String modificarCliente(long id, Cliente cliente){
        Cliente updateCliente = clienteRepository.findById(id).get();
        updateCliente.setNombre(cliente.getNombre());
        updateCliente.setEmail(cliente.getEmail());
        clienteRepository.save(updateCliente);
        return "Modificado";
    }

    public String eliminarCliente(long id){
        Cliente deleteCliente = clienteRepository.findById(id).get();
        clienteRepository.delete(deleteCliente);
        return "Eliminado";
    }
}
