/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ronaldarias
 */
@Entity
@Table(name = "parametro")
@NamedQueries({
    @NamedQuery(name = "Parametro.findAll", query = "SELECT p FROM Parametro p")})
public class Parametro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parametro")
    private Integer idParametro;
    @Basic(optional = false)
    @Column(name = "empresaparametro")
    private String empresaparametro;
    @Basic(optional = false)
    @Column(name = "rucparametro")
    private String rucparametro;
    @Basic(optional = false)
    @Column(name = "telefonoparametro")
    private String telefonoparametro;
    @Basic(optional = false)
    @Column(name = "direccionparametro")
    private String direccionparametro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ivaparametro")
    private BigDecimal ivaparametro;

    public Parametro() {
    }

    public Parametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public Parametro(Integer idParametro, String empresaparametro, String rucparametro, String telefonoparametro, String direccionparametro, BigDecimal ivaparametro) {
        this.idParametro = idParametro;
        this.empresaparametro = empresaparametro;
        this.rucparametro = rucparametro;
        this.telefonoparametro = telefonoparametro;
        this.direccionparametro = direccionparametro;
        this.ivaparametro = ivaparametro;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getEmpresaparametro() {
        return empresaparametro;
    }

    public void setEmpresaparametro(String empresaparametro) {
        this.empresaparametro = empresaparametro;
    }

    public String getRucparametro() {
        return rucparametro;
    }

    public void setRucparametro(String rucparametro) {
        this.rucparametro = rucparametro;
    }

    public String getTelefonoparametro() {
        return telefonoparametro;
    }

    public void setTelefonoparametro(String telefonoparametro) {
        this.telefonoparametro = telefonoparametro;
    }

    public String getDireccionparametro() {
        return direccionparametro;
    }

    public void setDireccionparametro(String direccionparametro) {
        this.direccionparametro = direccionparametro;
    }

    public BigDecimal getIvaparametro() {
        return ivaparametro;
    }

    public void setIvaparametro(BigDecimal ivaparametro) {
        this.ivaparametro = ivaparametro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Parametro[ idParametro=" + idParametro + " ]";
    }
    
}
