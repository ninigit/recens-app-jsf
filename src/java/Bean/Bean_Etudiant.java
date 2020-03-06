/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.EtudiantFacadeLocal;
import Entity.Etudiant;
import Util.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Etudiant")
@RequestScoped
public class Bean_Etudiant {
Connection conn= DataConnect.getConnection();
    @EJB
    private EtudiantFacadeLocal etudiantFacade;
    
    private List <Etudiant> Listmilamina;

    public List<Etudiant> getListmilamina() {
        return Listmilamina;
    }

    public void setListmilamina(List<Etudiant> Listmilamina) {
        this.Listmilamina = Listmilamina;
    }
   
private Etudiant etd = new Etudiant();

    public Etudiant getEtd() {
        return etd;
    }

    public void setEtd(Etudiant etd) {
        this.etd = etd;
    }
   public String ajouter(){
       etd.setNomcomplet(etd.getNom()+" "+etd.getPrenoms());
       etudiantFacade.create(etd);
       return "Personnes";
   }
   public String modifier(){
        etd.setNomcomplet(etd.getNom()+" "+etd.getPrenoms());
        etudiantFacade.edit(etd);
    return "Personnes";
    }
    public String obtenir(int code){
    
       etd = etudiantFacade.find(code);
    return "EditEtudiant";
    }
   public String supprimer(int code){
    
       etd = etudiantFacade.find(code);
       etudiantFacade.remove(etd);
       
       return "Personnes";
    }
   public List <Etudiant> lister()
    {    
       return etudiantFacade.findAll();
    }
   public String affichliste(){
    return "Personnes";
    }
   public String obtenirPourSupprimer(int code) {

        etd = etudiantFacade.find(code);
        return "ConfirmEtudiant";
    }
   public String visualiser(int code){
       etd = etudiantFacade.find(code);
    return "ConsulterEtudiant";
    }
   public List <Etudiant> listerInformationsPersonnelles(String motcle)
    {    
       
       List<Etudiant> list = new ArrayList<>();
       try {
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM etudiant WHERE nomcomplet=?");
            ps.setString(1, motcle);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Etudiant e= new Etudiant();
                e.setId(Integer.parseInt(rs.getString("id")));
                e.setNom(rs.getString("nom"));
                e.setPrenoms(rs.getString("prenoms"));
                e.setDatenaiss(rs.getDate("datenaiss"));
                e.setLieunaiss(rs.getString("lieunaiss"));
                e.setSexe(rs.getString("sexe"));
                e.setCin(rs.getLong("cin"));
                e.setContact(rs.getString("contact"));
                e.setUniversite(rs.getString("universite"));
                e.setNiveau(rs.getString("niveau"));
                e.setDiplome(rs.getString("diplome"));
                
                list.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
    }
    public Bean_Etudiant() {
    }
    
}
