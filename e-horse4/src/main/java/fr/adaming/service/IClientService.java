package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {

	public void ajout(Client client);

	public void supprId(int id);

	public List<Client> getAll();

	public Client getById(int id);

	public List<Client> getByNom(String nom);

	public void modif(Client client);
	
}
