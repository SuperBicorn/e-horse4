package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgentDao;

@Service("agentServiceBean")
@Transactional
public class AgentServiceImpl implements IAgentDao, IAgentService {

	@Autowired
	private IAgentDao aDao;
	
	@Override
	public int verif(String username, String password) {
		return aDao.verif(username, password);
	}

}
