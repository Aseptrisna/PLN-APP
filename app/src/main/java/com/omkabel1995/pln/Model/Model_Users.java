package com.omkabel1995.pln.Model;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class Model_Users implements Serializable {

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("username")
	private String username;

	@SerializedName("password")
	private String password;

	@SerializedName("status")
	private String status;

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Model_Users{" + 
			"id_user = '" + idUser + '\'' + 
			",username = '" + username + '\'' + 
			",password = '" + password + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}