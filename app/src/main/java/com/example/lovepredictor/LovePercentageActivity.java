package com.example.lovepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LovePercentageActivity extends AppCompatActivity {

    EditText mfirstname;
    EditText msecondname;

    android.widget.Button mcalculatebutton;

    androidx.appcompat.widget.Toolbar mtoolbaroflovepercentage;

    ImageButton mbackbuttonoflovepercentage;

    RelativeLayout mresultRelativeLayout;
    TextView mresultlabel;

    String s1,s2;

    TextView mnamesofboth , mresultmessage;

    double sum1=0,sum2=0,per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_percentage);

        mfirstname = findViewById(R.id.firstname);
        msecondname = findViewById(R.id.secondname);
        mcalculatebutton = findViewById(R.id.calculatebutton);
        mtoolbaroflovepercentage = findViewById(R.id.toolbaroflovepercentage);
        setSupportActionBar(mtoolbaroflovepercentage);
        mbackbuttonoflovepercentage = findViewById(R.id.backbuttonoflovepercentage);
        mresultRelativeLayout = findViewById(R.id.resultRelativeLyout);
        mresultlabel = findViewById(R.id.resultlabelpercent);

        mnamesofboth = findViewById(R.id.namesofboth);
        mresultmessage = findViewById(R.id.resultmessage);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_anim);

        mbackbuttonoflovepercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LovePercentageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mcalculatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = mfirstname.getText().toString().toLowerCase().trim();
                s2 = msecondname.getText().toString().toLowerCase().trim();

                if(s1.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Enter the name", Toast.LENGTH_SHORT).show();
                }
                else if(s2.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Enter the name", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    char[] arr1= s1.toCharArray();
                    char[] arr2= s2.toCharArray();
                    int n=0,i=0;
                    for(char ch : arr1)
                    {
                        n=(int) arr1[i++];
                        sum1=sum1+n;
                    }
                    //System.out.println(sum1);
                    i=0;
                    for(char ch : arr2)
                    {
                        n=(int) arr2[i++];
                        sum2=sum2+n;
                    }
                    //System.out.println(sum2);
                    if(sum1<=sum2){
                        per=(sum1/sum2)*100;
                    }

                    else
                    {
                        per=(sum2/sum1)*100;

                    }
                    per = Math.round(per);
                    mresultRelativeLayout.setVisibility(View.VISIBLE);
                    mresultlabel.setText(String.format("%.0f", per) + "%");
                    mnamesofboth.setVisibility(View.VISIBLE);
                    mnamesofboth.setText(s1.toUpperCase() + " ❤ " + s2.toUpperCase());
                    mresultmessage.setVisibility(View.VISIBLE);
                    mresultmessage.setAnimation(anim);
                    mresultmessage.setText("You Both are " + String.format("%.0f", per) + "% Compatible...");

                    //
                    sum1=0;
                    sum2=0;
                    //

                }
            }
        });

    }
}