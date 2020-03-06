/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Ordre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface OrdreFacadeLocal {

    void create(Ordre ordre);

    void edit(Ordre ordre);

    void remove(Ordre ordre);

    Ordre find(Object id);

    List<Ordre> findAll();

    List<Ordre> findRange(int[] range);

    int count();
    
}
