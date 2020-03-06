/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.AgentFacadeLocal;
import Entity.Agent;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rah Nini
 */
@Named(value = "bean_Agent")
@RequestScoped
public class Bean_Agent {

    @EJB
    private AgentFacadeLocal agentFacade;
    
    Agent agent= new Agent();

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    public String ajouter(){
       agentFacade.create(agent);
     
       return "AgentList";
   }
   public String modifier(){
    
       agentFacade.edit(agent);
    
    return "AgentList";
    }
    public String obtenir(int code){
    
       agent = agentFacade.find(code);
    return "EditAgent";
    }
   public String supprimer(int code){
    
       agent = agentFacade.find(code);
       agentFacade.remove(agent);
      
       return "AgentList";
    }
   public List <Agent> lister()
    {    
       return agentFacade.findAll();
    }
    public String affichliste(){
    return "AgentList";
    }
    public String obtenirPourSupprimer(int code) {

        agent = agentFacade.find(code);
        return "ConfirmAgent";
    }
    public String visualiser(int code){
       agent = agentFacade.find(code);
    return "ConsulterAgent";
    }
    /**
     * Creates a new instance of Bean_Agent
     */
    public Bean_Agent() {
    }
    
}
