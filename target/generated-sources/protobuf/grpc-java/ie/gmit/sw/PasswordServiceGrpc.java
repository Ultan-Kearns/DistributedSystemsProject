package ie.gmit.sw;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The Password service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: password.proto")
public final class PasswordServiceGrpc {

  private PasswordServiceGrpc() {}

  public static final String SERVICE_NAME = "PasswordService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ie.gmit.sw.Hash,
      ie.gmit.sw.HashResponse> getHashServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HashService",
      requestType = ie.gmit.sw.Hash.class,
      responseType = ie.gmit.sw.HashResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.sw.Hash,
      ie.gmit.sw.HashResponse> getHashServiceMethod() {
    io.grpc.MethodDescriptor<ie.gmit.sw.Hash, ie.gmit.sw.HashResponse> getHashServiceMethod;
    if ((getHashServiceMethod = PasswordServiceGrpc.getHashServiceMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getHashServiceMethod = PasswordServiceGrpc.getHashServiceMethod) == null) {
          PasswordServiceGrpc.getHashServiceMethod = getHashServiceMethod =
              io.grpc.MethodDescriptor.<ie.gmit.sw.Hash, ie.gmit.sw.HashResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HashService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.sw.Hash.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.sw.HashResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("HashService"))
              .build();
        }
      }
    }
    return getHashServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ie.gmit.sw.Validate,
      ie.gmit.sw.ValidateResponse> getValidateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateService",
      requestType = ie.gmit.sw.Validate.class,
      responseType = ie.gmit.sw.ValidateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.sw.Validate,
      ie.gmit.sw.ValidateResponse> getValidateServiceMethod() {
    io.grpc.MethodDescriptor<ie.gmit.sw.Validate, ie.gmit.sw.ValidateResponse> getValidateServiceMethod;
    if ((getValidateServiceMethod = PasswordServiceGrpc.getValidateServiceMethod) == null) {
      synchronized (PasswordServiceGrpc.class) {
        if ((getValidateServiceMethod = PasswordServiceGrpc.getValidateServiceMethod) == null) {
          PasswordServiceGrpc.getValidateServiceMethod = getValidateServiceMethod =
              io.grpc.MethodDescriptor.<ie.gmit.sw.Validate, ie.gmit.sw.ValidateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.sw.Validate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.sw.ValidateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordServiceMethodDescriptorSupplier("ValidateService"))
              .build();
        }
      }
    }
    return getValidateServiceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PasswordServiceStub newStub(io.grpc.Channel channel) {
    return new PasswordServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PasswordServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PasswordServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PasswordServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PasswordServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The Password service definition.
   * </pre>
   */
  public static abstract class PasswordServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Hash and validate
     * </pre>
     */
    public void hashService(ie.gmit.sw.Hash request,
        io.grpc.stub.StreamObserver<ie.gmit.sw.HashResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHashServiceMethod(), responseObserver);
    }

    /**
     */
    public void validateService(ie.gmit.sw.Validate request,
        io.grpc.stub.StreamObserver<ie.gmit.sw.ValidateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getValidateServiceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHashServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.sw.Hash,
                ie.gmit.sw.HashResponse>(
                  this, METHODID_HASH_SERVICE)))
          .addMethod(
            getValidateServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.sw.Validate,
                ie.gmit.sw.ValidateResponse>(
                  this, METHODID_VALIDATE_SERVICE)))
          .build();
    }
  }

  /**
   * <pre>
   * The Password service definition.
   * </pre>
   */
  public static final class PasswordServiceStub extends io.grpc.stub.AbstractStub<PasswordServiceStub> {
    private PasswordServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Hash and validate
     * </pre>
     */
    public void hashService(ie.gmit.sw.Hash request,
        io.grpc.stub.StreamObserver<ie.gmit.sw.HashResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHashServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateService(ie.gmit.sw.Validate request,
        io.grpc.stub.StreamObserver<ie.gmit.sw.ValidateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValidateServiceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Password service definition.
   * </pre>
   */
  public static final class PasswordServiceBlockingStub extends io.grpc.stub.AbstractStub<PasswordServiceBlockingStub> {
    private PasswordServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Hash and validate
     * </pre>
     */
    public ie.gmit.sw.HashResponse hashService(ie.gmit.sw.Hash request) {
      return blockingUnaryCall(
          getChannel(), getHashServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public ie.gmit.sw.ValidateResponse validateService(ie.gmit.sw.Validate request) {
      return blockingUnaryCall(
          getChannel(), getValidateServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Password service definition.
   * </pre>
   */
  public static final class PasswordServiceFutureStub extends io.grpc.stub.AbstractStub<PasswordServiceFutureStub> {
    private PasswordServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Hash and validate
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.sw.HashResponse> hashService(
        ie.gmit.sw.Hash request) {
      return futureUnaryCall(
          getChannel().newCall(getHashServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.sw.ValidateResponse> validateService(
        ie.gmit.sw.Validate request) {
      return futureUnaryCall(
          getChannel().newCall(getValidateServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HASH_SERVICE = 0;
  private static final int METHODID_VALIDATE_SERVICE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PasswordServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PasswordServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HASH_SERVICE:
          serviceImpl.hashService((ie.gmit.sw.Hash) request,
              (io.grpc.stub.StreamObserver<ie.gmit.sw.HashResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_SERVICE:
          serviceImpl.validateService((ie.gmit.sw.Validate) request,
              (io.grpc.stub.StreamObserver<ie.gmit.sw.ValidateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PasswordServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PasswordServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ie.gmit.sw.Password.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PasswordService");
    }
  }

  private static final class PasswordServiceFileDescriptorSupplier
      extends PasswordServiceBaseDescriptorSupplier {
    PasswordServiceFileDescriptorSupplier() {}
  }

  private static final class PasswordServiceMethodDescriptorSupplier
      extends PasswordServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PasswordServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PasswordServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PasswordServiceFileDescriptorSupplier())
              .addMethod(getHashServiceMethod())
              .addMethod(getValidateServiceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
