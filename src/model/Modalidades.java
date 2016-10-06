/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author 1961675
 */
@Entity
@Table(name = "modalidades", catalog = "tfm", schema = "")
@NamedQueries({
    @NamedQuery(name = "Modalidades.findAll", query = "SELECT m FROM Modalidades m"),
    @NamedQuery(name = "Modalidades.findByCodigo", query = "SELECT m FROM Modalidades m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Modalidades.findByNome", query = "SELECT m FROM Modalidades m WHERE m.nome = :nome"),
    @NamedQuery(name = "Modalidades.findByObservacao", query = "SELECT m FROM Modalidades m WHERE m.observacao = :observacao")})
public class Modalidades implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Observacao")
    private String observacao;
     
    @ManyToMany 
    private List<Alunos> alunos;
    
    public Modalidades() {
        this.alunos = new ArrayList<>();
    }

    public Modalidades(Integer codigo) {
        this.alunos = new ArrayList<>();
        this.codigo = codigo;
    }

    public Modalidades(Integer codigo, String nome) {
        this.alunos = new ArrayList<Alunos>();
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
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
        if (!(object instanceof Modalidades)) {
            return false;
        }
        Modalidades other = (Modalidades) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "view.Modalidades[ codigo=" + codigo + " ]";
     return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public List<Alunos> getAluno() {
        return alunos;
    }
     public void addAluno (Alunos a){
        alunos.add(a);
    }
    public void removeAluno (Alunos a){
       alunos.remove(a);
    }
    
    public Alunos getAluno (int matricula){
        return alunos.get(matricula);
    }
    
    public int sizeofListAluno(){
    return alunos.size();
    }


    
   
    
    
    
}
