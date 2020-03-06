/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.CollectionFacadeLocal;
import Entity.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "bean_Collection")
@RequestScoped
public class Bean_Collection {

    @EJB
    private CollectionFacadeLocal collectionFacade;

    Collection collection = new Collection();

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
    
    public String ajouter(){
       collectionFacade.create(collection);
     
       return "Collection";
   }
   public String modifier(){
    
       collectionFacade.edit(collection);
    
    return "Collection";
    }
    public String obtenir(int code){
    
       collection = collectionFacade.find(code);
    return "EditCollection";
    }
   public String supprimer(int code){
    
       collection = collectionFacade.find(code);
       collectionFacade.remove(collection);
      
       return "Collection";
    }
   public List <Collection> lister()
    {    
       return collectionFacade.findAll();
    }
    public String affichliste(){
    return "Collection";
    }
    public String obtenirPourSupprimer(int code) {

        collection = collectionFacade.find(code);
        return "ConfirmCollection";
    }
    public String visualiser(int code){
       collection = collectionFacade.find(code);
    return "ConsulterCollection";
    }
    public int totalcollection(){    
        return collectionFacade.count();
    }
    public Bean_Collection() {
    }
    
}
