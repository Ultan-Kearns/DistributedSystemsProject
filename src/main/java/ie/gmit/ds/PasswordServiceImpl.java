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
		
 	}
 	@Override
	public void hashPass(HashPassword password,StreamObserver<HashPassword> responseObserver) {
		
 	}
}
