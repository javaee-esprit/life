package ego.life.services;

import java.util.List;

import ego.life.domain.Agent;

public interface AgentServiceLocal {
	
	void save(Agent agent);
	void remove(Agent agent);
	Agent find(String name);
	Agent find(Long id);
	List<Agent> findAll();
	boolean exists(String name);

}
