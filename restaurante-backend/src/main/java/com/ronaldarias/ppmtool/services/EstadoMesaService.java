package com.ronaldarias.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldarias.ppmtool.domain.EstadoMesa;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.EstadoMesaRepository;

@Service
public class EstadoMesaService {

	@Autowired
	private EstadoMesaRepository estadomesaRepository;
	public EstadoMesa saveOrUpdateEstadoMesa(EstadoMesa estadoMesa) {
		try {
			return estadomesaRepository.save(estadoMesa);
		}catch (Exception ex) {
            throw new ProjectIdException("Estado Mesa ID " +estadoMesa.getIdEstadomesa()+ " already exists");
			}
	}
 
	public EstadoMesa findEstadoMesaById (Integer estadoMesaId) {
		EstadoMesa estadoMesa = estadomesaRepository.findById(estadoMesaId)
				.orElse(null);
		if(estadoMesa== null) {
			throw new ProjectIdException("Estado Mesa Id"+estadoMesaId+"does not exist");
		}
		return estadoMesa;
	}
	
	public Iterable<EstadoMesa> findAllEstadoMesa(){
		return estadomesaRepository.findAll();
	}
	
	public void DeleteEstadoMesaById(Integer estadoMesaId) {
		EstadoMesa estadoMesa =estadomesaRepository.findById(estadoMesaId)
				.orElse(null);
		if(estadoMesa== null) {
			throw new ProjectIdException("Estado Mesa Id "+estadoMesaId+" does not exist");
		}
		estadomesaRepository.delete(estadoMesa);
	}
}
