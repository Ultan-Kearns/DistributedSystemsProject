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
  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.HashPassword,
      ie.gmit.ds.HashPassword> getHashPassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HashPass",
      requestType = ie.gmit.ds.HashPassword.class,
      responseType = ie.gmit.ds.HashPassword.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.HashPassword,
      ie.gmit.ds.HashPassword> getHashPassMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.HashPassword, ie.gmit.ds.HashPassword> getHashPassMethod;
    if ((getHashPassMethod = passwordGrpc.getHashPassMethod) == null) {
      synchronized (passwordGrpc.class) {
        if ((getHashPassMethod = passwordGrpc.getHashPassMethod) == null) {
          passwordGrpc.getHashPassMethod = getHashPassMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.HashPassword, ie.gmit.ds.HashPassword>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HashPass"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.HashPassword.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.HashPassword.getDefaultInstance()))
              .setSchemaDescriptor(new passwordMethodDescriptorSupplier("HashPass"))
              .build();
        }
      }
    }
    return getHashPassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ie.gmit.ds.ValidatePassword,
      com.google.protobuf.BoolValue> getValidPassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidPass",
      requestType = ie.gmit.ds.ValidatePassword.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.ds.ValidatePassword,
      com.google.protobuf.BoolValue> getValidPassMethod() {
    io.grpc.MethodDescriptor<ie.gmit.ds.ValidatePassword, com.google.protobuf.BoolValue> getValidPassMethod;
    if ((getValidPassMethod = passwordGrpc.getValidPassMethod) == null) {
      synchronized (passwordGrpc.class) {
        if ((getValidPassMethod = passwordGrpc.getValidPassMethod) == null) {
          passwordGrpc.getValidPassMethod = getValidPassMethod =
              io.grpc.MethodDescriptor.<ie.gmit.ds.ValidatePassword, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidPass"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.ds.ValidatePassword.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new passwordMethodDescriptorSupplier("ValidPass"))
              .build();
        }
      }
    }
    return getValidPassMethod;
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
    public void hashPass(ie.gmit.ds.HashPassword request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.HashPassword> responseObserver) {
      asyncUnimplementedUnaryCall(getHashPassMethod(), responseObserver);
    }

    /**
     */
    public void validPass(ie.gmit.ds.ValidatePassword request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getValidPassMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHashPassMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.HashPassword,
                ie.gmit.ds.HashPassword>(
                  this, METHODID_HASH_PASS)))
          .addMethod(
            getValidPassMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.ds.ValidatePassword,
                com.google.protobuf.BoolValue>(
                  this, METHODID_VALID_PASS)))
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
    public void hashPass(ie.gmit.ds.HashPassword request,
        io.grpc.stub.StreamObserver<ie.gmit.ds.HashPassword> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHashPassMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validPass(ie.gmit.ds.ValidatePassword request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getValidPassMethod(), getCallOptions()), request, responseObserver);
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
    public ie.gmit.ds.HashPassword hashPass(ie.gmit.ds.HashPassword request) {
      return blockingUnaryCall(
          getChannel(), getHashPassMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue validPass(ie.gmit.ds.ValidatePassword request) {
      return blockingUnaryCall(
          getChannel(), getValidPassMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.ds.HashPassword> hashPass(
        ie.gmit.ds.HashPassword request) {
      return futureUnaryCall(
          getChannel().newCall(getHashPassMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> validPass(
        ie.gmit.ds.ValidatePassword request) {
      return futureUnaryCall(
          getChannel().newCall(getValidPassMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HASH_PASS = 0;
  private static final int METHODID_VALID_PASS = 1;

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
        case METHODID_HASH_PASS:
          serviceImpl.hashPass((ie.gmit.ds.HashPassword) request,
              (io.grpc.stub.StreamObserver<ie.gmit.ds.HashPassword>) responseObserver);
          break;
        case METHODID_VALID_PASS:
          serviceImpl.validPass((ie.gmit.ds.ValidatePassword) request,
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
              .addMethod(getHashPassMethod())
              .addMethod(getValidPassMethod())
              .build();
        }
      }
    }
    return result;
  }
}
