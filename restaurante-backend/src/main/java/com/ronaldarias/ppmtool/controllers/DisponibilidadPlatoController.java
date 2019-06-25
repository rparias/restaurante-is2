package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.DisponibilidadPlato;
import com.ronaldarias.ppmtool.services.DisponibilidadPlatoService;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/disponibilidadPlato")
public class DisponibilidadPlatoController {

    @Autowired
    private DisponibilidadPlatoService disponibilidadPlatoService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    /**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo DisponibilidadPlato con los datos ingresados
     */
    @PostMapping("")
    public ResponseEntity<?> createNewDisponibilidadPlato (@Valid @RequestBody DisponibilidadPlato disponibilidadPlato, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        disponibilidadPlatoService.saveOrUpdateDisponibilidadPlato(disponibilidadPlato);
        return new ResponseEntity<DisponibilidadPlato>(disponibilidadPlato, HttpStatus.CREATED);
    }

    @GetMapping("/{disponibilidadPlatoId}")
    public ResponseEntity<?> getDisponibilidadPlatoById(@PathVariable Integer disponibilidadPlatoId){
        DisponibilidadPlato disponibilidadPlato= disponibilidadPlatoService.findDisponibilidadPlatoById(disponibilidadPlatoId);
        return new ResponseEntity<DisponibilidadPlato>(disponibilidadPlato, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<DisponibilidadPlato> getAllDisponibilidadPlatos(){
        return disponibilidadPlatoService.findAllDisponibilidadPlatos();
    }

    @DeleteMapping("/{disponibilidadPlatoId}")
    public ResponseEntity<?> deleteDisponibilidadPlatoById(@PathVariable Integer disponibilidadPlatoId){
        disponibilidadPlatoService.deleteDisponibilidadPlatoById(disponibilidadPlatoId);
        return new ResponseEntity<String>("DisponibilidadPlato con ID: " +disponibilidadPlatoId + " ha sido eliminada", HttpStatus.OK);
    }
}
