package com.example.travelsimulation;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BadActivity extends AppCompatActivity {

    LinearLayout layout;
    int index;
    int bad[] = {R.drawable.bad_sagosa};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad);

        index = ((App)getApplication()).getBad();

        layout = (LinearLayout) findViewById(R.id.layout_bad);
        layout.setBackgroundResource(bad[index]);
    }
}
