package com.omkabel1995.pln.Response;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.omkabel1995.pln.Model.Model_Users;

import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class Response_Login implements Serializable {

	@SerializedName("status")
	private boolean status;

	@SerializedName("user")
	private List<Model_Users> user;

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setUser(List<Model_Users> user){
		this.user = user;
	}

	public List<Model_Users> getUser(){
		return user;
	}

	@Override
 	public String toString(){
		return 
			"Response_Login{" + 
			"status = '" + status + '\'' + 
			",user = '" + user + '\'' + 
			"}";
		}
}