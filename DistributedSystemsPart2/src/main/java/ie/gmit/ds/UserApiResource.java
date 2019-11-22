package ie.gmit.ds;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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

import com.google.protobuf.BoolValue;

import ie.gmit.ds.passwordGrpc.passwordStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {
	private static passwordGrpc.passwordStub asyncPasswordService;
	private passwordGrpc.passwordBlockingStub syncPasswordService;
	private static final Logger logger = Logger.getLogger(UserApiResource.class.getName());
	private final ManagedChannel channel;
	private HashMap<Integer, User> usersMap = new HashMap<Integer, User>();
	User user;

	//establishes initial connection
	public UserApiResource() {
		channel = ManagedChannelBuilder.forAddress("localhost", 50551).usePlaintext().build();
		asyncPasswordService = passwordGrpc.newStub(channel);
		syncPasswordService = passwordGrpc.newBlockingStub(channel);
	}

	//Gets all users from usermap
	@GET
	public Collection<User> getUsers() {
		return usersMap.values();
	}
	//takes UID as input parameter returns single user
	@GET
	@Path("/{uID}")
	public Response getSingleUser(@PathParam("uID") Integer uID) {
		User user = usersMap.get(uID);
		if (user == null)
			return Response.status(Status.NOT_FOUND).build();
		else
			return Response.ok(user).build();
	}
	//takes UID as parameter and deletes a single user
	@DELETE
	@Path("/{uID}")
	public Response deleteSingleUser(@PathParam("uID") Integer uID) {
		User user = usersMap.get(uID);
		if (user == null)
			return Response.status(Status.NOT_FOUND).build();
		else
			usersMap.remove(uID);
		 return Response.status(Status.NO_CONTENT).build();
	}

	// Adds user by getting parameters from the URL calls hash password for the hash
	@POST
	@Path("/{uID}/{userName}/{email}/{password}")
	public Response addUser(@PathParam("uID") Integer uID, @PathParam("userName") String userName,
			@PathParam("email") String email, @PathParam("password") String password) {
		String hashedPass = "";
		try {
		hashedPass = Hash(uID, password).toString();
		}
		catch(Exception connectionException) {
			logger.info("Failed to connect to the server");
		}
		user = new User(uID, userName, email, password, hashedPass, Passwords.getNextSalt().toString());
		if (usersMap.get(uID) == null) {
			usersMap.put(uID, user);
			return Response.ok(user).build();
		} else
			return Response.status(Status.CONFLICT).build();
	}
	//This updates the user by using a PUT, PUT allows us to update or overwrite existing info
	@PUT
	@Path("/{uID}/{userName}/{email}/{password}")
	public Response updateUser(@PathParam("uID") Integer uID, @PathParam("userName") String userName,
			@PathParam("email") String email, @PathParam("password") String password) {
		User user = usersMap.get(uID);
		if (user == null)
			return Response.status(Status.NOT_FOUND).build();
		user.userName = userName;
		user.email = email;
		user.password = password;
		return Response.ok(user).build();
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	/* Hash method - calls the server to hash the User Password - calls server
	This is used to call the server from post method to hash the users password*/
	public String Hash(int userId, String password) {
 		HashPassword request = HashPassword.newBuilder().setUserId(userId).setPassword(password).build();
 		StreamObserver<HashPassword> responseObserver = new StreamObserver<HashPassword>() {

			public void onNext(HashPassword value) {
				logger.info("TEST " + value.getPassword());

			}

			public void onError(Throwable t) {
				logger.info("Cannot reach server");

			}


			public void onCompleted() {
				logger.info("Completed");
			}
		};
		syncPasswordService.hashPass(request);
		try {
  			return responseObserver.toString();
		} catch (StatusRuntimeException ex) {
			logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
			return "ERROR is server connected?";
		}
	}

	//this calls server to check if password is valid then compares userpass with pass in maps
	@GET
	@Path("/{uID}/{password}")
	public Response login(@PathParam("uID") Integer uID, @PathParam("password") String password) {
		try {
			User user = usersMap.get(uID);
			ValidatePassword request = ValidatePassword.newBuilder().setPassword(user.getPassword())
					.setSalt(user.getSalt()).setHashedPassword(user.getHashedPassword()).build();
			BoolValue result = BoolValue.newBuilder().setValue(false).build();
			if(usersMap.get(uID) == null)
				return Response.status(Status.NOT_FOUND).build();
			result = syncPasswordService.validPass(request);
			//check if password is valid and user password = param password
 			if (result.getValue() && usersMap.get(uID).getPassword().equals(password))
				return Response.ok(user).build();
			else
				return  Response.status(Status.FORBIDDEN).build();
		} catch (Exception connectionError) {
			return  Response.status(Status.GATEWAY_TIMEOUT).build();
		}
	}
}
