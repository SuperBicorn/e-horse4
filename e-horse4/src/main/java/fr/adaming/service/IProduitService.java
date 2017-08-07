
package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitService {


	public void ajout(Produit produit);

	public void supprId(int id);

	public List<Produit> getAll();

	public Produit getById(int id);

	public List<Produit> getByNom(String nom);
	
	public void modif(Produit produit);
}
