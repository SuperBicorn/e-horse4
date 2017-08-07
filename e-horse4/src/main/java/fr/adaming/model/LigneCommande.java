package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lignesCommande")
public class LigneCommande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLigneCommande;

	private int quantite;
	private Double prix;

	@ManyToOne
	@JoinColumn(name = "idProduit", referencedColumnName = "idProduit")
	private Produit produit;

	@ManyToOne
	@JoinColumn(name="idCommande",referencedColumnName="idCommande")
	private Commande commande;
		
	public LigneCommande() {
	}

	

	public LigneCommande(int quantite, Double prix, Produit produit, Commande commande) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.produit = produit;
		this.commande = commande;
	}



	public LigneCommande(Long idLigneCommande, int quantite, Double prix, Produit produit, Commande commande) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.quantite = quantite;
		this.prix = prix;
		this.produit = produit;
		this.commande = commande;
	}



	public Long getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(Long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
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

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	
	public Commande getCommande() {
		return commande;
	}



	public void setCommande(Commande commande) {
		this.commande = commande;
	}



	@Override
	public String toString() {
		return "LigneCommande [" + (idLigneCommande != null ? "idLigneCommande=" + idLigneCommande + ", " : "")
				+ "quantite=" + quantite + ", " + (prix != null ? "prix=" + prix + ", " : "")
				+ (produit != null ? "produit=" + produit + ", " : "")
				+ (commande != null ? "commande=" + commande : "") + "]";
	}



	
}
