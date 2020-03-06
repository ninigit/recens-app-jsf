/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.ClasseFacadeLocal;
import Entity.Classe;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Classe")
@RequestScoped
public class Bean_Classe {

    @EJB
    private ClasseFacadeLocal classeFacade;

    private String succes = "";
    
    Classe classe= new Classe();
    
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getSucces() {
        return succes;
    }

    public void setSucces(String succes) {
        this.succes = succes;
    }
    
    public String ajouter() {
        classeFacade.create(classe);
        
        return "Classe";
    }

    public String modifier() {

        classeFacade.edit(classe);
        
        
        return "Classe";
    }

    public String obtenir(int code) {

        classe = classeFacade.find(code);
        return "EditClasse";
    }
    public String obtenirPourSupprimer(int code) {

        classe = classeFacade.find(code);
        return "ConfirmClasse";
    }
    public String supprimer(int code) {

        classe = classeFacade.find(code);
        classeFacade.remove(classe);
       
       
        return "Classe";
    }

    public List<Classe> lister() {
        return classeFacade.findAll();
    }
    public String affichliste(){
    return "Classe";
    }
    /**
     * Creates a new instance of Bean_Classe
     */
    public Bean_Classe() {
    }
    
}
