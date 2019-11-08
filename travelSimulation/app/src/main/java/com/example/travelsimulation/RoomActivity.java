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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class RoomActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnHotel;
    private Button btnGuesthouse;
    private Button btnRoad;
    private Button btnFinish;

    private boolean check_hotel;
    private boolean check_guesthouse;
    private boolean check_road;
    private boolean check_finish;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        btnHotel = (Button) findViewById(R.id.btnHotel);
        btnGuesthouse = (Button) findViewById(R.id.btnGuesthouse);
        btnRoad = (Button) findViewById(R.id.btnRoad);
        btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(this);
        btnHotel.setOnClickListener(this);
        btnGuesthouse.setOnClickListener(this);
        btnRoad.setOnClickListener(this);
        check_hotel = false;
        check_guesthouse = false ;
        check_road = false ;
        check_finish = false;

        Intent intent = getIntent(); /*데이터 수신*/

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnHotel){
            if(check_hotel == false )
            {
                btnHotel.setBackgroundResource(R.drawable.hotel2);
                check_hotel = true;
            }
            else
            {
                btnHotel.setBackgroundResource(R.drawable.hotel1);
                check_hotel = false;
            }

        }
        else if (v.getId() == R.id.btnGuesthouse){
            if(check_guesthouse == false )
            {
                btnGuesthouse.setBackgroundResource(R.drawable.guesthouse2);
                check_guesthouse = true;
            }
            else
            {
                btnGuesthouse.setBackgroundResource(R.drawable.guesthouse1);
                check_guesthouse = false;

            }

        }
        else if (v.getId() == R.id.btnRoad) {
            if(check_road == false )
            {
                btnRoad.setBackgroundResource(R.drawable.road2);
                check_road = true;
            }
            else
            {
                btnRoad.setBackgroundResource(R.drawable.road1);
                check_road = false;

            }

        }
        else if (v.getId() == R.id.btnFinish) {
            if(check_finish == false )
            {
                btnFinish.setBackgroundResource(R.drawable.finish3);
                check_finish = true;
            }
            else
            {
                btnFinish.setBackgroundResource(R.drawable.finish1);
                check_finish = false;

            }

        }

    }
}