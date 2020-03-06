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
@Table(name = "regne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regne.findAll", query = "SELECT r FROM Regne r")
    , @NamedQuery(name = "Regne.findById", query = "SELECT r FROM Regne r WHERE r.id = :id")
    , @NamedQuery(name = "Regne.findByDesgenre", query = "SELECT r FROM Regne r WHERE r.desgenre = :desgenre")})
public class Regne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desgenre")
    private String desgenre;

    public Regne() {
    }

    public Regne(Integer id) {
        this.id = id;
    }

    public Regne(Integer id, String desgenre) {
        this.id = id;
        this.desgenre = desgenre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesgenre() {
        return desgenre;
    }

    public void setDesgenre(String desgenre) {
        this.desgenre = desgenre;
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
        if (!(object instanceof Regne)) {
            return false;
        }
        Regne other = (Regne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Regne[ id=" + id + " ]";
    }
    
}
