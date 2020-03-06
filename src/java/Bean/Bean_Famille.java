/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.FamilleFacadeLocal;
import Entity.Famille;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Famille")
@RequestScoped
public class Bean_Famille {

    @EJB
    private FamilleFacadeLocal familleFacade;

    Famille famille = new Famille();

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }
    public String ajouter() {
        familleFacade.create(famille);
     
        return "Famille";
    }

    public String modifier() {

        familleFacade.edit(famille);
       
        
        return "Famille";
    }

    public String obtenir(int code) {

        famille = familleFacade.find(code);
        return "EditFamille";
    }
    public String obtenirPourSupprimer(int code) {

        famille = familleFacade.find(code);
        return "ConfirmFamille";
    }
    public String supprimer(int code) {

        famille = familleFacade.find(code);
        familleFacade.remove(famille);

       
        return "Famille";
    }

    public List<Famille> lister() {
        return familleFacade.findAll();
    }
    public String affichliste(){
    return "Famille";
    }
    
    /**
     * Creates a new instance of Bean_Famille
     */
    public Bean_Famille() {
    }
    
}
