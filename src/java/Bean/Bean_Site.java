/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.SiteFacadeLocal;
import Entity.Site;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "bean_Site")
@RequestScoped
public class Bean_Site {

    @EJB
    private SiteFacadeLocal siteFacade;
    
    Site site = new Site();

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
     public String ajouter() {
        siteFacade.create(site);
        
        return "Site";
    }

    public String modifier() {

        siteFacade.edit(site);
        
        
        return "Site";
    }

    public String obtenir(int code) {

        site = siteFacade.find(code);
        return "EditSite";
    }
    public String obtenirPourSupprimer(int code) {

        site = siteFacade.find(code);
        return "ConfirmSite";
    }
    public String supprimer(int code) {

        site = siteFacade.find(code);
        siteFacade.remove(site);
       
       
        return "Site";
    }

    public List<Site> lister() {
        return siteFacade.findAll();
    }
    public String affichliste(){
    return "Site";
    }
    public int totalsite(){    
        return siteFacade.count();
    }
    
    
    public Bean_Site() {
    }
    
}
