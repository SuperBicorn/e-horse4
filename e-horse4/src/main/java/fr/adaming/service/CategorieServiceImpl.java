package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenerique;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

/**
 * Couche Service de la classe categorie
 * @author INTI-390
 *
 */
@Service("categorieServiceBean")
@Transactional
public class CategorieServiceImpl implements ICategorieService {

	@Autowired
	private IGenerique<Categorie> cDao;
	

	/**
	 * Méthode pour ajouter une catégorie dans la BDD
	 * @param catégorie à ajouter
	 */
	@Override
	public void ajout(Categorie categorie) {
	cDao.ajout(categorie);
	}

	/**
	 * Méthode pour supprimer une catégorie de la BDD
	 * @param id de la catégorie à supprimer
	 */
	@Override
	public void supprId(int id) {
		cDao.supprId(id);
	}

	/**
	 * méthode pour trouver toutes les catégories
	 */
	@Override
	public List<Categorie> getAll() {
		return cDao.getAll();
	}

	/**
	 * méthode pour trouver une catégorie avec un id
	 * @param id de la catégorie à trouver
	 */
		@Override
	public Categorie getById(int id) {
		return cDao.getById(id);
	}

		/**
		 * méthode pour modifier une catégorie dans la BDD
		 * @param catégorie à modifier
		 */
	@Override
	public void modif(Categorie categorie) {
	cDao.modif(categorie);
	}

}
