package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.Detalle;
import com.ronaldarias.ppmtool.domain.DetallePK;
import com.ronaldarias.ppmtool.services.DetalleService;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/detalle")
public class DetalleController {

    @Autowired
    private DetalleService detalleService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    /**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo Detalle con los datos ingresados
     */
    @PostMapping("")
    public ResponseEntity<?> createNewDetalle(@Valid @RequestBody Detalle detalle, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        detalleService.saveOrUpdateDetalle(detalle);
        return new ResponseEntity<Detalle>(detalle, HttpStatus.CREATED);
    }

    @GetMapping("/{detalleId}")
    public ResponseEntity<?> getDetalleById(@PathVariable DetallePK detalleId) {

        Detalle detalle = detalleService.findDetalleById(detalleId);

        return new ResponseEntity<Detalle>(detalle, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Detalle> getAllDetalles() {
        return detalleService.findAllDetalles();
    }

    @DeleteMapping("/{detalleId}")
    public ResponseEntity<?> deleteDetalleById(@PathVariable DetallePK detalleId) {

        detalleService.deleteDetalleById(detalleId);

        return new ResponseEntity<String>("Detalle con ID: " + detalleId + " ha sido eliminada", HttpStatus.OK);
    }
}
