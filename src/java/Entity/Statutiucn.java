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
@Table(name = "statutiucn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statutiucn.findAll", query = "SELECT s FROM Statutiucn s")
    , @NamedQuery(name = "Statutiucn.findById", query = "SELECT s FROM Statutiucn s WHERE s.id = :id")
    , @NamedQuery(name = "Statutiucn.findByDesstatutiucn", query = "SELECT s FROM Statutiucn s WHERE s.desstatutiucn = :desstatutiucn")
    , @NamedQuery(name = "Statutiucn.findByDescription", query = "SELECT s FROM Statutiucn s WHERE s.description = :description")})
public class Statutiucn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desstatutiucn")
    private String desstatutiucn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "description")
    private String description;

    public Statutiucn() {
    }

    public Statutiucn(Integer id) {
        this.id = id;
    }

    public Statutiucn(Integer id, String desstatutiucn, String description) {
        this.id = id;
        this.desstatutiucn = desstatutiucn;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesstatutiucn() {
        return desstatutiucn;
    }

    public void setDesstatutiucn(String desstatutiucn) {
        this.desstatutiucn = desstatutiucn;
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
        if (!(object instanceof Statutiucn)) {
            return false;
        }
        Statutiucn other = (Statutiucn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Statutiucn[ id=" + id + " ]";
    }
    
}
