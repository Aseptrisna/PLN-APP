package com.omkabel1995.pln.Server;


import com.omkabel1995.pln.Response.Response_Login;
import com.omkabel1995.pln.Response.Response_Pln;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
//
//    @FormUrlEncoded
//    @POST("userlogin.php")
//    Call<Response_Login> UserLogin(
//            @Field("email") String email,
//            @Field("password") String password
//    );
//
//    @FormUrlEncoded
//    @POST("userregister.php")
//    Call<ResponseBody> UserDaftar(
//            @Field("nama") String nama,
//            @Field("email") String email,
//            @Field("password") String password
//    );
//    @FormUrlEncoded
//    @POST("userupdate.php")
//    Call<ResponseBody> UserUpadate(
//            @Field("id") String id,
//            @Field("nama") String nama,
//            @Field("email") String email,
//            @Field("password") String password
//    );
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
//    @FormUrlEncoded
//    @POST("cekJadwal.php")
//    Call<ResponseBody> RequestJadwal(
//            @Field("imei") String Imai,
//            @Field("package") String Package
//    );
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
