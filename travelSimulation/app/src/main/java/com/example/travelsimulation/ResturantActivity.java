package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResturantActivity extends AppCompatActivity {

    //hungry, joy, stamina
    RelativeLayout layout;
    ImageView stateImg[];
    TextView txtMsg, txtMoney;

    int state[];
    int money, travelIndex, index = 0;

    int travel[] = {R.drawable.botin, R.drawable.lamiventa};
    String msg[][] = {{"이곳이 해밍웨이의 단골식당인 Botin!","메인 메뉴인 새끼 돼지 구이를 시켜야지", "정말 훌륭한 맛이야..."},
            {"여기는 La Mi Venta!", "오늘은 해산물음식을 먹어볼까?", "해산물 빠에야 정말 맛있어!"}};



    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        stateImg = new ImageView[3];
        state = new int[3];
        travelIndex = ((App)getApplication()).getPlaceIndex();

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        txtMoney = (TextView) findViewById(R.id.txtMoney);

        layout = (RelativeLayout) findViewById(R.id.layout_place);
        stateImg[0] = (ImageView) findViewById(R.id.imgHungry);
        stateImg[1] = (ImageView) findViewById(R.id.imgJoy);
        stateImg[2] = (ImageView) findViewById(R.id.imgStamina);

        txtMsg.setText(msg[travelIndex][index]);
        index++;
        txtMsg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (index == 3){
                    if (travelIndex == 0){
                        ((App)getApplication()).setUpState(0);
                        ((App)getApplication()).setUp(2);
                        ((App)getApplication()).setDownState(3);
                        ((App)getApplication()).setDown(15);
                        startActivity(new Intent(getApplication(), ResultActivity.class));
                        ResturantActivity.this.finish();
                    }
                    else {
                        ((App)getApplication()).setUpState(0);
                        ((App)getApplication()).setUp(1);
                        ((App)getApplication()).setDownState(3);
                        ((App)getApplication()).setDown(3);
                        startActivity(new Intent(getApplication(), ResultActivity.class));
                        ResturantActivity.this.finish();
                    }
                }
                else {
                    txtMsg.setText(msg[travelIndex][index]);
                    index++;
                }
            }
        });
        layout.setBackgroundResource(travel[travelIndex]);
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
