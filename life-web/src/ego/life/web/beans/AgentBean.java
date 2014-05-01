package ego.life.web.beans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ego.life.domain.Agent;
import ego.life.services.AgentServiceLocal;

@ManagedBean @ViewScoped
public class AgentBean {

	@EJB
	private AgentServiceLocal service;
	
	private Agent agent;
	private List<Agent> agents;
	
	public AgentBean() {
		log(this);
	}
	
	@PostConstruct
	public void init(){
		log(this);
		agent = service.find("bison");
		agents = service.findAll();
	}
	
	public String doRefresh(){
		return null;
	}
	

	public Agent getAgent() {
		log(agent);
		return agent;
	}

	public void setAgent(Agent agent) {
		log(agent);
		this.agent = agent;
	}
	
	public List<Agent> getAgents() {
		log(agents);
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		log(agents);
		this.agents = agents;
	}

	private void log(Object object) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,methodName + ": " + object);
    }
}
