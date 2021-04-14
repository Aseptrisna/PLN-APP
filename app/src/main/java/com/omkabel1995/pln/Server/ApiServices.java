package com.omkabel1995.pln.Server;


import com.omkabel1995.pln.Response.Response_Detailasset;
import com.omkabel1995.pln.Response.Response_Login;
import com.omkabel1995.pln.Response.Response_Pln;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServices {
    @FormUrlEncoded
    @POST("UserLogin.php")
    Call<Response_Login> UserLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("UserRegister.php")
    Call<ResponseBody> UserDaftar(
            @Field("username") String username,
            @Field("password") String password,
            @Field("status") String status
    );


    @GET("getpln.php")
    Call<Response_Pln> getPln();
    @FormUrlEncoded
    @POST("getdetailasset.php")
    Call<Response_Detailasset> Assetgetbyid(
            @Field("id") String id
    );
    @FormUrlEncoded
    @POST("getdetailasset.php")
    Call<Response_Detailasset> Assetgetbykode(
            @Field("kode_asset") String id
    );
    @FormUrlEncoded
    @POST("getstatus.php")
    Call<Response_Detailasset> Assetgetbystatus(
            @Field("status") String status,
            @Field("id") String id
    );
    @GET("AssetDelete.php/{id}")
    Call<ResponseBody> deleteasset(
            @Query("id") String imei
    );
//
    @FormUrlEncoded
    @POST("AssetAdd.php")
    Call<ResponseBody> AssetAdd(
            @Field("id") String id,
            @Field("nomor") String nomor,
            @Field("kode") String kode,
            @Field("deskripsi") String deskripsi,
            @Field("tanggal") String tanggal
    );
    @FormUrlEncoded
    @POST("AssetUpdate.php")
    Call<ResponseBody> AssetUpadate(
            @Field("id") String id,
            @Field("nomor") String nomor,
            @Field("kode") String kode,
            @Field("deskripsi") String deskripsi
    );
//
//    @FormUrlEncoded
//    @POST("SimpanJadwal.php")
//    Call<ResponseBody> SimpanJadwal(
//            @Field("imei") String imei,
//            @Field("jammulai") String jammulai,
//            @Field("jamakhir") String jamakhir,
//            @Field("nama") String nama,
//            @Field("packeg") String packeg
//    );
    @FormUrlEncoded
    @POST("count.php")
    Call<ResponseBody> getCount(
            @Field("id") String Id
    );
    @FormUrlEncoded
    @POST("verifikasi.php")
    Call<ResponseBody> Verifikasi(
            @Field("status") String status,
            @Field("id") String id,
            @Field("keterangan") String keterangan
    );
//    @GET("getsensor.php")
//    Call<Response_Sensor> getsensor();
//////    @GET("getJawaban.php")
//////    Call<Response_Soal> tampil_pilihan();
////
////    @FormUrlEncoded
////    @POST("LupaPassword.php")
////    Call<ResponseBody> RequestPengingat(
////            @Field("imei") String Imei,
////            @Field("nama") String Nama
////    );
////    @FormUrlEncoded
////    @POST("ResetPassword.php")
////    Call<ResponseBody> ResetPassword(
////            @Field("Imei") String emai,
////            @Field("nama") String nama,
////            @Field("password") String password
////    );
////
////    @GET("TampilJadwal.php/{imei}")
////    Call<Response_Jadwal> tampil_jadwal(
////            @Query("imei") String imei
////            );
////    @FormUrlEncoded
////    @POST("DeleteJadwal.php")
////    Call<ResponseBody> deletejadwal(
////            @Field("id") String id
////    );
////    @GET("TampilUsage.php/{imei}{Tanggal}")
////    Call<Response_Jadwal> tampil_usage(
////            @Query("imei") String imei,
////            @Query("Tanggal") String Tanggal
////    );
//    @FormUrlEncoded
//    @POST("UpdateJadwal.php")
//    Call<ResponseBody> JadwalUpdate(
//            @Field("imei") String imai,
//            @Field("package") String Package,
//            @Field("status") String status
//    );
//
////    @GET("notifikasi.php/{imei}")
////    Call<Response_Jadwal> getnotifikasi(
////            @Query("imei") String imei
////    );
//
//    @FormUrlEncoded
//    @POST("SimpanUsage.php")
//    Call<ResponseBody> SimpanUsage(
//            @Field("imei") String imai,
//            @Field("package") String Package,
//            @Field("nama") String nama
//    );
//
//    @GET("lampu.php/{light}")
//    Call<ResponseBody> Lampu(
//            @Query("light") String light
//            );
//    @GET("kipas.php/{light}")
//    Call<ResponseBody> Kipas(
//            @Query("light") String light
//    );

}
