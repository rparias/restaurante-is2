package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.DisponibilidadPlato;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.DisponibilidadPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DisponibilidadPlatoService {

    @Autowired
    private DisponibilidadPlatoRepository disponibilidadPlatoRepository;

    @Transactional
    public DisponibilidadPlato saveOrUpdateDisponibilidadPlato(DisponibilidadPlato disponibilidadPlato) {

        try {
            return disponibilidadPlatoRepository.save(disponibilidadPlato);
        } catch (Exception ex) {
            throw new ProjectIdException("DisponibilidadPlato ID " + disponibilidadPlato.getIdDisponibilidadplato() + " already exists");
        }

    }

    public DisponibilidadPlato findDisponibilidadPlatoById(Integer disponibilidadPlatoId) {

        DisponibilidadPlato disponibilidadPlato = disponibilidadPlatoRepository.findById(disponibilidadPlatoId)
                .orElse(null);

        if (disponibilidadPlato == null) {
            throw new ProjectIdException("DisponibilidadPlato ID " + disponibilidadPlatoId + " does not exist");
        }

        return disponibilidadPlato;
    }

    public Iterable<DisponibilidadPlato> findAllDisponibilidadPlatos() {
        return disponibilidadPlatoRepository.findAll();
    }

    @Transactional
    public void deleteDisponibilidadPlatoById(Integer disponibilidadPlatoId) {

        DisponibilidadPlato disponibilidadPlato = disponibilidadPlatoRepository.findById(disponibilidadPlatoId)
                .orElse(null);

        if (disponibilidadPlato == null) {
            throw new ProjectIdException("DisponibilidadPlato ID " + disponibilidadPlatoId + " does not exist");
        }

        disponibilidadPlatoRepository.delete(disponibilidadPlato);
    }
}
