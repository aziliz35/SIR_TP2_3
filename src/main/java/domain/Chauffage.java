package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Chauffage  extends PeriphIntelligent{

	public Chauffage() {
		super();
	}



	
	//	public float getConso() {
	//		return conso;
	//	}
	//	public void setConso(float conso) {
	//		this.conso = conso;
	//	}
	//	public String getType() {
	//		return type;
	//	}
	//	public void setType(String type) {
	//		this.type = type;
	//	}
	//
	//	@ManyToOne
	//	public Residence getRe() {
	//		return re;
	//	}
	//	public void setRe(Residence re) {
	//		this.re = re;
	//	}



}
