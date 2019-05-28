package com.ronaldarias.ppmtool.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ronaldarias.ppmtool.domain.EstadoMesa;
import com.ronaldarias.ppmtool.services.EstadoMesaService;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;

@CrossOrigin(origins = "https://restaurante-is-udla.herokuapp.com")
@RestController
@RequestMapping("/api/estadoMesa")
public class EstadoMesaController {

	@Autowired
	private EstadoMesaService estadoMesaService;
	
	@Autowired
    private MapValidationErrorService mapValidationErrorService;
	
	/**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo Persona con los datos ingresados
     */
	@PostMapping("")
	public ResponseEntity<?> createNewEsatdoMesa(@Valid @RequestBody EstadoMesa estadoMesa,BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        estadoMesaService.saveOrUpdateEsatdoMesa(estadoMesa);
        return new ResponseEntity<EstadoMesa>(estadoMesa,HttpStatus.CREATED);

	}
	
	@GetMapping("/{estadoMesaId}")
	public ResponseEntity<?> getEstadoMesaById(@PathVariable Integer estadoMesaId){
		EstadoMesa estadoMesa = estadoMesaService.findEstadoMesaById(estadoMesaId);
		return new ResponseEntity<EstadoMesa>(estadoMesa,HttpStatus.OK);
	}
	@GetMapping("/all")
    public Iterable<EstadoMesa> getAllEstadoMesa(){
		return estadoMesaService.findAllEstadoMesa();
	}
	@DeleteMapping("/{estadoMesaId}")
	public ResponseEntity<?> deleteMesaById(@PathVariable Integer estadoMesaId){
		estadoMesaService.DeleteEstadoMesaById(estadoMesaId);
		return new ResponseEntity<String>("Esatdo Mesa con ID: "+estadoMesaId+ " ha sido eliminada", HttpStatus.OK);
	}
	
}
