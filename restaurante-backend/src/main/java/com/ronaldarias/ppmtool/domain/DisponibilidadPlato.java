/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ronaldarias
 */
@Entity
@Table(name = "disponibilidadplato")
@NamedQueries({
    @NamedQuery(name = "DisponibilidadPlato.findAll", query = "SELECT d FROM DisponibilidadPlato d")})
public class DisponibilidadPlato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disponibilidadplato")
    private Integer idDisponibilidadplato;
    @Basic(optional = false)
    @Column(name = "descripciondisponibilidad")
    private String descripcionDisponibilidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disponibilidadPlato")
    @JsonIgnore
    private List<Plato> platoList;

    public DisponibilidadPlato() {
    }

    public DisponibilidadPlato(Integer idDisponibilidadplato) {
        this.idDisponibilidadplato = idDisponibilidadplato;
    }

    public DisponibilidadPlato(Integer idDisponibilidadplato, String descripcionDisponibilidad) {
        this.idDisponibilidadplato = idDisponibilidadplato;
        this.descripcionDisponibilidad = descripcionDisponibilidad;
    }

    public Integer getIdDisponibilidadplato() {
        return idDisponibilidadplato;
    }

    public void setIdDisponibilidadplato(Integer idDisponibilidadplato) {
        this.idDisponibilidadplato = idDisponibilidadplato;
    }

    public String getDescripcionDisponibilidad() {
        return descripcionDisponibilidad;
    }

    public void setDescripcionDisponibilidad(String descripcionDisponibilidad) {
        this.descripcionDisponibilidad = descripcionDisponibilidad;
    }

    public List<Plato> getPlatoList() {
        return platoList;
    }

    public void setPlatoList(List<Plato> platoList) {
        this.platoList = platoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisponibilidadplato != null ? idDisponibilidadplato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisponibilidadPlato)) {
            return false;
        }
        DisponibilidadPlato other = (DisponibilidadPlato) object;
        if ((this.idDisponibilidadplato == null && other.idDisponibilidadplato != null) || (this.idDisponibilidadplato != null && !this.idDisponibilidadplato.equals(other.idDisponibilidadplato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.DisponibilidadPlato[ idDisponibilidadplato=" + idDisponibilidadplato + " ]";
    }
    
}
