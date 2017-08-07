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
	 * M�thode pour ajouter une cat�gorie dans la BDD
	 * @param cat�gorie � ajouter
	 */
	@Override
	public void ajout(Categorie categorie) {
	cDao.ajout(categorie);
	}

	/**
	 * M�thode pour supprimer une cat�gorie de la BDD
	 * @param id de la cat�gorie � supprimer
	 */
	@Override
	public void supprId(int id) {
		cDao.supprId(id);
	}

	/**
	 * m�thode pour trouver toutes les cat�gories
	 */
	@Override
	public List<Categorie> getAll() {
		return cDao.getAll();
	}

	/**
	 * m�thode pour trouver une cat�gorie avec un id
	 * @param id de la cat�gorie � trouver
	 */
		@Override
	public Categorie getById(int id) {
		return cDao.getById(id);
	}

		/**
		 * m�thode pour modifier une cat�gorie dans la BDD
		 * @param cat�gorie � modifier
		 */
	@Override
	public void modif(Categorie categorie) {
	cDao.modif(categorie);
	}

}
