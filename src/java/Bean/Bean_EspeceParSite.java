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
@Named(value = "bean_EspeceParSite")
@RequestScoped
public class Bean_EspeceParSite {

    Connection conn= DataConnect.getConnection();
    private String nomespece;
    private String annee;
    private PieChartModel model;
    
    public String AfficheGraphe(){
      init();
      return "EspeceParSiteAffiche";
  }

  @PostConstruct
  public void init() {
      model = new PieChartModel();
     
      try {
            PreparedStatement ps= conn.prepareStatement("SELECT desespece AS Espece, MAX(Nbobserves) AS NbEspece, YEAR(datedebut) AS Annee, dessite FROM collection WHERE desespece=? AND YEAR(datedebut)=? GROUP BY dessite");
            ps.setString(1, nomespece);
            ps.setString(2, annee);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                
                model.set(rs.getString("dessite"),Integer.parseInt(rs.getString("NbEspece")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bean_Charts.class.getName()).log(Level.SEVERE, null, ex);
        }

      //followings are some optional customizations:
      //set title
      model.setTitle("Nombre d'individus du "+nomespece+" par site pour l'année "+annee);
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

    public String getNomespece() {
        return nomespece;
    }

    public void setNomespece(String nomespece) {
        this.nomespece = nomespece;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
  

  public PieChartModel getModel() {
      return model;
  }
    public Bean_EspeceParSite() {
    }
    
}
