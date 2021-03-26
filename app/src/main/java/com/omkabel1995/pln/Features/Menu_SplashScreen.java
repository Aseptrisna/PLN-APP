package com.omkabel1995.pln.Features;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.omkabel1995.pln.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_SplashScreen extends AppCompatActivity {
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.SplashScreen_item)
    LinearLayout SplashScreenItem;
    @BindView(R.id.SplashScreen)
    LinearLayout SplashScreen;
    Animation uptodown, downtoup,Fadein,FadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__splash_screen);
        ButterKnife.bind(this);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        Fadein = AnimationUtils.loadAnimation(this, R.anim.to_left);
        FadeOut= AnimationUtils.loadAnimation(this, R.anim.to_right);
        icon.setAnimation(FadeOut);
        SplashScreenItem.setAnimation(Fadein);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goto_login();
            }
        }, 3000);
    }

    private void goto_login() {
        Intent intent=new Intent(Menu_SplashScreen.this,Menu_Signin.class);
        startActivity(intent);
        finish();
    }
}