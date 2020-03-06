/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.MethodecaptureFacadeLocal;
import Entity.Methodecapture;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Methodecapture")
@RequestScoped
public class Bean_Methodecapture {

    @EJB
    private MethodecaptureFacadeLocal methodecaptureFacade;
    
    Methodecapture methode = new Methodecapture();

    public Methodecapture getMethode() {
        return methode;
    }

    public void setMethode(Methodecapture methode) {
        this.methode = methode;
    }
    
    public String ajouter() {
        methodecaptureFacade.create(methode);
        
        return "MethodeCapture";
    }

    public String modifier() {

        methodecaptureFacade.edit(methode);
        
        
        return "MethodeCapture";
    }

    public String obtenir(int code) {

        methode = methodecaptureFacade.find(code);
        return "EditMethodeCapture";
    }
    public String obtenirPourSupprimer(int code) {

        methode = methodecaptureFacade.find(code);
        return "ConfirmMethodeCapture";
    }
    public String supprimer(int code) {

        methode = methodecaptureFacade.find(code);
        methodecaptureFacade.remove(methode);
        
        return "MethodeCapture";
    }

    public List<Methodecapture> lister() {
        return methodecaptureFacade.findAll();
    }
    public String nouveau(){
    return "NouveauMethodeCapture";
    }
    public String affichliste(){
    return "MethodeCapture";
    }
            
    
    /**
     * Creates a new instance of Bean_Methodecapture
     */
    public Bean_Methodecapture() {
    }
    
}
