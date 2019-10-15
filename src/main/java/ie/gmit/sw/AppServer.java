package ie.gmit.sw;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;

import ie.gmit.sw.PasswordServiceGrpc.PasswordServiceImplBase;
public class AppServer {
    private Server server;
    private static final Logger logger = Logger.getLogger(AppServer.class.getName());


    public static void main(String[] args) throws IOException, InterruptedException {
        final AppServer server = new AppServer();
        server.start();
        server.blockUntilShutdown();
    }
    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new AppServer.PasswordImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
    }
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
    static class PasswordImpl extends PasswordServiceImplBase implements BindableService {
    	//May have to delete overridden methods
        @Override
        public void hashService(HashResponse req, StreamObserver<HashResponse> responseObserver) {
        	HashResponse reply = HashResponse.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
        @Override
        public void validateService(ValidateResponse req, StreamObserver<ValidateResponse> responseObserver) {
        	ValidateResponse reply = ValidateResponse.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
