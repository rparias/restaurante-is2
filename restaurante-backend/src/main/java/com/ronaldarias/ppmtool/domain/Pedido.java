/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ronaldarias
 */
@Entity
@Table(name = "pedido")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidoPK pedidoPK;
    @Basic(optional = false)
    @Column(name = "fechapedido")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "subtotalpedido")
    private BigDecimal subtotalpedido;
    @Basic(optional = false)
    @Column(name = "ivapedido")
    private BigDecimal ivapedido;
    @Basic(optional = false)
    @Column(name = "totalpedido")
    private BigDecimal totalpedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<Detalle> detalleList;
    @JoinColumn(name = "cli_id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Cliente cliente;
    @JoinColumn(name = "emp_id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Empleado empleado;
    @JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Mesa mesa;
    @JoinColumn(name = "id_tipopedido", referencedColumnName = "id_tipopedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private TipoPedido tipoPedido;

    public Pedido() {
    }

    public Pedido(PedidoPK pedidoPK) {
        this.pedidoPK = pedidoPK;
    }

    public Pedido(PedidoPK pedidoPK, String numeropedido, Date fechapedido, BigDecimal subtotalpedido, BigDecimal ivapedido, BigDecimal totalpedido) {
        this.pedidoPK = pedidoPK;
        this.fechapedido = fechapedido;
        this.subtotalpedido = subtotalpedido;
        this.ivapedido = ivapedido;
        this.totalpedido = totalpedido;
    }

    public Pedido(int idPedido, int idTipopedido, int empIdPersona, int cliIdPersona, int idMesa) {
        this.pedidoPK = new PedidoPK(idPedido, idTipopedido, empIdPersona, cliIdPersona, idMesa);
    }

    public PedidoPK getPedidoPK() {
        return pedidoPK;
    }

    public void setPedidoPK(PedidoPK pedidoPK) {
        this.pedidoPK = pedidoPK;
    }

    public Date getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(Date fechapedido) {
        this.fechapedido = fechapedido;
    }

    public BigDecimal getSubtotalpedido() {
        return subtotalpedido;
    }

    public void setSubtotalpedido(BigDecimal subtotalpedido) {
        this.subtotalpedido = subtotalpedido;
    }

    public BigDecimal getIvapedido() {
        return ivapedido;
    }

    public void setIvapedido(BigDecimal ivapedido) {
        this.ivapedido = ivapedido;
    }

    public BigDecimal getTotalpedido() {
        return totalpedido;
    }

    public void setTotalpedido(BigDecimal totalpedido) {
        this.totalpedido = totalpedido;
    }

    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
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

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoPK != null ? pedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pedidoPK == null && other.pedidoPK != null) || (this.pedidoPK != null && !this.pedidoPK.equals(other.pedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Pedido[ pedidoPK=" + pedidoPK + " ]";
    }
    
}
