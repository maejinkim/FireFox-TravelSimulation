package com.example.travelsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int index = 0;
    String msg[] = {"여행 가고싶다!","여행 가려면 돈이 필요한데...","통장에 돈이 얼마나 남아 있지?"};

    TextView txtMsg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        txtMsg.setText(msg[index]);
        index++;
        txtMsg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txtMsg){

            if (index == 3)
            {

            }


            txtMsg.setText(msg[index]);
            index++;
        }
    }
}
