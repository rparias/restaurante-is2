package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Pedido;
import com.ronaldarias.ppmtool.domain.PedidoPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, PedidoPK> {

    @Query(value = "SELECT MAX(id_pedido) FROM pedido p", nativeQuery = true)
    public Integer buscarUltimoId();
}
