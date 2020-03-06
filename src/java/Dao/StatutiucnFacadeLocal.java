/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Statutiucn;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface StatutiucnFacadeLocal {

    void create(Statutiucn statutiucn);

    void edit(Statutiucn statutiucn);

    void remove(Statutiucn statutiucn);

    Statutiucn find(Object id);

    List<Statutiucn> findAll();

    List<Statutiucn> findRange(int[] range);

    int count();
    
}
