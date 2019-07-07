package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.Detalle;
import com.ronaldarias.ppmtool.domain.Pedido;
import com.ronaldarias.ppmtool.domain.PedidoPK;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import com.ronaldarias.ppmtool.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    /**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo Pedido con los datos ingresados
     */
    @PostMapping("")
    public ResponseEntity<?> createNewPedido(@Valid @RequestBody Pedido pedido, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        if (pedido.getPedidoPK().getIdPedido() == null) {
            PedidoPK pedidoPK = pedido.getPedidoPK();
            Integer idPedido = pedidoService.buscarUltimoIdMasUno();
            pedidoPK.setIdPedido(idPedido);
            pedido.setPedidoPK(pedidoPK);

            List<Detalle> detalleList = pedido.getDetalleList();

            for (Detalle detalle : detalleList) {
                detalle.getDetallePK().setIdPedido(idPedido);
            }

            pedido.setDetalleList(detalleList);
        }

        pedidoService.saveOrUpdatePedido(pedido);
        return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<?> getPedidoById(@PathVariable PedidoPK pedidoId) {

        Pedido pedido = pedidoService.findPedidoById(pedidoId);

        return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Pedido> getAllPedidos() {
        return pedidoService.findAllPedidos();
    }

    @DeleteMapping("/{pedidoId}")
    public ResponseEntity<?> deletePedidoById(@PathVariable PedidoPK pedidoId) {

        pedidoService.deletePedidoById(pedidoId);

        return new ResponseEntity<String>("Pedido con ID: " + pedidoId + " ha sido eliminada", HttpStatus.OK);
    }
}
