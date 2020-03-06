/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Methodecapture;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface MethodecaptureFacadeLocal {

    void create(Methodecapture methodecapture);

    void edit(Methodecapture methodecapture);

    void remove(Methodecapture methodecapture);

    Methodecapture find(Object id);

    List<Methodecapture> findAll();

    List<Methodecapture> findRange(int[] range);

    int count();
    
}
