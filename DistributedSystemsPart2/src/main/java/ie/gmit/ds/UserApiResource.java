package ie.gmit.ds;

import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {

	private HashMap<Integer, User> usersMap = new HashMap<Integer, User>();

	public UserApiResource() {
		//params int userID, String userName, String email, String salt
		User testUser = new User(123, "test", "test@test.com", "salt");
		usersMap.put(testUser.getUserID(), testUser);
	}

	@GET
	public Collection<User> getUsers() {
		return usersMap.values();
	}
}
