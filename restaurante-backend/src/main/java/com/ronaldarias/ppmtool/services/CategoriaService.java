package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Categoria;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria saveOrUpdateCategoria(Categoria categoria) {


        try {
            return categoriaRepository.save(categoria);
        } catch (Exception ex) {
            throw new ProjectIdException("Categoria ID " + categoria.getIdCategoria() + " already exists");
        }

    }
    public Categoria findCategoriaById(Integer categoriaId) {

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElse(null);

        if (categoria == null) {
            throw new ProjectIdException("Categoria ID " + categoriaId + " does not exist");
        }

        return categoria;
    }
    public Iterable<Categoria> findAllCategorias(){
        return categoriaRepository.findAll();
    }
    public void deleteCategoriaById(Integer categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElse(null);
        if (categoria == null) {
            throw new ProjectIdException("Categoria ID "+ categoriaId +" does not exist");
        }
        categoriaRepository.delete(categoria);
    }
}
