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
@Table(name = "site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
    , @NamedQuery(name = "Site.findById", query = "SELECT s FROM Site s WHERE s.id = :id")
    , @NamedQuery(name = "Site.findByDessite", query = "SELECT s FROM Site s WHERE s.dessite = :dessite")
    , @NamedQuery(name = "Site.findByStatutsite", query = "SELECT s FROM Site s WHERE s.statutsite = :statutsite")
    , @NamedQuery(name = "Site.findByDescommune", query = "SELECT s FROM Site s WHERE s.descommune = :descommune")})
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dessite")
    private String dessite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "statutsite")
    private String statutsite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descommune")
    private String descommune;

    public Site() {
    }

    public Site(Integer id) {
        this.id = id;
    }

    public Site(Integer id, String dessite, String statutsite, String descommune) {
        this.id = id;
        this.dessite = dessite;
        this.statutsite = statutsite;
        this.descommune = descommune;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDessite() {
        return dessite;
    }

    public void setDessite(String dessite) {
        this.dessite = dessite;
    }

    public String getStatutsite() {
        return statutsite;
    }

    public void setStatutsite(String statutsite) {
        this.statutsite = statutsite;
    }

    public String getDescommune() {
        return descommune;
    }

    public void setDescommune(String descommune) {
        this.descommune = descommune;
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
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Site[ id=" + id + " ]";
    }
    
}
