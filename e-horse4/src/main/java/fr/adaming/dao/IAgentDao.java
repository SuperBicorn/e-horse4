package fr.adaming.dao;

import fr.adaming.model.Agent;

public interface IAgentDao {

	/**
	 * méthode pour vérifier les identifiants de l'agent
	 * @param username de l'agent
	 * @param password de l'agent
	 * @return le nombre d'agent correspondant à ce username et password
	 */
	public int verif(String username, String password);
	
}
