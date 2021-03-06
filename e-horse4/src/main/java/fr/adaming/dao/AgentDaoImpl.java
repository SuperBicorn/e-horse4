package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.fabric.xmlrpc.Client;

import fr.adaming.model.Agent;

/**
 * Couche DAO de la classe agent
 * @author INTI-390
 *
 */
@Repository
public class AgentDaoImpl implements IAgentDao {

	@Autowired
	private SessionFactory sf;

	/**
	 * m�thode pour v�rifier les identifiants de l'agent
	 * @param username de l'agent
	 * @param password de l'agent
	 */
	@Override
	public int verif(String username, String password) {
		Session s=sf.getCurrentSession();
		String req="FROM Agent WHERE username=:puser AND mdp=:pmdp";
		Query query=s.createQuery(req);
		query.setParameter("puser", username);
		query.setParameter("pmdp", password);
		List<Agent> lAgents = query.list();
		return lAgents.size();
	}

}
