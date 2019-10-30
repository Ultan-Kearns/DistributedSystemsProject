package ie.gmit.ds;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.hash.Hasher;
import com.google.protobuf.BoolValue;
 
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class PasswordClient {
	private passwordGrpc.passwordStub asyncPasswordService;
	private passwordGrpc.passwordBlockingStub syncPasswordService;
	private static final Logger logger = Logger.getLogger(PasswordClient.class.getName());
	private final ManagedChannel channel;

	public PasswordClient(String host, int port) {
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		asyncPasswordService = passwordGrpc.newStub(channel);
        syncPasswordService = passwordGrpc.newBlockingStub(channel);

	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	// call all methods from password implementation get params from requirement
	public String Hash(int userId, String password) {
 		HashPassword request = HashPassword.newBuilder().setUserId(userId).setPassword(password).build();
		StreamObserver<HashPassword> responseObserver = new StreamObserver<HashPassword>() {
			@Override
			public void onNext(HashPassword value) {
				logger.info("user ID = "  + value.getUserId() +" Pass to hash = " + value.getPassword());
			}

			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onCompleted() {
			}
		};
		StreamObserver<HashPasswordResponse> res = new StreamObserver<HashPasswordResponse>() {

			@Override
			public void onNext(HashPasswordResponse value) {
				// TODO Auto-generated method stub
				logger.info("user ID = "  + value.getUserId() +" Pass to hash = " + value.getHashedPassword() + " salt = " + value.getSalt());
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

	private BoolValue validate(String password,String hashedPassword, String salt) {
		ValidatePassword request = ValidatePassword.newBuilder().setPassword(password).setSalt(salt)
				.setHashedPassword(hashedPassword).build();
        BoolValue result = BoolValue.newBuilder().setValue(false).build();
            result = syncPasswordService.validPass(request);
         if (result.getValue()) {
            logger.info("Successfully validated password ");
        } else {
            logger.warning("Failed to validate password " +  result);
        }
        return result;
	}

	public static void main(String[] args) throws Exception {
		PasswordClient pc = new PasswordClient("localhost", 50551);
		try {
			 Scanner sc = new Scanner(System.in);
			 System.out.println("Enter user ID: ");
			 int uID = sc.nextInt();
			 System.out.println("Enter password: ");
			 String password = sc.next();
			 pc.Hash(uID, password);
			// should return true problem with tostring 
			pc.validate(password,Passwords.hash(password.toCharArray(),Passwords.getNextSalt()).toString(),Passwords.getNextSalt().toString());
 		} finally {
			// Don't stop process, keep alive to receive async response
			Thread.currentThread().join();
		}
	}
}
