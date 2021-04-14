package com.omkabel1995.pln.Features;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.omkabel1995.pln.Adapter.Adapter_Asset;
import com.omkabel1995.pln.Adapter.Adapter_Monitoring;
import com.omkabel1995.pln.Controller.Asset;
import com.omkabel1995.pln.R;
import com.omkabel1995.pln.Response.Model_DetailAsset;
import com.omkabel1995.pln.Session.SharedPrefManager;
import com.omkabel1995.pln.View.ViewAsset;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_MonitoringAset extends AppCompatActivity implements ViewAsset,AdapterView.OnItemClickListener {
    @BindView(R.id.Title_monitoring)
    TextView TitleMonitoring;
    @BindView(R.id.keterangan)
    TextView keterangan;
    @BindView(R.id.warning)
    TextView warning;
    @BindView(R.id.valuewarning)
    TextView valuewarning;
    @BindView(R.id.hatihati)
    TextView hatihati;
    @BindView(R.id.valuehatihati)
    TextView valuehatihati;
    @BindView(R.id.normal)
    TextView normal;
    @BindView(R.id.valuenormal)
    TextView valuenormal;
    @BindView(R.id.status)
    Spinner status;
    @BindView(R.id.cariasset)
    EditText cariasset;
    @BindView(R.id.Btncari)
    Button Btncari;
    @BindView(R.id.List_monitoring)
    RecyclerView ListMonitoring;
    String Status_Asset []={"Semua","Warning","Hati-Hati","Normal",""};
    @BindView(R.id.FromAddaseet)
    LinearLayout FromAddaseet;
    Asset asset;
    ProgressDialog Loading;
    String Id;
    ArrayAdapter ja;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__monitoring_aset);
        ButterKnife.bind(this);
        String Title=getIntent().getExtras().getString("NAMA");
        Id=getIntent().getExtras().getString("ID");
        TitleMonitoring.setText("Monitoring Kesehatan "+ Title);
         ja = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Status_Asset);
        ja.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status.setAdapter(ja);
        Loading=new ProgressDialog(this);
        asset=new Asset(this);
        ListMonitoring.setHasFixedSize(true);
        GridLayoutManager llmm=new GridLayoutManager(this,1);
        ListMonitoring.setLayoutManager(llmm);
        getdata(Id);


    }
    private void getdata(String id) {
        Loading.setMessage("..Loading...");
        Loading.setCancelable(true);
        Loading.show();
        asset.getassetbyid(id);
    }
    private void getStatus(String status) {
        Loading.setMessage("..Loading...");
        Loading.setCancelable(true);
        Loading.show();
        asset.getStatus(status,Id);
    }

    public void carimonitoring(View view) {
        String kode=cariasset.getText().toString();
        String Status=status.getSelectedItem().toString();
//        Toast.makeText(this, Status, Toast.LENGTH_SHORT).show();
        if (kode.equals("")){
            if (Status.equals("Semua")) {
                getdata(Id);
            }else if (Status.equals("Hati-Hati")) {
                getStatus(Status);
            }else if (Status.equals("Normal")) {
                getStatus(Status);
            }else if (Status.equals("Warning")) {
                getStatus(Status);
            }
//            Toast.makeText(this, "Kode Asset Harus diisi!!!!", Toast.LENGTH_SHORT).show();
//        }else if (Status.equals("Semua")) {
//            getdata(Id);
//        }else if (Status.equals("Hati-Hati")) {
//            getStatus(Status);
//        }else if (Status.equals("Normal")) {
//            getStatus(Status);
//        }else if (Status.equals("Warning")){
//            getStatus(Status);
        }  else {
            Loading.setMessage("..Loading...");
            Loading.setCancelable(true);
            Loading.show();
            asset.getassetbykode(kode);
        }
    }

    @Override
    public void Berhasil_getdata(List<Model_DetailAsset> data) {
        Loading.dismiss();
        ListMonitoring.setVisibility(View.VISIBLE);
        Adapter_Monitoring adapter_asset=new Adapter_Monitoring(this,data);
        ListMonitoring.setAdapter(adapter_asset);

    }

    @Override
    public void Gagal_getdata(String Message) {
        Loading.dismiss();
        showSnackbar(Message);
        ListMonitoring.setVisibility(View.GONE);

    }

    @Override
    public void Berhasil(String Message) {
        Loading.dismiss();
        showSnackbar(Message);

    }

    @Override
    public void No_Internet(String Message) {
        Loading.dismiss();
        showSnackbar(Message);
        ListMonitoring.setVisibility(View.GONE);


    }
    public void showSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(FromAddaseet,""+message , Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        snackbar.dismiss();
                    }
                });
        snackbar.show();
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),Status_Asset[position],Toast.LENGTH_SHORT).show();
        Log.d("data",Status_Asset[position]);
//        Toast.makeText(getApplicationContext(),JenisKelamin[position],Toast.LENGTH_SHORT).show();
//        jenisakun=JenisAkun[position];
    }
}