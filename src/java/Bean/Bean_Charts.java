/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entity.Classe;
import Util.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author PC
 */
@Named(value = "bean_Charts")
@RequestScoped
public class Bean_Charts {
    Connection conn= DataConnect.getConnection();
    private PieChartModel model;

  @PostConstruct
  public void init() {
      model = new PieChartModel();
     
      try {
            PreparedStatement ps= conn.prepareStatement("SELECT COUNT(id) AS NbCollection, dessite FROM collection GROUP BY dessite");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                
                model.set(rs.getString("dessite"),Integer.parseInt(rs.getString("NbCollection")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bean_Charts.class.getName()).log(Level.SEVERE, null, ex);
        }

      //followings are some optional customizations:
      //set title
      model.setTitle("Nombre de collections par site");
      //set legend position to 'e' (east), other values are 'w', 's' and 'n'
      model.setLegendPosition("e");
      //enable tooltips
      model.setShowDatatip(true);
      //show labels inside pie chart
      model.setShowDataLabels(true);
      //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
      model.setDataFormat("value");
      //format: %d for 'value', %s for 'label', %d%% for 'percent'
   
      //pie sector colors
      model.setSeriesColors("aaf,afa,faa,ffa,aff,faf,ddd");
  }

  public PieChartModel getModel() {
      return model;
  }
    public Bean_Charts() {
    }
    
}
