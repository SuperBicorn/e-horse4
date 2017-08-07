package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Produit;

@Repository
public class ProduitDaoImpl implements IGenerique<Produit>{
	@Autowired
	private SessionFactory sf;
	
	@Override
	public void ajout(Produit produit) {
		Session s=sf.getCurrentSession();
		s.save(produit);
		
	}

	@Override
	public void supprId(int id) {
		Session s=sf.getCurrentSession();
		Produit produit=(Produit) s.get(Produit.class,id);
		s.delete(produit);
		
	}

	@Override
	public Produit getById(int id) {
		Session s=sf.getCurrentSession();
		return (Produit) s.get(Produit.class,id);
	}

	// TO DO : try with Criteria
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
	
	public List<Produit> getAll(){
		Session s=sf.getCurrentSession();
		String req="FROM Produit";
		Query query=s.createQuery(req);
		List<Produit> lProduits =query.list();
		return lProduits;
	}
	
	@Override
	public void modif(Produit produit){
		Session s=sf.getCurrentSession();
		s.update(produit);
	}
	

}
