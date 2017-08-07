package fr.adaming.dao;

import java.util.List;

public interface IGenerique<T> {
	
	public void ajout(T t);
	public void supprId(int id);
	public List<T> getAll();
	public T getById(int id);
	public List<T> getByNom(String nom);
	public void modif(T t);

}
