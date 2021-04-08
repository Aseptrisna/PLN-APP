package com.omkabel1995.pln.Features;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.omkabel1995.pln.Adapter.Adapter_Asset;
import com.omkabel1995.pln.Controller.Asset;
import com.omkabel1995.pln.Model.Model_Pln;
import com.omkabel1995.pln.R;
import com.omkabel1995.pln.Response.Model_DetailAsset;
import com.omkabel1995.pln.View.ViewAsset;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_DataAsset extends AppCompatActivity implements ViewAsset {
    @BindView(R.id.TopAsset)
    TextView TopAsset;
    @BindView(R.id.CariAsset)
    EditText CariAsset;
    @BindView(R.id.Btncari)
    Button Btncari;
    @BindView(R.id.ListAsset)
    RecyclerView ListAsset;
    @BindView(R.id.FromdataAsset)
    LinearLayout Tampilan;
    ProgressDialog Loading;
    Asset asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__data_asset);
        ButterKnife.bind(this);
        String Title=getIntent().getExtras().getString("NAMA");
        String Id=getIntent().getExtras().getString("ID");
        TopAsset.setText("Data Asset "+" "+Title);
        Loading=new ProgressDialog(this);
        asset=new Asset(this);
        ListAsset.setHasFixedSize(true);
        GridLayoutManager llmm=new GridLayoutManager(this,1);
        ListAsset.setLayoutManager(llmm);
        getdata(Id);

    }

    private void getdata(String id) {
        Loading.setMessage("..Loading...");
        Loading.setCancelable(true);
        Loading.show();
        asset.getassetbyid(id);
    }

    public void addasset(View view) {
        goto_addaset();

    }

    private void goto_addaset() {
        Intent intent=new Intent(Menu_DataAsset.this,Menu_AddAsset.class);
        String Id=getIntent().getExtras().getString("ID");
        intent.putExtra("ID", Id);
        startActivity(intent);
        finish();
    }

    public void cariasset(View view) {
        String kode=CariAsset.getText().toString();
        if (kode.equals("")){
            Toast.makeText(this, "Kode Asset Harus diisi!!!!", Toast.LENGTH_SHORT).show();
        }else {
            Loading.setMessage("..Loading...");
            Loading.setCancelable(true);
            Loading.show();
            asset.getassetbykode(kode);
        }

    }
    @Override
    public void Berhasil_getdata(List<Model_DetailAsset> data){
        Loading.dismiss();
        Adapter_Asset adapter_asset=new Adapter_Asset(this,data);
        ListAsset.setAdapter(adapter_asset);

    }
    @Override
    public void Gagal_getdata(String Message){
        Loading.dismiss();
        showSnackbar(Message);

    }
    @Override
    public void Berhasil(String Message){
        Loading.dismiss();
        showSnackbar(Message);

    }
    @Override
    public void No_Internet(String Message){
        Loading.dismiss();
        showSnackbar(Message);

    }
    public void showSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(Tampilan,""+message , Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        snackbar.dismiss();
                    }
                });
        snackbar.show();
    }
}