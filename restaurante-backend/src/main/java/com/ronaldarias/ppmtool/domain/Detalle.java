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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ronaldarias
 */
@Entity
@Table(name = "detalle")
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePK detallePK;
    @Basic(optional = false)
    @Column(name = "cantidaddetalle")
    private int cantidaddetalle;
    @Basic(optional = false)
    @Column(name = "descripciondetalle")
    private String descripciondetalle;
    @Column(name = "adicionaldetalle")
    private String adicionaldetalle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "preciounitariodetalle")
    private BigDecimal preciounitariodetalle;
    @Basic(optional = false)
    @Column(name = "importedetalle")
    private BigDecimal importedetalle;
    @JoinColumns({
        @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", insertable = false, updatable = false)
        , @JoinColumn(name = "id_tipopedido", referencedColumnName = "id_tipopedido", insertable = false, updatable = false)
        , @JoinColumn(name = "emp_id_persona", referencedColumnName = "emp_id_persona", insertable = false, updatable = false)
        , @JoinColumn(name = "cli_id_persona", referencedColumnName = "cli_id_persona", insertable = false, updatable = false)
        , @JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedido;
    @JoinColumn(name = "id_plato", referencedColumnName = "id_plato", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Plato plato;

    public Detalle() {
    }

    public Detalle(DetallePK detallePK) {
        this.detallePK = detallePK;
    }

    public Detalle(DetallePK detallePK, int cantidaddetalle, String descripciondetalle, BigDecimal preciounitariodetalle, BigDecimal importedetalle) {
        this.detallePK = detallePK;
        this.cantidaddetalle = cantidaddetalle;
        this.descripciondetalle = descripciondetalle;
        this.preciounitariodetalle = preciounitariodetalle;
        this.importedetalle = importedetalle;
    }

    public Detalle(int idPlato, int idPedido, int idTipopedido, int empIdPersona, int cliIdPersona, int idMesa) {
        this.detallePK = new DetallePK(idPlato, idPedido, idTipopedido, empIdPersona, cliIdPersona, idMesa);
    }

    public DetallePK getDetallePK() {
        return detallePK;
    }

    public void setDetallePK(DetallePK detallePK) {
        this.detallePK = detallePK;
    }

    public int getCantidaddetalle() {
        return cantidaddetalle;
    }

    public void setCantidaddetalle(int cantidaddetalle) {
        this.cantidaddetalle = cantidaddetalle;
    }

    public String getDescripciondetalle() {
        return descripciondetalle;
    }

    public void setDescripciondetalle(String descripciondetalle) {
        this.descripciondetalle = descripciondetalle;
    }

    public String getAdicionaldetalle() {
        return adicionaldetalle;
    }

    public void setAdicionaldetalle(String adicionaldetalle) {
        this.adicionaldetalle = adicionaldetalle;
    }

    public BigDecimal getPreciounitariodetalle() {
        return preciounitariodetalle;
    }

    public void setPreciounitariodetalle(BigDecimal preciounitariodetalle) {
        this.preciounitariodetalle = preciounitariodetalle;
    }

    public BigDecimal getImportedetalle() {
        return importedetalle;
    }

    public void setImportedetalle(BigDecimal importedetalle) {
        this.importedetalle = importedetalle;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePK != null ? detallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.detallePK == null && other.detallePK != null) || (this.detallePK != null && !this.detallePK.equals(other.detallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Detalle[ detallePK=" + detallePK + " ]";
    }
    
}
