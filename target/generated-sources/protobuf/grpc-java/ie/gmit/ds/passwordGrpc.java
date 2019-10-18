package ie.gmit.ds;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: password.proto")
public final class passwordGrpc {

  private passwordGrpc() {}

  public static final String SERVICE_NAME = "ie.gmit.ds.password";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.Hash,
      ie.gmit.ds.Hash> getHashPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HashPassword",
      requestType = ie.gmit.ds.Hash.class,
      responseType = ie.gmit.ds.Hash.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.Hash,
      ie.gmit.ds.Hash> getHashPasswordMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.Hash, ie.gmit.ds.Hash> getHashPasswordMethod;
    if ((getHashPasswordMethod = passwordGrpc.getHashPasswordMethod) == null) {
      synchronized (passwordGrpc.class) {
        if ((getHashPasswordMethod = passwordGrpc.getHashPasswordMethod) == null) {
          passwordGrpc.getHashPasswordMethod = getHashPasswordMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.Hash, ie.gmit.ds.Hash>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HashPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.Hash.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.Hash.getDefaultInstance()))
              .setSchemaDescriptor(new passwordMethodDescriptorSupplier("HashPassword"))
              .build();
        }
      }
    }
    return getHashPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.Hash,
      com.google.protobuf.BoolValue> getValidatePasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidatePassword",
      requestType = ie.gmit.ds.Hash.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.Hash,
      com.google.protobuf.BoolValue> getValidatePasswordMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.Hash, com.google.protobuf.BoolValue> getValidatePasswordMethod;
    if ((getValidatePasswordMethod = passwordGrpc.getValidatePasswordMethod) == null) {
      synchronized (passwordGrpc.class) {
        if ((getValidatePasswordMethod = passwordGrpc.getValidatePasswordMethod) == null) {
          passwordGrpc.getValidatePasswordMethod = getValidatePasswordMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.Hash, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidatePassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.Hash.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new passwordMethodDescriptorSupplier("ValidatePassword"))
              .build();
        }
      }
    }
    return getValidatePasswordMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static passwordStub newStub(io.grpc.Channel channel) {
    return new passwordStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static passwordBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new passwordBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static passwordFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new passwordFutureStub(channel);
  }

  /**
   */
  public static abstract class passwordImplBase implements io.grpc.BindableService {

    /**
     */
    public void hashPassword(ie.gmit.ds.Hash request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.Hash> responseObserver) {
      asyncUnimplementedUnaryCall(getHashPasswordMethod(), responseObserver);
    }

    /**
     */
    public void validatePassword(ie.gmit.ds.Hash request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getValidatePasswordMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHashPasswordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.Hash,
                ie.gmit.ds.Hash>(
                  this, METHODID_HASH_PASSWORD)))
          .addMethod(
            getValidatePasswordMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.Hash,
                com.google.protobuf.BoolValue>(
                  this, METHODID_VALIDATE_PASSWORD)))
          .build();
    }
  }

  /**
   */
  public static final class passwordStub extends io.grpc.stub.AbstractStub<passwordStub> {
    private passwordStub(io.grpc.Channel channel) {
      super(channel);
    }

    private passwordStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected passwordStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new passwordStub(channel, callOptions);
    }

    /**
     */
    public void hashPassword(ie.gmit.ds.Hash request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.Hash> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHashPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validatePassword(ie.gmit.ds.Hash request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValidatePasswordMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class passwordBlockingStub extends io.grpc.stub.AbstractStub<passwordBlockingStub> {
    private passwordBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private passwordBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected passwordBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new passwordBlockingStub(channel, callOptions);
    }

    /**
     */
    public ie.gmit.ds.Hash hashPassword(ie.gmit.ds.Hash request) {
      return blockingUnaryCall(
          getChannel(), getHashPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue validatePassword(ie.gmit.ds.Hash request) {
      return blockingUnaryCall(
          getChannel(), getValidatePasswordMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class passwordFutureStub extends io.grpc.stub.AbstractStub<passwordFutureStub> {
    private passwordFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private passwordFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected passwordFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new passwordFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.ds.Hash> hashPassword(
        ie.gmit.ds.Hash request) {
      return futureUnaryCall(
          getChannel().newCall(getHashPasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> validatePassword(
        ie.gmit.ds.Hash request) {
      return futureUnaryCall(
          getChannel().newCall(getValidatePasswordMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HASH_PASSWORD = 0;
  private static final int METHODID_VALIDATE_PASSWORD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final passwordImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(passwordImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HASH_PASSWORD:
          serviceImpl.hashPassword((ie.gmit.ds.Hash) request,
              (io.grpc.stub.StreamObserver<ie.gmit.ds.Hash>) responseObserver);
          break;
        case METHODID_VALIDATE_PASSWORD:
          serviceImpl.validatePassword((ie.gmit.ds.Hash) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
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

  private static abstract class passwordBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    passwordBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ie.gmit.ds.Password.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("password");
    }
  }

  private static final class passwordFileDescriptorSupplier
      extends passwordBaseDescriptorSupplier {
    passwordFileDescriptorSupplier() {}
  }

  private static final class passwordMethodDescriptorSupplier
      extends passwordBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    passwordMethodDescriptorSupplier(String methodName) {
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
      synchronized (passwordGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new passwordFileDescriptorSupplier())
              .addMethod(getHashPasswordMethod())
              .addMethod(getValidatePasswordMethod())
              .build();
        }
      }
    }
    return result;
  }
}
