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
@Table(name = "coba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coba.findAll", query = "SELECT c FROM Coba c")
    , @NamedQuery(name = "Coba.findById", query = "SELECT c FROM Coba c WHERE c.id = :id")
    , @NamedQuery(name = "Coba.findByNom", query = "SELECT c FROM Coba c WHERE c.nom = :nom")
    , @NamedQuery(name = "Coba.findByPrenoms", query = "SELECT c FROM Coba c WHERE c.prenoms = :prenoms")
    , @NamedQuery(name = "Coba.findByDatenaiss", query = "SELECT c FROM Coba c WHERE c.datenaiss = :datenaiss")
    , @NamedQuery(name = "Coba.findByLieunaiss", query = "SELECT c FROM Coba c WHERE c.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Coba.findBySexe", query = "SELECT c FROM Coba c WHERE c.sexe = :sexe")
    , @NamedQuery(name = "Coba.findByCin", query = "SELECT c FROM Coba c WHERE c.cin = :cin")
    , @NamedQuery(name = "Coba.findByContact", query = "SELECT c FROM Coba c WHERE c.contact = :contact")
    , @NamedQuery(name = "Coba.findByVillage", query = "SELECT c FROM Coba c WHERE c.village = :village")
    , @NamedQuery(name = "Coba.findByMembrevoi", query = "SELECT c FROM Coba c WHERE c.membrevoi = :membrevoi")})
public class Coba implements Serializable {

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
    @Size(min = 1, max = 50)
    @Column(name = "village")
    private String village;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "membrevoi")
    private String membrevoi;

    public Coba() {
    }

    public Coba(Integer id) {
        this.id = id;
    }

    public Coba(Integer id, String nom, String prenoms, Date datenaiss, String lieunaiss, String sexe, long cin, String contact, String village, String membrevoi) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.datenaiss = datenaiss;
        this.lieunaiss = lieunaiss;
        this.sexe = sexe;
        this.cin = cin;
        this.contact = contact;
        this.village = village;
        this.membrevoi = membrevoi;
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

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getMembrevoi() {
        return membrevoi;
    }

    public void setMembrevoi(String membrevoi) {
        this.membrevoi = membrevoi;
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
        if (!(object instanceof Coba)) {
            return false;
        }
        Coba other = (Coba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Coba[ id=" + id + " ]";
    }
    
}
