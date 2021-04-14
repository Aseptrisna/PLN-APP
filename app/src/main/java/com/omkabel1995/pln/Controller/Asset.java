package com.omkabel1995.pln.Controller;

import android.util.Log;

import com.omkabel1995.pln.Model.Model_Pln;
import com.omkabel1995.pln.Response.Model_DetailAsset;
import com.omkabel1995.pln.Response.Response_Detailasset;
import com.omkabel1995.pln.Response.Response_Pln;
import com.omkabel1995.pln.Server.ApiServices;
import com.omkabel1995.pln.Server.InitRetrofit;
import com.omkabel1995.pln.View.ViewAsset;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Asset {
    final ViewAsset viewAsset;


    public Asset(ViewAsset viewAsset) {
        this.viewAsset = viewAsset;
    }

    public void getassetbyid(String id){
        ApiServices api = InitRetrofit.getInstance().getApi();
        Call<Response_Detailasset> menuCall = api.Assetgetbyid(id);
        menuCall.enqueue(new Callback<Response_Detailasset>() {
            @Override
            public void onResponse(Call<Response_Detailasset> call, Response<Response_Detailasset> response) {
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    List<Model_DetailAsset> dataaset= response.body().getAssetdetail();
                    boolean status = response.body().isStatus();
                    if (status){
                        try {
                            viewAsset.Berhasil_getdata(dataaset);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        try {
                            String Message="Data Tidak di Temukan";
                           viewAsset.Gagal_getdata(Message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<Response_Detailasset> call, Throwable t) {
                try {
                    String Message="Tidak Ada Internet";
                    viewAsset.No_Internet(Message);
                    t.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
    public void getassetbykode(String kode){
        ApiServices api = InitRetrofit.getInstance().getApi();
        Call<Response_Detailasset> menuCall = api.Assetgetbykode(kode);
        menuCall.enqueue(new Callback<Response_Detailasset>() {
            @Override
            public void onResponse(Call<Response_Detailasset> call, Response<Response_Detailasset> response) {
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    List<Model_DetailAsset> dataaset= response.body().getAssetdetail();
                    boolean status = response.body().isStatus();
                    if (status){
                        try {
                            viewAsset.Berhasil_getdata(dataaset);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        try {
                            String Message="Data Tidak di Temukan";
                            viewAsset.Gagal_getdata(Message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<Response_Detailasset> call, Throwable t) {
                try {
                    String Message="Tidak Ada Internet";
                    viewAsset.No_Internet(Message);
                    t.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }
    public void addAsset(String id, String nomor_asset, String kode_asset, String deskripsi, String tanggal){
        retrofit2.Call<ResponseBody> call = InitRetrofit.getInstance().getApi().AssetAdd(id,nomor_asset,kode_asset,deskripsi,tanggal);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getString("status").equals("true")){
                            Log.d("response api", jsonRESULTS.toString());
                            String Berhasil=jsonRESULTS.getString("message");
                            viewAsset.Berhasil(Berhasil);
                        } else {
                            try {
                                Log.d("response api", jsonRESULTS.toString());
                                String Gagal=jsonRESULTS.getString("message");
                                Log.v("pesan",Gagal);
                                viewAsset.Gagal_getdata(Gagal);
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
                        viewAsset.No_Internet(error_message);
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
                    viewAsset.No_Internet(error_message);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
    public void editAsset(String ID, String Nomor, String kode, String deskripsi){
        retrofit2.Call<ResponseBody> call = InitRetrofit.getInstance().getApi().AssetUpadate(ID,Nomor,kode,deskripsi);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getString("status").equals("true")){
                            Log.d("response api", jsonRESULTS.toString());
                            String Berhasil=jsonRESULTS.getString("message");
                            viewAsset.Berhasil(Berhasil);
                        } else {
                            try {
                                Log.d("response api", jsonRESULTS.toString());
                                String Gagal=jsonRESULTS.getString("message");
                                Log.v("pesan",Gagal);
                                viewAsset.Gagal_getdata(Gagal);
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
                        viewAsset.No_Internet(error_message);
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
                    viewAsset.No_Internet(error_message);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }
    public void hapusAsset(String id){
        retrofit2.Call<ResponseBody> call = InitRetrofit.getInstance().getApi().deleteasset(id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getString("status").equals("true")){
                            Log.d("response api", jsonRESULTS.toString());
                            String Berhasil=jsonRESULTS.getString("message");
                            viewAsset.Berhasil(Berhasil);
                        } else {
                            try {
                                Log.d("response api", jsonRESULTS.toString());
                                String Gagal=jsonRESULTS.getString("message");
                                Log.v("pesan",Gagal);
                                viewAsset.Gagal_getdata(Gagal);
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
                        viewAsset.No_Internet(error_message);
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
                    viewAsset.No_Internet(error_message);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
    public void count (String Id){
        retrofit2.Call<ResponseBody> call = InitRetrofit.getInstance().getApi().getCount(Id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getString("status").equals("true")){
                            Log.d("response api", jsonRESULTS.toString());
                            String Berhasil=jsonRESULTS.getString("count");
                            viewAsset.Berhasil(Berhasil);
                        } else {
                            try {
                                Log.d("response api", jsonRESULTS.toString());
                                String Gagal=jsonRESULTS.getString("message");
                                Log.v("pesan",Gagal);
                                viewAsset.Gagal_getdata(Gagal);
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
                        viewAsset.No_Internet(error_message);
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
                    viewAsset.No_Internet(error_message);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
    public void getStatus(String status,String id){
        ApiServices api = InitRetrofit.getInstance().getApi();
        Call<Response_Detailasset> menuCall = api.Assetgetbystatus(status,id);
        menuCall.enqueue(new Callback<Response_Detailasset>() {
            @Override
            public void onResponse(Call<Response_Detailasset> call, Response<Response_Detailasset> response) {
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    List<Model_DetailAsset> dataaset= response.body().getAssetdetail();
                    boolean status = response.body().isStatus();
                    if (status){
                        try {
                            viewAsset.Berhasil_getdata(dataaset);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        try {
                            String Message="Data Tidak di Temukan";
                            viewAsset.Gagal_getdata(Message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<Response_Detailasset> call, Throwable t) {
                try {
                    String Message="Tidak Ada Internet";
                    viewAsset.No_Internet(Message);
                    t.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }


    public void Verifikasi(String status, String id, String keterangan) {
        retrofit2.Call<ResponseBody> call = InitRetrofit.getInstance().getApi().Verifikasi(status,id,keterangan);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getString("status").equals("true")){
                            Log.d("response api", jsonRESULTS.toString());
                            String Berhasil=jsonRESULTS.getString("message");
                            viewAsset.Berhasil(Berhasil);
                        } else {
                            try {
                                Log.d("response api", jsonRESULTS.toString());
                                String Gagal=jsonRESULTS.getString("message");
                                Log.v("pesan",Gagal);
                                viewAsset.Gagal_getdata(Gagal);
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
                        viewAsset.No_Internet(error_message);
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
                    viewAsset.No_Internet(error_message);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
