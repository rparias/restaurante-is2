/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author ronaldarias
 */
@Embeddable
public class PedidoPK implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private int idPedido;
    @Basic(optional = false)
    @Column(name = "id_tipopedido")
    private int idTipopedido;
    @Basic(optional = false)
    @Column(name = "emp_id_persona")
    private int empIdPersona;
    @Basic(optional = false)
    @Column(name = "cli_id_persona")
    private int cliIdPersona;
    @Basic(optional = false)
    @Column(name = "id_mesa")
    private int idMesa;

    public PedidoPK() {
    }

    public PedidoPK(int idPedido, int idTipopedido, int empIdPersona, int cliIdPersona, int idMesa) {
        this.idPedido = idPedido;
        this.idTipopedido = idTipopedido;
        this.empIdPersona = empIdPersona;
        this.cliIdPersona = cliIdPersona;
        this.idMesa = idMesa;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdTipopedido() {
        return idTipopedido;
    }

    public void setIdTipopedido(int idTipopedido) {
        this.idTipopedido = idTipopedido;
    }

    public int getEmpIdPersona() {
        return empIdPersona;
    }

    public void setEmpIdPersona(int empIdPersona) {
        this.empIdPersona = empIdPersona;
    }

    public int getCliIdPersona() {
        return cliIdPersona;
    }

    public void setCliIdPersona(int cliIdPersona) {
        this.cliIdPersona = cliIdPersona;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedido;
        hash += (int) idTipopedido;
        hash += (int) empIdPersona;
        hash += (int) cliIdPersona;
        hash += (int) idMesa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoPK)) {
            return false;
        }
        PedidoPK other = (PedidoPK) object;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (this.idTipopedido != other.idTipopedido) {
            return false;
        }
        if (this.empIdPersona != other.empIdPersona) {
            return false;
        }
        if (this.cliIdPersona != other.cliIdPersona) {
            return false;
        }
        if (this.idMesa != other.idMesa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PedidoPK[ idPedido=" + idPedido + ", idTipopedido=" + idTipopedido + ", empIdPersona=" + empIdPersona + ", cliIdPersona=" + cliIdPersona + ", idMesa=" + idMesa + " ]";
    }
    
}
