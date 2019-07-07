package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.LoginDTO;
import com.ronaldarias.ppmtool.domain.Empleado;
import com.ronaldarias.ppmtool.services.EmpleadoService;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    /**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo Empleado con los datos ingresados
     */
    @PostMapping("")
    public ResponseEntity<?> createNewEmpleado(@Valid @RequestBody Empleado empleado, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        empleadoService.saveOrUpdateEmpleado(empleado);
        return new ResponseEntity<Empleado>(empleado, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmpleado(@Valid @RequestBody LoginDTO login, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        Empleado empleado = empleadoService.findEmpleadoLogin(login.getUsuario(), login.getPassword());
        return new ResponseEntity<Empleado>(empleado, HttpStatus.CREATED);
    }

    @GetMapping("/{empleadoId}")
    public ResponseEntity<?> getEmpleadoById(@PathVariable Integer empleadoId) {

        Empleado empleado = empleadoService.findEmpleadoById(empleadoId);

        return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Empleado> getAllEmpleados() {
        return empleadoService.findAllEmpleados();
    }

    @DeleteMapping("/{empleadoId}")
    public ResponseEntity<?> deleteEmpleadoById(@PathVariable Integer empleadoId) {

        empleadoService.deleteEmpleadoById(empleadoId);

        return new ResponseEntity<String>("Empleado con ID: " + empleadoId + " ha sido eliminado", HttpStatus.OK);
    }
}
