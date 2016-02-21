package domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


@Entity

public class Personne {
	private int idp;
	private String nom;
	private String prenom;
	private String email;
	private List <Residence> R;
	
	public Personne() {
		// TODO Auto-generated constructor stub
	}
	
	public Personne( String nom) {
		super();
		//this.idp++;
		this.nom = nom;

	}
	
	@Id
    @GeneratedValue
	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToMany
	public List<Residence> getR() {
		return R;
	}
	public void setR(List<Residence> r) {
		R = r;
	}

}
