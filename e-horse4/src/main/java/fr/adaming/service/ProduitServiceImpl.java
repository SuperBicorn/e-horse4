package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenerique;
import fr.adaming.model.Produit;

/**
 * Couche Service de la classe produit
 * @author INTI-390
 *
 */
@Service("produitServiceBean")
@Transactional 
public class ProduitServiceImpl implements IProduitService{

	@Autowired
	private IGenerique<Produit> pDao;

	/**
	 * Méthode pour ajouter un produit dans la BDD
	 * @param Produit à ajouter
	 */
	@Override
	public void ajout(Produit produit) {
		pDao.ajout(produit);
	}

	/**
	 * Méthode pour supprimer un produit de la BDD
	 * @param id du produit à supprimer
	 */
	@Override
	public void supprId(int id) {
		pDao.supprId(id);
	}

	/**
	 * méthode pour récupérer tous les produits
	 */
	@Override
	public List<Produit> getAll() {
		return pDao.getAll();
		}

	/**
	 * méthode pour trouver un produit avec un id
	 * @param id du produit à trouver
	 */
	@Override
	public Produit getById(int id) {
		return pDao.getById(id);
	}

	/**
	 * méthode pour trouver un produit par son nom
	 * @param nom du produit à trouver
	 */
	@Override
	public List<Produit> getByNom(String nom) {
		System.out.println("message depuis Service");
		return pDao.getByNom(nom);
	}
	
	/**
	 * méthode pour modifier un produit dans la BDD
	 * @param produit à modifier
	 */
	@Override
	public void modif(Produit produit) {
		pDao.modif(produit);		
	}
}
