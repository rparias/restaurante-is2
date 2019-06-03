package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Parametro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepository extends CrudRepository<Parametro, Integer> {
}
