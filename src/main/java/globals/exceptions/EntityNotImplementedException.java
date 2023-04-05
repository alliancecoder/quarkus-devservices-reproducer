package globals.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EntityNotImplementedException extends WebApplicationException {

	private static final long serialVersionUID = -1532640186971317347L;

	public EntityNotImplementedException(String message) {
		super(Response.status(Response.Status.NOT_IMPLEMENTED).entity(message).type(MediaType.TEXT_PLAIN).build());
	}
}
