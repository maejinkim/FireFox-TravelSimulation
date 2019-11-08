package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AirportActivity extends AppCompatActivity implements View.OnClickListener {

    int index = 0;
    RelativeLayout layout;
    String msg[] = {"와! 공항에 도착했다!", "드디어 스페인으로 가는구나!", "스페인에서는 어떤 일이 일어날까?"};

    TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        layout = (RelativeLayout) findViewById(R.id.layout_airport);


        txtMsg.setText(msg[index]);
        index++;
        txtMsg.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txtMsg){

            if (index == 3){
                layout.setBackgroundResource(R.drawable.airport_dark);
                Handler handler = new Handler();
                handler.postDelayed(new airportHandler(), 3000);
            }
            else{
                txtMsg.setText(msg[index]);
                index++;
            }
        }
    }

    private class airportHandler implements Runnable{
        @Override
        public void run() {
            startActivity(new Intent(getApplication(), DayActivity.class));
            AirportActivity.this.finish();
        }
    }
}
