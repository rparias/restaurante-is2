package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Cliente;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.ClienteRepository;
import com.ronaldarias.ppmtool.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Transactional
    public Cliente saveOrUpdateCliente(Cliente cliente) {

        try {
            personaRepository.save(cliente.getPersona());
            cliente.setIdPersona(cliente.getPersona().getIdPersona());
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

    @Transactional
    public void deleteClienteById(Integer personaId) {

        Cliente cliente = clienteRepository.findById(personaId)
                .orElse(null);

        if (cliente == null) {
            throw new ProjectIdException("Cliente ID " + personaId + " does not exist");
        }

        clienteRepository.delete(cliente);
        personaRepository.delete(cliente.getPersona());
    }
}
