package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Residence {

	private String nomh;
	private int idr;
	private int taille;
	private int nbrpiece;
	private List <Chauffage> ch;
	private float Devis1;
	private float Devis2;
	private List <EquipementE> eq;
	private	List <Personne> p;
	
	
	
	public Residence() {
		
	}
	public Residence(int i,String n){
		this.idr=i;
		this.nomh=n;
	}
	
	public Residence(int idr, int taille, int nbrpiece, ArrayList<Chauffage> ch, ArrayList<EquipementE> eq) {
		super();
		this.idr = idr;
		this.taille = taille;
		this.nbrpiece = nbrpiece;
		this.ch = ch;
		this.eq = eq;
	}
	
	@Id
    @GeneratedValue
	public int getIdr() {
		return idr;
	}
	public void setIdr(int idr) {
		this.idr = idr;
	}
	
	public String getNomh() {
		return nomh;
	}
	public void setNomh(String nomh) {
		this.nomh = nomh;
	}
	
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getNbrpiece() {
		return nbrpiece;
	}
	public void setNbrpiece(int nbrpiece) {
		this.nbrpiece = nbrpiece;
	}
	
	@ManyToMany(mappedBy="r")
	public List<Personne> getP() {
		return p;
	}
	public void setP(List<Personne> p) {
		this.p = p;
	}
	@OneToMany(mappedBy="id")
	public List<Chauffage> getCh() {
		return ch;
	}
	public void setCh(List<Chauffage> ch) {
		this.ch = ch;
	}
	@OneToMany(mappedBy="id")
	public List<EquipementE> getEq() {
		return eq;
	}
	public void setEq(List<EquipementE> eq) {
		this.eq = eq;
	}

	
	public void addDevice(Chauffage c){
		this.Devis1=12* c.getConso();
		
	}
	
	public void addDevice(EquipementE e){
		this.Devis2=4* e.getConso();
		
	}
	@Override
	public String toString() {
		return "Residence [nomh=" + nomh + ", idr2=" + idr + ", taille=" + taille + ", nbrpiece=" + nbrpiece + ", ch="
				+ ch + ", Devis1=" + Devis1 + ", Devis2=" + Devis2 + ", eq=" + eq + ", p=" + p + "]";
	}



}
