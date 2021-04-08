package com.omkabel1995.pln.Response;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class Model_DetailAsset implements Serializable {

	@SerializedName("id")
	private String id;

	@SerializedName("id_asset")
	private String idAsset;

	@SerializedName("Nomor_Asset")
	private String nomorAsset;

	@SerializedName("Kode_Asset")
	private String kodeAsset;

	@SerializedName("Deskripsi")
	private String deskripsi;

	@SerializedName("Status")
	private String status;

	@SerializedName("Keterangan")
	private String keterangan;

	@SerializedName("Tanggal")
	private Object tanggal;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setIdAsset(String idAsset){
		this.idAsset = idAsset;
	}

	public String getIdAsset(){
		return idAsset;
	}

	public void setNomorAsset(String nomorAsset){
		this.nomorAsset = nomorAsset;
	}

	public String getNomorAsset(){
		return nomorAsset;
	}

	public void setKodeAsset(String kodeAsset){
		this.kodeAsset = kodeAsset;
	}

	public String getKodeAsset(){
		return kodeAsset;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setTanggal(Object tanggal){
		this.tanggal = tanggal;
	}

	public Object getTanggal(){
		return tanggal;
	}

	@Override
 	public String toString(){
		return 
			"Model_DetailAsset{" + 
			"id = '" + id + '\'' + 
			",id_asset = '" + idAsset + '\'' + 
			",nomor_Asset = '" + nomorAsset + '\'' + 
			",kode_Asset = '" + kodeAsset + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			",status = '" + status + '\'' + 
			",keterangan = '" + keterangan + '\'' + 
			",tanggal = '" + tanggal + '\'' + 
			"}";
		}
}