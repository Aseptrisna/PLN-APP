package com.omkabel1995.pln.Features;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.omkabel1995.pln.Controller.User;
import com.omkabel1995.pln.Features.Pemilik.Dashboard_Pemilik;
import com.omkabel1995.pln.Model.Model_Users;
import com.omkabel1995.pln.R;
import com.omkabel1995.pln.Session.SharedPrefManager;
import com.omkabel1995.pln.View.ViewUser;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_Signin extends AppCompatActivity implements ViewUser {
    @BindView(R.id.LoginEmail)
    TextInputEditText LoginEmail;
    @BindView(R.id.LoginPassword)
    TextInputEditText LoginPassword;
    @BindView(R.id.btn_signin)
    Button btnSignin;
    @BindView(R.id.FromLogin)
    LinearLayout FromLogin;
    User users;
    SharedPrefManager sharedPrefManager;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__signin);
        ButterKnife.bind(this);
        loading=new ProgressDialog(this);
        users=new User(this);
        sharedPrefManager=new SharedPrefManager(this);
        ceksession();
    }
    private void ceksession(){
        SharedPrefManager sharedPrefManager=new SharedPrefManager(this);
        if (sharedPrefManager.getSudahLogin()){
           goto_dashboard();
        }
    }

    private void goto_dashboard() {
        startActivity(new Intent(Menu_Signin.this, Dashboard_Pemilik.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }

    public void Login(View view) {
        Validasi();

    }
    private void Validasi() {
        if (LoginEmail.getText().toString().equals("") || LoginPassword.getText().toString().equals("")) {
            LoginEmail.setFocusable(false);
            LoginPassword.setFocusable(false);
            showSnackbar("Lengkapi data terlebih dahulu");
        } else {
            String usename=LoginEmail.getText().toString();
            String password= LoginPassword.getText().toString();
            RequestLogin(usename,password);
        }

    }
    private void RequestLogin(String username, String password) {
        users.UserLogin(username,password);
    }
    public void showSnackbar(String message) {
        Snackbar snackbar = Snackbar.make(FromLogin,""+message , Snackbar.LENGTH_INDEFINITE)
                .setAction("Ulangi", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(FromLogin, "Silahkan Ulangi", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                        LoginEmail.setFocusableInTouchMode(true);
                        LoginPassword.setFocusableInTouchMode(true);
                    }
                });
        snackbar.show();
    }

    @Override
    public void Berhasil(String message, String Message) {
        loading.dismiss();
        showSnackbar(Message);

    }

    @Override
    public void Gagal(String Message) {
        loading.dismiss();
        showSnackbar(Message);

    }

    @Override
    public void No_Internet(String Message) {
        loading.dismiss();
        showSnackbar(Message);

    }

    @Override
    public void Berhasil(List<Model_Users> datauser) {
        loading.dismiss();
        String Username=datauser.get(0).getUsername();
        String Password=datauser.get(0).getPassword();
        String Status=datauser.get(0).getStatus();
        sharedPrefManager.saveSPString(SharedPrefManager.SP_Username, Username);
        sharedPrefManager.saveSPString(SharedPrefManager.SP_Password, Password);
        sharedPrefManager.saveSPString(SharedPrefManager.SP_Status, Status);
        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
        goto_dashboard();
    }
}