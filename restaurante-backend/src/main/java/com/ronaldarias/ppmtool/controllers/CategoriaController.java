package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.Categoria;
import com.ronaldarias.ppmtool.services.CategoriaService;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    /**
     * @Valid sirve para obtener el error en el json de forma mas clara y detallada
     * @BindingResult analiza el objeto y determina si tiene o no errores
     *
     * @return si result tiene errores entonces devuelve un Map con la
     * estructura "atributo":"error". De lo contrario
     * devuelve un response json tipo Categoria con los datos ingresados
     */
    @PostMapping("")
    public ResponseEntity<?> createNewCategoria(@Valid @RequestBody Categoria categoria, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        categoriaService.saveOrUpdateCategoria(categoria);
        return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<?> getCategoriaById(@PathVariable Integer categoriaId) {

        Categoria categoria = categoriaService.findCategoriaById(categoriaId);

        return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Categoria> getAllCategorias() {
        return categoriaService.findAllCategorias();
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<?> deleteCategoriaById(@PathVariable Integer categoriaId) {

        categoriaService.deleteCategoriaById(categoriaId);

        return new ResponseEntity<String>("Categoria con ID: " + categoriaId + " ha sido eliminado", HttpStatus.OK);
    }
}
