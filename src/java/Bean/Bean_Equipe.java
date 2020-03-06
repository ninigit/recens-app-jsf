/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.EquipeFacadeLocal;
import Entity.Equipe;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Equipe")
@RequestScoped
public class Bean_Equipe {

    @EJB
    private EquipeFacadeLocal equipeFacade;

    Equipe equipe = new Equipe();
    String [] EquipeSelect;

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String[] getEquipeSelect() {
        return EquipeSelect;
    }

    public void setEquipeSelect(String[] EquipeSelect) {
        this.EquipeSelect = EquipeSelect;
    }

     
    
   /*Getters and Setters*/
    public String ajouter(){
       equipeFacade.create(equipe);
     
       return "EquipeList";
   }
   public String modifier(){
    
       equipeFacade.edit(equipe);
    
    return "EquipeList";
    }
    public String obtenir(int code){
    
       equipe = equipeFacade.find(code);
    return "EditEquipe";
    }
   public String supprimer(int code){
    
       equipe = equipeFacade.find(code);
       equipeFacade.remove(equipe);
      
       return "EquipeList";
    }
   public String obtenirPourSupprimer(int code) {

        equipe = equipeFacade.find(code);
        return "ConfirmEquipe";
    }
   public List <Equipe> lister()
    {    
       return equipeFacade.findAll();
    }
   
   public String affichliste(){
    
       return "EquipeList";
    }
   public String choixEquipeTermine(){
     equipe.setNomconcat(Arrays.toString(EquipeSelect));
       return "NouveauEquipe";
    }
  
    
    public Bean_Equipe() {
    }
    
}
