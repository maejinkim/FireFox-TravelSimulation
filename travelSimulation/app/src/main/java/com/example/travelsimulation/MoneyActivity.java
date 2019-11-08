package com.example.travelsimulation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MoneyActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout layout;
    Button btnStart;
    int backgrount[] = {R.drawable.money1, R.drawable.money6, R.drawable.money5, R.drawable.money4, R.drawable.money3, R.drawable.money2};
    int money;
    int index = 0;
    int num = 0;
    boolean check = false;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_money);

        Random random = new Random();
        money = random.nextInt(3);

        Log.d("index: ",String.valueOf(money));

        if (money != 2)
            money+=4;


        Log.d("index: ",String.valueOf(money));

        layout = (LinearLayout) findViewById(R.id.layout_money);
        btnStart = (Button) findViewById(R.id.btnMoney);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnMoney){
            mediaPlayer = MediaPlayer.create(MoneyActivity.this, R.raw.slotmachine);
            mediaPlayer.start();
            layout.setBackgroundResource(backgrount[index]);
            index++;
            Handler handler = new Handler();
            handler.postDelayed(new moneyhandler(), 50*num);
        }
    }

    private class moneyhandler implements Runnable{
        @Override
        public void run() {

            if (index == 6){
                num++;
                index = 0;
            }

            layout.setBackgroundResource(backgrount[index]);

            if (num == 4 && index == money){
                Handler handler = new Handler();
                handler.postDelayed(new nexthandler(), 500);
            }
            else {
                index++;
                Handler handler = new Handler();
                handler.postDelayed(new moneyhandler(), 50*num);
            }
        }

    }

    private class nexthandler implements Runnable {
        @Override
        public void run() {

            if (check){
                startActivity(new Intent(getApplication(), MainActivity.class));
                MoneyActivity.this.finish();
            }
            else {
                if (money == 2){
                    ((App)getApplication()).setMoney(100);
                    layout.setBackgroundResource(R.drawable.money100);
                }
                else if (money == 4) {
                    ((App) getApplication()).setMoney(200);
                    layout.setBackgroundResource(R.drawable.money200);
                }
                else {
                    ((App) getApplication()).setMoney(300);
                    layout.setBackgroundResource(R.drawable.money300);
                }
                check = true;
                Handler handler = new Handler();
                handler.postDelayed(new nexthandler(), 1000);
            }
        }
    }

}