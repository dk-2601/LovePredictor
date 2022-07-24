package com.example.lovepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static final int  SPLASH_TIMER = 2000;

    TextView mtextsplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mtextsplash = findViewById(R.id.textsplash);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        mtextsplash.setAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);

                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);
    }
}