/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ronaldarias
 */
@Entity
@Table(name = "plato")
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p")})
public class Plato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plato")
    private Integer idPlato;
    @Basic(optional = false)
    @Column(name = "nombreplato")
    private String nombreplato;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precioplato")
    private BigDecimal precioplato;
    @Column(name = "descripcionplato")
    private String descripcionplato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plato", fetch = FetchType.LAZY)
    private List<Detalle> detalleList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoria;
    @JoinColumn(name = "id_disponibilidadplato", referencedColumnName = "id_disponibilidadplato")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private DisponibilidadPlato disponibilidadPlato;

    public Plato() {
    }

    public Plato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public Plato(Integer idPlato, String nombreplato, BigDecimal precioplato) {
        this.idPlato = idPlato;
        this.nombreplato = nombreplato;
        this.precioplato = precioplato;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombreplato() {
        return nombreplato;
    }

    public void setNombreplato(String nombreplato) {
        this.nombreplato = nombreplato;
    }

    public BigDecimal getPrecioplato() {
        return precioplato;
    }

    public void setPrecioplato(BigDecimal precioplato) {
        this.precioplato = precioplato;
    }

    public String getDescripcionplato() {
        return descripcionplato;
    }

    public void setDescripcionplato(String descripcionplato) {
        this.descripcionplato = descripcionplato;
    }

    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public DisponibilidadPlato getDisponibilidadPlato() {
        return disponibilidadPlato;
    }

    public void setDisponibilidadPlato(DisponibilidadPlato disponibilidadPlato) {
        this.disponibilidadPlato = disponibilidadPlato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlato != null ? idPlato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.idPlato == null && other.idPlato != null) || (this.idPlato != null && !this.idPlato.equals(other.idPlato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Plato[ idPlato=" + idPlato + " ]";
    }
    
}
