package com.example.travelsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int index = 0;
    int msgIndex;
    String msg[][] = {{"여행 가고싶다!","어디로 가야하지?"},
            {"스페인으로 가자!", "통장에 돈이 얼마 있었지..."},
            {"", "숙소를 미리 생각해보자!"}};

    TextView txtMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgIndex = ((App)getApplication()).getMsgIndex();
        txtMsg = (TextView) findViewById(R.id.txtMsg);

        if (msgIndex == 3)
        {
            txtMsg.setText("공항으로 떠나자!");
        }
        else {
            if (msgIndex == 2)
                msg[2][0] = String.valueOf(((App) getApplication()).getMoney()) + "만원이 있었네";

            txtMsg.setText(msg[msgIndex][index]);
            index++;
            txtMsg.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txtMsg){

            if (msgIndex == 0 && index == 2)
            {
                msgIndex++;
                ((App)getApplication()).setMsgIndex(msgIndex);
                startActivity(new Intent(getApplication(), CountryActivity.class));
                this.finish();
            }
            else if (msgIndex == 1 && index == 2)
            {
                msgIndex++;
                ((App)getApplication()).setMsgIndex(msgIndex);
                startActivity(new Intent(getApplication(), MoneyActivity.class));
                this.finish();
            }
            else if (msgIndex == 2 && index == 2)
            {
                msgIndex++;
                ((App)getApplication()).setMsgIndex(msgIndex);
                startActivity(new Intent(getApplication(), RoomActivity.class));
                this.finish();
            }
            else{
                txtMsg.setText(msg[msgIndex][index]);
                index++;
            }
        }
    }
}
