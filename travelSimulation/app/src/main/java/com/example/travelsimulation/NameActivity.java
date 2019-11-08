package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {

    EditText editName;
    Button btnStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        editName = (EditText) findViewById(R.id.editName);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                if ( name.isEmpty()){
                    Toast.makeText(getApplication(), "이름을 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
                else{
                    //((App)getApplication()).setName(name);
                    startActivity(new Intent(getApplication(), MainActivity.class));
                    NameActivity.this.finish();
                }
            }
        });
    }
}
