package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BadActivity extends AppCompatActivity {

    RelativeLayout layout;
    Button btnRestart;
    int index;
    int bad[] = {R.drawable.bad_sagosa};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad);

        index = ((App)getApplication()).getBad();
        btnRestart = (Button) findViewById(R.id.btnRestart);

        layout = (RelativeLayout) findViewById(R.id.layout_bad);
        layout.setBackgroundResource(bad[index]);
        btnRestart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((App)getApplication()).setAllClear();
                startActivity(new Intent(getApplication(), OpenActivity.class));
            }
        });
    }
}
