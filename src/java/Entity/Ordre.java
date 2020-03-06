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
@Table(name = "ordre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordre.findAll", query = "SELECT o FROM Ordre o")
    , @NamedQuery(name = "Ordre.findById", query = "SELECT o FROM Ordre o WHERE o.id = :id")
    , @NamedQuery(name = "Ordre.findByDesordre", query = "SELECT o FROM Ordre o WHERE o.desordre = :desordre")
    , @NamedQuery(name = "Ordre.findByDesclasse", query = "SELECT o FROM Ordre o WHERE o.desclasse = :desclasse")})
public class Ordre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desordre")
    private String desordre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desclasse")
    private String desclasse;

    public Ordre() {
    }

    public Ordre(Integer id) {
        this.id = id;
    }

    public Ordre(Integer id, String desordre, String desclasse) {
        this.id = id;
        this.desordre = desordre;
        this.desclasse = desclasse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesordre() {
        return desordre;
    }

    public void setDesordre(String desordre) {
        this.desordre = desordre;
    }

    public String getDesclasse() {
        return desclasse;
    }

    public void setDesclasse(String desclasse) {
        this.desclasse = desclasse;
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
        if (!(object instanceof Ordre)) {
            return false;
        }
        Ordre other = (Ordre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ordre[ id=" + id + " ]";
    }
    
}
