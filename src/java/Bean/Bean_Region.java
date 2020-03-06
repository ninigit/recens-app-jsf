/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.RegionFacadeLocal;
import Entity.Region;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "bean_Region")
@RequestScoped
public class Bean_Region {

    @EJB
    private RegionFacadeLocal regionFacade;

    Region region = new Region();

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
    public String ajouter() {
        regionFacade.create(region);
        region.setDesregion("");
        return "Region";
    }

    public String modifier() {

        regionFacade.edit(region);
        region.setDesregion("");
        
        return "Region";
    }

    public String obtenir(int code) {

        region = regionFacade.find(code);
        return "EditRegion";
    }
    public String obtenirPourSupprimer(int code) {

        region = regionFacade.find(code);
        return "ConfirmRegion";
    }
    public String supprimer(int code) {

        region = regionFacade.find(code);
        regionFacade.remove(region);
        region.setDesregion("");
       
        return "Region";
    }

    public List<Region> lister() {
        return regionFacade.findAll();
    }
    public String affichliste(){
    return "Region";
    }
    
    public Bean_Region() {
    }
    
}
