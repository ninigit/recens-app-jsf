/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.CommuneFacadeLocal;
import Entity.Commune;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "bean_Commune")
@RequestScoped
public class Bean_Commune {

    @EJB
    private CommuneFacadeLocal communeFacade;

    Commune commune = new Commune();

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }
    
    public String ajouter() {
        communeFacade.create(commune);
        
        return "Commune";
    }

    public String modifier() {

        communeFacade.edit(commune);
        
        
        return "Commune";
    }

    public String obtenir(int code) {

        commune = communeFacade.find(code);
        return "EditCommune";
    }
    public String obtenirPourSupprimer(int code) {

        commune = communeFacade.find(code);
        return "ConfirmCommune";
    }
    public String supprimer(int code) {

        commune = communeFacade.find(code);
        communeFacade.remove(commune);
       
       
        return "Commune";
    }

    public List<Commune> lister() {
        return communeFacade.findAll();
    }
    public String affichliste(){
    return "Commune";
    }
    
    public Bean_Commune() {
    }
    
}
