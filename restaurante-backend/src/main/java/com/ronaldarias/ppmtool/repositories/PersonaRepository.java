package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
}
