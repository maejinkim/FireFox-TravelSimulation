package com.example.travelsimulation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CountryActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtMsg;
    private Button btnSpain;
    private Button btnChina;
    private Button btnUSA;
    private Button btnVietnam;
    private Button btnFinish;

    private boolean check_spain;
    private boolean check_china;
    private boolean check_USA;
    private boolean check_vietnam;
    private boolean check_finish;
    private LinearLayout coutry;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        btnSpain = (Button) findViewById(R.id.btnSpain);
        btnChina = (Button) findViewById(R.id.btnChina);
        btnUSA = (Button) findViewById(R.id.btnUSA);
        btnVietnam = (Button) findViewById(R.id.btnVietnam);
        btnFinish = (Button) findViewById(R.id.btnFinish);
        coutry = (LinearLayout) findViewById(R.id.country);

        btnFinish.setOnClickListener(this);
        btnSpain.setOnClickListener(this);
        btnChina.setOnClickListener(this);
        btnUSA.setOnClickListener(this);
        btnVietnam.setOnClickListener(this);

        check_spain = false;
        check_china = false ;
        check_USA = false ;
        check_vietnam = false ;
        check_finish = false;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSpain){
            if(check_spain == false )
            {
                btnSpain.setBackgroundResource(R.drawable.spain2);
                coutry.setBackgroundResource(R.drawable.spain);

                check_spain = true;
            }
            else
            {
                btnSpain.setBackgroundResource(R.drawable.spain1);
                coutry.setBackgroundResource(R.drawable.countryback);
                check_spain = false;
            }

        }
        else if (v.getId() == R.id.btnChina){
            if(check_china == false )
            {
                btnChina.setBackgroundResource(R.drawable.china2);
                coutry.setBackgroundResource(R.drawable.china);
                check_china = true;
            }
            else
            {
                btnChina.setBackgroundResource(R.drawable.china1);
                coutry.setBackgroundResource(R.drawable.countryback);
                check_china = false;

            }

        }
        else if (v.getId() == R.id.btnUSA) {
            if(check_USA == false )
            {
                btnUSA.setBackgroundResource(R.drawable.usa2);
                coutry.setBackgroundResource(R.drawable.usa);
                check_USA = true;
            }
            else
            {
                btnUSA.setBackgroundResource(R.drawable.usa1);
                coutry.setBackgroundResource(R.drawable.countryback);
                check_USA = false;

            }

        }
        else if (v.getId() == R.id.btnVietnam) {
            if(check_vietnam == false )
            {
                btnVietnam.setBackgroundResource(R.drawable.vietnam2);
                coutry.setBackgroundResource(R.drawable.vietnam);
                check_vietnam = true;
            }
            else
            {
                btnVietnam.setBackgroundResource(R.drawable.vietnam1);
                coutry.setBackgroundResource(R.drawable.countryback);
                check_vietnam = false;

            }

        }
        else if (v.getId() == R.id.btnFinish) {

            startActivity(new Intent(getApplication(), MainActivity.class));
            this.finish();
//            if(check_finish == false )
//            {
//                startActivity(new Intent(getApplication(), MainActivity.class));
//                this.finish();
//            }
//            else
//            {
//                btnFinish.setBackgroundResource(R.drawable.finish1);
//                check_finish = false;
//
//            }

        }

    }
}