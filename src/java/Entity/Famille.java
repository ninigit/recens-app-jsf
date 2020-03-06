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
@Table(name = "famille")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Famille.findAll", query = "SELECT f FROM Famille f")
    , @NamedQuery(name = "Famille.findById", query = "SELECT f FROM Famille f WHERE f.id = :id")
    , @NamedQuery(name = "Famille.findByDesfamille", query = "SELECT f FROM Famille f WHERE f.desfamille = :desfamille")
    , @NamedQuery(name = "Famille.findByDesordre", query = "SELECT f FROM Famille f WHERE f.desordre = :desordre")})
public class Famille implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desfamille")
    private String desfamille;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desordre")
    private String desordre;

    public Famille() {
    }

    public Famille(Integer id) {
        this.id = id;
    }

    public Famille(Integer id, String desfamille, String desordre) {
        this.id = id;
        this.desfamille = desfamille;
        this.desordre = desordre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesfamille() {
        return desfamille;
    }

    public void setDesfamille(String desfamille) {
        this.desfamille = desfamille;
    }

    public String getDesordre() {
        return desordre;
    }

    public void setDesordre(String desordre) {
        this.desordre = desordre;
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
        if (!(object instanceof Famille)) {
            return false;
        }
        Famille other = (Famille) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Famille[ id=" + id + " ]";
    }
    
}
