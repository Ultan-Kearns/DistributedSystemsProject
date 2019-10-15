package ie.gmit.sw;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    private final ManagedChannel channel;
    private final PasswordServiceGrpc.PasswordServiceBlockingStub passwordClientStub;

    /** Construct client for accessing HelloWorld server using the existing channel. */
    public App(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        passwordClientStub = PasswordServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /** Say hello to server. */
    public void greet(String name) {
        logger.info("Will try to greet " + name + " ...");
        Hash request = Hash.newBuilder().setUserID(1234).build();
        Hash UID = Hash.newBuilder().setPassword("Password").build();
        HashResponse response;
        try {
            response = passwordClientStub.hashService(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Communicating with server: " + response.getHashedPassword());
    }

    public static void main(String[] args) throws Exception {
        App client = new App("localhost", 50051);
        try {
            client.greet("TeST");
        } finally {
            client.shutdown();
        }
    }
}
