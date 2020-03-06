/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.RegneFacadeLocal;
import Entity.Regne;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "bean_Regne")
@RequestScoped
public class Bean_Regne {

    @EJB
    private RegneFacadeLocal regneFacade;

    Regne regne = new Regne();

    public Regne getRegne() {
        return regne;
    }

    public void setRegne(Regne regne) {
        this.regne = regne;
    }
    
    public String ajouter() {
        regneFacade.create(regne);
        regne.setDesgenre("");
        return "Regne";
    }

    public String modifier() {

        regneFacade.edit(regne);
        regne.setDesgenre("");
        
        return "Regne";
    }

    public String obtenir(int code) {

        regne = regneFacade.find(code);
        return "EditRegne";
    }
    public String obtenirPourSupprimer(int code) {

        regne = regneFacade.find(code);
        return "ConfirmRegne";
    }
    public String supprimer(int code) {

        regne = regneFacade.find(code);
        regneFacade.remove(regne);
        regne.setDesgenre("");
    
       
        return "Regne";
    }

    public List<Regne> lister() {
        return regneFacade.findAll();
    }
    public String affichliste(){
    return "Regne";
    }
    
    
    public Bean_Regne() {
    }
    
}
