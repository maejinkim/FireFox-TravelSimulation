package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HappyActivity extends AppCompatActivity {

    Button btnRestart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy);

        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((App)getApplication()).setAllClear();
                startActivity(new Intent(getApplication(), OpenActivity.class));
            }
        });

    }
}
