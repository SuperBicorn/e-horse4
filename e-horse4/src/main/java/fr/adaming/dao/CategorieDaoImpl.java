package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

/**
 * Couche DAO de la classe cat�gorie
 * @author INTI-390
 *
 */
@Repository
public class CategorieDaoImpl implements IGenerique<Categorie> {

	@Autowired
	private SessionFactory sf;
	
	/**
	 * M�thode pour ajouter une cat�gorie dans la BDD
	 * @param cat�gorie � ajouter
	 */
	@Override
	public void ajout(Categorie t) {
		Session s=sf.getCurrentSession();
		s.save(t);
	}
	
	/**
	 * M�thode pour supprimer une cat�gorie de la BDD
	 * @param id de la cat�gorie � supprimer
	 */
	@Override
	public void supprId(int id) {
		Session s=sf.getCurrentSession();
		Categorie categorie=(Categorie) s.get(Categorie.class,id);
		s.delete(categorie);
	}

	/**
	 * m�thode pour trouver toutes les cat�gories
	 */
	public List<Categorie> getAll() {
		Session s=sf.getCurrentSession();
		String req="FROM Categorie";
		Query query=s.createQuery(req);
		List<Categorie> lCategories =query.list();
		return lCategories;
	}

	/**
	 * m�thode pour trouver une cat�gorie avec un id
	 * @param id de la cat�gorie � trouver
	 */
	@Override
	public Categorie getById(int id) {
		Session s=sf.getCurrentSession();
		return (Categorie) s.get(Categorie.class,id);
	}

	@Override
	public List<Categorie> getByNom(String nom) {
		return null;
	}

	/**
	 * m�thode pour modifier une cat�gorie dans la BDD
	 * @param cat�gorie � modifier
	 */
	@Override
	public void modif(Categorie t) {
		Session s=sf.getCurrentSession();
		s.update(t);
	}

	
}
