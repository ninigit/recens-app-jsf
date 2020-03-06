/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.GenreFacadeLocal;
import Entity.Genre;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Genre")
@RequestScoped
public class Bean_Genre {

    @EJB
    private GenreFacadeLocal genreFacade;

    Genre genre = new Genre();

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    public String ajouter() {
        genreFacade.create(genre);
      
        return "Genre";
    }

    public String modifier() {

        genreFacade.edit(genre);

        
        return "Genre";
    }

    public String obtenir(int code) {

        genre = genreFacade.find(code);
        return "EditGenre";
    }
    public String obtenirPourSupprimer(int code) {

        genre = genreFacade.find(code);
        return "ConfirmGenre";
    }
    public String supprimer(int code) {

        genre = genreFacade.find(code);
        genreFacade.remove(genre);
   
       
        return "Genre";
    }

    public List<Genre> lister() {
        return genreFacade.findAll();
    }
    public String affichliste(){
    return "Genre";
    }
    /**
     * Creates a new instance of Bean_Genre
     */
    public Bean_Genre() {
    }
    
}
