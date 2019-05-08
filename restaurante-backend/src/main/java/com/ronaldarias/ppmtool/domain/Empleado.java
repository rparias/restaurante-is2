/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ronaldarias
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @Column(name = "cedulaempleado")
    private String cedulaempleado;
    @Basic(optional = false)
    @Column(name = "fechanacimientoempleado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimientoempleado;
    @Basic(optional = false)
    @Column(name = "fechaingresoempleado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingresoempleado;
    @Column(name = "fechasalidaempleado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalidaempleado;
    @Basic(optional = false)
    @Column(name = "usuarioempleado")
    private String usuarioempleado;
    @Basic(optional = false)
    @Column(name = "passwordempleado")
    private String passwordempleado;
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Empleado> empleadoList;
    @JoinColumn(name = "id_subalterno", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Persona persona;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;

    public Empleado() {
    }

    public Empleado(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Empleado(Integer idPersona, String cedulaempleado, Date fechanacimientoempleado, Date fechaingresoempleado, String usuarioempleado, String passwordempleado) {
        this.idPersona = idPersona;
        this.cedulaempleado = cedulaempleado;
        this.fechanacimientoempleado = fechanacimientoempleado;
        this.fechaingresoempleado = fechaingresoempleado;
        this.usuarioempleado = usuarioempleado;
        this.passwordempleado = passwordempleado;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getCedulaempleado() {
        return cedulaempleado;
    }

    public void setCedulaempleado(String cedulaempleado) {
        this.cedulaempleado = cedulaempleado;
    }

    public Date getFechanacimientoempleado() {
        return fechanacimientoempleado;
    }

    public void setFechanacimientoempleado(Date fechanacimientoempleado) {
        this.fechanacimientoempleado = fechanacimientoempleado;
    }

    public Date getFechaingresoempleado() {
        return fechaingresoempleado;
    }

    public void setFechaingresoempleado(Date fechaingresoempleado) {
        this.fechaingresoempleado = fechaingresoempleado;
    }

    public Date getFechasalidaempleado() {
        return fechasalidaempleado;
    }

    public void setFechasalidaempleado(Date fechasalidaempleado) {
        this.fechasalidaempleado = fechasalidaempleado;
    }

    public String getUsuarioempleado() {
        return usuarioempleado;
    }

    public void setUsuarioempleado(String usuarioempleado) {
        this.usuarioempleado = usuarioempleado;
    }

    public String getPasswordempleado() {
        return passwordempleado;
    }

    public void setPasswordempleado(String passwordempleado) {
        this.passwordempleado = passwordempleado;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Empleado[ idPersona=" + idPersona + " ]";
    }
    
}
