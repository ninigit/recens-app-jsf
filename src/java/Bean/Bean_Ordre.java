/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.OrdreFacadeLocal;
import Entity.Ordre;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Ordre")
@RequestScoped
public class Bean_Ordre {

    @EJB
    private OrdreFacadeLocal ordreFacade;
    
    Ordre ordre = new Ordre();

    public Ordre getOrdre() {
        return ordre;
    }

    public void setOrdre(Ordre ordre) {
        this.ordre = ordre;
    }
    
    public String ajouter() {
        ordreFacade.create(ordre);
       
        return "Ordre";
    }

    public String modifier() {

        ordreFacade.edit(ordre);

        return "Ordre";
    }

    public String obtenir(int code) {

        ordre = ordreFacade.find(code);
        return "EditOrdre";
    }
    public String obtenirPourSupprimer(int code) {

        ordre = ordreFacade.find(code);
        return "ConfirmOrdre";
    }
    public String supprimer(int code) {

        ordre = ordreFacade.find(code);
        ordreFacade.remove(ordre);
    
       
        return "Ordre";
    }

    public List<Ordre> lister() {
        return ordreFacade.findAll();
    }
    public String affichliste(){
    return "Ordre";
    }
    /**
     * Creates a new instance of Bean_Ordre
     */
    public Bean_Ordre() {
    }
    
}
