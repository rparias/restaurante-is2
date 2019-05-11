/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ronaldarias
 */
@Entity
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @Column(name = "nombre1persona")
    private String nombre1persona;
    @Column(name = "nombre2persona")
    private String nombre2persona;
    @Basic(optional = false)
    @Column(name = "apellido1persona")
    private String apellido1persona;
    @Column(name = "apellido2persona")
    private String apellido2persona;
    @Column(name = "direccionpersona")
    private String direccionpersona;
    @Column(name = "telefonopersona")
    private String telefonopersona;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    @JsonIgnore
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    @JsonIgnore
    private Empleado empleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Email> emailList;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String nombre1persona, String apellido1persona) {
        this.idPersona = idPersona;
        this.nombre1persona = nombre1persona;
        this.apellido1persona = apellido1persona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre1persona() {
        return nombre1persona;
    }

    public void setNombre1persona(String nombre1persona) {
        this.nombre1persona = nombre1persona;
    }

    public String getNombre2persona() {
        return nombre2persona;
    }

    public void setNombre2persona(String nombre2persona) {
        this.nombre2persona = nombre2persona;
    }

    public String getApellido1persona() {
        return apellido1persona;
    }

    public void setApellido1persona(String apellido1persona) {
        this.apellido1persona = apellido1persona;
    }

    public String getApellido2persona() {
        return apellido2persona;
    }

    public void setApellido2persona(String apellido2persona) {
        this.apellido2persona = apellido2persona;
    }

    public String getDireccionpersona() {
        return direccionpersona;
    }

    public void setDireccionpersona(String direccionpersona) {
        this.direccionpersona = direccionpersona;
    }

    public String getTelefonopersona() {
        return telefonopersona;
    }

    public void setTelefonopersona(String telefonopersona) {
        this.telefonopersona = telefonopersona;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
