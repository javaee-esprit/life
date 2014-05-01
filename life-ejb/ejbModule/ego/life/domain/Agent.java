package ego.life.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.*;

@Entity
@Table(name="life_agent")
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	   
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String name;
	private String role;

	public Agent() {
	}
	
	
	public Agent(String name, String role) {
		this.name = name;
		this.role = role;
	}


	public Long getId() {
		log(this.id);
		return this.id;
	}

	public void setId(Long id) {
		log(id);
		this.id = id;
	}   
	public String getName() {
		log(this.name);
		return this.name;
	}

	public void setName(String name) {
		log(name);
		this.name = name;
	}   
	public String getRole() {
		log(this.role);
		return this.role;
	}

	public void setRole(String role) {
		log(role);
		this.role = role;
	}


	
	public String toString() {
		String toString = "Agent [id=" + id + ", name=" + name + ", role=" + role + "]";
		log(toString);
		return toString;
	}
	
	private void log(Object object) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,methodName + ": " + object);
    }


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		log(result);
		return result;
	}


	public boolean equals(Object obj) {
		log(obj);
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
   
}
