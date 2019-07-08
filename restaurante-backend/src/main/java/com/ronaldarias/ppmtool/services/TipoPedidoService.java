package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.TipoPedido;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.TipoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPedidoService {

	@Autowired
	private TipoPedidoRepository tipoPedidoRepository;
	public TipoPedido saveOrUpdateTipoPedido(TipoPedido tipoPedido) {
		try {
			return tipoPedidoRepository.save(tipoPedido);
		}catch (Exception ex) {
            throw new ProjectIdException("TipoPedido ID " +tipoPedido.getIdTipopedido()+ " already exists");
			}
	}
 
	public TipoPedido findTipoPedidoById (Integer tipoPedidoId) {
		TipoPedido tipoPedido = tipoPedidoRepository.findById(tipoPedidoId)
				.orElse(null);
		if(tipoPedido== null) {
			throw new ProjectIdException("TipoPedido Id "+tipoPedidoId+" does not exist");
		}
		return tipoPedido;
	}
	
	public Iterable<TipoPedido> findAllTipoPedido(){
		return tipoPedidoRepository.findAll();
	}
	
	public void DeleteTipoPedidoById(Integer tipoPedidoId) {
		TipoPedido tipoPedido =tipoPedidoRepository.findById(tipoPedidoId)
				.orElse(null);
		if(tipoPedido== null) {
			throw new ProjectIdException("TipoPedido Id "+tipoPedidoId+" does not exist");
		}
		tipoPedidoRepository.delete(tipoPedido);
	}
}
