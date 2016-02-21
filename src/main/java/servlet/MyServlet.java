package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Personne;

@WebServlet(name="mytest",
urlPatterns={"/src/main/webapp/index.html"})
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            
        PrintWriter p = new PrintWriter(resp.getOutputStream());
        p.print("Hello world SIR");
        p.flush();
        
    }

    
    //PersonService personneservice =  new PersonService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
    	EntityManager manager = factory.createEntityManager();
    	EntityTransaction tx = manager.getTransaction();
   	tx.begin();
		try {
			
			
			Personne p = new Personne( req.getParameter("name"));
			manager.persist(p);
	
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
        super.doPost(req, resp);
       
    }    
}