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
@Table(name = "methodeobservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Methodeobservation.findAll", query = "SELECT m FROM Methodeobservation m")
    , @NamedQuery(name = "Methodeobservation.findById", query = "SELECT m FROM Methodeobservation m WHERE m.id = :id")
    , @NamedQuery(name = "Methodeobservation.findByDesmethodeobservation", query = "SELECT m FROM Methodeobservation m WHERE m.desmethodeobservation = :desmethodeobservation")
    , @NamedQuery(name = "Methodeobservation.findByDistanceobservation", query = "SELECT m FROM Methodeobservation m WHERE m.distanceobservation = :distanceobservation")
    , @NamedQuery(name = "Methodeobservation.findByDescription", query = "SELECT m FROM Methodeobservation m WHERE m.description = :description")})
public class Methodeobservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desmethodeobservation")
    private String desmethodeobservation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distanceobservation")
    private int distanceobservation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "description")
    private String description;

    public Methodeobservation() {
    }

    public Methodeobservation(Integer id) {
        this.id = id;
    }

    public Methodeobservation(Integer id, String desmethodeobservation, int distanceobservation, String description) {
        this.id = id;
        this.desmethodeobservation = desmethodeobservation;
        this.distanceobservation = distanceobservation;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesmethodeobservation() {
        return desmethodeobservation;
    }

    public void setDesmethodeobservation(String desmethodeobservation) {
        this.desmethodeobservation = desmethodeobservation;
    }

    public int getDistanceobservation() {
        return distanceobservation;
    }

    public void setDistanceobservation(int distanceobservation) {
        this.distanceobservation = distanceobservation;
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
        if (!(object instanceof Methodeobservation)) {
            return false;
        }
        Methodeobservation other = (Methodeobservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Methodeobservation[ id=" + id + " ]";
    }
    
}
