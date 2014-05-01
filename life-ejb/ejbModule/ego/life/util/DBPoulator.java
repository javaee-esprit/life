package ego.life.util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Startup;

import javax.ejb.Singleton;

import ego.life.domain.Agent;
import ego.life.services.AgentServiceLocal;

@Singleton
@Startup
public class DBPoulator {
	
	@EJB
	private AgentServiceLocal service;
	
	@PostConstruct
	public void init(){
		if (!service.exists("ryu")) {
			service.save(new Agent("ryu","fighter"));
		}
		if (!service.exists("ken")) {
			service.save(new Agent("ken","fighter"));
		}
		if (!service.exists("bison")) {
			service.save(new Agent("bison","boss"));
		}
	}

}
