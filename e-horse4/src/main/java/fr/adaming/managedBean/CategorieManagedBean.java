package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name="catMB")
@RequestScoped
public class CategorieManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Categorie categorie;
	private List<Categorie> lCategories;
	
	@ManagedProperty(value="#{categorieServiceBean}")
	private ICategorieService caService;

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Categorie> getlCategories() {
		return lCategories;
	}

	public void setlCategories(List<Categorie> lCategories) {
		this.lCategories = lCategories;
	}

	

	public void setCaService(ICategorieService caService) {
		this.caService = caService;
	}

	public CategorieManagedBean() {
		super();
		this.categorie=new Categorie(); 
	}
	
	@PostConstruct
	public void init() {
		this.lCategories=caService.getAll();		
	}
	
	
	public String ajouterCategorie() {
		caService.ajout(this.categorie);
		this.lCategories=caService.getAll();
		return "listeCategorie";
	}
	
	public String modifCategorie() {
			caService.modif(this.categorie);
		this.lCategories=caService.getAll();
		return "listeCategorie";
	}
	
	public String supprCategorie(int id){
		caService.supprId(id);
		this.lCategories=caService.getAll();
		return "listeCategorie";
	}
	
	
}
