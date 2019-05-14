package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.TipoPedido;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.TipoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPedidoService {

    @Autowired
    private TipoPedidoRepository tipopedidoRepository;

    public TipoPedido saveOrUpdateTipoPedido(TipoPedido tipopedido) {

        try {
            return tipopedidoRepository.save(tipopedido);
        } catch (Exception ex) {
            throw new ProjectIdException("TipoPedido ID " + tipopedido.getIdTipopedido() + " already exists");
        }

    }

    public TipoPedido findTipoPedidoById(Integer tipopedidoId) {

        TipoPedido tipopedido = tipopedidoRepository.findById(tipopedidoId)
                .orElse(null);

        if (tipopedido == null) {
            throw new ProjectIdException("TipoPedido ID " + tipopedidoId + " does not exist");
        }

        return tipopedido;
    }

    public Iterable<TipoPedido> findAllTipoPedidos() {
        return tipopedidoRepository.findAll();
    }

    public void deleteTipoPedidoById(Integer tipopedidoId) {

        TipoPedido tipopedido = tipopedidoRepository.findById(tipopedidoId)
                .orElse(null);

        if (tipopedido == null) {
            throw new ProjectIdException("TipoPedido ID " + tipopedidoId + " does not exist");
        }

        tipopedidoRepository.delete(tipopedido);
    }
}
