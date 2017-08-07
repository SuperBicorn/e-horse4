package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

 @Entity
 @Table(name="agents")
public class Agent implements Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAgent;
	private String username;
	private String mdp;

	public Agent() {
	}

	public Agent(String username, String mdp) {
		super();
		this.username = username;
		this.mdp = mdp;
	}

	public Agent(Long idAgent, String username, String mdp) {
		super();
		this.idAgent = idAgent;
		this.username = username;
		this.mdp = mdp;
	}

	public Long getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(Long idAgent) {
		this.idAgent = idAgent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Agent [" + (idAgent != null ? "idAgent=" + idAgent + ", " : "")
				+ (username != null ? "username=" + username + ", " : "") + (mdp != null ? "mdp=" + mdp : "") + "]";
	}

}
