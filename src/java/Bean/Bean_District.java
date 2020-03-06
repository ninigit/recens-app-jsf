/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.DistrictFacadeLocal;
import Entity.District;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "bean_District")
@RequestScoped
public class Bean_District {

    @EJB
    private DistrictFacadeLocal districtFacade;

   District district = new District();

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
           
    public String ajouter() {
        districtFacade.create(district);
        
        return "District";
    }

    public String modifier() {

        districtFacade.edit(district);
        
        
        return "District";
    }

    public String obtenir(int code) {

        district = districtFacade.find(code);
        return "EditDistrict";
    }
    public String obtenirPourSupprimer(int code) {

        district = districtFacade.find(code);
        return "ConfirmDistrict";
    }
    public String supprimer(int code) {

        district = districtFacade.find(code);
        districtFacade.remove(district);
       
       
        return "District";
    }

    public List<District> lister() {
        return districtFacade.findAll();
    }
    public String affichliste(){
    return "District";
    }
    
    public Bean_District() {
    }
    
}
