/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Coba;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface CobaFacadeLocal {

    void create(Coba coba);

    void edit(Coba coba);

    void remove(Coba coba);

    Coba find(Object id);

    List<Coba> findAll();

    List<Coba> findRange(int[] range);

    int count();
    
}
