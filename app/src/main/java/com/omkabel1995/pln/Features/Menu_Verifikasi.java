package com.omkabel1995.pln.Features;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.omkabel1995.pln.Controller.Asset;
import com.omkabel1995.pln.Features.Pemilik.Dashboard_Pemilik;
import com.omkabel1995.pln.R;
import com.omkabel1995.pln.Response.Model_DetailAsset;
import com.omkabel1995.pln.View.ViewAsset;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_Verifikasi extends AppCompatActivity implements ViewAsset {

    @BindView(R.id.VerNomorAsset)
    TextView VerNomorAsset;
    @BindView(R.id.VerKodeAsset)
    TextView VerKodeAsset;
    @BindView(R.id.VerDeskrispiAsset)
    TextView VerDeskrispiAsset;
    @BindView(R.id.statusSekrang)
    TextView statusSekrang;
    @BindView(R.id.Verstatus)
    Spinner Verstatus;
    @BindView(R.id.VerketeranganAsset)
    TextView VerketeranganAsset;
    String Status_Asset []={"Warning","Hati-Hati","Normal"};
    Asset asset;
    ProgressDialog Loading;
    String ID,KETERANGAN;
    ArrayAdapter ja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__verifikasi);
        ButterKnife.bind(this);
        ja = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Status_Asset);
        ja.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Verstatus.setAdapter(ja);
        Loading=new ProgressDialog(this);
        asset=new Asset(this);
        ID=getIntent().getExtras().getString("ID");
        String NOMOR_ASSET=getIntent().getExtras().getString("NOMOR_ASSET");
        String KODE_ASSET=getIntent().getExtras().getString("KODE_ASSET");
        String DESKRIPSI=getIntent().getExtras().getString("DESKRIPSI");
        String STATUS=getIntent().getExtras().getString("STATUS");
       KETERANGAN=getIntent().getExtras().getString("KETERANGAN");
        VerNomorAsset.setText(NOMOR_ASSET);
        VerKodeAsset.setText(KODE_ASSET);
        VerDeskrispiAsset.setText(DESKRIPSI);
        statusSekrang.setText(STATUS);
        VerketeranganAsset.setText(KETERANGAN);

    }

    public void Verifikasi(View view) {
        Loading.setMessage("..Loading...");
        Loading.setCancelable(true);
        Loading.show();
        String Status=Verstatus.getSelectedItem().toString();
        String ket=VerketeranganAsset.getText().toString();
        asset.Verifikasi(Status,ID,ket);
    }

    @Override
    public void Berhasil_getdata(List<Model_DetailAsset> data) {

    }

    @Override
    public void Gagal_getdata(String Message) {
        Loading.dismiss();
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void Berhasil(String Message) {
        Loading.dismiss();
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
        back();

    }

    @Override
    public void No_Internet(String Message) {
        Loading.dismiss();
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        back();
//        super.onBackPressed();
    }

    private void back() {
        Intent intent = new Intent(this, Dashboard_Pemilik.class);
        startActivity(intent);
        finish();
    }

}