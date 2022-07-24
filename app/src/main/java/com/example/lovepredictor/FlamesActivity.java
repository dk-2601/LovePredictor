package com.example.lovepredictor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FlamesActivity extends AppCompatActivity {

    EditText mfirstname;
    EditText msecondname;

    android.widget.Button mcalculatebutton;

    RelativeLayout mresult;

    CardView mcardviewofimage;
    ImageView mimageinimageview;
    TextView mmessagetext;
    TextView mresultlabel;

    androidx.appcompat.widget.Toolbar mtoolbarofflames;

    ImageButton mbackbuttonofflames;

    String s1,s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flames);

        mfirstname = findViewById(R.id.firstname);
        msecondname = findViewById(R.id.secondname);

        mcalculatebutton = findViewById(R.id.calculatebutton);

        mresult = findViewById(R.id.result);

        mcardviewofimage = findViewById(R.id.cardviewofimage);
        mimageinimageview = findViewById(R.id.imageinimageview);
        mmessagetext = findViewById(R.id.messagetext);
        mresultlabel = findViewById(R.id.resultlabel);

        mtoolbarofflames = findViewById(R.id.toolbarofflames);
        setSupportActionBar(mtoolbarofflames);

        mbackbuttonofflames = findViewById(R.id.backbuttonofflames);

        mbackbuttonofflames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlamesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mcalculatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1 = mfirstname.getText().toString();
                s2 = msecondname.getText().toString();

                if(s1.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter the name",Toast.LENGTH_SHORT).show();
                    mresult.setVisibility(View.INVISIBLE);
                }
                else if(s2.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter the name",Toast.LENGTH_SHORT).show();
                    mresult.setVisibility(View.INVISIBLE);
                }
                else
                {

                    flamesCalculate();
                }

            }
        });


    }

    private void flamesCalculate() {

        StringBuilder s1 = new StringBuilder(mfirstname.getText().toString().toLowerCase().trim());
        StringBuilder s2 = new StringBuilder(msecondname.getText().toString().toLowerCase().trim());

        char c,d,e='\0';
        for(int i=0;i<s1.length();i++)
        {
            c=s1.charAt(i);
            for(int j=0;j<s2.length();j++)
            {
                d=s2.charAt(j);
                if(c==d)
                {
                    s1.deleteCharAt(i);
                    s2.deleteCharAt(j);
                    i--;
                    j--;
                    break;
                }
            }
        }
        s1=s1.append(s2);
        int k=6,l=0;
        String s3="FLAMES";
        while(k>1)
        {
            for(int m=1;m<s1.length();m++)
            {
                if(s3.charAt(l)!='X')
                {
                    l++;
                    if(l==6)
                        l=0;
                }
                else
                {
                    l++;
                    if(l==6)
                        l=0;
                    m--;
                }
            }
            while(s3.charAt(l)=='X')
            {
                l++;
                if(l==6)
                    l=0;
            }
            s3=s3.substring(0,l)+"X"+s3.substring(l+1);
            k--;
        }

        for(int i=0;i<s3.length();i++)
        {
            if(s3.charAt(i)!='X')
                e=s3.charAt(i);
        }
        switch(e)
        {
            case 'F':
                mresult.setVisibility(View.VISIBLE);
                mimageinimageview.setImageResource(R.drawable.frd);
                mresultlabel.setText("FRIENDS");
                mmessagetext.setText("Friends make you laugh a little harder, cry a little, and smile a lot more. Friends bring the kind of happiness that never fades. There is nothing on this earth more to be prized than true friendship\uD83D\uDC9B");
                break;
            case 'L':
                mresult.setVisibility(View.VISIBLE);
                mimageinimageview.setImageResource(R.drawable.ll);
                mresultlabel.setText("LOVE");
                mmessagetext.setText("LOVE...LOVE and only LOVE; Love is a sentiment not able to be characterized by words. There is only one happiness in life to love and to be loved\uD83D\uDC96");
                break;
            case 'A':
                mresult.setVisibility(View.VISIBLE);
                mimageinimageview.setImageResource(R.drawable.affectionimg);
                mresultlabel.setText("AFFECTION");
                mmessagetext.setText("You both may have a mutual affection on each other;a gentle feeling of fondness,caring or liking. It is a moderate feeling or emotion compared to love. Unlike love, affection doesn't consist of passionate or romantic feelings. Yet, affection makes you feel safe and cared for.\uD83E\uDD70");
                break;
            case 'M':
                mresult.setVisibility(View.VISIBLE);
                mimageinimageview.setImageResource(R.drawable.mg);
                mresultlabel.setText("MARRIAGE");
                mmessagetext.setText("SOUL-MATES...two halves of the same soul joining together in lifes journey. Love is not about how much you say 'I LOVE YOU', but how much you can prove that it's true\uD83D\uDC8D ");
                break;
            case 'E':
                mresult.setVisibility(View.VISIBLE);
                mimageinimageview.setImageResource(R.drawable.tomandjerry);
                mresultlabel.setText("ENEMY");
                mmessagetext.setText("Your relationship will be like Tom and Jerry; no matter how many times you fight , you won't be apart. You tease each other,knock each other,irritate each other, but can't live without each other\uD83D\uDC99 ");
                break;
            case 'S':
                mresult.setVisibility(View.VISIBLE);
                mimageinimageview.setImageResource(R.drawable.sibe);
                mresultlabel.setText("SIBLINGS");
                mmessagetext.setText("Sisters/Brothers make the best friends in the world. Brothers and sisters are as close as hands and feet. Never miss them in any situation, we repeat never\uD83E\uDDE1");
                break;

            default :

                break;
        }
    
    }
}