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
@Table(name = "commune")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commune.findAll", query = "SELECT c FROM Commune c")
    , @NamedQuery(name = "Commune.findById", query = "SELECT c FROM Commune c WHERE c.id = :id")
    , @NamedQuery(name = "Commune.findByDescommune", query = "SELECT c FROM Commune c WHERE c.descommune = :descommune")
    , @NamedQuery(name = "Commune.findByDesdistrict", query = "SELECT c FROM Commune c WHERE c.desdistrict = :desdistrict")})
public class Commune implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descommune")
    private String descommune;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desdistrict")
    private String desdistrict;

    public Commune() {
    }

    public Commune(Integer id) {
        this.id = id;
    }

    public Commune(Integer id, String descommune, String desdistrict) {
        this.id = id;
        this.descommune = descommune;
        this.desdistrict = desdistrict;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescommune() {
        return descommune;
    }

    public void setDescommune(String descommune) {
        this.descommune = descommune;
    }

    public String getDesdistrict() {
        return desdistrict;
    }

    public void setDesdistrict(String desdistrict) {
        this.desdistrict = desdistrict;
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
        if (!(object instanceof Commune)) {
            return false;
        }
        Commune other = (Commune) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Commune[ id=" + id + " ]";
    }
    
}
