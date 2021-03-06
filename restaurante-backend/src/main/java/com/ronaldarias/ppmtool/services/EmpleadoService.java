package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Empleado;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.EmpleadoRepository;
import com.ronaldarias.ppmtool.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Transactional
    public Empleado saveOrUpdateEmpleado(Empleado empleado) {

        try {
            personaRepository.save(empleado.getPersona());
            empleado.setIdPersona(empleado.getPersona().getIdPersona());
            return empleadoRepository.save(empleado);
        } catch (Exception ex) {
            throw new ProjectIdException("Empleado ID " + empleado.getIdPersona() + " already exists");
        }

    }

    public Empleado findEmpleadoById(Integer personaId) {

        Empleado empleado = empleadoRepository.findById(personaId)
                .orElse(null);

        if (empleado == null) {
            throw new ProjectIdException("Empleado ID " + personaId + " does not exist");
        }

        return empleado;
    }

    public Empleado findEmpleadoLogin(String usuario, String password) {

        Empleado empleado = empleadoRepository.findEmpleadoByUsuarioempleadoAndPasswordempleado(usuario, password);

        if (empleado == null) {
            throw new ProjectIdException("Usuario o clave incorrectas");
        }

        return empleado;
    }

    public Iterable<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Transactional
    public void deleteEmpleadoById(Integer personaId) {

        Empleado empleado = empleadoRepository.findById(personaId)
                .orElse(null);

        if (empleado == null) {
            throw new ProjectIdException("Empleado ID " + personaId + " does not exist");
        }

        empleadoRepository.delete(empleado);
        personaRepository.delete(empleado.getPersona());
    }
}
