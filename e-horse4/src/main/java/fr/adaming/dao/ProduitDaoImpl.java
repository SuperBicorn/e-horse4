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
	 * M�thode pour ajouter un produit dans la BDD
	 * @param Produit � ajouter
	 */
	@Override
	public void ajout(Produit produit) {
		Session s=sf.getCurrentSession();
		s.save(produit);
		
	}

	/**
	 * M�thode pour supprimer un produit de la BDD
	 * @param id du produit � supprimer
	 */
	@Override
	public void supprId(int id) {
		Session s=sf.getCurrentSession();
		Produit produit=(Produit) s.get(Produit.class,id);
		s.delete(produit);
		
	}

	/**
	 * m�thode pour trouver un produit avec un id
	 * @param id du produit � trouver
	 */
	@Override
	public Produit getById(int id) {
		Session s=sf.getCurrentSession();
		return (Produit) s.get(Produit.class,id);
	}

	/**
	 * m�thode pour trouver un produit par son nom
	 * @param nom du produit � trouver
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
	 * m�thode pour r�cup�rer tous les produits
	 */
	public List<Produit> getAll(){
		Session s=sf.getCurrentSession();
		String req="FROM Produit";
		Query query=s.createQuery(req);
		List<Produit> lProduits =query.list();
		return lProduits;
	}
	
	/**
	 * m�thode pour modifier un produit dans la BDD
	 * @param produit � modifier
	 */
	@Override
	public void modif(Produit produit){
		Session s=sf.getCurrentSession();
		s.update(produit);
	}
	

}
