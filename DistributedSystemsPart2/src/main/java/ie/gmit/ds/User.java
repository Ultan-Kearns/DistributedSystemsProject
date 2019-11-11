package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	/*
	 * userIdinteger•userNamestring•emailstring•hashedPasswordstring•saltstring
	 */
	int userID;
	String userName;
	String email;
	String salt;

	@JsonProperty
	public int getUserID() {
		return userID;
	}

	@JsonProperty
	public String getUserName() {
		return userName;
	}

	@JsonProperty
	public String getEmail() {
		return email;
	}

	@JsonProperty
	public String getSalt() {
		return salt;
	}

	public User(int userID, String userName, String email, String salt) {
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.salt = salt;
	}

}
