package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OpenActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btnPre;
    private Button btnNew;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        btnPre = (Button) findViewById(R.id.btnPre);
        btnNew = (Button) findViewById(R.id.btnNew);
        btnPre.setOnClickListener(this);
        btnNew.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnNew){
            startActivity(new Intent(getApplication(), NameActivity.class));
            this.finish();
        }
        else if (v.getId() == R.id.btnPre){
        }

    }
}
