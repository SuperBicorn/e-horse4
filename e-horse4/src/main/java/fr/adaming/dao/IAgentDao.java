package fr.adaming.dao;

import fr.adaming.model.Agent;

public interface IAgentDao {

	/**
	 * m�thode pour v�rifier les identifiants de l'agent
	 * @param username de l'agent
	 * @param password de l'agent
	 * @return le nombre d'agent correspondant � ce username et password
	 */
	public int verif(String username, String password);
	
}
