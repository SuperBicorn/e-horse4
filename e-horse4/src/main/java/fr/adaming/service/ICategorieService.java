package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieService {

	public void ajout(Categorie categorie);

	public void supprId(int id);

	public List<Categorie> getAll();

	public Categorie getById(int id);
	
	public void modif(Categorie categorie);
	
}
