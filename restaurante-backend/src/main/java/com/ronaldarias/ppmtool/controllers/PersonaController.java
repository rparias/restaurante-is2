package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.Persona;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import com.ronaldarias.ppmtool.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

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
    public ResponseEntity<?> createNewPersona(@Valid @RequestBody Persona persona, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        personaService.saveOrUpdatePersona(persona);
        return new ResponseEntity<Persona>(persona, HttpStatus.CREATED);
    }

    @GetMapping("/{personaId}")
    public ResponseEntity<?> getPersonaById(@PathVariable Integer personaId) {

        Persona persona = personaService.findPersonaById(personaId);

        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Persona> getAllPersonas() {
        return personaService.findAllPersonas();
    }

    @DeleteMapping("/{personaId}")
    public ResponseEntity<?> deletePersonaById(@PathVariable Integer personaId) {

        personaService.deletePersonaById(personaId);

        return new ResponseEntity<String>("Persona con ID: " + personaId + " ha sido eliminada", HttpStatus.OK);
    }
}
