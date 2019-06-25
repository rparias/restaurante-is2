package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Parametro;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParametroService {

    @Autowired
    private ParametroRepository parametroRepository;

    public Parametro saveOrUpdateParametro(Parametro parametro) {

        try {
            return parametroRepository.save(parametro);
        } catch (Exception ex) {
            throw new ProjectIdException("Parametro ID " + parametro.getIdParametro() + " already exists");
        }

    }

    public Parametro findParametroById(Integer parametroId) {

        Parametro parametro = parametroRepository.findById(parametroId)
                .orElse(null);

        if (parametro == null) {
            throw new ProjectIdException("Parametro ID " + parametroId + " does not exist");
        }

        return parametro;
    }

    public Iterable<Parametro> findAllParametros() {
        return parametroRepository.findAll();
    }

    public void deleteParametroById(Integer parametroId) {
        Parametro parametro = parametroRepository.findById(parametroId)
                .orElse(null);
        if (parametro == null) {
            throw new ProjectIdException("Parametro ID " + parametroId + " does not exist");
        }
        parametroRepository.delete(parametro);
    }
}
