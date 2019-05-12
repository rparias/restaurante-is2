package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Pedido;
import com.ronaldarias.ppmtool.domain.PedidoPK;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido saveOrUpdatePedido(Pedido pedido) {

        try {
            return pedidoRepository.save(pedido);
        } catch (Exception ex) {
            throw new ProjectIdException("Pedido ID " + pedido.getPedidoPK().getIdPedido() + " already exists");
        }

    }

    public Pedido findPedidoById(PedidoPK pedidoId) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElse(null);

        if (pedido == null) {
            throw new ProjectIdException("Pedido ID " + pedidoId + " does not exist");
        }

        return pedido;
    }

    public Iterable<Pedido> findAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public void deletePedidoById(PedidoPK pedidoId) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElse(null);

        if (pedido == null) {
            throw new ProjectIdException("Pedido ID " + pedidoId + " does not exist");
        }

        pedidoRepository.delete(pedido);
    }
}
