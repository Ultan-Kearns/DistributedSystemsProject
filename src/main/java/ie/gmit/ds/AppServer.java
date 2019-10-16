package ie.gmit.ds;

import ie.gmit.ds.*;
import io.grpc.Server;
import io.grpc.BindableService;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import ie.gmit.ds.ValidateResponse;
import ie.gmit.ds.HashResponse;
import ie.gmit.ds.PasswordServiceGrpc.PasswordServiceImplBase;

import java.util.logging.Logger;
public class AppServer{
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
		server = ServerBuilder.forPort(port).addService(new AppServer.PasswordImpl()).build().start();
		logger.info("Server started, listening on " + port);
	}

	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	static class PasswordImpl implements BindableService
	{

		@Override
		public ServerServiceDefinition bindService() {
			// TODO Auto-generated method stub
			return null;
		}		// May have to delete overridden methods
	
	}
}
