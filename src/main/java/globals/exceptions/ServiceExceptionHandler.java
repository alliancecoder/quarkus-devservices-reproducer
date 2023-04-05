package globals.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;


public class ServiceExceptionHandler implements ExceptionMapper<ServiceException>{

    @Override
    public Response toResponse(ServiceException exception) {
        String message = exception.getMessage();
        message = exception.getMessage().substring(exception.getMessage().indexOf(" "));
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(message).build();
    }
}