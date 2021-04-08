package com.omkabel1995.pln.Features;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Menu_EditAsset extends AppCompatActivity implements ViewAsset {

    @BindView(R.id.EditNomorAsset)
    EditText EditNomorAsset;
    @BindView(R.id.EditKodeAsset)
    EditText EditKodeAsset;
    @BindView(R.id.EditDeskrispiAsset)
    EditText EditDeskrispiAsset;
    @BindView(R.id.editasset)
    Button editasset;
    ProgressDialog Loading;
    Asset asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__edit_asset);
        ButterKnife.bind(this);
        Loading=new ProgressDialog(this);
        asset=new Asset(this);
        String ID=getIntent().getExtras().getString("ID");
        String NOMOR_ASSET=getIntent().getExtras().getString("NOMOR_ASSET");
        String KODE_ASSET=getIntent().getExtras().getString("KODE_ASSET");
        String DESKRIPSI=getIntent().getExtras().getString("DESKRIPSI");
        EditNomorAsset.setText(NOMOR_ASSET);
        EditDeskrispiAsset.setText(DESKRIPSI);
        EditKodeAsset.setText(KODE_ASSET);
    }

    public void editasse(View view) {
        Loading.setMessage(".....");
        Loading.setCancelable(true);
        Loading.show();
        String ID=getIntent().getExtras().getString("ID");
        asset.editAsset(ID,EditNomorAsset.getText().toString(),EditKodeAsset.getText().toString(),EditDeskrispiAsset.getText().toString());

    }

    @Override
    public void Berhasil_getdata(List<Model_DetailAsset> data) {

    }

    @Override
    public void Gagal_getdata(String Message) {
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
        Loading.dismiss();

    }

    @Override
    public void Berhasil(String Message) {
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
        Loading.dismiss();
        Goto_dashboard();

    }

    private void Goto_dashboard() {
        Intent intent=new Intent(Menu_EditAsset.this, Dashboard_Pemilik.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void No_Internet(String Message) {
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
        Loading.dismiss();

    }
}