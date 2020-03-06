/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.CodecollectionFacadeLocal;
import Entity.Codecollection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Codecollection")
@RequestScoped
public class Bean_Codecollection {

    @EJB
    private CodecollectionFacadeLocal codecollectionFacade;
    
    Codecollection codecollection = new Codecollection();

    public Codecollection getCodecollection() {
        return codecollection;
    }

    public void setCodecollection(Codecollection codecollection) {
        this.codecollection = codecollection;
    }
    public String ajouter() {
        codecollectionFacade.create(codecollection);
        codecollection.setDescodecollection("");
        return "CodeCollection";
    }

    public String modifier() {

        codecollectionFacade.edit(codecollection);
        codecollection.setDescodecollection("");
        
        return "CodeCollection";
    }

    public String obtenir(int code) {

        codecollection = codecollectionFacade.find(code);
        return "EditCodeCollection";
    }
    public String obtenirPourSupprimer(int code) {

        codecollection = codecollectionFacade.find(code);
        return "ConfirmCodeCollection";
    }
    public String supprimer(int code) {

        codecollection = codecollectionFacade.find(code);
        codecollectionFacade.remove(codecollection);
        codecollection.setDescodecollection("");
       
        return "CodeCollection";
    }

    public List<Codecollection> lister() {
        return codecollectionFacade.findAll();
    }
    public String affichliste(){
    return "CodeCollection";
    }
    
    /**
     * Creates a new instance of Bean_Codecollection
     */
    public Bean_Codecollection() {
    }
    
}
