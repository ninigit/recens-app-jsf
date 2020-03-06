/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Classe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface ClasseFacadeLocal {

    void create(Classe classe);

    void edit(Classe classe);

    void remove(Classe classe);

    Classe find(Object id);

    List<Classe> findAll();
    
    List<Classe> findByDesembranchement(String embranchement);

    List<Classe> findRange(int[] range);

    int count();
    
}
