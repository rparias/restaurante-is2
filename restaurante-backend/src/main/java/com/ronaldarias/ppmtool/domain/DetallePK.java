/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ronaldarias.ppmtool.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ronaldarias
 */
@Embeddable
public class DetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_plato")
    private int idPlato;
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

    public DetallePK() {
    }

    public DetallePK(int idPlato, int idPedido, int idTipopedido, int empIdPersona, int cliIdPersona, int idMesa) {
        this.idPlato = idPlato;
        this.idPedido = idPedido;
        this.idTipopedido = idTipopedido;
        this.empIdPersona = empIdPersona;
        this.cliIdPersona = cliIdPersona;
        this.idMesa = idMesa;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
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
        hash += (int) idPlato;
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
        if (!(object instanceof DetallePK)) {
            return false;
        }
        DetallePK other = (DetallePK) object;
        if (this.idPlato != other.idPlato) {
            return false;
        }
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
        return "domain.DetallePK[ idPlato=" + idPlato + ", idPedido=" + idPedido + ", idTipopedido=" + idTipopedido + ", empIdPersona=" + empIdPersona + ", cliIdPersona=" + cliIdPersona + ", idMesa=" + idMesa + " ]";
    }
    
}
