/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.ClasseFacadeLocal;
import Dao.EmbranchementFacadeLocal;
import Dao.EspeceFacadeLocal;
import Dao.RegneFacadeLocal;
import Entity.Classe;
import Entity.Embranchement;
import Entity.Espece;
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
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author PC
 */
@Named(value = "bean_Espece")
@RequestScoped
public class Bean_Espece {

    private String regne;
    private String embranchement;
    private String classe;
    private String ordre;
    private String famille;
    private String genre;
   
    private List<Embranchement> listembr;
    private List<Classe> listclasse;
    
    Connection conn= DataConnect.getConnection();
   
    
    @EJB
    private EspeceFacadeLocal especeFacade;
    
    
    Espece espece = new Espece();

    
/*Getters and Setters*/
    public Espece getEspece() {
        return espece;
    }
    
    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public String getRegne() {
        return regne;
    }

    public void setRegne(String regne) {
        this.regne = regne;
    }

    public String getEmbranchement() {
        return embranchement;
    }

    public void setEmbranchement(String embranchement) {
        this.embranchement = embranchement;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Embranchement> getListembr() {
        return listembr;
    }

    public void setListembr(List<Embranchement> listembr) {
        this.listembr = listembr;
    }

    public List<Classe> getListclasse() {
        return listclasse;
    }

    public void setListclasse(List<Classe> listclasse) {
        this.listclasse = listclasse;
    }
    
   
    
/* End of Getters and Setters*/

    
    
    public String ajouter(){
       especeFacade.create(espece);
     
       return "Espece";
   }
   public String modifier(){
    
       especeFacade.edit(espece);
    
    return "Espece";
    }
    public String obtenir(int code){
    
       espece = especeFacade.find(code);
    return "EditEspece";
    }
   public String supprimer(int code){
    
       espece = especeFacade.find(code);
       especeFacade.remove(espece);
      
       return "Espece";
    }
   public List <Espece> lister()
    {    
       return especeFacade.findAll();
    }
    public String affichliste(){
    return "Espece";
    }
    public String obtenirPourSupprimer(int code) {

        espece = especeFacade.find(code);
        return "ConfirmEspece";
    }
    public String visualiser(int code){
       espece = especeFacade.find(code);
    return "ConsulterEspece";
    }
    
    public int totalespece(){    
        return especeFacade.count();
    }
    /*Operatons choix par étape debut*/
    public String ValiderChoixregne(){
        espece.setDesregne(regne);
        listembr=listerEmbranchement(regne);
        return "ChoixEmbranchement";
    }
    public String ValiderChoixembranchement(){
        espece.setDesembranchement(embranchement);
        listclasse=listerClasse(embranchement);
        return "ChoixClasse";
    }
    public String ValiderChoixClasse(){
        espece.setDesclasse(classe);
        return "ChoixOrdre";
    }
    public String ValiderChoixOrdre(){
        espece.setDesordre(ordre);
        return "ChoixFamille";
    }
    public String ValiderChoixFamille(){
        espece.setDesfamille(famille);
        return "ChoixGenre";
    }
    public String ValiderChoixGenre(){
        espece.setDesgenre(genre);
        return "NouveauEspece";
    }
    /*Operatons choix par étape fin*/
    
    public int totalendemique(){
       int total=0;
       String endem = "Endemique";
        try {
            PreparedStatement ps= conn.prepareStatement("SELECT COUNT(id) AS Endem FROM espece WHERE endemisme=?");
            ps.setString(1,endem);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                total=Integer.parseInt(rs.getString("Endem"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    return total;
    }
    
    
    
    
    
    
    public List<Embranchement> listerEmbranchement(String motcle){
       List<Embranchement> list = new ArrayList<>();
        try {
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM embranchement WHERE desregne=?");
            ps.setString(1, motcle);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Embranchement e = new Embranchement();
                e.setId(Integer.parseInt(rs.getString("id")));
                e.setDesembranchement(rs.getString("desembranchement"));
                e.setDesregne(rs.getString("desregne"));
                list.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
    }
    
    public List<Classe> listerClasse(String motcle){
       List<Classe> list = new ArrayList<>();
        try {
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM classe WHERE desembranchement=?");
            ps.setString(1, motcle);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Classe e = new Classe();
                e.setId(Integer.parseInt(rs.getString("id")));
                e.setDesembranchement(rs.getString("desembranchement"));
                e.setDesclasse(rs.getString("desclasse"));
                list.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
    }
   
 
    public Bean_Espece() {
    }
    
}
