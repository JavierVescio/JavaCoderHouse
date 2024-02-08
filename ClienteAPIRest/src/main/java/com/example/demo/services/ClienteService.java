package com.example.demo.services;

import com.example.demo.models.Cliente;
import com.example.demo.models.ClienteDto;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getClienteById(long id){
        return clienteRepository.findById(id).get();
    }

    public ClienteDto getClienteConEdad(long id){
        Cliente cliente = clienteRepository.findById(id).get();

        int edad = Period.between(cliente.getFechaNacimiento(), LocalDate.now()).getYears();

        ClienteDto clienteDto = new ClienteDto(
                cliente.getNombre(),
                cliente.getApellido(),
                edad
        );

        return clienteDto;
    }

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public String altaCliente(Cliente cliente){
        clienteRepository.save(cliente);
        return "Guardado";
    }
}
