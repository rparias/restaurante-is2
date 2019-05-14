package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.Parametro;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import com.ronaldarias.ppmtool.services.ParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/parametro")
public class ParametroController {

    @Autowired
    private ParametroService parametroService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    /**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo Parametro con los datos ingresados
     */
    @PostMapping("")
    public ResponseEntity<?> createNewParametro(@Valid @RequestBody Parametro parametro, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        parametroService.saveOrUpdateParametro(parametro);
        return new ResponseEntity<Parametro>(parametro, HttpStatus.CREATED);
    }

    @GetMapping("/{parametroId}")
    public ResponseEntity<?> getParametroById(@PathVariable Integer parametroId) {

        Parametro parametro = parametroService.findParametroById(parametroId);

        return new ResponseEntity<Parametro>(parametro, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Parametro> getAllParametros() {
        return parametroService.findAllParametros();
    }

    @DeleteMapping("/{parametroId}")
    public ResponseEntity<?> deleteParametroById(@PathVariable Integer parametroId) {

        parametroService.deleteParametroById(parametroId);

        return new ResponseEntity<String>("Parametro con ID: " + parametroId + " ha sido eliminada", HttpStatus.OK);
    }
}
