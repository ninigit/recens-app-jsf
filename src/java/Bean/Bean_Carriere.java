/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.TypecarriereFacadeLocal;
import Entity.Typecarriere;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "bean_Carriere")
@RequestScoped
public class Bean_Carriere {

    @EJB
    private TypecarriereFacadeLocal typecarriereFacade;
    
    Typecarriere carriere = new Typecarriere();

    public Typecarriere getCarriere() {
        return carriere;
    }

    public void setCarriere(Typecarriere carriere) {
        this.carriere = carriere;
    }
    
    public String ajouter() {
        typecarriereFacade.create(carriere);
        carriere.setDescarriere("");
        return "Carriere";
    }

    public String modifier() {

        typecarriereFacade.edit(carriere);
        carriere.setDescarriere("");
        
        return "Carriere";
    }

    public String obtenir(int code) {

        carriere = typecarriereFacade.find(code);
        return "EditCarriere";
    }
    public String obtenirPourSupprimer(int code) {

        carriere = typecarriereFacade.find(code);
        return "ConfirmCarriere";
    }
    public String supprimer(int code) {

        carriere = typecarriereFacade.find(code);
        typecarriereFacade.remove(carriere);
        carriere.setDescarriere("");
    
       
        return "Carriere";
    }

    public List<Typecarriere> lister() {
        return typecarriereFacade.findAll();
    }
    public String affichliste(){
    return "Carriere";
    }
    
    public Bean_Carriere() {
    }
    
}
