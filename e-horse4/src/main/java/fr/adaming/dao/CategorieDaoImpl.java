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
 * Couche DAO de la classe catégorie
 * @author INTI-390
 *
 */
@Repository
public class CategorieDaoImpl implements IGenerique<Categorie> {

	@Autowired
	private SessionFactory sf;
	
	/**
	 * Méthode pour ajouter une catégorie dans la BDD
	 * @param catégorie à ajouter
	 */
	@Override
	public void ajout(Categorie t) {
		Session s=sf.getCurrentSession();
		s.save(t);
	}
	
	/**
	 * Méthode pour supprimer une catégorie de la BDD
	 * @param id de la catégorie à supprimer
	 */
	@Override
	public void supprId(int id) {
		Session s=sf.getCurrentSession();
		Categorie categorie=(Categorie) s.get(Categorie.class,id);
		s.delete(categorie);
	}

	/**
	 * méthode pour trouver toutes les catégories
	 */
	public List<Categorie> getAll() {
		Session s=sf.getCurrentSession();
		String req="FROM Categorie";
		Query query=s.createQuery(req);
		List<Categorie> lCategories =query.list();
		return lCategories;
	}

	/**
	 * méthode pour trouver une catégorie avec un id
	 * @param id de la catégorie à trouver
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
	 * méthode pour modifier une catégorie dans la BDD
	 * @param catégorie à modifier
	 */
	@Override
	public void modif(Categorie t) {
		Session s=sf.getCurrentSession();
		s.update(t);
	}

	
}
