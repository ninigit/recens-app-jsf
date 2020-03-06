/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Util.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rah Nini
 */
public class LoginDAO {
  public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select nomutilisateur, motdepasse from utilisateur where nomutilisateur = ? and motdepasse = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}
  
  public static String PhotoGet(String user, String password){
      String res="";
                Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select photo from utilisateur where nomUser = ? and pass = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				res=rs.getString("photo");
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
                }
		
		return res;
}
}
