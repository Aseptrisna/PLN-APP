package com.omkabel1995.pln.Model;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class Model_Pln implements Serializable {

	@SerializedName("id")
	private String id;

	@SerializedName("nama")
	private String nama;

	@SerializedName("image")
	private String image;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	@Override
 	public String toString(){
		return 
			"Model_Pln{" + 
			"id = '" + id + '\'' + 
			",nama = '" + nama + '\'' + 
			",image = '" + image + '\'' + 
			"}";
		}
}