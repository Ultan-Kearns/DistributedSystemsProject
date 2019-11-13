package ie.gmit.ds;

import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {

	private HashMap<Integer, User> usersMap = new HashMap<Integer, User>();

	public UserApiResource() {
		//params int userID, String userName, String email, String salt
		User testUser = new User(123, "test", "test@test.com", "pass");
		User testUser2 = new User(231, "aaaaaaaaa", "aaaaaaaaaaaaaaaaaa@test.com", "pass");
		usersMap.put(testUser.userID, testUser);
		usersMap.put(testUser2.userID, testUser2);
	 
	}

	@GET
	public Collection<User> getUsers() {
		return usersMap.values();
	}
	@GET
	@Path("/{uID}")
	public Response getSingleUser(@PathParam("uID") Integer uID) {
		User user = usersMap.get(uID);
		if(user == null)
			return Response.status(Status.NOT_FOUND).build();
		else
			return Response.ok(user).build();
	}
	@DELETE
	@Path("/{uID}")
	public Response deleteSingleUser(@PathParam("uID") Integer uID) {
		User user = usersMap.get(uID);
		if(user == null)
			return Response.status(Status.NOT_FOUND).build();
		else
			usersMap.remove(uID);
			return Response.ok(user).build();
	}
	//int userID, String userName, String email, String password
	@POST
	@Path("/{uID}/{userName}/{email}/{password}")
	public Response addUser(@PathParam("uID") Integer uID,@PathParam("userName") String userName, @PathParam("email") String email,@PathParam("password") String password)
	{
		User user = new User(uID,userName,email,password);
	
		if(usersMap.get(uID) == null)
		{
			usersMap.put(uID, user);
			return Response.ok(user).build();
		}
		else 
			return Response.status(Status.CONFLICT).build();
	}
	@PUT
	@Path("/{uID}/{userName}/{email}/{password}")
	public Response updateUser(@PathParam("uID") Integer uID,@PathParam("userName") String userName, @PathParam("email") String email,@PathParam("password") String password)
	{
		User user = usersMap.get(uID);
		if(user == null)
			return Response.status(Status.NOT_FOUND).build();
		else
			user.userName = userName;
			user.email = email;
			user.password = password;
			return Response.ok(user).build();

	}
	
}
