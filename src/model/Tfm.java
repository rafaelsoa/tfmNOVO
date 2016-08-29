/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author 1961675
 */
@Entity
@Table(name = "tfm", catalog = "tfm", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tfm.findAll", query = "SELECT t FROM Tfm t"),
    @NamedQuery(name = "Tfm.findByCodigo", query = "SELECT t FROM Tfm t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Tfm.findByHora", query = "SELECT t FROM Tfm t WHERE t.hora = :hora"),
    @NamedQuery(name = "Tfm.findByObservacao", query = "SELECT t FROM Tfm t WHERE t.observacao = :observacao")})
public class Tfm implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Column(name = "Hora")
    @Temporal(TemporalType.DATE)
    private Date hora;
    @Column(name = "Observacao")
    private String observacao;

    public Tfm() {
    }

    public Tfm(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        String oldObservacao = this.observacao;
        this.observacao = observacao;
        changeSupport.firePropertyChange("observacao", oldObservacao, observacao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tfm)) {
            return false;
        }
        Tfm other = (Tfm) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Tfm[ codigo=" + codigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
