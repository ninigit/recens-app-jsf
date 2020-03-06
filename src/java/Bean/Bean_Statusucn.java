/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.StatutiucnFacadeLocal;
import Entity.Statutiucn;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Statusucn")
@RequestScoped
public class Bean_Statusucn {

    @EJB
    private StatutiucnFacadeLocal statusucnFacade;

    Statutiucn statutiucn = new Statutiucn();

    public Statutiucn getStatutiucn() {
        return statutiucn;
    }

    public void setStatutiucn(Statutiucn statutiucn) {
        this.statutiucn = statutiucn;
    }

    
    public String ajouter() {
        statusucnFacade.create(statutiucn);
        
        return "StatusUCN";
    }

    public String modifier() {

        statusucnFacade.edit(statutiucn);
      
        return "StatusUCN";
    }

    public String obtenir(int code) {

        statutiucn = statusucnFacade.find(code);
        return "EditStatusUCN";
    }
    public String obtenirPourSupprimer(int code) {

        statutiucn = statusucnFacade.find(code);
        return "ConfirmStatusUCN";
    }
    public String supprimer(int code) {

        statutiucn = statusucnFacade.find(code);
        statusucnFacade.remove(statutiucn);
        
       
        return "StatusUCN";
    }

    public List<Statutiucn> lister() {
        return statusucnFacade.findAll();
    }
    public String nouveau(){
    return "NouveauStatusUCN";
    }
    public String affichliste(){
    return "StatusUCN";
    }
    /**
     * Creates a new instance of Bean_Statusucn
     */
    public Bean_Statusucn() {
    }
    
}
