package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenerique;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Service("categorieServiceBean")
@Transactional
public class CategorieServiceImpl implements ICategorieService {

	@Autowired
	private IGenerique<Categorie> cDao;
	


	@Override
	public void ajout(Categorie categorie) {
	cDao.ajout(categorie);
	}

	@Override
	public void supprId(int id) {
		cDao.supprId(id);
	}

	@Override
	public List<Categorie> getAll() {
		return cDao.getAll();
	}

	@Override
	public Categorie getById(int id) {
		return cDao.getById(id);
	}

	@Override
	public void modif(Categorie categorie) {
	cDao.modif(categorie);
	}

}
