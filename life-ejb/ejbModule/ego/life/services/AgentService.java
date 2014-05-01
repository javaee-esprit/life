package ego.life.services;

import java.util.List;
import java.util.logging.Level;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.logging.Logger;

import ego.life.domain.Agent;

@Stateful
@Remote(AgentServiceRemote.class)
@Local(AgentServiceLocal.class)
public class AgentService implements AgentServiceLocal, AgentServiceRemote{
	
	@PersistenceContext
	private EntityManager em;
	
	public AgentService() {
	}

	public void save(Agent agent) {
		em.merge(agent);
	}

	public void remove(Agent agent) {
		em.remove(em.merge(agent));
	}

	public Agent find(String name) {
		Agent found = null;
		TypedQuery<Agent> query = em.createQuery("select a from Agent a where a.name=:x",Agent.class);
		query.setParameter("x", name);
		try{
			found = (Agent) query.getSingleResult();
		}catch(Exception ex){
			Logger.getLogger(this.getClass().getName()).log(Level.INFO, "no agent found with name="+name);
		}
		return found;
	}

	public Agent find(Long id) {
		return em.find(Agent.class, id);
	}

	public List<Agent> findAll() {
		List<Agent> all = null;
		TypedQuery<Agent> query = em.createQuery("select a from Agent a",Agent.class);
		all = query.getResultList();
		return all;
	}

	public boolean exists(String name) {
		boolean exists = false;
		TypedQuery<Boolean> query = em.createQuery("select case when (count(a)>0) then true else false end from Agent a where a.name=:x",Boolean.class);
		query.setParameter("x", name);
		exists = (Boolean) query.getSingleResult();
		return exists;
	}

}
