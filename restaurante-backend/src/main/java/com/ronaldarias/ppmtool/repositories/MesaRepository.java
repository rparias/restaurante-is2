package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Mesa;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends CrudRepository<Mesa, Integer>{

}
