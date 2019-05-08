package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Persona;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona saveOrUpdatePersona(Persona persona) {

        try {
            return personaRepository.save(persona);
        } catch (Exception ex) {
            throw new ProjectIdException("Persona ID " + persona.getIdPersona() + " already exists");
        }

    }

    public Persona findPersonaById(Integer personaId) {

        Persona persona = personaRepository.findById(personaId)
                .orElse(null);

        if (persona == null) {
            throw new ProjectIdException("Persona ID " + personaId + " does not exist");
        }

        return persona;
    }

    public Iterable<Persona> findAllPersonas() {
        return personaRepository.findAll();
    }

    public void deletePersonaById(Integer personaId) {

        Persona persona = personaRepository.findById(personaId)
                .orElse(null);

        if (persona == null) {
            throw new ProjectIdException("Persona ID " + personaId + " does not exist");
        }

        personaRepository.delete(persona);
    }
}
