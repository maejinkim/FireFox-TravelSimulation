package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TravelSelectActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout layout;
    TextView txtSelect;
    Button btnSelect1;
    Button btnSelect2;
    int index;

    TextView txtMoney;
    int money;
    ImageView stateImg[];
    int state[];

    String msg[] = {"","입장료를 내고 들어가 볼까?","엄청난 풍경이다.\n사진을 찍어볼까?"};
    String select1[] = {"", "들어가 본다.","관광객에게 찍어달라고 부탁한다."};
    String select2[] = {"", "외부만 구경한다.","그냥 절벽을 구경한다."};
    int travel[] = {R.drawable.casa, R.drawable.cathedral, R.drawable.ronda, R.drawable.monju, R.drawable.guell};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);


        index = ((App)getApplication()).getPlaceIndex();
        txtSelect = (TextView) findViewById(R.id.txtSelect);
        btnSelect1 = (Button) findViewById(R.id.btnSelect1);
        btnSelect2 = (Button) findViewById(R.id.btnSelect2);
        layout = (RelativeLayout) findViewById(R.id.layout_select);

        state = new int[3];
        stateImg = new ImageView[3];
        txtMoney = (TextView) findViewById(R.id.txtMoney);
        stateImg[0] = (ImageView) findViewById(R.id.imgHungry);
        stateImg[1] = (ImageView) findViewById(R.id.imgJoy);
        stateImg[2] = (ImageView) findViewById(R.id.imgStamina);

        txtSelect.setText(msg[index]);
        btnSelect1.setText(select1[index]);
        btnSelect2.setText(select2[index]);
        layout.setBackgroundResource(travel[index]);
        btnSelect1.setOnClickListener(this);
        btnSelect2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSelect1){
            if (index == 1){
                ((App)getApplication()).setDownState(3);
                ((App)getApplication()).setDown(5);
                ((App)getApplication()).setUpState(1);
                ((App)getApplication()).setUp(2);
                startActivity(new Intent(getApplication(), ResultActivity.class));
            }
            //절벽 폰 뺏김     //hungry, joy, stamina
            if (index == 2){
                ((App)getApplication()).setResult("핸드폰을 도난당했다!\n\n");
                ((App)getApplication()).setDownState(1);
                ((App)getApplication()).setDown(2);
                ((App)getApplication()).setUpState(-1);
                startActivity(new Intent(getApplication(), ResultActivity.class));
            }
        }
        else if (v.getId() == R.id.btnSelect2){
            if (index == 1){
                ((App)getApplication()).setUpState(1);
                ((App)getApplication()).setUp(1);
                ((App)getApplication()).setDownState(-1);
                startActivity(new Intent(getApplication(), ResultActivity.class));
            }
            //절벽 bad
            if (index == 2){
                ((App)getApplication()).setBad(0);
                startActivity(new Intent(getApplication(), BadActivity.class));
            }
        }
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
