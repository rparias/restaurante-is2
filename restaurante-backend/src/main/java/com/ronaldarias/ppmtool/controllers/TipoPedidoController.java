package com.ronaldarias.ppmtool.conttipoPedidolers;

import com.ronaldarias.ppmtool.domain.TipoPedido;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import com.ronaldarias.ppmtool.services.TipoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/tipoPedido")
public class TipoPedidoController {

	@Autowired
	private TipoPedidoService tipoPedidoService;
	
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
	public ResponseEntity<?> createNewTipoPedido(@Valid @RequestBody TipoPedido tipoPedido,BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        tipoPedidoService.saveOrUpdateTipoPedido(tipoPedido);
        return new ResponseEntity<TipoPedido>(tipoPedido,HttpStatus.CREATED);

	}
	
	@GetMapping("/{tipoPedidoId}")
	public ResponseEntity<?> getTipoPedidoById(@PathVariable Integer tipoPedidoId){
		TipoPedido tipoPedido = tipoPedidoService.findTipoPedidoById(tipoPedidoId);
		return new ResponseEntity<TipoPedido>(tipoPedido,HttpStatus.OK);
	}
	@GetMapping("/all")
    public Iterable<TipoPedido> getAllTipoPedido(){
		return tipoPedidoService.findAllTipoPedido();
	}
	@DeleteMapping("/{tipoPedidoId}")
	public ResponseEntity<?> deleteMesaById(@PathVariable Integer tipoPedidoId){
		tipoPedidoService.DeleteTipoPedidoById(tipoPedidoId);
		return new ResponseEntity<String>("TipoPedido con ID: "+tipoPedidoId+ " ha sido eliminado", HttpStatus.OK);
	}
	
}
