package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.TipoPedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPedidoRepository extends CrudRepository<TipoPedido,Integer>{

}
