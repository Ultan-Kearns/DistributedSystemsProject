package ie.gmit.ds;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

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
	//read spec may have to change supposed to take input params
	// userId, password output userId, hashedPassword, salt, use return string?
	//allow user to set password?
	//issues with this
	public void hashPassword(Hash password) {
		logger.info("Hashing password  " + password);
		try {
			StreamObserver<Hash> responseObserver = null;
			passwordService.hashPassword(password, responseObserver);
		} catch (StatusRuntimeException ex) {
			logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
			return;
		}
	}

	private static boolean validatePassword(String password, String hashedPassword,String salt) {
		return Passwords.isExpectedPassword(password.toCharArray(), hashedPassword.getBytes(), salt.getBytes());
	}

	public static void main(String[] args) throws Exception {
		//changing for some reason
 		byte[] salt = Passwords.getNextSalt();
 		String password = Passwords.generateRandomPassword(12);
   		Hash newPassword = Hash.newBuilder().setUserId(1234).setSalt(salt.toString())
				.setHashedPassword(password).build();
		try {
			if(newPassword != null)
			{
				
				logger.info("New password = " +  newPassword.getAllFields());
				//need to change this to match fields		 
				//issues with hash it should be exact same in passwords
				logger.info("This password is valid = " + Passwords.isExpectedPassword(password.toCharArray(), salt, Passwords.hash(password.toCharArray(), salt)));
		 
			}

		} finally {
			// Don't stop process, keep alive to receive async response
			Thread.currentThread().join();
		}
	}
}
