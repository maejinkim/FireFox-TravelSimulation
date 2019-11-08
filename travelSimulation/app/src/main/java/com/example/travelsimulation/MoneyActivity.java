package com.example.travelsimulation;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MoneyActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout layout;
    Button btnStart;
    int backgrount[] = {R.drawable.money1, R.drawable.money2, R.drawable.money3, R.drawable.money4, R.drawable.money5, R.drawable.money6};
    int index;
    int speed = 100;
    int num = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_money);

        double random = Math.random();
        index = (int) (random * 6);

        layout = (LinearLayout) findViewById(R.id.layout_money);
        btnStart = (Button) findViewById(R.id.btnMoney);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 6; j++){
                layout.setBackgroundResource(backgrount[j]);
                try{
                    Thread.sleep(100+50*i);
                }catch (InterruptedException e){
                    e.printStackTrace();;
                }
            }
        }
    }
}
