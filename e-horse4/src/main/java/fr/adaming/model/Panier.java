package fr.adaming.model;

public class Panier {

	private Produit produit;
	private int quantite;
	private Double prix;
	
	public Panier() {
		}

	public Panier(Produit produit, int quantite, Double prix) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.prix = prix;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Panier [" + (produit != null ? "produit=" + produit + ", " : "") + "quantite=" + quantite + ", "
				+ (prix != null ? "prix=" + prix : "") + "]";
	}

	 
	
}
