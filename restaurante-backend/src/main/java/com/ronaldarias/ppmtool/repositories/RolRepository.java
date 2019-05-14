package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {
}
