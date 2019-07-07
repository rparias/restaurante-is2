package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {

    public Empleado findEmpleadoByUsuarioempleadoAndPasswordempleado(String usuario, String password);
}
