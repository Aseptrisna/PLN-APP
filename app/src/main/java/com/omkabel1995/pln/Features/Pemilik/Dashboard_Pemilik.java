package com.omkabel1995.pln.Features.Pemilik;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.omkabel1995.pln.Adapter.Adapter_Pln;
import com.omkabel1995.pln.Controller.Pln;
import com.omkabel1995.pln.Model.Model_Pln;
import com.omkabel1995.pln.Model.Model_Users;
import com.omkabel1995.pln.R;
import com.omkabel1995.pln.View.ViewPln;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dashboard_Pemilik extends AppCompatActivity implements ViewPln {
    @BindView(R.id.Home)
    ImageView Home;
    @BindView(R.id.datamaster)
    ImageView datamaster;
    @BindView(R.id.Monitoring)
    ImageView Monitoring;
    @BindView(R.id.Laporan)
    ImageView Laporan;
    @BindView(R.id.ListPln)
    RecyclerView ListPln;
    ProgressDialog loading;
    Pln pln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard__pemilik);
        ButterKnife.bind(this);
        loading=new ProgressDialog(this);
        pln=new Pln(this);
        loading.setMessage("...Loading...");
        loading.setCancelable(true);
        loading.show();
        ListPln.setHasFixedSize(true);
        GridLayoutManager llm=new GridLayoutManager(this,1);
        ListPln.setLayoutManager(llm);
        pln.getPln();

    }

    public void Home(View view) {
    }

    public void Datamaster(View view) {
    }

    public void Monitoring(View view) {
    }

    public void Laporan(View view) {
    }

    @Override
    public void Berhasil(List<Model_Pln> datapln) {
        loading.dismiss();
        Adapter_Pln adapter = new Adapter_Pln(this, datapln);
        ListPln.setAdapter(adapter);

    }
    @Override
    public void gagal(String Message){
        loading.dismiss();
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void no_internet(String Message){
        loading.dismiss();
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
    }
}