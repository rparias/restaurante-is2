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
@Table(name = "tipopedido")
@NamedQueries({
    @NamedQuery(name = "TipoPedido.findAll", query = "SELECT t FROM TipoPedido t")})
public class TipoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipopedido")
    private Integer idTipopedido;
    @Basic(optional = false)
    @Column(name = "nombretipopedido")
    private String nombretipopedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPedido", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pedido> pedidoList;

    public TipoPedido() {
    }

    public TipoPedido(Integer idTipopedido) {
        this.idTipopedido = idTipopedido;
    }

    public TipoPedido(Integer idTipopedido, String nombretipopedido) {
        this.idTipopedido = idTipopedido;
        this.nombretipopedido = nombretipopedido;
    }

    public Integer getIdTipopedido() {
        return idTipopedido;
    }

    public void setIdTipopedido(Integer idTipopedido) {
        this.idTipopedido = idTipopedido;
    }

    public String getNombretipopedido() {
        return nombretipopedido;
    }

    public void setNombretipopedido(String nombretipopedido) {
        this.nombretipopedido = nombretipopedido;
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
        hash += (idTipopedido != null ? idTipopedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPedido)) {
            return false;
        }
        TipoPedido other = (TipoPedido) object;
        if ((this.idTipopedido == null && other.idTipopedido != null) || (this.idTipopedido != null && !this.idTipopedido.equals(other.idTipopedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TipoPedido[ idTipopedido=" + idTipopedido + " ]";
    }
    
}
