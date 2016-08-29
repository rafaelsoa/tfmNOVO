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
@Table(name = "alunos", catalog = "tfm", schema = "")
@NamedQueries({
    @NamedQuery(name = "Alunos.findAll", query = "SELECT a FROM Alunos a"),
    @NamedQuery(name = "Alunos.findByMatricula", query = "SELECT a FROM Alunos a WHERE a.matricula = :matricula"),
    @NamedQuery(name = "Alunos.findByNome", query = "SELECT a FROM Alunos a WHERE a.nome = :nome"),
    @NamedQuery(name = "Alunos.findByCpf", query = "SELECT a FROM Alunos a WHERE a.cpf = :cpf"),
    @NamedQuery(name = "Alunos.findByEnd", query = "SELECT a FROM Alunos a WHERE a.end = :end"),
    @NamedQuery(name = "Alunos.findBySexo", query = "SELECT a FROM Alunos a WHERE a.sexo = :sexo"),
    @NamedQuery(name = "Alunos.findByTelefone", query = "SELECT a FROM Alunos a WHERE a.telefone = :telefone"),
    @NamedQuery(name = "Alunos.findByEmail", query = "SELECT a FROM Alunos a WHERE a.email = :email"),
    @NamedQuery(name = "Alunos.findByDataNascimento", query = "SELECT a FROM Alunos a WHERE a.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Alunos.findByObs", query = "SELECT a FROM Alunos a WHERE a.obs = :obs"),
    @NamedQuery(name = "Alunos.findByAltura", query = "SELECT a FROM Alunos a WHERE a.altura = :altura"),
    @NamedQuery(name = "Alunos.findByPeso", query = "SELECT a FROM Alunos a WHERE a.peso = :peso"),
    @NamedQuery(name = "Alunos.findByTFMCodigo", query = "SELECT a FROM Alunos a WHERE a.tFMCodigo = :tFMCodigo")})
public class Alunos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Matricula")
    private Integer matricula;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "End")
    private String end;
    @Column(name = "Sexo")
    private String sexo;
    @Column(name = "Telefone")
    private String telefone;
    @Column(name = "Email")
    private String email;
    @Column(name = "DataNascimento")
    private String dataNascimento;
    @Column(name = "Obs")
    private String obs;
    @Column(name = "Altura")
    private Integer altura;
    @Column(name = "Peso")
    private Integer peso;
    @Column(name = "TFM_Codigo")
    private Integer tFMCodigo;
    
//    @ManyToMany (mappedBy = "alunos")
    private List<Modalidades> modalidades;
    
    
    
    public Alunos() {
        this.modalidades = new ArrayList<>();
    }

    public Alunos(Integer matricula) {
        this.modalidades = new ArrayList<>();
        this.matricula = matricula;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        Integer oldMatricula = this.matricula;
        this.matricula = matricula;
        changeSupport.firePropertyChange("matricula", oldMatricula, matricula);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        String oldEnd = this.end;
        this.end = end;
        changeSupport.firePropertyChange("end", oldEnd, end);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        String oldSexo = this.sexo;
        this.sexo = sexo;
        changeSupport.firePropertyChange("sexo", oldSexo, sexo);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        String oldDataNascimento = this.dataNascimento;
        this.dataNascimento = dataNascimento;
        changeSupport.firePropertyChange("dataNascimento", oldDataNascimento, dataNascimento);
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        String oldObs = this.obs;
        this.obs = obs;
        changeSupport.firePropertyChange("obs", oldObs, obs);
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        Integer oldAltura = this.altura;
        this.altura = altura;
        changeSupport.firePropertyChange("altura", oldAltura, altura);
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        Integer oldPeso = this.peso;
        this.peso = peso;
        changeSupport.firePropertyChange("peso", oldPeso, peso);
    }

    public Integer getTFMCodigo() {
        return tFMCodigo;
    }

    public void setTFMCodigo(Integer tFMCodigo) {
        Integer oldTFMCodigo = this.tFMCodigo;
        this.tFMCodigo = tFMCodigo;
        changeSupport.firePropertyChange("TFMCodigo", oldTFMCodigo, tFMCodigo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alunos)) {
            return false;
        }
        Alunos other = (Alunos) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Alunos[ matricula=" + matricula + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public List<Modalidades> getModalidades() {
        return modalidades;
    }
    public void addModalidade (Modalidades m){
        modalidades.add(m);
    }
    public void removeModalidade (Modalidades m){
       modalidades.remove(m);
    }
    
    public Modalidades getModalidade (int codigo){
        return modalidades.get(codigo);
    }
    
    public int sizeofListModalides(){
    return modalidades.size();
    }
    
}
