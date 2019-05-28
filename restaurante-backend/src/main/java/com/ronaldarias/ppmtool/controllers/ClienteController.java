package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.Cliente;
import com.ronaldarias.ppmtool.services.ClienteService;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    /**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo Cliente con los datos ingresados
     */
    @PostMapping("")
    public ResponseEntity<?> createNewCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        clienteService.saveOrUpdateCliente(cliente);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<?> getClienteById(@PathVariable Integer clienteId) {

        Cliente cliente = clienteService.findClienteById(clienteId);

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Cliente> getAllClientes() {
        return clienteService.findAllClientes();
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<?> deleteClienteById(@PathVariable Integer clienteId) {

        clienteService.deleteClienteById(clienteId);

        return new ResponseEntity<String>("Cliente con ID: " + clienteId + " ha sido eliminado", HttpStatus.OK);
    }
}
