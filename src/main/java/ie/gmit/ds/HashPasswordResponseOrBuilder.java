// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

public interface HashPasswordResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ie.gmit.ds.HashPasswordResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 userId = 1;</code>
   */
  int getUserId();

  /**
   * <code>string hashedPassword = 2;</code>
   */
  java.lang.String getHashedPassword();
  /**
   * <code>string hashedPassword = 2;</code>
   */
  com.google.protobuf.ByteString
      getHashedPasswordBytes();

  /**
   * <code>string salt = 3;</code>
   */
  java.lang.String getSalt();
  /**
   * <code>string salt = 3;</code>
   */
  com.google.protobuf.ByteString
      getSaltBytes();
}
