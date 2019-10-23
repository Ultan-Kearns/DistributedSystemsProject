package ie.gmit.ds;

import java.util.logging.Logger;

import com.google.protobuf.BoolValue;

import ie.gmit.ds.passwordGrpc.passwordImplBase;
import io.grpc.stub.StreamObserver;

public class PasswordServiceImpl extends passwordImplBase{
	private static final Logger logger =
            Logger.getLogger(PasswordServiceImpl.class.getName());
	//implement methods to be called in the client here
 	@Override
	public void validPass(ValidatePassword v,StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
 		try {
 			byte[] b = v.getHashedPassword().getBytes();
 			//this evals to true try subin
 			  responseObserver.onNext(BoolValue.newBuilder().setValue(Passwords.isExpectedPassword(v.getPassword().toCharArray(), v.getSalt().getBytes(), Passwords.hash(v.getPassword().toCharArray(), v.getSalt().getBytes()))).build());	        
 			  } catch (RuntimeException ex) {
	 			  responseObserver.onNext(BoolValue.newBuilder().setValue(Passwords.isExpectedPassword(v.getPassword().toCharArray(), v.getSalt().getBytes(), v.getHashedPassword().getBytes())).build());
	        }
 		responseObserver.onCompleted();
 	}
 	@Override
	public void hashPass(HashPassword password,StreamObserver<HashPassword> responseObserver) {
 		// make hashed password
		byte[] hashed = Passwords.hash(password.getPassword().toCharArray(), Passwords.getNextSalt());
		//rebuild password with new hashed pass - can probably return string from here to server and then send to user
		password = HashPassword.newBuilder().setUserId(password.getUserId()).setPassword(hashed.toString()).build();
		//return try using strings
		responseObserver.onNext(password);
        responseObserver.onCompleted();
 	}
}
