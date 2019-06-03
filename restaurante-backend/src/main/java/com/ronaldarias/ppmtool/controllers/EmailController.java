package com.ronaldarias.ppmtool.controllers;

import com.ronaldarias.ppmtool.domain.Email;
import com.ronaldarias.ppmtool.services.EmailService;
import com.ronaldarias.ppmtool.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

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
    public ResponseEntity<?> createNewEmail (@Valid @RequestBody Email email, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        emailService.saveOrUpdateEmail(email);
        return new ResponseEntity<Email>(email, HttpStatus.CREATED);
    }

    @GetMapping("/{emailId}")
    public ResponseEntity<?> getEmailById(@PathVariable Integer emailId){
        Email email= emailService.findEmailById(emailId);
        return new ResponseEntity<Email>(email, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Email> getAllEmails(){
        return emailService.findAllEmails();
    }

    @DeleteMapping("/{emailId}")
    public ResponseEntity<?> deleteEmailById(@PathVariable Integer emailId){
        emailService.deleteEmailById(emailId);
        return new ResponseEntity<String>("Email con ID: " +emailId + " ha sido eliminado", HttpStatus.OK);
    }
}
