package com.ronaldarias.ppmtool.controllers;


import com.ronaldarias.ppmtool.domain.Mesa;

import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import com.ronaldarias.ppmtool.services.MesaService;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/mesa")
public class MesaController {

	@Autowired
	private MesaService mesaService;
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
    public ResponseEntity<?> createNewMesa (@Valid @RequestBody Mesa mesa, BindingResult result){
    	 ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
         if (errorMap != null)
             return errorMap;
         mesaService.saveOrUpdateMesa(mesa);
         return new ResponseEntity<Mesa>(mesa, HttpStatus.CREATED);
    }
    
    @GetMapping("/{mesaId}")
    public ResponseEntity<?> getMesaById(@PathVariable Integer mesaId){
    	Mesa mesa= mesaService.findMesaById(mesaId);
    	return new ResponseEntity<Mesa>(mesa, HttpStatus.OK);
    }
	
    @GetMapping("/all")
    public Iterable<Mesa> getAllMesas(){
    	return mesaService.findAllMesas();
    }
    
    @DeleteMapping("/{mesaId}")
    public ResponseEntity<?> deleteMesaById(@PathVariable Integer mesaId){
    	mesaService.deleteMesaById(mesaId);
    	return new ResponseEntity<String>("Mesa con ID: " +mesaId + " ha sido eliminada", HttpStatus.OK);
    }
}
