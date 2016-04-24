package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Personne;



@WebServlet(name="personneinfo",
urlPatterns={"/PersonneInfo"})
public class PersonneInfo extends HttpServlet {

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();


		out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"<UL>\n" +            
				" <LI>Nom: "
				+ request.getParameter("name") +  "\n" +
				"</UL>\n" +                
				"</BODY></HTML>");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			Personne p = new Personne( request.getParameter("name"));
			manager.persist(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String query = "select h from Personne as h";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		Query q = (Query) manager.createQuery(query,Personne.class);
		List<Personne> person =   q.getResultList();
		
		out.println("<HTML>\n<BODY>\n" +
				"<H1>Liste des personnes inscrites</H1>\n");
	    for (Personne p: person){
	    	  out.println("<h2>"+p.getNom()+"</h2>\n");
	    	  }
				out.println("</UL>\n" +				
				"</BODY></HTML>");
	}
}
