package pl.javastart.usermanager.endpoint;
 
import java.io.IOException;
import java.util.List;
 
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
 
import pl.javastart.usermanager.data.UserRepository;
import pl.javastart.usermanager.model.User;
import pl.javastart.usermanager.model.UserDetails;
 
@RequestScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserEndpoint {
 
    @Inject
    private UserRepository users;
     
    @GET
    public Response getAll() {
        List<User> allUsers = users.getAll();
        if(allUsers.isEmpty())
            return Response.noContent().build();
        else
            return Response.ok(allUsers).build();
    }
     
    @GET
    @Path("/{userId}")
    public Response getById(@PathParam("userId") Long id) {
        User user = users.get(id);
        if(user == null)
            return Response.noContent().build();
        else
            return Response.ok(user).build();
    }
     
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user, @Context UriInfo uriInfo) {
        if(user != null && user.getId() == null) {
            users.add(user);
            return Response
                    .created(uriInfo
                            .getAbsolutePathBuilder()
                            .path(user.getId().toString())
                            .build())
                    .build();
        } else {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }
     
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createUser(@FormParam("firstName") String firstName, 
                           @FormParam("lastName") String lastName,
                           @FormParam("telephone") String telephone,
                           @FormParam("pesel") String pesel,
                           @FormParam("country") String country,
                           @FormParam("address") String address,
                           @Context HttpServletRequest request,
                           @Context HttpServletResponse response) throws IOException {
        User user = new User(firstName, lastName, telephone, pesel);
        UserDetails details = new UserDetails(address, country);
        user.setDetails(details);
        users.add(user);
        response.sendRedirect(request.getContextPath());
    }
}