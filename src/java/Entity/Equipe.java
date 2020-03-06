/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "equipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e")
    , @NamedQuery(name = "Equipe.findById", query = "SELECT e FROM Equipe e WHERE e.id = :id")
    , @NamedQuery(name = "Equipe.findBySurnom", query = "SELECT e FROM Equipe e WHERE e.surnom = :surnom")
    , @NamedQuery(name = "Equipe.findByNomconcat", query = "SELECT e FROM Equipe e WHERE e.nomconcat = :nomconcat")})
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "surnom")
    private String surnom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nomconcat")
    private String nomconcat;

    public Equipe() {
    }

    public Equipe(Integer id) {
        this.id = id;
    }

    public Equipe(Integer id, String surnom, String nomconcat) {
        this.id = id;
        this.surnom = surnom;
        this.nomconcat = nomconcat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public String getNomconcat() {
        return nomconcat;
    }

    public void setNomconcat(String nomconcat) {
        this.nomconcat = nomconcat;
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
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Equipe[ id=" + id + " ]";
    }
    
}
