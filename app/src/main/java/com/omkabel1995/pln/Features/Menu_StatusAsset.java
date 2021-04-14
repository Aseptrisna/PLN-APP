package com.omkabel1995.pln.Features;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.omkabel1995.pln.Controller.Asset;
import com.omkabel1995.pln.R;
import com.omkabel1995.pln.Response.Model_DetailAsset;
import com.omkabel1995.pln.View.ViewAsset;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_StatusAsset extends AppCompatActivity implements ViewAsset {

    @BindView(R.id.namaaset)
    TextView namaaset;
    @BindView(R.id.Status)
    TextView Status;
    @BindView(R.id.JumlahStatus)
    TextView JumlahStatus;
    @BindView(R.id.Kembali)
    Button Kembali;
    ProgressDialog Loading;
    Asset asset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__status_asset);
        ButterKnife.bind(this);
        String Title=getIntent().getExtras().getString("NAMA");
        String Id=getIntent().getExtras().getString("ID");
        namaaset.setText("Parameter Status Data Kesehatan Pembangkit Pada "+Title);
        Loading=new ProgressDialog(this);
        asset=new Asset(this);
        getdata(Id);
    }

    private void getdata(String id) {
        Loading.setMessage("..Loading...");
        Loading.setCancelable(true);
        Loading.show();
        asset.count(id);
    }

    public void Back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void Berhasil_getdata(List<Model_DetailAsset> data) {
        Loading.dismiss();
        }



    @Override
    public void Gagal_getdata(String Message) {
        Loading.dismiss();
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
        Status.setText("");

    }

    @Override
    public void Berhasil(String Message) {
        Loading.dismiss();
        JumlahStatus.setText(Message);

    }

    @Override
    public void No_Internet(String Message) {
        Loading.dismiss();
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
        Status.setText("");

    }
}