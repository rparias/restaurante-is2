/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import javax.persistence.Table;

/**
 *
 * @author ronaldarias
 */
@Entity
@Table(name = "estadomesa")
@NamedQueries({
    @NamedQuery(name = "EstadoMesa.findAll", query = "SELECT e FROM EstadoMesa e")})
public class EstadoMesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estadomesa")
    private Integer idEstadomesa;
    @Basic(optional = false)
    @Column(name = "nombreestadomesa")
    private String nombreestadomesa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoMesa")
    @JsonIgnore
    private List<Mesa> mesaList;

    public EstadoMesa() {
    }

    public EstadoMesa(Integer idEstadomesa) {
        this.idEstadomesa = idEstadomesa;
    }

    public EstadoMesa(Integer idEstadomesa, String nombreestadomesa) {
        this.idEstadomesa = idEstadomesa;
        this.nombreestadomesa = nombreestadomesa;
    }

    public Integer getIdEstadomesa() {
        return idEstadomesa;
    }

    public void setIdEstadomesa(Integer idEstadomesa) {
        this.idEstadomesa = idEstadomesa;
    }

    public String getNombreestadomesa() {
        return nombreestadomesa;
    }

    public void setNombreestadomesa(String nombreestadomesa) {
        this.nombreestadomesa = nombreestadomesa;
    }

    public List<Mesa> getMesaList() {
        return mesaList;
    }

    public void setMesaList(List<Mesa> mesaList) {
        this.mesaList = mesaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadomesa != null ? idEstadomesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoMesa)) {
            return false;
        }
        EstadoMesa other = (EstadoMesa) object;
        if ((this.idEstadomesa == null && other.idEstadomesa != null) || (this.idEstadomesa != null && !this.idEstadomesa.equals(other.idEstadomesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.EstadoMesa[ idEstadomesa=" + idEstadomesa + " ]";
    }
    
}
