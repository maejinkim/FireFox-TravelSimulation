package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        layout = (LinearLayout) findViewById(R.id.layout_splash);

        Handler handler = new Handler();
        handler.postDelayed(new splashHandler1(), 300);


    }

    private class splashHandler1 implements Runnable{
        @Override
        public void run() {

            layout.setBackgroundResource(R.drawable.main2);
            Handler handler = new Handler();
            handler.postDelayed(new splashHandler2(), 300);
        }
    }

    private class splashHandler2 implements Runnable{
        @Override
        public void run() {
            layout.setBackgroundResource(R.drawable.main3);
            Handler handler = new Handler();
            handler.postDelayed(new splashHandler3(), 300);
        }
    }

    private class splashHandler3 implements Runnable{
        @Override
        public void run() {
            layout.setBackgroundResource(R.drawable.main4);
            Handler handler = new Handler();
            handler.postDelayed(new splashHandler4(), 300);
        }
    }

    private class splashHandler4 implements Runnable{
        @Override
        public void run() {
            layout.setBackgroundResource(R.drawable.main);
            Handler handler = new Handler();
            handler.postDelayed(new splashHandler5(), 500);
        }
    }

    private class splashHandler5 implements Runnable{
        @Override
        public void run() {
            startActivity(new Intent(getApplication(), OpenActivity.class));
            SplashActivity.this.finish();
        }
    }

    @Override
    public void onBackPressed() {

    }
}
