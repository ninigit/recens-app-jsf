/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Typecarriere;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface TypecarriereFacadeLocal {

    void create(Typecarriere typecarriere);

    void edit(Typecarriere typecarriere);

    void remove(Typecarriere typecarriere);

    Typecarriere find(Object id);

    List<Typecarriere> findAll();

    List<Typecarriere> findRange(int[] range);

    int count();
    
}
