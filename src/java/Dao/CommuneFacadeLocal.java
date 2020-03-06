/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Commune;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface CommuneFacadeLocal {

    void create(Commune commune);

    void edit(Commune commune);

    void remove(Commune commune);

    Commune find(Object id);

    List<Commune> findAll();

    List<Commune> findRange(int[] range);

    int count();
    
}
