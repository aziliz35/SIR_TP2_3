package servlet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import domain.Personne;

public class data {

	EntityTransaction tx;

	/*Pattern singleton pour créer dans un threadLocal pour utiliser un entityManager 
	 * par thread (avec gestion automatique démarrage/arret) A TOUJOURS FAIRE*/
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
	private static final ThreadLocal<EntityManager> thread = new ThreadLocal<EntityManager>();

	

	public static EntityManager getEntityManager() {
		EntityManager em = thread.get();

		if (em == null) {
			em = emf.createEntityManager();
			thread.set(em);
		}
		return em;
	}

	public static List<Personne> ListePersonne(){
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder(); 
		CriteriaQuery<Personne> query = criteriaBuilder.createQuery(Personne.class); 
		Root<Personne> person = query.from(Personne.class); 
		query.select(person); 
		TypedQuery<Personne> req = getEntityManager().createQuery(query); 

		return (List<Personne>)req.getResultList(); 
	}

}
