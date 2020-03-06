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
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findById", query = "SELECT u FROM Utilisateur u WHERE u.id = :id")
    , @NamedQuery(name = "Utilisateur.findByNomutilisateur", query = "SELECT u FROM Utilisateur u WHERE u.nomutilisateur = :nomutilisateur")
    , @NamedQuery(name = "Utilisateur.findByMotdepasse", query = "SELECT u FROM Utilisateur u WHERE u.motdepasse = :motdepasse")
    , @NamedQuery(name = "Utilisateur.findByTypeutilisateur", query = "SELECT u FROM Utilisateur u WHERE u.typeutilisateur = :typeutilisateur")
    , @NamedQuery(name = "Utilisateur.findByNomcomplet", query = "SELECT u FROM Utilisateur u WHERE u.nomcomplet = :nomcomplet")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomutilisateur")
    private String nomutilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "motdepasse")
    private String motdepasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "typeutilisateur")
    private String typeutilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomcomplet")
    private String nomcomplet;

    public Utilisateur() {
    }

    public Utilisateur(Integer id) {
        this.id = id;
    }

    public Utilisateur(Integer id, String nomutilisateur, String motdepasse, String typeutilisateur, String nomcomplet) {
        this.id = id;
        this.nomutilisateur = nomutilisateur;
        this.motdepasse = motdepasse;
        this.typeutilisateur = typeutilisateur;
        this.nomcomplet = nomcomplet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getTypeutilisateur() {
        return typeutilisateur;
    }

    public void setTypeutilisateur(String typeutilisateur) {
        this.typeutilisateur = typeutilisateur;
    }

    public String getNomcomplet() {
        return nomcomplet;
    }

    public void setNomcomplet(String nomcomplet) {
        this.nomcomplet = nomcomplet;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Utilisateur[ id=" + id + " ]";
    }
    
}
