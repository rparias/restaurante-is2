package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Detalle;
import com.ronaldarias.ppmtool.domain.DetallePK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends CrudRepository<Detalle, DetallePK> {
}
