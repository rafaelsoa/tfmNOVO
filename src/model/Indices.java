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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "indices", catalog = "tfm", schema = "")
@NamedQueries({
    @NamedQuery(name = "Indices.findAll", query = "SELECT i FROM Indices i"),
    @NamedQuery(name = "Indices.findById", query = "SELECT i FROM Indices i WHERE i.id = :id"),
    @NamedQuery(name = "Indices.findByMatricula", query = "SELECT i FROM Indices i WHERE i.matricula = :matricula"),
    @NamedQuery(name = "Indices.findByCodigo", query = "SELECT i FROM Indices i WHERE i.codigo = :codigo"),
    @NamedQuery(name = "Indices.findByData", query = "SELECT i FROM Indices i WHERE i.data = :data"),
    @NamedQuery(name = "Indices.findByIndice", query = "SELECT i FROM Indices i WHERE i.indice = :indice"),
    @NamedQuery(name = "Indices.findByObservacao", query = "SELECT i FROM Indices i WHERE i.observacao = :observacao")})
public class Indices implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Matricula")
    private int matricula;
    @Basic(optional = false)
    @Column(name = "Codigo")
    private int codigo;
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "Indice")
    private String indice;
    @Column(name = "Observacao")
    private String observacao;

    public Indices() {
    }

    public Indices(Integer id) {
        this.id = id;
    }

    public Indices(Integer id, int matricula, int codigo) {
        this.id = id;
        this.matricula = matricula;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        int oldMatricula = this.matricula;
        this.matricula = matricula;
        changeSupport.firePropertyChange("matricula", oldMatricula, matricula);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        int oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        String oldIndice = this.indice;
        this.indice = indice;
        changeSupport.firePropertyChange("indice", oldIndice, indice);
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indices)) {
            return false;
        }
        Indices other = (Indices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Indices[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
