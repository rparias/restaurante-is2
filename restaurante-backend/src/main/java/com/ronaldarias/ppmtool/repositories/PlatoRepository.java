package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Plato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends CrudRepository<Plato, Integer> {
}
