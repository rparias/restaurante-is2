package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Rol;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

	@Autowired
	private RolRepository rolRepository;
	public Rol saveOrUpdateRol(Rol rol) {
		try {
			return rolRepository.save(rol);
		}catch (Exception ex) {
            throw new ProjectIdException("Rol ID " +rol.getIdRol()+ " already exists");
			}
	}
 
	public Rol findRolById (Integer rolId) {
		Rol rol = rolRepository.findById(rolId)
				.orElse(null);
		if(rol== null) {
			throw new ProjectIdException("Rol Id "+rolId+" does not exist");
		}
		return rol;
	}
	
	public Iterable<Rol> findAllRol(){
		return rolRepository.findAll();
	}
	
	public void DeleteRolById(Integer rolId) {
		Rol rol =rolRepository.findById(rolId)
				.orElse(null);
		if(rol== null) {
			throw new ProjectIdException("Rol Id "+rolId+" does not exist");
		}
		rolRepository.delete(rol);
	}
}
