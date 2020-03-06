/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Codecollection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface CodecollectionFacadeLocal {

    void create(Codecollection codecollection);

    void edit(Codecollection codecollection);

    void remove(Codecollection codecollection);

    Codecollection find(Object id);

    List<Codecollection> findAll();

    List<Codecollection> findRange(int[] range);

    int count();
    
}
