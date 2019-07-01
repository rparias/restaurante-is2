/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author ronaldarias
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @NotBlank(message = "El ruc o cedula es requerida")
    @Size(min = 10, max = 13, message = "La cédula o ruc debe contener 10 o 13 digitos")
    @Column(name = "cedularuccliente")
    private String cedularuccliente;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Persona persona;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;

    public Cliente() {
    }

    public Cliente(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Cliente(Integer idPersona, String cedularuccliente) {
        this.idPersona = idPersona;
        this.cedularuccliente = cedularuccliente;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getCedularuccliente() {
        return cedularuccliente;
    }

    public void setCedularuccliente(String cedularuccliente) {
        this.cedularuccliente = cedularuccliente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Cliente[ idPersona=" + idPersona + " ]";
    }
    
}
