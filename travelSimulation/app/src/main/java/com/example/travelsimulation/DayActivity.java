package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DayActivity extends AppCompatActivity {

    //hungry, joy, stamina
    RelativeLayout layout;
    ImageView stateImg[];
    TextView txtMsg, txtMoney;

    int state[];
    int money, day, index = 0;

    int backIndex;
    int back[] = {R.drawable.hotel, R.drawable.guesthouse,R.drawable.road};
    String msg[][] = {{"오늘은 첫쨋날","무엇을 해볼까?"},
            {"오늘은 둘쨋날", "무엇을 해볼까?"}};

    //카사밀라, 사그라다, 구엘공원, 몬주이크, 론다절벽
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

        txtMsg.setText(msg[day][index]);
        index++;
        txtMsg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (index == 2){
                    startActivity(new Intent(getApplication(), ScheduleActivity.class));
                    DayActivity.this.finish();
                }
                else {
                    txtMsg.setText(msg[day][index]);
                    index++;
                }
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
