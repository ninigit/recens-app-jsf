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
@Table(name = "collection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collection.findAll", query = "SELECT c FROM Collection c")
    , @NamedQuery(name = "Collection.findById", query = "SELECT c FROM Collection c WHERE c.id = :id")
    , @NamedQuery(name = "Collection.findByTitre", query = "SELECT c FROM Collection c WHERE c.titre = :titre")
    , @NamedQuery(name = "Collection.findByCodeinstitution", query = "SELECT c FROM Collection c WHERE c.codeinstitution = :codeinstitution")
    , @NamedQuery(name = "Collection.findByCodecollection", query = "SELECT c FROM Collection c WHERE c.codecollection = :codecollection")
    , @NamedQuery(name = "Collection.findByDessite", query = "SELECT c FROM Collection c WHERE c.dessite = :dessite")
    , @NamedQuery(name = "Collection.findByTypeobservateur", query = "SELECT c FROM Collection c WHERE c.typeobservateur = :typeobservateur")
    , @NamedQuery(name = "Collection.findByDatedebut", query = "SELECT c FROM Collection c WHERE c.datedebut = :datedebut")
    , @NamedQuery(name = "Collection.findByDatefin", query = "SELECT c FROM Collection c WHERE c.datefin = :datefin")
    , @NamedQuery(name = "Collection.findByDateexacte", query = "SELECT c FROM Collection c WHERE c.dateexacte = :dateexacte")
    , @NamedQuery(name = "Collection.findByLatitudedecimal", query = "SELECT c FROM Collection c WHERE c.latitudedecimal = :latitudedecimal")
    , @NamedQuery(name = "Collection.findByLongitudedecimal", query = "SELECT c FROM Collection c WHERE c.longitudedecimal = :longitudedecimal")
    , @NamedQuery(name = "Collection.findByLatitudeexacte", query = "SELECT c FROM Collection c WHERE c.latitudeexacte = :latitudeexacte")
    , @NamedQuery(name = "Collection.findByLongitudeexacte", query = "SELECT c FROM Collection c WHERE c.longitudeexacte = :longitudeexacte")
    , @NamedQuery(name = "Collection.findByAltitudemin", query = "SELECT c FROM Collection c WHERE c.altitudemin = :altitudemin")
    , @NamedQuery(name = "Collection.findByAltitudemax", query = "SELECT c FROM Collection c WHERE c.altitudemax = :altitudemax")
    , @NamedQuery(name = "Collection.findByNbobserves", query = "SELECT c FROM Collection c WHERE c.nbobserves = :nbobserves")
    , @NamedQuery(name = "Collection.findByGuide", query = "SELECT c FROM Collection c WHERE c.guide = :guide")
    , @NamedQuery(name = "Collection.findByMethodecollecte", query = "SELECT c FROM Collection c WHERE c.methodecollecte = :methodecollecte")
    , @NamedQuery(name = "Collection.findByCollecteur", query = "SELECT c FROM Collection c WHERE c.collecteur = :collecteur")
    , @NamedQuery(name = "Collection.findByDesespece", query = "SELECT c FROM Collection c WHERE c.desespece = :desespece")
    , @NamedQuery(name = "Collection.findByHabitatobs", query = "SELECT c FROM Collection c WHERE c.habitatobs = :habitatobs")})
public class Collection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "titre")
    private String titre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codeinstitution")
    private String codeinstitution;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codecollection")
    private String codecollection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dessite")
    private String dessite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "typeobservateur")
    private String typeobservateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateexacte")
    @Temporal(TemporalType.DATE)
    private Date dateexacte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitudedecimal")
    private double latitudedecimal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitudedecimal")
    private double longitudedecimal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "latitudeexacte")
    private String latitudeexacte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "longitudeexacte")
    private String longitudeexacte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "altitudemin")
    private int altitudemin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "altitudemax")
    private int altitudemax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbobserves")
    private int nbobserves;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "guide")
    private String guide;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "methodecollecte")
    private String methodecollecte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "collecteur")
    private String collecteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desespece")
    private String desespece;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "habitatobs")
    private String habitatobs;

    public Collection() {
    }

    public Collection(Integer id) {
        this.id = id;
    }

    public Collection(Integer id, String titre, String codeinstitution, String codecollection, String dessite, String typeobservateur, Date datedebut, Date datefin, Date dateexacte, double latitudedecimal, double longitudedecimal, String latitudeexacte, String longitudeexacte, int altitudemin, int altitudemax, int nbobserves, String guide, String methodecollecte, String collecteur, String desespece, String habitatobs) {
        this.id = id;
        this.titre = titre;
        this.codeinstitution = codeinstitution;
        this.codecollection = codecollection;
        this.dessite = dessite;
        this.typeobservateur = typeobservateur;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.dateexacte = dateexacte;
        this.latitudedecimal = latitudedecimal;
        this.longitudedecimal = longitudedecimal;
        this.latitudeexacte = latitudeexacte;
        this.longitudeexacte = longitudeexacte;
        this.altitudemin = altitudemin;
        this.altitudemax = altitudemax;
        this.nbobserves = nbobserves;
        this.guide = guide;
        this.methodecollecte = methodecollecte;
        this.collecteur = collecteur;
        this.desespece = desespece;
        this.habitatobs = habitatobs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCodeinstitution() {
        return codeinstitution;
    }

    public void setCodeinstitution(String codeinstitution) {
        this.codeinstitution = codeinstitution;
    }

    public String getCodecollection() {
        return codecollection;
    }

    public void setCodecollection(String codecollection) {
        this.codecollection = codecollection;
    }

    public String getDessite() {
        return dessite;
    }

    public void setDessite(String dessite) {
        this.dessite = dessite;
    }

    public String getTypeobservateur() {
        return typeobservateur;
    }

    public void setTypeobservateur(String typeobservateur) {
        this.typeobservateur = typeobservateur;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Date getDateexacte() {
        return dateexacte;
    }

    public void setDateexacte(Date dateexacte) {
        this.dateexacte = dateexacte;
    }

    public double getLatitudedecimal() {
        return latitudedecimal;
    }

    public void setLatitudedecimal(double latitudedecimal) {
        this.latitudedecimal = latitudedecimal;
    }

    public double getLongitudedecimal() {
        return longitudedecimal;
    }

    public void setLongitudedecimal(double longitudedecimal) {
        this.longitudedecimal = longitudedecimal;
    }

    public String getLatitudeexacte() {
        return latitudeexacte;
    }

    public void setLatitudeexacte(String latitudeexacte) {
        this.latitudeexacte = latitudeexacte;
    }

    public String getLongitudeexacte() {
        return longitudeexacte;
    }

    public void setLongitudeexacte(String longitudeexacte) {
        this.longitudeexacte = longitudeexacte;
    }

    public int getAltitudemin() {
        return altitudemin;
    }

    public void setAltitudemin(int altitudemin) {
        this.altitudemin = altitudemin;
    }

    public int getAltitudemax() {
        return altitudemax;
    }

    public void setAltitudemax(int altitudemax) {
        this.altitudemax = altitudemax;
    }

    public int getNbobserves() {
        return nbobserves;
    }

    public void setNbobserves(int nbobserves) {
        this.nbobserves = nbobserves;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getMethodecollecte() {
        return methodecollecte;
    }

    public void setMethodecollecte(String methodecollecte) {
        this.methodecollecte = methodecollecte;
    }

    public String getCollecteur() {
        return collecteur;
    }

    public void setCollecteur(String collecteur) {
        this.collecteur = collecteur;
    }

    public String getDesespece() {
        return desespece;
    }

    public void setDesespece(String desespece) {
        this.desespece = desespece;
    }

    public String getHabitatobs() {
        return habitatobs;
    }

    public void setHabitatobs(String habitatobs) {
        this.habitatobs = habitatobs;
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
        if (!(object instanceof Collection)) {
            return false;
        }
        Collection other = (Collection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Collection[ id=" + id + " ]";
    }
    
}
