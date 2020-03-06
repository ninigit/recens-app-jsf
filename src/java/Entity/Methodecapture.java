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
@Table(name = "methodecapture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Methodecapture.findAll", query = "SELECT m FROM Methodecapture m")
    , @NamedQuery(name = "Methodecapture.findById", query = "SELECT m FROM Methodecapture m WHERE m.id = :id")
    , @NamedQuery(name = "Methodecapture.findByDesmethodecapture", query = "SELECT m FROM Methodecapture m WHERE m.desmethodecapture = :desmethodecapture")
    , @NamedQuery(name = "Methodecapture.findByDescription", query = "SELECT m FROM Methodecapture m WHERE m.description = :description")})
public class Methodecapture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desmethodecapture")
    private String desmethodecapture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "description")
    private String description;

    public Methodecapture() {
    }

    public Methodecapture(Integer id) {
        this.id = id;
    }

    public Methodecapture(Integer id, String desmethodecapture, String description) {
        this.id = id;
        this.desmethodecapture = desmethodecapture;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesmethodecapture() {
        return desmethodecapture;
    }

    public void setDesmethodecapture(String desmethodecapture) {
        this.desmethodecapture = desmethodecapture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Methodecapture)) {
            return false;
        }
        Methodecapture other = (Methodecapture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Methodecapture[ id=" + id + " ]";
    }
    
}
