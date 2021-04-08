package com.omkabel1995.pln.Features.Pemilik;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.omkabel1995.pln.Adapter.Adapter_Nama;
import com.omkabel1995.pln.Adapter.Adapter_Nama1;
import com.omkabel1995.pln.Adapter.Adapter_Nama2;
import com.omkabel1995.pln.Adapter.Adapter_Pln;
import com.omkabel1995.pln.Controller.Pln;
import com.omkabel1995.pln.Features.Menu_Signin;
import com.omkabel1995.pln.Model.Model_Pln;
import com.omkabel1995.pln.Model.Model_Users;
import com.omkabel1995.pln.R;
import com.omkabel1995.pln.Session.SharedPrefManager;
import com.omkabel1995.pln.View.ViewPln;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dashboard_Pemilik extends AppCompatActivity implements ViewPln {
    @BindView(R.id.LinearHome)
    LinearLayout LinearHome;
    @BindView(R.id.Lineardatmaster)
    LinearLayout Lineardatamaster;
    @BindView(R.id.LinearLaporan)
    LinearLayout LinearLaporan;
    @BindView(R.id.LineraPengaturan)
    LinearLayout Linearpengaturan;
    @BindView(R.id.LinearMonitoring)
    LinearLayout Linearmonitoring;
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
    @BindView(R.id.setting)
    ImageView Setting;
    ProgressDialog loading;
    Pln pln;
    SharedPrefManager sharedPrefManager;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    TextView Username,Role;
    RecyclerView listdatamaster,listlaporan,listmonitoring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard__pemilik);
        ButterKnife.bind(this);
        LinearHome.setVisibility(View.GONE);
        Lineardatamaster.setVisibility(View.GONE);
        Linearmonitoring.setVisibility(View.GONE);
        LinearLaporan.setVisibility(View.GONE);
        Linearpengaturan.setVisibility(View.GONE);
        loading=new ProgressDialog(this);
        sharedPrefManager=new SharedPrefManager(this);
        pln=new Pln(this);
        loading.setMessage("...Loading...");
        loading.setCancelable(true);
        loading.show();
        ListPln.setHasFixedSize(true);
        GridLayoutManager llm=new GridLayoutManager(this,1);
        ListPln.setLayoutManager(llm);
        pln.getPln();
        chex_role();

    }

    private void chex_role() {
        String Role=sharedPrefManager.getSP_Status();
        if (Role.equals("user")){
            LinearHome.setVisibility(View.VISIBLE);
            Linearpengaturan.setVisibility(View.VISIBLE);
            Linearmonitoring.setVisibility(View.VISIBLE);
            LinearLaporan.setVisibility(View.GONE);
            Lineardatamaster.setVisibility(View.GONE);
        }else if (Role.equals("admin")){
            LinearHome.setVisibility(View.VISIBLE);
            Linearpengaturan.setVisibility(View.VISIBLE);
            Linearmonitoring.setVisibility(View.VISIBLE);
            LinearLaporan.setVisibility(View.VISIBLE);
            Lineardatamaster.setVisibility(View.VISIBLE);
        }else {
            Toast.makeText(this, "Anda Belum Login !!!!!", Toast.LENGTH_SHORT).show();
        }

    }



    public void Home(View view) {
    }

    public void Datamaster(View view) {
        dialog = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.list_namapln, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.ic_data);
        dialog.setTitle("Data Master");
        listdatamaster=(RecyclerView) dialogView.findViewById(R.id.Listnamapln);
        loading.setMessage("...Loading...");
        loading.setCancelable(true);
        loading.show();
        listdatamaster.setHasFixedSize(true);
        GridLayoutManager llmm=new GridLayoutManager(this,1);
        listdatamaster.setLayoutManager(llmm);
        pln.getPln();
        dialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    public void Monitoring(View view) {
        dialog = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.list_namapln, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.ic_monitoring);
        dialog.setTitle("Monitoring");
        listmonitoring=(RecyclerView) dialogView.findViewById(R.id.Listnamapln);
        loading.setMessage("...Loading...");
        loading.setCancelable(true);
        loading.show();
        listmonitoring.setHasFixedSize(true);
        GridLayoutManager llmm=new GridLayoutManager(this,1);
        listmonitoring.setLayoutManager(llmm);
        pln.getPln();
        dialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void Laporan(View view) {
        dialog = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.list_namapln, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.ic_message);
        dialog.setTitle("Laporan");
        listlaporan=(RecyclerView) dialogView.findViewById(R.id.Listnamapln);
        loading.setMessage("...Loading...");
        loading.setCancelable(true);
        loading.show();
        listlaporan.setHasFixedSize(true);
        GridLayoutManager llmm=new GridLayoutManager(this,1);
        listlaporan.setLayoutManager(llmm);
        pln.getPln();
        dialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void Berhasil(List<Model_Pln> datapln) {
        loading.dismiss();
        Adapter_Pln adapter = new Adapter_Pln(this, datapln);
        ListPln.setAdapter(adapter);
        Adapter_Nama adapterNm = new Adapter_Nama(this, datapln);
        listdatamaster.setAdapter(adapterNm);
        Adapter_Nama1 adapterNm1 = new Adapter_Nama1(this, datapln);
        listlaporan.setAdapter(adapterNm1);
        Adapter_Nama2 adapterNm2 = new Adapter_Nama2(this, datapln);
        listmonitoring.setAdapter(adapterNm2);
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

    public void Setting(View view) {
        String username=sharedPrefManager.getSP_Username();
        String role=sharedPrefManager.getSP_Status();
        dialog = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.list_profile, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.ic_profile);
        dialog.setTitle("Profile");
        Username=(TextView)dialogView.findViewById(R.id.Username);
        Role=(TextView)dialogView.findViewById(R.id.Role);
        Username.setText(username);
        Role.setText(role);
        dialog.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sharedPrefManager.saveSPBoolean(sharedPrefManager.SP_SUDAH_LOGIN,false);
                startActivity(new Intent(Dashboard_Pemilik.this, Menu_Signin.class));
                finish();
            }
        });

        dialog.setNegativeButton("Kembali", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    }
