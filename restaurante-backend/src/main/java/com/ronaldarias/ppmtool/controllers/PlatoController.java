package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.Plato;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import com.ronaldarias.ppmtool.services.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/plato")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    /**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo Plato con los datos ingresados
     */
    @PostMapping("")
    public ResponseEntity<?> createNewPlato (@Valid @RequestBody Plato plato, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        platoService.saveOrUpdatePlato(plato);
        return new ResponseEntity<Plato>(plato, HttpStatus.CREATED);
    }

    @GetMapping("/{platoId}")
    public ResponseEntity<?> getPlatoById(@PathVariable Integer platoId){
        Plato plato= platoService.findPlatoById(platoId);
        return new ResponseEntity<Plato>(plato, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Plato> getAllPlatos(){
        return platoService.findAllPlatos();
    }

    @DeleteMapping("/{platoId}")
    public ResponseEntity<?> deletePlatoById(@PathVariable Integer platoId){
        platoService.deletePlatoById(platoId);
        return new ResponseEntity<String>("Plato con ID: " +platoId + " ha sido eliminada", HttpStatus.OK);
    }
}
