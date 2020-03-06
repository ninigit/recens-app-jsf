/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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
@Named(value = "bean_Top5")
@RequestScoped
public class Bean_Top5 {
Connection conn= DataConnect.getConnection();
    private PieChartModel model;
    private int n;

  @PostConstruct
  public void init() {
      model = new PieChartModel();
      n=0;
      try {
            PreparedStatement ps= conn.prepareStatement("SELECT desespece AS espece, COUNT(id) AS NbCollection FROM collection GROUP BY desespece ORDER BY NbCollection DESC");
            ResultSet rs=ps.executeQuery();
            while(rs.next()&&n<=5)
            {
                n++;
                model.set(rs.getString("espece"),Integer.parseInt(rs.getString("NbCollection")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bean_Charts.class.getName()).log(Level.SEVERE, null, ex);
        }

      //followings are some optional customizations:
      //set title
      model.setTitle("Top 5 des espèces les plus étudiées");
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
      model.setSeriesColors("86D7FA,aaf,afa,faa,faf,aff,ddd,1AA15F");
  }

  public String EspeceFavoris(){
  String espece="";
  n=0;
  try {
            PreparedStatement ps= conn.prepareStatement("SELECT desespece AS espece, COUNT(id) AS NbCollection FROM collection GROUP BY desespece ORDER BY NbCollection DESC");
            ResultSet rs=ps.executeQuery();
            while(rs.next()&&n<1)
            {
                n++;               
                espece="L'espèce la plus étudiée est le "+rs.getString("espece");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bean_Charts.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  return espece;
  }
  public PieChartModel getModel() {
      return model;
  }
    public Bean_Top5() {
    }
    
}
