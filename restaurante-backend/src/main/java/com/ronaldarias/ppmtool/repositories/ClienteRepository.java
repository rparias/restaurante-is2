package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
