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
@Table(name = "espece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espece.findAll", query = "SELECT e FROM Espece e")
    , @NamedQuery(name = "Espece.findById", query = "SELECT e FROM Espece e WHERE e.id = :id")
    , @NamedQuery(name = "Espece.findByNomscientifiqueavant", query = "SELECT e FROM Espece e WHERE e.nomscientifiqueavant = :nomscientifiqueavant")
    , @NamedQuery(name = "Espece.findByNomscientifiqueactuel", query = "SELECT e FROM Espece e WHERE e.nomscientifiqueactuel = :nomscientifiqueactuel")
    , @NamedQuery(name = "Espece.findByAppellationmlg", query = "SELECT e FROM Espece e WHERE e.appellationmlg = :appellationmlg")
    , @NamedQuery(name = "Espece.findBySexeesp", query = "SELECT e FROM Espece e WHERE e.sexeesp = :sexeesp")
    , @NamedQuery(name = "Espece.findByStatutmigratoire", query = "SELECT e FROM Espece e WHERE e.statutmigratoire = :statutmigratoire")
    , @NamedQuery(name = "Espece.findByEndemisme", query = "SELECT e FROM Espece e WHERE e.endemisme = :endemisme")
    , @NamedQuery(name = "Espece.findByStatutcites", query = "SELECT e FROM Espece e WHERE e.statutcites = :statutcites")
    , @NamedQuery(name = "Espece.findByDesregne", query = "SELECT e FROM Espece e WHERE e.desregne = :desregne")
    , @NamedQuery(name = "Espece.findByDesembranchement", query = "SELECT e FROM Espece e WHERE e.desembranchement = :desembranchement")
    , @NamedQuery(name = "Espece.findByDesclasse", query = "SELECT e FROM Espece e WHERE e.desclasse = :desclasse")
    , @NamedQuery(name = "Espece.findByDesordre", query = "SELECT e FROM Espece e WHERE e.desordre = :desordre")
    , @NamedQuery(name = "Espece.findByDesfamille", query = "SELECT e FROM Espece e WHERE e.desfamille = :desfamille")
    , @NamedQuery(name = "Espece.findByDesgenre", query = "SELECT e FROM Espece e WHERE e.desgenre = :desgenre")
    , @NamedQuery(name = "Espece.findByDesstatutiucn", query = "SELECT e FROM Espece e WHERE e.desstatutiucn = :desstatutiucn")})
public class Espece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomscientifiqueavant")
    private String nomscientifiqueavant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomscientifiqueactuel")
    private String nomscientifiqueactuel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "appellationmlg")
    private String appellationmlg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "sexeesp")
    private String sexeesp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "statutmigratoire")
    private String statutmigratoire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "endemisme")
    private String endemisme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "statutcites")
    private String statutcites;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desregne")
    private String desregne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desembranchement")
    private String desembranchement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desclasse")
    private String desclasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desordre")
    private String desordre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desfamille")
    private String desfamille;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desgenre")
    private String desgenre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "desstatutiucn")
    private String desstatutiucn;

    public Espece() {
    }

    public Espece(Integer id) {
        this.id = id;
    }

    public Espece(Integer id, String nomscientifiqueavant, String nomscientifiqueactuel, String appellationmlg, String sexeesp, String statutmigratoire, String endemisme, String statutcites, String desregne, String desembranchement, String desclasse, String desordre, String desfamille, String desgenre, String desstatutiucn) {
        this.id = id;
        this.nomscientifiqueavant = nomscientifiqueavant;
        this.nomscientifiqueactuel = nomscientifiqueactuel;
        this.appellationmlg = appellationmlg;
        this.sexeesp = sexeesp;
        this.statutmigratoire = statutmigratoire;
        this.endemisme = endemisme;
        this.statutcites = statutcites;
        this.desregne = desregne;
        this.desembranchement = desembranchement;
        this.desclasse = desclasse;
        this.desordre = desordre;
        this.desfamille = desfamille;
        this.desgenre = desgenre;
        this.desstatutiucn = desstatutiucn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomscientifiqueavant() {
        return nomscientifiqueavant;
    }

    public void setNomscientifiqueavant(String nomscientifiqueavant) {
        this.nomscientifiqueavant = nomscientifiqueavant;
    }

    public String getNomscientifiqueactuel() {
        return nomscientifiqueactuel;
    }

    public void setNomscientifiqueactuel(String nomscientifiqueactuel) {
        this.nomscientifiqueactuel = nomscientifiqueactuel;
    }

    public String getAppellationmlg() {
        return appellationmlg;
    }

    public void setAppellationmlg(String appellationmlg) {
        this.appellationmlg = appellationmlg;
    }

    public String getSexeesp() {
        return sexeesp;
    }

    public void setSexeesp(String sexeesp) {
        this.sexeesp = sexeesp;
    }

    public String getStatutmigratoire() {
        return statutmigratoire;
    }

    public void setStatutmigratoire(String statutmigratoire) {
        this.statutmigratoire = statutmigratoire;
    }

    public String getEndemisme() {
        return endemisme;
    }

    public void setEndemisme(String endemisme) {
        this.endemisme = endemisme;
    }

    public String getStatutcites() {
        return statutcites;
    }

    public void setStatutcites(String statutcites) {
        this.statutcites = statutcites;
    }

    public String getDesregne() {
        return desregne;
    }

    public void setDesregne(String desregne) {
        this.desregne = desregne;
    }

    public String getDesembranchement() {
        return desembranchement;
    }

    public void setDesembranchement(String desembranchement) {
        this.desembranchement = desembranchement;
    }

    public String getDesclasse() {
        return desclasse;
    }

    public void setDesclasse(String desclasse) {
        this.desclasse = desclasse;
    }

    public String getDesordre() {
        return desordre;
    }

    public void setDesordre(String desordre) {
        this.desordre = desordre;
    }

    public String getDesfamille() {
        return desfamille;
    }

    public void setDesfamille(String desfamille) {
        this.desfamille = desfamille;
    }

    public String getDesgenre() {
        return desgenre;
    }

    public void setDesgenre(String desgenre) {
        this.desgenre = desgenre;
    }

    public String getDesstatutiucn() {
        return desstatutiucn;
    }

    public void setDesstatutiucn(String desstatutiucn) {
        this.desstatutiucn = desstatutiucn;
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
        if (!(object instanceof Espece)) {
            return false;
        }
        Espece other = (Espece) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Espece[ id=" + id + " ]";
    }
    
}
