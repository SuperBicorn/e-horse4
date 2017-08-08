package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.fabric.xmlrpc.Client;

import fr.adaming.model.Produit;

/**
 * Couche DAO de la classe produit
 * @author INTI-390
 *
 */
@Repository
public class ClientDaoImpl implements IGenerique<Client> {
	@Autowired
	private SessionFactory sf;
	
	@Override
	public void ajout(Client t) {
		Session s=sf.getCurrentSession();
		s.save(t);
	}

	@Override
	public void supprId(int id) {
		Session s=sf.getCurrentSession();
		Client client=(Client) s.get(Client.class,id);
		s.delete(client);
	}

	@Override
	public List<Client> getAll() {
		Session s=sf.getCurrentSession();
		String req="FROM Client";
		Query query=s.createQuery(req);
		List<Client> lClients =query.list();
		return lClients;
	}

	@Override
	public Client getById(int id) {
		Session s=sf.getCurrentSession();
		return (Client) s.get(Client.class,id);
	}

	@Override
	public List<Client> getByNom(String nom) {
		Session s=sf.getCurrentSession();
		String req="FROM Client c WHERE c.nomClient LIKE :pNom";
		Query query=s.createQuery(req);
		query.setParameter("pNom", nom);
		List<Client> liste = query.list();
		return liste;
	}

	@Override
	public void modif(Client t) {
		Session s=sf.getCurrentSession();
		s.update(t);
	}


}
