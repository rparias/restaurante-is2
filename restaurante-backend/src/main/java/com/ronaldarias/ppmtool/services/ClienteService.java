package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Cliente;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveOrUpdateCliente(Cliente cliente) {

        try {
            return clienteRepository.save(cliente);
        } catch (Exception ex) {
            throw new ProjectIdException("Cliente ID " + cliente.getIdPersona() + " already exists");
        }

    }

    public Cliente findClienteById(Integer personaId) {

        Cliente cliente = clienteRepository.findById(personaId)
                .orElse(null);

        if (cliente == null) {
            throw new ProjectIdException("Cliente ID " + personaId + " does not exist");
        }

        return cliente;
    }

    public Iterable<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    public void deleteClienteById(Integer personaId) {

        Cliente cliente = clienteRepository.findById(personaId)
                .orElse(null);

        if (cliente == null) {
            throw new ProjectIdException("Cliente ID " + personaId + " does not exist");
        }

        clienteRepository.delete(cliente);
    }
}
