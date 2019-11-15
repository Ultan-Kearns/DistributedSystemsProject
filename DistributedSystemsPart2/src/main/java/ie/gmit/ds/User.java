package ie.gmit.ds;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAnyElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.protobuf.BoolValue;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class User {
	/*
	 * userIdinteger•userNamestring•emailstring•hashedPasswordstring•saltstring
	 */
	int userID;
	String userName;
	String email;
	String password;
	String hashedPassword,salt;
	@XmlAnyElement
	@JsonProperty
	public int getUserID() {
		return userID;
	}
	@XmlAnyElement
	@JsonProperty
	public String getUserName() {
		return userName;
	}
	@XmlAnyElement
	@JsonProperty
	public String getEmail() {
		return email;
	}
	@XmlAnyElement
	@JsonProperty
	public String getPassword() {
		return password;
	}
	@XmlAnyElement
	@JsonProperty
	public String getHashedPassword() {
		return hashedPassword;
	}
	@XmlAnyElement
	@JsonProperty
	public String getSalt() {
		return salt;
	}
	public User(int userID, String userName, String email, String password,String hashedPassword,String salt) {
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.hashedPassword = hashedPassword;
		this.salt = salt;

	}
}
