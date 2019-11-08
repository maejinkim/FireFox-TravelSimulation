package com.example.travelsimulation;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class RoomActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnHotel;
    private Button btnGuesthouse;
    private Button btnRoad;
    private Button btnFinish;
    private LinearLayout layout;

    int room = 5;
    private boolean check_finish;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        layout = (LinearLayout) findViewById(R.id.layout_room);
        btnHotel = (Button) findViewById(R.id.btnHotel);
        btnGuesthouse = (Button) findViewById(R.id.btnGuesthouse);
        btnRoad = (Button) findViewById(R.id.btnRoad);
        btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(this);
        btnHotel.setOnClickListener(this);
        btnGuesthouse.setOnClickListener(this);
        btnRoad.setOnClickListener(this);
        check_finish = false;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnHotel){

            if(room != 0) {
                btnHotel.setBackgroundResource(R.drawable.hotel2);
                layout.setBackgroundResource(R.drawable.hotel);
                room = 0;
            }
            else {
                layout.setBackgroundResource(R.drawable.room);
                btnHotel.setBackgroundResource(R.drawable.hotel1);
                room = 5;
            }

        }
        else if (v.getId() == R.id.btnGuesthouse){
            if(room == 1)
            {
                layout.setBackgroundResource(R.drawable.guesthouse);
                btnGuesthouse.setBackgroundResource(R.drawable.guesthouse2);
                room = 1;
            }
            else
            {
                layout.setBackgroundResource(R.drawable.room);
                btnGuesthouse.setBackgroundResource(R.drawable.guesthouse1);
                room = 5;

            }

        }
        else if (v.getId() == R.id.btnRoad) {
            if(room == 2)
            {
                layout.setBackgroundResource(R.drawable.road);
                btnRoad.setBackgroundResource(R.drawable.road2);
                room = 2;
            }
            else
            {
                layout.setBackgroundResource(R.drawable.room);
                btnRoad.setBackgroundResource(R.drawable.road1);
                room = 5;

            }

        }
        else if (v.getId() == R.id.btnFinish) {
            if(room != 5)
            {
                int money = ((App)getApplication()).getMoney();
                if (room == 0){
                    money -= 50;
                }
                else if (room == 1){
                    money -= 30;
                }
                ((App)getApplication()).setMoney(money);
                startActivity(new Intent(getApplication(), MainActivity.class));
                this.finish();
            }
        }
    }
}