package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.DisponibilidadPlato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadPlatoRepository extends CrudRepository<DisponibilidadPlato, Integer> {
}
