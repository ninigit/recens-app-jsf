/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.CobaFacadeLocal;
import Entity.Coba;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "bean_Coba")
@RequestScoped
public class Bean_Coba {

    @EJB
    private CobaFacadeLocal cobaFacade;
    
    Coba coba = new Coba();

    public Coba getCoba() {
        return coba;
    }

    public void setCoba(Coba coba) {
        this.coba = coba;
    }
    
    public String ajouter(){
       cobaFacade.create(coba);
     
       return "CobaList";
   }
   public String modifier(){
    
       cobaFacade.edit(coba);
    
    return "CobaList";
    }
    public String obtenir(int code){
    
       coba = cobaFacade.find(code);
    return "EditCoba";
    }
   public String supprimer(int code){
    
       coba = cobaFacade.find(code);
       cobaFacade.remove(coba);
      
       return "CobaList";
    }
   public List <Coba> lister()
    {    
       return cobaFacade.findAll();
    }
    public String affichliste(){
    return "CobaList";
    }
    public String obtenirPourSupprimer(int code) {

        coba = cobaFacade.find(code);
        return "ConfirmCoba";
    }
    public String visualiser(int code){
       coba = cobaFacade.find(code);
    return "ConsulterCoba";
    }
    
    
    public Bean_Coba() {
    }
    
}
