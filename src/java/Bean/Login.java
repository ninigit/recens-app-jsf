/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.LoginDAO;
import Util.DataConnect;
import Util.SessionUtils;

import javax.inject.Named;
import org.primefaces.context.RequestContext;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rah Nini
 */
@ManagedBean(name= "login")
@SessionScoped
public class Login implements Serializable {
private static final long serialVersionUID = 1094801825228386363L;
Connection conn= DataConnect.getConnection();
	
	private String pwd;
	private String msg;
	private String user;
     

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

 

	//validate login
	public String validateUsernamePassword() {
		boolean valid = LoginDAO.validate(user, pwd);
             
                
		if (valid) {
			HttpSession session = SessionUtils.getSession();
                        
			session.setAttribute("username", user);
                       
			return "Accueil.xhtml?faces-redirect=true";
		} 
                else
                {
                    RequestContext.getCurrentInstance().update("growl");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur", "Les informations de l'utilisateur sont érronées"));
                
			return "";
		}
        }
	

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "Login.xhtml";
	}
    public String typeUser(String user){
   String resultat=new String();
   
        try {
            PreparedStatement ps= conn.prepareStatement("SELECT typeutilisateur FROM utilisateur WHERE nomutilisateur=?");
            ps.setString(1, user);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                resultat=rs.getString("typeutilisateur");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultat;
   
   }
    public String nomcompletUser(String user){
   String resultat=new String();
   
        try {
            PreparedStatement ps= conn.prepareStatement("SELECT nomcomplet FROM utilisateur WHERE nomutilisateur=?");
            ps.setString(1, user);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                resultat=rs.getString("nomcomplet");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultat;
   
   }
    public Login() {
    }
    
}
