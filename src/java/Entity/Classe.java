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
@Table(name = "classe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c")
    , @NamedQuery(name = "Classe.findById", query = "SELECT c FROM Classe c WHERE c.id = :id")
    , @NamedQuery(name = "Classe.findByDesclasse", query = "SELECT c FROM Classe c WHERE c.desclasse = :desclasse")
    , @NamedQuery(name = "Classe.findByDesembranchement", query = "SELECT c FROM Classe c WHERE c.desembranchement = :desembranchement")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desclasse")
    private String desclasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desembranchement")
    private String desembranchement;

    public Classe() {
    }

    public Classe(Integer id) {
        this.id = id;
    }

    public Classe(Integer id, String desclasse, String desembranchement) {
        this.id = id;
        this.desclasse = desclasse;
        this.desembranchement = desembranchement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesclasse() {
        return desclasse;
    }

    public void setDesclasse(String desclasse) {
        this.desclasse = desclasse;
    }

    public String getDesembranchement() {
        return desembranchement;
    }

    public void setDesembranchement(String desembranchement) {
        this.desembranchement = desembranchement;
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
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Classe[ id=" + id + " ]";
    }
    
}
