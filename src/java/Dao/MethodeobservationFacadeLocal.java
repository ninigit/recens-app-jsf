/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Methodeobservation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface MethodeobservationFacadeLocal {

    void create(Methodeobservation methodeobservation);

    void edit(Methodeobservation methodeobservation);

    void remove(Methodeobservation methodeobservation);

    Methodeobservation find(Object id);

    List<Methodeobservation> findAll();

    List<Methodeobservation> findRange(int[] range);

    int count();
    
}
