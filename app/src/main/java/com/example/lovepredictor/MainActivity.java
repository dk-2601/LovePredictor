package com.example.lovepredictor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar mtoolmarofmain;
    ImageButton mbackbuttonofmain;

    android.widget.Button mflamesbutton,mlovepercentagebutton;

    TextView migid;
    ImageView migimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolmarofmain = findViewById(R.id.toolbarofmain);
        mbackbuttonofmain = findViewById(R.id.backbuttonofmainactivity);

        mflamesbutton = findViewById(R.id.flamesbutton);
        mlovepercentagebutton = findViewById(R.id.lovepercentage);

        migid = findViewById(R.id.igid);
        migimg = findViewById(R.id.igimg);

        setSupportActionBar(mtoolmarofmain);

        mbackbuttonofmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mflamesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FlamesActivity.class);
                startActivity(intent);
            }
        });

        mlovepercentagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LovePercentageActivity.class);
                startActivity(intent);
            }
        });

        migimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/dk_2601/?hl=en"));
                startActivity(intent);
            }
        });

        migid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/dk_2601/?hl=en"));
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}