package boundary;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import entity.Person;

@Path("people")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class PersonResource {

    private static final Logger LOGGER = Logger.getLogger(PersonResource.class.getName());

    @Inject
    PersonManager manager;

    @GET
    @Path("{personId}")
    public Response findById(@PathParam("personId") UUID personId) {
        Person person = this.manager.findById(personId);
        if (person != null) {
            return Response.ok(person).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("bylast/{name}")
    public Response findById(@PathParam("name") String name) {
        List<Person> people = this.manager.findByLastName(name);
        if (people != null) {
            return Response.ok(people).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    public Response getAll() {
        List<Person> people = this.manager.getAll();
        if (people != null && !people.isEmpty()) {
            return Response.ok(people).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
}
