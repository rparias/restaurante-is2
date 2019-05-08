package com.ronaldarias.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    /**
     *@return si result tiene errores entonces devuelve un Map con la
     *estructura "atributo":"error". De lo contrario null
     */
    public ResponseEntity<?> MapValidationService(BindingResult result) {

        // en caso de error hago que el json q me devuelve tenga la estructura "field": "errormessage"
        if (result.hasErrors()) {

            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        return null;
    }



}
