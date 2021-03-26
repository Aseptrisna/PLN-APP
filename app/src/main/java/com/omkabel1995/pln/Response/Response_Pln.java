package com.omkabel1995.pln.Response;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.omkabel1995.pln.Model.Model_Pln;

import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class Response_Pln implements Serializable {

	@SerializedName("dataaset")
	private boolean dataaset;

	@SerializedName("aset")
	private List<Model_Pln> aset;

	public void setDataaset(boolean dataaset){
		this.dataaset = dataaset;
	}

	public boolean isDataaset(){
		return dataaset;
	}

	public void setAset(List<Model_Pln> aset){
		this.aset = aset;
	}

	public List<Model_Pln> getAset(){
		return aset;
	}

	@Override
 	public String toString(){
		return 
			"Response_Pln{" + 
			"dataaset = '" + dataaset + '\'' + 
			",aset = '" + aset + '\'' + 
			"}";
		}
}