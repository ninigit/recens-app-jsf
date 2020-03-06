/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Regne;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface RegneFacadeLocal {

    void create(Regne regne);

    void edit(Regne regne);

    void remove(Regne regne);

    Regne find(Object id);

    List<Regne> findAll();

    List<Regne> findRange(int[] range);

    int count();
    
}
