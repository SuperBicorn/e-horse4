package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenerique;
import fr.adaming.model.Produit;

@Service("produitServiceBean")
@Transactional 
public class ProduitServiceImpl implements IProduitService{

	@Autowired
	private IGenerique<Produit> pDao;

	@Override
	public void ajout(Produit produit) {
		pDao.ajout(produit);
	}

	@Override
	public void supprId(int id) {
		pDao.supprId(id);
	}

	@Override
	public List<Produit> getAll() {
		return pDao.getAll();
		}

	@Override
	public Produit getById(int id) {
		return pDao.getById(id);
	}

	@Override
	public List<Produit> getByNom(String nom) {
		System.out.println("message depuis Service");
		return pDao.getByNom(nom);
	}

	@Override
	public void modif(Produit produit) {
		pDao.modif(produit);		
	}
}
