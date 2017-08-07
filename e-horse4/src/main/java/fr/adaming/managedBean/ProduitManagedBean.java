package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

/**
 * Definition du bean produit prMB
 * @author INTI-399
 *
 */
@ManagedBean(name="prMB")
@RequestScoped
public class ProduitManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Produit produit;
	private List<Produit> lProduits;
	private List<Produit> lProduitsRecherche;
	private int idCategorie;
	
	@ManagedProperty(value="#{produitServiceBean}")
	private IProduitService prService;
	@ManagedProperty(value="#{categorieServiceBean}")
	private ICategorieService caService;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Produit> getlProduits() {
		return lProduits;
	}

	public void setlProduits(List<Produit> lProduits) {
		this.lProduits = lProduits;
	}

	public void setPrService(IProduitService prService) {
		this.prService = prService;
	}
	
	public void setCaService(ICategorieService caService) {
		this.caService = caService;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public List<Produit> getlProduitsRecherche() {
		return lProduitsRecherche;
	}

	public void setlProduitsRecherche(List<Produit> lProduitsRecherche) {
		this.lProduitsRecherche = lProduitsRecherche;
	}

	public ProduitManagedBean() {
		super();
		this.produit=new Produit(); 
	}
	/**
	 * Post construct pour afficher la liste de sprod quand on le souhaite
	 * @return liste des produits
	 */
	@PostConstruct
	public void init() {
		this.lProduits=prService.getAll();		
	}
	
	/**
	 * Ajout d'un produit
	 * @return la page accueilAdmin + liste de prod actualisé
	 */
	public String ajouterProduit() {
		Categorie categorie = caService.getById(this.idCategorie);
		this.produit.setCategorie(categorie);
		prService.ajout(this.produit);
		this.lProduits=prService.getAll();
		return "accueilAdmin";
	}
	/**
	 * modification d'un produti
	 * @returnla page accueilAdmin + liste de prod actualisé
	 */
	public String modifProduit() {
		prService.modif(this.produit);
		this.lProduits=prService.getAll();
		return "accueilAdmin";
	}
	/**
	 * Suppression d'un produit
	 * @param id
	 * @returnla page accueilAdmin + liste de prod actualisé
	 */
	public String supprProduit(int id){
		prService.supprId(id);
		this.lProduits=prService.getAll();
		return "accueilAdmin";
	}
	/**
	 * obtenir un produit à partir de son nom
	 * @return le ou les produits recherché sur la page correspondante
	 */
	public String getProduitByNom(){
		this.lProduitsRecherche = prService.getByNom(this.produit.getDesignation());
		System.out.println("message depuis service"+lProduitsRecherche);
		return "listeProduitRecherche";
	}
	/**
	 * Obtenir un produit à partir de son id
	 * @return la page accueilAdmin + liste de prod actualisé
	 */
	public String getProduitById(){
		this.produit=prService.getById(this.produit.getIdProduit());
		return "listeProduitRecherche";
	}
	
	
}
