/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Espece;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface EspeceFacadeLocal {

    void create(Espece espece);

    void edit(Espece espece);

    void remove(Espece espece);

    Espece find(Object id);

    List<Espece> findAll();

    List<Espece> findRange(int[] range);

    int count();
    
}
