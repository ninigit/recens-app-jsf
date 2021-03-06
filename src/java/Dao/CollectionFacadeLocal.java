/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface CollectionFacadeLocal {

    void create(Collection collection);

    void edit(Collection collection);

    void remove(Collection collection);

    Collection find(Object id);

    List<Collection> findAll();

    List<Collection> findRange(int[] range);

    int count();
    
}
