/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.EmbranchementFacadeLocal;
import Entity.Embranchement;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Embranchement")
@RequestScoped
public class Bean_Embranchement {

    @EJB
    private EmbranchementFacadeLocal embranchementFacade;
    
    Embranchement embrancehement = new Embranchement();

    public Embranchement getEmbrancehement() {
        return embrancehement;
    }

    public void setEmbrancehement(Embranchement embrancehement) {
        this.embrancehement = embrancehement;
    }
     public String ajouter() {
        embranchementFacade.create(embrancehement);
        
        return "Embranchement";
    }

    public String modifier() {

        embranchementFacade.edit(embrancehement);
        
        return "Embranchement";
    }

    public String obtenir(int code) {

        embrancehement = embranchementFacade.find(code);
        return "EditEmbranchement";
    }
public String obtenirPourSupprimer(int code) {

        embrancehement = embranchementFacade.find(code);
        return "ConfirmEmbranchement";
    }
    public String supprimer(int code) {

        embrancehement = embranchementFacade.find(code);
        embranchementFacade.remove(embrancehement);
        
        
        return "Embranchement";
       
    }

    public List<Embranchement> lister() {
        return embranchementFacade.findAll();
    }
   public String affichliste(){
    return "Embranchement";
    }
    /**
     * Creates a new instance of Bean_Embranchement
     */
    public Bean_Embranchement() {
    }
    
}
