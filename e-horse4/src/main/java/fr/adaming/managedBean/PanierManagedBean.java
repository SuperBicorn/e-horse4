package fr.adaming.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "paMB")
@ApplicationScoped
public class PanierManagedBean {

	private Panier panier;
	private List<Panier> lPaniers;
	private int qtte;

	@ManagedProperty(value="#{produitServiceBean}")
	private IProduitService prService;

	
	public PanierManagedBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		this.lPaniers = new ArrayList<>();
		this.panier = new Panier();
	}

	
	public void setPrService(IProduitService prService) {
		this.prService = prService;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public List<Panier> getlPaniers() {
		return lPaniers;
	}

	public void setlPaniers(List<Panier> lPaniers) {
		this.lPaniers = lPaniers;
	}

	public int getQtte() {
		return qtte;
	}

	public void setQtte(int qtte) {
		this.qtte = qtte;
	}

	// m�thodes
	public String ajouterProduitPanier(int id_p) {
		Produit prod = prService.getById(id_p);
		this.panier = new Panier(prod,this.qtte,prod.getPrix()*qtte);
		int x = 0;
		for (Panier pan : this.lPaniers) {
			if (pan.getProduit().getIdProduit() == this.panier.getProduit().getIdProduit()) {
				x = 1;
			}
		}
		if (x == 1) {
			for (Panier pan : this.lPaniers) {
				System.out.println(pan);
			}
			return "index";
		} else {
			this.lPaniers.add(this.panier);
			for (Panier pan : this.lPaniers) {
				System.out.println(pan);
			}
			return "index";
		}
	}
	
	public String modifierQuantitePanier(int id_p){
		Produit prod = prService.getById(id_p);
		for (Panier pan : this.lPaniers) {
			System.out.println(pan);
			if (pan.getProduit().getIdProduit() == this.panier.getProduit().getIdProduit()) {
				System.out.println("ok");
				pan.setQuantite(this.qtte);
			}
		}
		return "panier";
	}

	public String supprimerPanier(int id_p){
		Produit prod = prService.getById(id_p);
		for (Panier pan : this.lPaniers) {
			System.out.println(pan);
			if (pan.getProduit().getIdProduit() == this.panier.getProduit().getIdProduit()) {
				System.out.println("ok");
				this.lPaniers.remove(pan);
			}
		}
		return "panier";
	}

	
}
