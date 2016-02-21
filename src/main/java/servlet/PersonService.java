package servlet;

import domain.Personne;

public class PersonService {

	public void savePerson(String name){
		Personne p = new Personne(name);
	}
}
