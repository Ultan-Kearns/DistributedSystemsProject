package ie.gmit.ds;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import ie.gmit.ds.passwordGrpc.passwordStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class PasswordClient {
	private passwordGrpc.passwordStub passwordService;
	private static final Logger logger = Logger.getLogger(PasswordClient.class.getName());
	private final ManagedChannel channel;

	public PasswordClient(String host, int port) {
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		passwordService = passwordGrpc.newStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void hashPassword(Hash password) {
		logger.info("Hashing password  " + password);
		try {
			StreamObserver<Hash> responseObserver = null;
			passwordService.hashPassword(password, responseObserver);
		} catch (StatusRuntimeException ex) {
			logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
			return;
		}
		/*
		 * if (result.getValue()) { logger.info("Successfully added item " + newItem); }
		 * else { logger.warning("Failed to add item"); }
		 */
	}

	private void validatePassword() {

	}

	public static void main(String[] args) throws Exception {
		PasswordClient client = new PasswordClient("localhost", 50551);
		String salt = Passwords.getNextSalt().toString();
		Hash newPassword = Hash.newBuilder().setUserId(1234).setSalt(salt)
				.setHashedPassword(Passwords.generateRandomPassword(12) + salt).build();
		try {
			if(newPassword != null)
			{
				logger.info("New password = " +  newPassword.getAllFields());
			}

		} finally {
			// Don't stop process, keep alive to receive async response
			Thread.currentThread().join();
		}
	}
}
