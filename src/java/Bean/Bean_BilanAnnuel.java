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
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author PC
 */
@Named(value = "bean_BilanAnnuel")
@RequestScoped
public class Bean_BilanAnnuel {
    Connection conn= DataConnect.getConnection();
    private String param;
    private LineChartModel lineModel;
    
    public String AfficheGraphe(){
      init();
      return "BilanAnnuelAffiche";
  }

  @PostConstruct
  public void init() {
      lineModel = new LineChartModel();
      lineModel.setTitle("Bilan par an du "+param);
      LineChartSeries s = new LineChartSeries();
      try {
            PreparedStatement ps= conn.prepareStatement("SELECT YEAR(datedebut) AS Annee, MAX(nbobserves) AS NombreEspece, desespece FROM collection WHERE desespece=? GROUP BY Annee ORDER BY Annee ASC");
            ps.setString(1, param);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                
                s.set(Integer.parseInt(rs.getString("Annee")),Integer.parseInt(rs.getString("NombreEspece")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bean_BilanAnnuel.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      s.setLabel(param);

      

      lineModel.addSeries(s);
      lineModel.setLegendPosition("e");
      Axis y = lineModel.getAxis(AxisType.Y);
      y.setMin(0);
      
      y.setLabel("Nombre d'individus");

      Axis x = lineModel.getAxis(AxisType.X);
      
      x.setMin(2007);
      x.setTickInterval("1");
      x.setLabel("Année");

  }
  

  public LineChartModel getLineModel() {
      return lineModel;
  }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
  
    public Bean_BilanAnnuel() {
    }
    
}
