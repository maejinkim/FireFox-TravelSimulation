package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DayNextActivity extends AppCompatActivity {

    //hungry, joy, stamina
    RelativeLayout layout;
    ImageView stateImg[];
    TextView txtMsg, txtMoney;

    int state[];
    int money, day;

    int backIndex;
    int back[] = {R.drawable.hotel, R.drawable.guesthouse,R.drawable.road};
    String msg = "숙소로 돌아와서 휴식을 취했다.";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        stateImg = new ImageView[3];
        state = new int[3];
        day = ((App)getApplication()).getDay();
        backIndex = ((App)getApplication()).getRoom();

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        txtMoney = (TextView) findViewById(R.id.txtMoney);

        layout = (RelativeLayout) findViewById(R.id.layout_place);
        stateImg[0] = (ImageView) findViewById(R.id.imgHungry);
        stateImg[1] = (ImageView) findViewById(R.id.imgJoy);
        stateImg[2] = (ImageView) findViewById(R.id.imgStamina);

        txtMsg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(((App)getApplication()).getRoom() ==0 ) // 호텔
                {
                    ((App)getApplication()).setStamina(((App)getApplication()).getStamina()+2);
                }
                else if(((App)getApplication()).getRoom() ==1 ) // 게스트하우
                {
                    ((App)getApplication()).setStamina(((App)getApplication()).getStamina()+1);
                }

                startActivity(new Intent(getApplication(), DayActivity.class));
                DayNextActivity.this.finish();
            }
        });
        layout.setBackgroundResource(back[backIndex]);
        getState();
    }


    void getState(){
        money = ((App)getApplication()).getMoney();
        state[0] = ((App)getApplication()).getHungry();
        state[1] = ((App)getApplication()).getJoy();
        state[2] = ((App)getApplication()).getStamina();

        for (int i = 0; i < 3; i++){
            if (state[i] == 5)
                stateImg[i].setBackgroundResource(R.drawable.status_100);
            else if(state[i] == 4)
                stateImg[i].setBackgroundResource(R.drawable.status_75);
            else if(state[i] == 3)
                stateImg[i].setBackgroundResource(R.drawable.status_50);
            else if(state[i] == 2)
                stateImg[i].setBackgroundResource(R.drawable.status_25);
            else if(state[i] == 1)
                stateImg[i].setBackgroundResource(R.drawable.status_0);
        }
        txtMoney.setText(String.valueOf(money)+"만원");

    }

}