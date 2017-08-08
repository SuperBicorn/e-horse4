package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGenerique;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Service("clientServiceBean")
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IGenerique<Client> cDao;

	@Override
	public void ajout(Client client) {
		cDao.ajout(client);
	}

	@Override
	public void supprId(int id) {
		cDao.supprId(id);
	}

	@Override
	public List<Client> getAll() {
		return cDao.getAll();
	}

	@Override
	public Client getById(int id) {
		return cDao.getById(id);
	}

	@Override
	public List<Client> getByNom(String nom) {
		return cDao.getByNom(nom);
	}

	@Override
	public void modif(Client client) {
		cDao.modif(client);
	}

}
