/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.UtilisateurFacadeLocal;
import Entity.Utilisateur;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "bean_Compte")
@RequestScoped
public class Bean_Compte {

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    Utilisateur utilisateur = new Utilisateur();

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public String ajouter() {
        utilisateurFacade.create(utilisateur);
        
        return "Comptes";
    }

    public String modifier() {

        utilisateurFacade.edit(utilisateur);
        
        
        return "Comptes";
    }

    public String obtenir(int code) {

        utilisateur = utilisateurFacade.find(code);
        return "EditComptes";
    }
    public String obtenirPourSupprimer(int code) {

        utilisateur = utilisateurFacade.find(code);
        return "ConfirmComptes";
    }
    public String supprimer(int code) {

        utilisateur = utilisateurFacade.find(code);
        utilisateurFacade.remove(utilisateur);
       
       
        return "Comptes";
    }

    public List<Utilisateur> lister() {
        return utilisateurFacade.findAll();
    }
    public String affichliste(){
    return "Comptes";
    }
    
    public Bean_Compte() {
    }
    
}
