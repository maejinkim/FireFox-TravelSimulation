package com.example.travelsimulation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnschedule1;
    private Button btnschedule2;
    private Button btnschedule3;
    private Button btnschedule4;
    private Button btnschedule5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        btnschedule1 = (Button) findViewById(R.id.btnSchedule1);
        btnschedule2 = (Button) findViewById(R.id.btnSchedule2);
        btnschedule3 = (Button) findViewById(R.id.btnSchedule3);
        btnschedule4 = (Button) findViewById(R.id.btnSchedule4);
        btnschedule5 = (Button) findViewById(R.id.btnSchedule5);

        btnschedule1.setOnClickListener(this);
        btnschedule2.setOnClickListener(this);
        btnschedule3.setOnClickListener(this);
        btnschedule4.setOnClickListener(this);
        btnschedule5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSchedule1:
                ShowTravelDialog();
                break;
            case R.id.btnSchedule2:
                ShowResturantlDialog();
                break;
            case R.id.btnSchedule3:
                ShowShoppingDialog();
                break;
            case R.id.btnSchedule4:
                ShowRestDialog();
                break;
            case R.id.btnSchedule5:
                ShowBackDialog();
                break;

        }
    }

    private void ShowTravelDialog()
    {
        LayoutInflater dialog = LayoutInflater.from(this);
        final LinearLayout dlg_layout = (LinearLayout) View.inflate(this, R.layout.dialog_travel, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setView(dlg_layout);
        Button btnSchedule1 = (Button) dlg_layout.findViewById(R.id.btnSchedule1);
        Button btnSchedule2 = (Button) dlg_layout.findViewById(R.id.btnSchedule2);
        Button btnSchedule3 = (Button) dlg_layout.findViewById(R.id.btnSchedule3);
        Button btnSchedule4 = (Button) dlg_layout.findViewById(R.id.btnSchedule4);
        Button btnSchedule5 = (Button) dlg_layout.findViewById(R.id.btnSchedule5);

        ((App)getApplication()).setPlace(0);
        btnSchedule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App)getApplication()).setPlaceIndex(0);
                startActivity(new Intent(getApplication(), TravelActivity.class));
                ScheduleActivity.this.finish();
            }
        });

        btnSchedule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App)getApplication()).setPlaceIndex(1);
                startActivity(new Intent(getApplication(), TravelActivity.class));
                ScheduleActivity.this.finish();
            }
        });

        btnSchedule3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App)getApplication()).setPlaceIndex(2);
                startActivity(new Intent(getApplication(), TravelActivity.class));
                ScheduleActivity.this.finish();
            }
        });
        dlg.show();
    }

    private void ShowResturantlDialog()
    {
        LayoutInflater dialog = LayoutInflater.from(this);
        final LinearLayout dlg_layout = (LinearLayout) View.inflate(this, R.layout.dialog_resturant, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setView(dlg_layout);

        ((App)getApplication()).setPlace(1);

        Button btnSchedule1 = (Button) dlg_layout.findViewById(R.id.btnSchedule1);
        Button btnSchedule2 = (Button) dlg_layout.findViewById(R.id.btnSchedule2);
        Button btnSchedule3 = (Button) dlg_layout.findViewById(R.id.btnSchedule3);

        btnSchedule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowRes1Dialog();
            }
        });

        btnSchedule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowRes2Dialog();
            }
        });

        btnSchedule3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowRes3Dialog();
            }
        });

        dlg.show();
        //this.finish();
    }

    private void ShowShoppingDialog()
    {
        LayoutInflater dialog = LayoutInflater.from(this);
        final LinearLayout dlg_layout = (LinearLayout) View.inflate(this, R.layout.dialog_shopping, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setView(dlg_layout);
        Button btnSchedule1 = (Button) dlg_layout.findViewById(R.id.btnSchedule1);
        Button btnSchedule2 = (Button) dlg_layout.findViewById(R.id.btnSchedule2);
        Button btnSchedule3 = (Button) dlg_layout.findViewById(R.id.btnSchedule3);
        dlg.show();
    }

    private void ShowRestDialog()
    {


        LayoutInflater dialog = LayoutInflater.from(this);
        final LinearLayout dlg_layout = (LinearLayout) View.inflate(this, R.layout.dialog_rest, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setView(dlg_layout);
        Button btnSchedule1 = (Button) dlg_layout.findViewById(R.id.btnSchedule1);
        Button btnSchedule2 = (Button) dlg_layout.findViewById(R.id.btnSchedule2);
        Button btnSchedule3 = (Button) dlg_layout.findViewById(R.id.btnSchedule3);

        btnSchedule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSchedule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSchedule3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dlg.show();
    }

    private void ShowBackDialog()
    {
        LayoutInflater dialog = LayoutInflater.from(this);

        final LinearLayout dlg_layout = (LinearLayout) View.inflate(this, R.layout.dialog_back, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setView(dlg_layout);

        Button btnSchedule1 = (Button) dlg_layout.findViewById(R.id.btnSchedule1);
        Button btnSchedule2 = (Button) dlg_layout.findViewById(R.id.btnSchedule2);

        btnSchedule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), HappyActivity.class));
                ScheduleActivity.this.finish();

            }
        });

        btnSchedule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dlg.show();
    }

    private void ShowRes1Dialog()
    {
        LayoutInflater dialog = LayoutInflater.from(this);
        final LinearLayout dlg_layout = (LinearLayout) View.inflate(this, R.layout.dialog_resturant_res1, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setView(dlg_layout);
        Button btnSchedule1 = (Button) dlg_layout.findViewById(R.id.btnSchedule1);
        Button btnSchedule2 = (Button) dlg_layout.findViewById(R.id.btnSchedule2);

        btnSchedule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App)getApplication()).setPlaceIndex(0);
                startActivity(new Intent(getApplication(), ResturantActivity.class));
                ScheduleActivity.this.finish();

            }
        });

        btnSchedule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dlg.show();
    }

    private void ShowRes2Dialog()
    {
        LayoutInflater dialog = LayoutInflater.from(this);
        final LinearLayout dlg_layout = (LinearLayout) View.inflate(this, R.layout.dialog_resturant_res2, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setView(dlg_layout);
        Button btnSchedule1 = (Button) dlg_layout.findViewById(R.id.btnSchedule1);
        Button btnSchedule2 = (Button) dlg_layout.findViewById(R.id.btnSchedule2);

        btnSchedule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App)getApplication()).setPlaceIndex(1);
                startActivity(new Intent(getApplication(), ResturantActivity.class));
                ScheduleActivity.this.finish();

            }
        });

        btnSchedule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dlg.show();
    }

    private void ShowRes3Dialog()
    {
        LayoutInflater dialog = LayoutInflater.from(this);
        final LinearLayout dlg_layout = (LinearLayout) View.inflate(this, R.layout.dialog_resturant_res3, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setView(dlg_layout);
        dlg.show();
    }


}