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
 		boolean test = false;
 		if(Passwords.isExpectedPassword(v.getPassword().toCharArray(), v.getSalt().getBytes(), v.getHashedPassword().getBytes()) == true){
 			 test = true;
 		}
 		try {
 			responseObserver.onNext(BoolValue.newBuilder().setValue(test).build());
 		}
 		catch (RuntimeException ex) {
            responseObserver.onNext(BoolValue.newBuilder().setValue(test).build());
        }
        responseObserver.onCompleted();
 	}
 	@Override
	public void hashPass(HashPassword password,StreamObserver<HashPassword> responseObserver) {
 		// make hashed password
		byte[] hashed = Passwords.hash(password.getPassword().toCharArray(), Passwords.getNextSalt());
		//rebuild password with new hashed pass - tested works need to find way to get saltr
		password = HashPassword.newBuilder().setUserId(password.getUserId()).setPassword(hashed.toString()).build();
		//return
		responseObserver.onNext(password);
        responseObserver.onCompleted();
 	}
}
