package com.ronaldarias.ppmtool.services;

import com.ronaldarias.ppmtool.domain.Email;
import com.ronaldarias.ppmtool.exceptions.ProjectIdException;
import com.ronaldarias.ppmtool.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public Email saveOrUpdateEmail(Email email) {


        try {
            return emailRepository.save(email);
        } catch (Exception ex) {
            throw new ProjectIdException("Email ID " + email.getIdEmail() + " already exists");
        }

    }
    public Email findEmailById(Integer emailId) {

        Email email = emailRepository.findById(emailId)
                .orElse(null);

        if (email == null) {
            throw new ProjectIdException("Email ID " + emailId + " does not exist");
        }

        return email;
    }
    public Iterable<Email> findAllEmails(){
        return emailRepository.findAll();
    }
    public void deleteEmailById(Integer emailId) {
        Email email = emailRepository.findById(emailId)
                .orElse(null);
        if (email == null) {
            throw new ProjectIdException("Email ID "+ emailId+" does not exist");
        }
        emailRepository.delete(email);
    }
}
