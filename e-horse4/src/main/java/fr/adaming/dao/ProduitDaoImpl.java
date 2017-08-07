package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Produit;

/**
 * Couche DAO de la classe produit
 * @author INTI-390
 *
 */
@Repository
public class ProduitDaoImpl implements IGenerique<Produit>{
	@Autowired
	private SessionFactory sf;
	
	/**
	 * Méthode pour ajouter un produit dans la BDD
	 * @param Produit à ajouter
	 */
	@Override
	public void ajout(Produit produit) {
		Session s=sf.getCurrentSession();
		s.save(produit);
		
	}

	/**
	 * Méthode pour supprimer un produit de la BDD
	 * @param id du produit à supprimer
	 */
	@Override
	public void supprId(int id) {
		Session s=sf.getCurrentSession();
		Produit produit=(Produit) s.get(Produit.class,id);
		s.delete(produit);
		
	}

	/**
	 * méthode pour trouver un produit avec un id
	 * @param id du produit à trouver
	 */
	@Override
	public Produit getById(int id) {
		Session s=sf.getCurrentSession();
		return (Produit) s.get(Produit.class,id);
	}

	/**
	 * méthode pour trouver un produit par son nom
	 * @param nom du produit à trouver
	 */
	@Override
	public List<Produit> getByNom(String nom) {
		Session s=sf.getCurrentSession();
		String req="FROM Produit p WHERE p.designation LIKE :pNom";
		Query query=s.createQuery(req);
		query.setParameter("pNom", nom);
		List<Produit> liste = query.list();
		System.out.println("message depuis DAO"+liste);
		return liste;
	}
	
	
	/**
	 * méthode pour récupérer tous les produits
	 */
	public List<Produit> getAll(){
		Session s=sf.getCurrentSession();
		String req="FROM Produit";
		Query query=s.createQuery(req);
		List<Produit> lProduits =query.list();
		return lProduits;
	}
	
	/**
	 * méthode pour modifier un produit dans la BDD
	 * @param produit à modifier
	 */
	@Override
	public void modif(Produit produit){
		Session s=sf.getCurrentSession();
		s.update(produit);
	}
	

}
