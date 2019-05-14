package com.ronaldarias.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ronaldarias.ppmtool.domain.EstadoMesa;

@Repository
public interface EstadoMesaRepository extends CrudRepository<EstadoMesa,Integer>{

}
