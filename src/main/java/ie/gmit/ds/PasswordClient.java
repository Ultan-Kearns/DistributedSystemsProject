package ie.gmit.ds;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class PasswordClient {
	private static final Logger logger =
            Logger.getLogger(PasswordClient.class.getName());
    private final ManagedChannel channel; 
    public PasswordClient(String host, int port) {
    	 channel = ManagedChannelBuilder
                 .forAddress(host, port)
                 .usePlaintext()
                 .build();	}
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    private void validatePassword() {
  
    }
    public static void main(String[] args) throws Exception {
        PasswordClient client = new PasswordClient("localhost", 50551);
       
    }
}
