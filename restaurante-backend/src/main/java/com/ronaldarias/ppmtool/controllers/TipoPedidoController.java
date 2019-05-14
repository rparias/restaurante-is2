package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.TipoPedido;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import com.ronaldarias.ppmtool.services.TipoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tipopedido")
public class TipoPedidoController {

    @Autowired
    private TipoPedidoService tipopedidoService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    /**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo TipoPedido con los datos ingresados
     */
    @PostMapping("")
    public ResponseEntity<?> createNewTipoPedido(@Valid @RequestBody TipoPedido tipopedido, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        tipopedidoService.saveOrUpdateTipoPedido(tipopedido);
        return new ResponseEntity<TipoPedido>(tipopedido, HttpStatus.CREATED);
    }

    @GetMapping("/{tipopedidoId}")
    public ResponseEntity<?> getTipoPedidoById(@PathVariable Integer tipopedidoId) {

        TipoPedido tipopedido = tipopedidoService.findTipoPedidoById(tipopedidoId);

        return new ResponseEntity<TipoPedido>(tipopedido, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<TipoPedido> getAllTipoPedidos() {
        return tipopedidoService.findAllTipoPedidos();
    }

    @DeleteMapping("/{tipopedidoId}")
    public ResponseEntity<?> deleteTipoPedidoById(@PathVariable Integer tipopedidoId) {

        tipopedidoService.deleteTipoPedidoById(tipopedidoId);

        return new ResponseEntity<String>("TipoPedido con ID: " + tipopedidoId + " ha sido eliminada", HttpStatus.OK);
    }
}
