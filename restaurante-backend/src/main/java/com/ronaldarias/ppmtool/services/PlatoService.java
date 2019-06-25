package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Plato;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    public Plato saveOrUpdatePlato(Plato plato) {

        try {
            return platoRepository.save(plato);
        } catch (Exception ex) {
            throw new ProjectIdException("Plato ID " + plato.getIdPlato() + " already exists");
        }

    }

    public Plato findPlatoById(Integer platoId) {

        Plato plato = platoRepository.findById(platoId)
                .orElse(null);

        if (plato == null) {
            throw new ProjectIdException("Plato ID " + platoId + " does not exist");
        }

        return plato;
    }

    public Iterable<Plato> findAllPlatos() {
        return platoRepository.findAll();
    }

    public void deletePlatoById(Integer platoId) {
        Plato plato = platoRepository.findById(platoId)
                .orElse(null);
        if (plato == null) {
            throw new ProjectIdException("Plato ID " + platoId + " does not exist");
        }
        platoRepository.delete(plato);
    }
}
