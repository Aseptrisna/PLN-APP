package com.omkabel1995.pln.Controller;

import android.util.Log;


import com.omkabel1995.pln.Model.Model_Users;
import com.omkabel1995.pln.Response.Response_Login;
import com.omkabel1995.pln.Server.ApiServices;
import com.omkabel1995.pln.Server.InitRetrofit;
import com.omkabel1995.pln.View.ViewUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class User {
    final ViewUser users;
    public User(ViewUser users) {
        this.users = users;
    }
    public void UserRegsiter(String username, String password, String status){
        Call<ResponseBody> call = InitRetrofit.getInstance().getApi().UserDaftar(username,password,status);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getString("status").equals("true")){
                            Log.d("response api", jsonRESULTS.toString());
                            String Message=jsonRESULTS.getString("message");
                            users.Berhasil(Message, Message);
                        } else {
                            try {
                                Log.d("response api", jsonRESULTS.toString());
                                String Message=jsonRESULTS.getString("message");
                                users.Gagal(Message);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        String error_message ="Ada Masalah Internet";
                        users.No_Internet(error_message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.v("debug", "onFailure: ERROR > " + t.toString());
                try {
                    String error_message ="Server Tidak Merespon";
                    users.No_Internet(error_message);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }
    public void  UserLogin(String Username,String Password){
        ApiServices api = InitRetrofit.getInstance().getApi();
        Call<Response_Login> menuCall = api.UserLogin(Username,Password);
        menuCall.enqueue(new Callback<Response_Login>() {
            @Override
            public void onResponse(Call<Response_Login> call, Response<Response_Login> response) {
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    List<Model_Users> datauser= response.body().getUser();
                    boolean status = response.body().isStatus();
                    if (status){
                        try {
                            users.Berhasil(datauser);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        try {
                            String Message="Login Gagal";
                            users.Gagal(Message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<Response_Login> call, Throwable t) {
                try {
                    String Message="Tidak Ada Internet";
                    users.No_Internet(Message);
                    t.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
