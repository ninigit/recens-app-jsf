/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Login;
import Entity.Classe;
import Util.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC
 */
@Stateless
public class ClasseFacade extends AbstractFacade<Classe> implements ClasseFacadeLocal {
    
    Connection conn= DataConnect.getConnection();
    
    @PersistenceContext(unitName = "TpfAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClasseFacade() {
        super(Classe.class);
    }

    @Override
    public List<Classe> findByDesembranchement(String embranchement) {
        List<Classe> list = new ArrayList<>();
        try {
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM classe WHERE desembranchement=?");
            ps.setString(1, embranchement);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
               Classe c = new Classe();
               c.setDesclasse(rs.getString("desclasse"));
               list.add(c);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClasseFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
}
