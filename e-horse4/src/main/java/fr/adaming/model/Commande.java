package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commandes")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommande;

	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	@OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
	private List<LigneCommande> lLignesCommande;

	@ManyToOne
	@JoinColumn(name="idClient",referencedColumnName="idClient")
	private Client client;
	
	public Commande() {
	}

	
	public Commande(Date dateCommande, Client client) {
		super();
		this.dateCommande = dateCommande;
		
		this.client = client;
	}


	public Commande(Long idCommande, Date dateCommande, Client client) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.client = client;
	}


	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Commande [" + (idCommande != null ? "idCommande=" + idCommande + ", " : "")
				+ (dateCommande != null ? "dateCommande=" + dateCommande + ", " : "")
				+ (client != null ? "client=" + client : "") + "]";
	}


}
