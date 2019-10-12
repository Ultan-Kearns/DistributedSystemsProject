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
public final class PasswordGrpc {

  private PasswordGrpc() {}

  public static final String SERVICE_NAME = "Password";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ie.gmit.sw.HashSaltPassword,
      ie.gmit.sw.GeneratePassword> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = ie.gmit.sw.HashSaltPassword.class,
      responseType = ie.gmit.sw.GeneratePassword.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ie.gmit.sw.HashSaltPassword,
      ie.gmit.sw.GeneratePassword> getSayHelloMethod() {
    io.grpc.MethodDescriptor<ie.gmit.sw.HashSaltPassword, ie.gmit.sw.GeneratePassword> getSayHelloMethod;
    if ((getSayHelloMethod = PasswordGrpc.getSayHelloMethod) == null) {
      synchronized (PasswordGrpc.class) {
        if ((getSayHelloMethod = PasswordGrpc.getSayHelloMethod) == null) {
          PasswordGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<ie.gmit.sw.HashSaltPassword, ie.gmit.sw.GeneratePassword>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.sw.HashSaltPassword.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ie.gmit.sw.GeneratePassword.getDefaultInstance()))
              .setSchemaDescriptor(new PasswordMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PasswordStub newStub(io.grpc.Channel channel) {
    return new PasswordStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PasswordBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PasswordBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PasswordFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PasswordFutureStub(channel);
  }

  /**
   * <pre>
   * The Password service definition.
   * </pre>
   */
  public static abstract class PasswordImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a Password
     * </pre>
     */
    public void sayHello(ie.gmit.sw.HashSaltPassword request,
        io.grpc.stub.StreamObserver<ie.gmit.sw.GeneratePassword> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ie.gmit.sw.HashSaltPassword,
                ie.gmit.sw.GeneratePassword>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   * <pre>
   * The Password service definition.
   * </pre>
   */
  public static final class PasswordStub extends io.grpc.stub.AbstractStub<PasswordStub> {
    private PasswordStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a Password
     * </pre>
     */
    public void sayHello(ie.gmit.sw.HashSaltPassword request,
        io.grpc.stub.StreamObserver<ie.gmit.sw.GeneratePassword> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Password service definition.
   * </pre>
   */
  public static final class PasswordBlockingStub extends io.grpc.stub.AbstractStub<PasswordBlockingStub> {
    private PasswordBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a Password
     * </pre>
     */
    public ie.gmit.sw.GeneratePassword sayHello(ie.gmit.sw.HashSaltPassword request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Password service definition.
   * </pre>
   */
  public static final class PasswordFutureStub extends io.grpc.stub.AbstractStub<PasswordFutureStub> {
    private PasswordFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PasswordFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PasswordFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PasswordFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a Password
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ie.gmit.sw.GeneratePassword> sayHello(
        ie.gmit.sw.HashSaltPassword request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PasswordImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PasswordImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((ie.gmit.sw.HashSaltPassword) request,
              (io.grpc.stub.StreamObserver<ie.gmit.sw.GeneratePassword>) responseObserver);
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

  private static abstract class PasswordBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PasswordBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ie.gmit.sw.PasswordProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Password");
    }
  }

  private static final class PasswordFileDescriptorSupplier
      extends PasswordBaseDescriptorSupplier {
    PasswordFileDescriptorSupplier() {}
  }

  private static final class PasswordMethodDescriptorSupplier
      extends PasswordBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PasswordMethodDescriptorSupplier(String methodName) {
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
      synchronized (PasswordGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PasswordFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
