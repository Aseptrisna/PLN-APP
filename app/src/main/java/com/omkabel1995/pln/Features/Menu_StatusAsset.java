package com.omkabel1995.pln.Features;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.omkabel1995.pln.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_StatusAsset extends AppCompatActivity {

    @BindView(R.id.namaaset)
    TextView namaaset;
    @BindView(R.id.Status)
    TextView Status;
    @BindView(R.id.JumlahStatus)
    TextView JumlahStatus;
    @BindView(R.id.Kembali)
    Button Kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__status_asset);
        ButterKnife.bind(this);
    }

    public void Back(View view) {
    }
}