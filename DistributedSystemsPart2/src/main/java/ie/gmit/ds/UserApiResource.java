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


	public UserApiResource() {
		channel = ManagedChannelBuilder.forAddress("localhost", 50551).usePlaintext().build();
		asyncPasswordService = passwordGrpc.newStub(channel);
		syncPasswordService = passwordGrpc.newBlockingStub(channel);
	}

	// should return hashed password and salt
	@GET
	public Collection<User> getUsers() {
		return usersMap.values();
	}

	@GET
	@Path("/{uID}")
	public Response getSingleUser(@PathParam("uID") Integer uID) {
		User user = usersMap.get(uID);
		if (user == null)
			return Response.status(Status.NOT_FOUND).build();
		else
			return Response.ok(user).build();
	}

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

	// int userID, String userName, String email, String password
	@POST
	@Path("/{uID}/{userName}/{email}/{password}")
	public Response addUser(@PathParam("uID") Integer uID, @PathParam("userName") String userName,
			@PathParam("email") String email, @PathParam("password") String password) {
	
		String test = Hash(uID, password).toString();
		user = new User(uID, userName, email, password, test, Passwords.getNextSalt().toString());
		if (usersMap.get(uID) == null) {
			usersMap.put(uID, user);
			return Response.ok(user).build();
		} else
			return Response.status(Status.CONFLICT).build();
	}

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

	// Hash method - calls the server to hash the User Password - calls server
	public String Hash(int userId, String password) {
 		HashPassword request = HashPassword.newBuilder().setUserId(userId).setPassword(password).build();
		StreamObserver<HashPassword> responseObserver = new StreamObserver<HashPassword>() {
			@Override
			public void onNext(HashPassword value) {
				logger.info("user ID = "  + value.getUserId() +" Pass to hash = " + value.getPassword());
			}

			@Override
			public void onError(Throwable t) {
				logger.info("ERROR IN RESPONSE");
			}

			@Override
			public void onCompleted() {
				logger.info("RESPONSE COMPLETED");
			}
		};
		StreamObserver<HashPasswordResponse> res = new StreamObserver<HashPasswordResponse>() {

			@Override
			public void onNext(HashPasswordResponse value) {
				//Print out hashed password
				logger.info("user ID = "  + value.getUserId() +" Hashed pass = " + value.getHashedPassword() + " salt = " + value.getSalt());
			}
			
			@Override
			public void onError(Throwable t) {
				logger.info("ERROR: " + t.toString());
				
			}

			@Override
			public void onCompleted() {
				logger.info("completed hashing");
				
			}
			
		};
		asyncPasswordService.hashPass(request, res);
		try {
			responseObserver.onNext(request);
			responseObserver.onCompleted();
  			return responseObserver.toString();
		} catch (StatusRuntimeException ex) {
			logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
			return "ERROR";
		}
	}

	//this calls server and logs in
	@GET
	@Path("/{uID}/{password}")
	public String login(@PathParam("uID") Integer uID, @PathParam("password") String password) {
		try {
			User user = usersMap.get(uID);
			ValidatePassword request = ValidatePassword.newBuilder().setPassword(user.getPassword())
					.setSalt(user.getSalt()).setHashedPassword(user.getHashedPassword()).build();
			BoolValue result = BoolValue.newBuilder().setValue(false).build();
			if(usersMap.get(uID) != null)
				return "User doesn't exist";
			result = syncPasswordService.validPass(request);
			//check if password is valid and user password = param password
			logger.info("USER PASS " + user.password  + " " + usersMap.get(uID).password);
			if (result.getValue() && user.password == usersMap.get(uID).password)
				return "Logged In User " + user.userID;
			else
				return "Incorrect Username or Password";
		} catch (Exception connectionError) {
			return "Check if password server is running";
		}
	}
}