/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "etudiant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e")
    , @NamedQuery(name = "Etudiant.findById", query = "SELECT e FROM Etudiant e WHERE e.id = :id")
    , @NamedQuery(name = "Etudiant.findByNom", query = "SELECT e FROM Etudiant e WHERE e.nom = :nom")
    , @NamedQuery(name = "Etudiant.findByPrenoms", query = "SELECT e FROM Etudiant e WHERE e.prenoms = :prenoms")
    , @NamedQuery(name = "Etudiant.findByNomcomplet", query = "SELECT e FROM Etudiant e WHERE e.nomcomplet = :nomcomplet")
    , @NamedQuery(name = "Etudiant.findByDatenaiss", query = "SELECT e FROM Etudiant e WHERE e.datenaiss = :datenaiss")
    , @NamedQuery(name = "Etudiant.findByLieunaiss", query = "SELECT e FROM Etudiant e WHERE e.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Etudiant.findBySexe", query = "SELECT e FROM Etudiant e WHERE e.sexe = :sexe")
    , @NamedQuery(name = "Etudiant.findByCin", query = "SELECT e FROM Etudiant e WHERE e.cin = :cin")
    , @NamedQuery(name = "Etudiant.findByContact", query = "SELECT e FROM Etudiant e WHERE e.contact = :contact")
    , @NamedQuery(name = "Etudiant.findByUniversite", query = "SELECT e FROM Etudiant e WHERE e.universite = :universite")
    , @NamedQuery(name = "Etudiant.findByNiveau", query = "SELECT e FROM Etudiant e WHERE e.niveau = :niveau")
    , @NamedQuery(name = "Etudiant.findByDiplome", query = "SELECT e FROM Etudiant e WHERE e.diplome = :diplome")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "prenoms")
    private String prenoms;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nomcomplet")
    private String nomcomplet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datenaiss")
    @Temporal(TemporalType.DATE)
    private Date datenaiss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "lieunaiss")
    private String lieunaiss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sexe")
    private String sexe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cin")
    private long cin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contact")
    private String contact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "universite")
    private String universite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "niveau")
    private String niveau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "diplome")
    private String diplome;

    public Etudiant() {
    }

    public Etudiant(Integer id) {
        this.id = id;
    }

    public Etudiant(Integer id, String nom, String prenoms, String nomcomplet, Date datenaiss, String lieunaiss, String sexe, long cin, String contact, String universite, String niveau, String diplome) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.nomcomplet = nomcomplet;
        this.datenaiss = datenaiss;
        this.lieunaiss = lieunaiss;
        this.sexe = sexe;
        this.cin = cin;
        this.contact = contact;
        this.universite = universite;
        this.niveau = niveau;
        this.diplome = diplome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getNomcomplet() {
        return nomcomplet;
    }

    public void setNomcomplet(String nomcomplet) {
        this.nomcomplet = nomcomplet;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getLieunaiss() {
        return lieunaiss;
    }

    public void setLieunaiss(String lieunaiss) {
        this.lieunaiss = lieunaiss;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public long getCin() {
        return cin;
    }

    public void setCin(long cin) {
        this.cin = cin;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
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
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Etudiant[ id=" + id + " ]";
    }
    
}
