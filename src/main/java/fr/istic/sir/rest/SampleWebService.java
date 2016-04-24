package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Chauffage;
import domain.EquipementE;
import domain.Personne;
import domain.Residence;
import servlet.data;

@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
    
    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Residence getHome() {
    	Residence h = new Residence();
        h.setNomh("toto");
        Chauffage h1 = new Chauffage();
        h1.setConso(500);
        EquipementE h2 = new EquipementE();
        h2.setConso(600);
        h.addDevice(h1);
        h.addDevice(h2);
        return h;
    }

    @GET
    @Path("/listePersonne")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getListPerson() {
    
    	List<Personne> personnes = data.ListePersonne();
	    return personnes;
    }
}
