/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Login;
import Entity.Embranchement;
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
public class EmbranchementFacade extends AbstractFacade<Embranchement> implements EmbranchementFacadeLocal {

    Connection conn= DataConnect.getConnection();
    
    @PersistenceContext(unitName = "TpfAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmbranchementFacade() {
        super(Embranchement.class);
    }

    @Override
    public List<Embranchement> findByRegne(String regne) {
       List<Embranchement> list = new ArrayList<>();
        try {
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM embranchement WHERE desregne=?");
            ps.setString(1,regne);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Embranchement e= new Embranchement();
                e.setDesembranchement(rs.getString("desembranchement"));
                list.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
