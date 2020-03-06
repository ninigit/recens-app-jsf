/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.MethodeobservationFacadeLocal;
import Entity.Methodeobservation;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Methodeobservation")
@RequestScoped
public class Bean_Methodeobservation {

    @EJB
    private MethodeobservationFacadeLocal methodeobservationFacade;
    
    Methodeobservation methode = new Methodeobservation();

    public Methodeobservation getMethode() {
        return methode;
    }

    public void setMethode(Methodeobservation methode) {
        this.methode = methode;
    }
    public String ajouter() {
        methodeobservationFacade.create(methode);
        methode.setDesmethodeobservation("");
        return "MethodeObs";
    }

    public String modifier() {

        methodeobservationFacade.edit(methode);
        methode.setDesmethodeobservation("");
        
        return "MethodeObs";
    }

    public String obtenir(int code) {

        methode = methodeobservationFacade.find(code);
        return "EditMethodeObs";
    }
    public String obtenirPourSupprimer(int code) {

        methode = methodeobservationFacade.find(code);
        return "ConfirmMethodeObs";
    }
    public String supprimer(int code) {

        methode = methodeobservationFacade.find(code);
        methodeobservationFacade.remove(methode);

       
        return "MethodeObs";
    }

    public List<Methodeobservation> lister() {
        return methodeobservationFacade.findAll();
    }
    public String affichliste(){
    return "MethodeObs";
    }
    /**
     * Creates a new instance of Bean_Methodeobservation
     */
    public Bean_Methodeobservation() {
    }
    
}
