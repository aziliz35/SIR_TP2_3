package fr.istic.sir.rest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import domain.Residence;

@Path("/residence")
public class ResidenceResources {

	private List<Residence> residences = new ArrayList<Residence>();

	public ResidenceResources() {
		for (int i = 0; i < 10; i++) {
			residences.add(new Residence(i,"nomh "));
		}
	}


	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Collection<Residence> list() {
		return residences;
	}
	
	@GET @Path("search/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Residence findById(@PathParam("id") String arg0) {
		return residences.get(Integer.parseInt(arg0));
	}
	
	@DELETE @Path("delete/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Residence deleteById(@PathParam("id") String arg0) {
		return residences.remove(Integer.parseInt(arg0));
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}
}

