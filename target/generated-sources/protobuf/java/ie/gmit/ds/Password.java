// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

public final class Password {
  private Password() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_HashPassword_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_HashPassword_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_ValidatePassword_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_ValidatePassword_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_HashPasswordResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_HashPasswordResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016password.proto\022\nie.gmit.ds\032\036google/pro" +
      "tobuf/wrappers.proto\"0\n\014HashPassword\022\016\n\006" +
      "userId\030\001 \001(\005\022\020\n\010password\030\002 \001(\t\"J\n\020Valida" +
      "tePassword\022\020\n\010password\030\001 \001(\t\022\026\n\016hashedPa" +
      "ssword\030\002 \001(\t\022\014\n\004salt\030\003 \001(\t\"L\n\024HashPasswo" +
      "rdResponse\022\016\n\006userId\030\001 \001(\005\022\026\n\016hashedPass" +
      "word\030\002 \001(\t\022\014\n\004salt\030\003 \001(\t2\231\001\n\010password\022F\n" +
      "\010HashPass\022\030.ie.gmit.ds.HashPassword\032 .ie" +
      ".gmit.ds.HashPasswordResponse\022E\n\tValidPa" +
      "ss\022\034.ie.gmit.ds.ValidatePassword\032\032.googl" +
      "e.protobuf.BoolValueB\016\n\nie.gmit.dsP\001b\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_ie_gmit_ds_HashPassword_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ie_gmit_ds_HashPassword_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_HashPassword_descriptor,
        new java.lang.String[] { "UserId", "Password", });
    internal_static_ie_gmit_ds_ValidatePassword_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ie_gmit_ds_ValidatePassword_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_ValidatePassword_descriptor,
        new java.lang.String[] { "Password", "HashedPassword", "Salt", });
    internal_static_ie_gmit_ds_HashPasswordResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ie_gmit_ds_HashPasswordResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_HashPasswordResponse_descriptor,
        new java.lang.String[] { "UserId", "HashedPassword", "Salt", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}