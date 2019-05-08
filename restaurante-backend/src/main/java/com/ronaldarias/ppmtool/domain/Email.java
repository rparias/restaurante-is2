/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ronaldarias
 */
@Entity
@Table(name = "email")
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e")})
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_email")
    private Integer idEmail;
    @Basic(optional = false)
    @Column(name = "correoemail")
    private String correoemail;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Persona persona;

    public Email() {
    }

    public Email(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public Email(Integer idEmail, String correoemail) {
        this.idEmail = idEmail;
        this.correoemail = correoemail;
    }

    public Integer getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public String getCorreoemail() {
        return correoemail;
    }

    public void setCorreoemail(String correoemail) {
        this.correoemail = correoemail;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmail != null ? idEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.idEmail == null && other.idEmail != null) || (this.idEmail != null && !this.idEmail.equals(other.idEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Email[ idEmail=" + idEmail + " ]";
    }
    
}
