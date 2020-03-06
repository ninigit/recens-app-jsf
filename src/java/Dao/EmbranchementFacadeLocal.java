/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Embranchement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface EmbranchementFacadeLocal {

    void create(Embranchement embranchement);

    void edit(Embranchement embranchement);

    void remove(Embranchement embranchement);

    Embranchement find(Object id);

    List<Embranchement> findAll();
    
    List<Embranchement> findByRegne(String regne);

    List<Embranchement> findRange(int[] range);

    int count();
    
}
