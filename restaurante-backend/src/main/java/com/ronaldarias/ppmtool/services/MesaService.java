package com.ronaldarias.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ronaldarias.ppmtool.domain.Mesa;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.MesaRepository;

@Service
public class MesaService {

	@Autowired
	private MesaRepository mesaRepository;
	
	 public Mesa saveOrUpdatePersona(Mesa mesa) {


	        try {
	            return mesaRepository.save(mesa);
	        } catch (Exception ex) {
	            throw new ProjectIdException("Mesa ID " + mesa.getIdMesa() + " already exists");
	        }

	    }
	 public Mesa findMesaById(Integer mesaId) {

	        Mesa mesa = mesaRepository.findById(mesaId)
	                .orElse(null);

	        if (mesa == null) {
	            throw new ProjectIdException("Mesa ID " + mesaId + " does not exist");
	        }

	        return mesa;
	    }
	 public Iterable<Mesa> findAllMesas(){
		 return mesaRepository.findAll();
	 }
	 public void deleteMesaById(Integer mesaId) {
		 Mesa mesa = mesaRepository.findById(mesaId)
				 .orElse(null);
		 if (mesa == null) {
			 throw new ProjectIdException("Mesa ID"+ mesaId+"does not exist");
		 }
		 mesaRepository.delete(mesa);
	 }
}
