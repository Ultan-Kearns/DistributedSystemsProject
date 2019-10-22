package ie.gmit.ds;

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
				logger.info(value.getUserId() + " " + value.getPassword());
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
		logger.info("Hashing password  ");
		asyncPasswordService.hashPass(request, responseObserver);
		try {
			responseObserver.onNext(request);
			return responseObserver.toString();
		} catch (StatusRuntimeException ex) {
			logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
			return "ERROR";
		}
	}

	private BoolValue validate(String password, String hashedPassword, String salt) {
		// return boolean
		ValidatePassword request = ValidatePassword.newBuilder().setHashedPassword(hashedPassword).setPassword(password)
				.setSalt("Need to find way to get salt").build();
		logger.info(request.getAllFields().toString());
        BoolValue result = BoolValue.newBuilder().setValue(false).build();
  		try {
  			logger.info("TEST " + result.toString());
  			//this causing crash
  	        result = syncPasswordService.validPass(request);
  	        } catch (StatusRuntimeException ex) {
			logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
  	        }
			return result;
	}

	public static void main(String[] args) throws Exception {
		PasswordClient pc = new PasswordClient("localhost", 50551);
		try {
			pc.Hash(123, "12213231");
			// should return true
			BoolValue test = pc.validate("test", "test", "test");
			logger.info("VALID " + test);
		} finally {
			// Don't stop process, keep alive to receive async response
			Thread.currentThread().join();
		}
	}
}
