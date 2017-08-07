package fr.adaming.managedBean;

/**
 * Definition de l'agent pour l'authentification utilis� pour l'admin
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Agent;
import fr.adaming.service.IAgentService;

@ManagedBean(name="aMB")
@RequestScoped
public class AgentManagedBean {

	private Agent agent;
	
	@ManagedProperty(value = "#{agentServiceBean}")
	private IAgentService aSer;
	
	public AgentManagedBean() {
		this.agent = new Agent();
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	
	public void setaSer(IAgentService aSer) {
		this.aSer = aSer;
	}
/**
 * M�thode de v�rification de l'exstence de l'admin dans la base de donn�e
 * @return accueilAdmin si ok index sinon
 */
	public String verif(){
		int verif = aSer.verif(this.agent.getUsername(), this.agent.getMdp());
		if (verif == 1){
						return "accueilAdmin";
		} else {
			System.out.println("nop");
			return "index";
		}
	}
	/**
	 * M�thode pour la d�connexion de l'admin
	 * @return page index
	 */
	public String deco(){
		return "index";
	}
	
	
}
