package com.omkabel1995.pln.Features;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.omkabel1995.pln.Controller.Asset;
import com.omkabel1995.pln.R;
import com.omkabel1995.pln.Response.Model_DetailAsset;
import com.omkabel1995.pln.View.ViewAsset;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_AddAsset extends AppCompatActivity implements ViewAsset {
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    @BindView(R.id.AddNomorAsset)
    EditText AddNomorAsset;
    @BindView(R.id.AddKodeAsset)
    EditText AddKodeAsset;
    @BindView(R.id.AddDeskrispiAsset)
    EditText AddDeskrispiAsset;
    @BindView(R.id.AddTglAsset)
    EditText AddTglAsset;
    @BindView(R.id.addasset)
    Button addasset;
    @BindView(R.id.FromAddaseet)
    LinearLayout FromAddaseet;
    ProgressDialog Loading;
    Asset asset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__add_asset);
        ButterKnife.bind(this);
        Loading=new ProgressDialog(this);
        asset=new Asset(this);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    }

    public void adddataasset(View view) {
        String Id=getIntent().getExtras().getString("ID");
        String nomor_asset=AddNomorAsset.getText().toString();
        String kode_asset=AddKodeAsset.getText().toString();
        String deskripsi=AddDeskrispiAsset.getText().toString();
        String tanggal=AddTglAsset.getText().toString();
        if (nomor_asset.equals("")||kode_asset.equals("")||deskripsi.equals("")||tanggal.equals("")){
            showSnackbar("Form Harus di isi Semua!!!!");
        }else {
            Loading.setMessage("...");
            Loading.setCancelable(true);
            Loading.show();
            asset.addAsset(Id,nomor_asset,kode_asset,deskripsi,tanggal);
        }

    }

    @Override
    public void Berhasil_getdata(List<Model_DetailAsset> data) {

    }

    @Override
    public void Gagal_getdata(String Message) {
        Loading.dismiss();
        showSnackbar(Message);

    }

    @Override
    public void Berhasil(String Message) {
        clears();
        Loading.dismiss();
        showSnackbar(Message);

    }

    private void clears() {
        AddDeskrispiAsset.setText("");
        AddKodeAsset.setText("");
        AddNomorAsset.setText("");
        AddTglAsset.setText("");
    }

    @Override
    public void No_Internet(String Message) {
        Loading.dismiss();
        showSnackbar(Message);

    }

    public void getTanggal(View view) {
        Calendar newCalendar = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            newCalendar = Calendar.getInstance();
        }if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            newCalendar = Calendar.getInstance();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Calendar newDate = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        newDate = Calendar.getInstance();
                    }
                    newDate.set(year, monthOfYear, dayOfMonth);
                    AddTglAsset.setText(dateFormatter.format(newDate.getTime()));
                }

            },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        }
        datePickerDialog.show();
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
}