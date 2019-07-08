package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.Rol;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import com.ronaldarias.ppmtool.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/rol")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@Autowired
    private MapValidationErrorService mapValidationErrorService;
	
	/**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo Rol con los datos ingresados
     */
	@PostMapping("")
	public ResponseEntity<?> createNewRol(@Valid @RequestBody Rol rol,BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        rolService.saveOrUpdateRol(rol);
        return new ResponseEntity<Rol>(rol,HttpStatus.CREATED);

	}
	
	@GetMapping("/{rolId}")
	public ResponseEntity<?> getRolById(@PathVariable Integer rolId){
		Rol rol = rolService.findRolById(rolId);
		return new ResponseEntity<Rol>(rol,HttpStatus.OK);
	}
	@GetMapping("/all")
    public Iterable<Rol> getAllRol(){
		return rolService.findAllRol();
	}
	@DeleteMapping("/{rolId}")
	public ResponseEntity<?> deleteMesaById(@PathVariable Integer rolId){
		rolService.DeleteRolById(rolId);
		return new ResponseEntity<String>("Rol con ID: "+rolId+ " ha sido eliminado", HttpStatus.OK);
	}
	
}
