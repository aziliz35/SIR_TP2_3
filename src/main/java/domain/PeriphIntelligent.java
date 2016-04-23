package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PeriphIntelligent {
	
	private int id;
	private float conso;
	private String type;
	private Residence re;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public PeriphIntelligent() {
		super();
	}


	public PeriphIntelligent(float conso, String type, Residence re) {
		super();
		this.conso = conso;
		this.type = type;
		this.re = re;
	}


	public float getConso() {
		return conso;
	}


	public void setConso(float conso) {
		this.conso = conso;
	}


	public String getType() {
		return type;
	}


	@Override
	public String toString() {
		return "PeriphIntelligent [getId()=" + getId() + ", getConso()=" + getConso() + ", getType()=" + getType()
				+ ", getRe()=" + getRe() + "]";
	}


	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne
	public Residence getRe() {
		return re;
	}


	public void setRe(Residence re) {
		this.re = re;
	}
}
