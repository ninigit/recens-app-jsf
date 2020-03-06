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
@Table(name = "agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a")
    , @NamedQuery(name = "Agent.findById", query = "SELECT a FROM Agent a WHERE a.id = :id")
    , @NamedQuery(name = "Agent.findByNom", query = "SELECT a FROM Agent a WHERE a.nom = :nom")
    , @NamedQuery(name = "Agent.findByPrenoms", query = "SELECT a FROM Agent a WHERE a.prenoms = :prenoms")
    , @NamedQuery(name = "Agent.findByDatenaiss", query = "SELECT a FROM Agent a WHERE a.datenaiss = :datenaiss")
    , @NamedQuery(name = "Agent.findByLieunaiss", query = "SELECT a FROM Agent a WHERE a.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Agent.findBySexe", query = "SELECT a FROM Agent a WHERE a.sexe = :sexe")
    , @NamedQuery(name = "Agent.findByCin", query = "SELECT a FROM Agent a WHERE a.cin = :cin")
    , @NamedQuery(name = "Agent.findByContact", query = "SELECT a FROM Agent a WHERE a.contact = :contact")
    , @NamedQuery(name = "Agent.findByNummatricule", query = "SELECT a FROM Agent a WHERE a.nummatricule = :nummatricule")
    , @NamedQuery(name = "Agent.findByCarriere", query = "SELECT a FROM Agent a WHERE a.carriere = :carriere")
    , @NamedQuery(name = "Agent.findByEmployeur", query = "SELECT a FROM Agent a WHERE a.employeur = :employeur")})
public class Agent implements Serializable {

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
    @Column(name = "nummatricule")
    private int nummatricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "carriere")
    private String carriere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "employeur")
    private String employeur;

    public Agent() {
    }

    public Agent(Integer id) {
        this.id = id;
    }

    public Agent(Integer id, String nom, String prenoms, Date datenaiss, String lieunaiss, String sexe, long cin, String contact, int nummatricule, String carriere, String employeur) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.datenaiss = datenaiss;
        this.lieunaiss = lieunaiss;
        this.sexe = sexe;
        this.cin = cin;
        this.contact = contact;
        this.nummatricule = nummatricule;
        this.carriere = carriere;
        this.employeur = employeur;
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

    public int getNummatricule() {
        return nummatricule;
    }

    public void setNummatricule(int nummatricule) {
        this.nummatricule = nummatricule;
    }

    public String getCarriere() {
        return carriere;
    }

    public void setCarriere(String carriere) {
        this.carriere = carriere;
    }

    public String getEmployeur() {
        return employeur;
    }

    public void setEmployeur(String employeur) {
        this.employeur = employeur;
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
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Agent[ id=" + id + " ]";
    }
    
}
