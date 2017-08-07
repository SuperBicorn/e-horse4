package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produits")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduit;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	
//	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
//    private boolean selectionne;
	private boolean selectionne;
	
	@ManyToOne
	@JoinColumn(name="idCategorie",referencedColumnName="idCategorie")
private Categorie categorie;
	
	@OneToMany(mappedBy="produit",cascade=CascadeType.ALL)
	private List<LigneCommande> lLignesCommande;
	
	public Produit() {
		super();
	}

	
	public Produit(String designation, String description, double prix, int quantite, boolean selectionne,
			Categorie categorie) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.categorie = categorie;
	}

	

	public Produit(int idProduit, String designation, String description, double prix, int quantite,
			boolean selectionne, Categorie categorie) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.categorie = categorie;
	}


	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}
	
	

	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", "
				+ (designation != null ? "designation=" + designation + ", " : "")
				+ (description != null ? "description=" + description + ", " : "") + "prix=" + prix + ", quantite="
				+ quantite + ", selectionne=" + selectionne + ", " + (categorie != null ? "categorie=" + categorie : "")
				+ "]";
	}



}