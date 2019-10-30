package ie.gmit.ds;

import java.util.logging.Logger;

import com.google.protobuf.BoolValue;

import ie.gmit.ds.passwordGrpc.passwordImplBase;
import io.grpc.stub.StreamObserver;

public class PasswordServiceImpl extends passwordImplBase {
	private static final Logger logger = Logger.getLogger(PasswordServiceImpl.class.getName());

	// implement methods to be called in the client here
	@Override
	public void validPass(ValidatePassword v, StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
		try {
			byte[] b = v.getHashedPassword().getBytes();
			// this evals to true try subin
			responseObserver.onNext(BoolValue.newBuilder()
					.setValue(Passwords.isExpectedPassword(v.getPassword().toCharArray(), v.getSalt().getBytes(),
							Passwords.hash(v.getPassword().toCharArray(), v.getSalt().getBytes())))
					.build());
		} catch (RuntimeException ex) {
			responseObserver
					.onNext(BoolValue.newBuilder().setValue(Passwords.isExpectedPassword(v.getPassword().toCharArray(),
							v.getSalt().getBytes(), v.getHashedPassword().getBytes())).build());
		}
		responseObserver.onCompleted();
	}

	@Override
	public void hashPass(HashPassword password,StreamObserver<HashPasswordResponse> responseObserver) {
 		try {
 		// make hashed password
 		byte[] salt = Passwords.getNextSalt();
		byte[] hashed = Passwords.hash(password.getPassword().toCharArray(), salt);
		//re uild password with new hashed pass - can probably return string from here to server and then send to user
		password = HashPassword.newBuilder().setUserId(password.getUserId()).setPassword(hashed.toString()).build();
		HashPasswordResponse pass = HashPasswordResponse.newBuilder().setUserId(password.getUserId()).setHashedPassword(hashed.toString()).setSalt(salt.toString()).build();
		//return  the hashed pass response
		responseObserver.onNext(pass);
        responseObserver.onCompleted();
 		}
 		catch(Exception e)
 		{
 			logger.info("Something went wrong when hashing the password");
 		}
}
}
