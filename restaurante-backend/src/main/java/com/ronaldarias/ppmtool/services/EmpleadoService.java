package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Empleado;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado saveOrUpdateEmpleado(Empleado empleado) {

        try {
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

    public Iterable<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public void deleteEmpleadoById(Integer personaId) {

        Empleado empleado = empleadoRepository.findById(personaId)
                .orElse(null);

        if (empleado == null) {
            throw new ProjectIdException("Empleado ID " + personaId + " does not exist");
        }

        empleadoRepository.delete(empleado);
    }
}
