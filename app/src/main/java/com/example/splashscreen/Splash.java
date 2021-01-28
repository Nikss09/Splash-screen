package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    Handler handler;
    Handler textHandler;
    CountDownTimer waitTimer;
    TextView text;
    String s1,s2="";
    char c;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView image=findViewById(R.id.img1);
        image.setX(-800);
        image.animate().translationXBy(1700).rotation(720).setDuration(5000);


        s1="Lucifer was an Imposter.";

        textHandler=new Handler();
        textHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                waitTimer = new CountDownTimer(7000, 100) {
                    public void onTick(long millisUntilFinished) {
                        if(i<s1.length())
                        {
                            c = s1.charAt(i);
                            s2 = s2 + c;
                            text = findViewById(R.id.textView);
                            text.setText(s2);
                            i++;
                            //called every 300 milliseconds, which could be used to
                            //send messages or some other action
                        }
                    }

                    public void onFinish() {
                        //After 60000 milliseconds (60 sec) finish current
                        //if you would like to execute something when time finishes
                    }
                }.start();

            }
        },2500);


        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                waitTimer.cancel();
                Intent intent=new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },6000);
    }
}