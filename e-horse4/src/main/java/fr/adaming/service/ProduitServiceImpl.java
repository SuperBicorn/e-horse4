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
	 * M�thode pour ajouter un produit dans la BDD
	 * @param Produit � ajouter
	 */
	@Override
	public void ajout(Produit produit) {
		pDao.ajout(produit);
	}

	/**
	 * M�thode pour supprimer un produit de la BDD
	 * @param id du produit � supprimer
	 */
	@Override
	public void supprId(int id) {
		pDao.supprId(id);
	}

	/**
	 * m�thode pour r�cup�rer tous les produits
	 */
	@Override
	public List<Produit> getAll() {
		return pDao.getAll();
		}

	/**
	 * m�thode pour trouver un produit avec un id
	 * @param id du produit � trouver
	 */
	@Override
	public Produit getById(int id) {
		return pDao.getById(id);
	}

	/**
	 * m�thode pour trouver un produit par son nom
	 * @param nom du produit � trouver
	 */
	@Override
	public List<Produit> getByNom(String nom) {
		System.out.println("message depuis Service");
		return pDao.getByNom(nom);
	}
	
	/**
	 * m�thode pour modifier un produit dans la BDD
	 * @param produit � modifier
	 */
	@Override
	public void modif(Produit produit) {
		pDao.modif(produit);		
	}
}
