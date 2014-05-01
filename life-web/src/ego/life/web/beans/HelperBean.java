package ego.life.web.beans;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ego.life.domain.Agent;
import ego.life.services.AgentServiceLocal;

@ManagedBean @ApplicationScoped
public class HelperBean {
	
	@EJB
	private AgentServiceLocal service;
	
	public Agent find(String name){
		return service.find(name);
	}

}
