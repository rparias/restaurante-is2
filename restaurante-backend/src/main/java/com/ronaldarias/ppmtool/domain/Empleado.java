/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @Column(name = "cedulaempleado", unique = true)
    @NotBlank(message = "La cedula es requerida")
    @Size(min = 10, max = 10, message = "La cédula debe contener 10 digitos")
    private String cedulaempleado;
    @Basic(optional = false)
    @Column(name = "fechanacimientoempleado")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimientoempleado;
    @Basic(optional = false)
    @Column(name = "fechaingresoempleado")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingresoempleado;
    @Column(name = "fechasalidaempleado")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalidaempleado;
    @Basic(optional = false)
    @Column(name = "usuarioempleado")
    @NotBlank(message = "El usuario es requerido")
    private String usuarioempleado;
    @Basic(optional = false)
    @Column(name = "passwordempleado")
    @NotBlank(message = "La contrasena es requerida")
    private String passwordempleado;
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Empleado> empleadoList;
    @JoinColumn(name = "id_subalterno", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Empleado empleado;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Persona persona;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
    @JsonIgnore
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
