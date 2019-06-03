package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Detalle;
import com.ronaldarias.ppmtool.domain.DetallePK;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalleService {

    @Autowired
    private DetalleRepository detalleRepository;

    @Transactional
    public Detalle saveOrUpdateDetalle(Detalle detalle) {

        try {
            return detalleRepository.save(detalle);
        } catch (Exception ex) {
            throw new ProjectIdException("Detalle ID " + detalle.getDetallePK().getIdPedido() + " already exists");
        }

    }

    public Detalle findDetalleById(DetallePK detalleId) {

        Detalle detalle = detalleRepository.findById(detalleId)
                .orElse(null);

        if (detalle == null) {
            throw new ProjectIdException("Detalle ID " + detalleId.getIdPedido() + " does not exist");
        }

        return detalle;
    }

    public Iterable<Detalle> findAllDetalles() {
        return detalleRepository.findAll();
    }

    @Transactional
    public void deleteDetalleById(DetallePK detalleId) {

        Detalle detalle = detalleRepository.findById(detalleId)
                .orElse(null);

        if (detalle == null) {
            throw new ProjectIdException("Detalle ID " + detalleId.getIdPedido() + " does not exist");
        }

        detalleRepository.delete(detalle);
    }
}
