package com.omkabel1995.pln.Response;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class Response_Detailasset implements Serializable {

	@SerializedName("status")
	private boolean status;

	@SerializedName("assetdetail")
	private List<Model_DetailAsset> assetdetail;

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setAssetdetail(List<Model_DetailAsset> assetdetail){
		this.assetdetail = assetdetail;
	}

	public List<Model_DetailAsset> getAssetdetail(){
		return assetdetail;
	}

	@Override
 	public String toString(){
		return 
			"Response_Detailasset{" + 
			"status = '" + status + '\'' + 
			",assetdetail = '" + assetdetail + '\'' + 
			"}";
		}
}