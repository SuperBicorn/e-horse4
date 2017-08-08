package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgentDao;

/**
 * Couche Service de la classe agent
 * @author INTI-390
 *
 */
@Service("agentServiceBean")
@Transactional
public class AgentServiceImpl implements IAgentDao, IAgentService {

	@Autowired
	private IAgentDao aDao;
	
	/**
	 * méthode pour vérifier les identifiants de l'agent
	 * @param username de l'agent
	 * @param password de l'agent
	 */
	@Override
	public int verif(String username, String password) {
		return aDao.verif(username, password);
	}

}
