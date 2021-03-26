package com.omkabel1995.pln.Controller;

import android.util.Log;

import com.omkabel1995.pln.Model.Model_Pln;
import com.omkabel1995.pln.Model.Model_Users;
import com.omkabel1995.pln.Response.Response_Login;
import com.omkabel1995.pln.Response.Response_Pln;
import com.omkabel1995.pln.Server.ApiServices;
import com.omkabel1995.pln.Server.InitRetrofit;
import com.omkabel1995.pln.View.ViewPln;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pln {
    final ViewPln Plns;
    public Pln(ViewPln plns) {
        Plns = plns;
    }

    public void getPln(){
        ApiServices api = InitRetrofit.getInstance().getApi();
        Call<Response_Pln> menuCall = api.getPln();
        menuCall.enqueue(new Callback<Response_Pln>() {
            @Override
            public void onResponse(Call<Response_Pln> call, Response<Response_Pln> response) {
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    List<Model_Pln> dataaset= response.body().getAset();
                    boolean status = response.body().isDataaset();
                    if (status){
                        try {
                            Plns.Berhasil(dataaset);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        try {
                            String Message="Login Gagal";
                            Plns.gagal(Message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<Response_Pln> call, Throwable t) {
                try {
                    String Message="Tidak Ada Internet";
                    Plns.no_internet(Message);
                    t.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
