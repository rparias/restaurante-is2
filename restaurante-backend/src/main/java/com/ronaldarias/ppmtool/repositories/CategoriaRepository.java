package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
}
