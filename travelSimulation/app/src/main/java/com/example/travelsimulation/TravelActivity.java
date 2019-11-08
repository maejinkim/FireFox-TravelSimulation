package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TravelActivity extends AppCompatActivity {

    //hungry, joy, stamina
    RelativeLayout layout;
    ImageView stateImg[];
    TextView txtMsg, txtMoney;

    int state[];
    int money, travelIndex, index = 0;

    int travel[] = {R.drawable.casa, R.drawable.cathedral,R.drawable.ronda, R.drawable.guell, R.drawable.monju};
    String msg[][] = {{"이곳은 카사밀라.","안토니오 가우디의 작품으로 유네스코 세계 문화 유산이군!", "굉장히 특이한 건물이네"},
            {"이곳은 사그라다 파밀리아 성당", "사그라다는 성스러운\n파밀리아는 가족을 뜻하는군", "엄청 웅장한걸!"},
            {"이곳이 바로 헤밍웨이가 소설을 집필하며 말년을 보냈던 론다구나!", "풍경이 아름다운 누에보 다리와 절벽 위 오솔길이 헤밍웨이 산책길로 불리다니, 멋진걸?","200m나 되는 론다 전망대에서 이곳의 일몰을 보면 정말 아름답겠네."}};

    //카사밀라, 사그라다, 구엘공원, 몬주이크, 론다절벽
    @Override
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
                    if (travelIndex == 1 || travelIndex == 2){
                        startActivity(new Intent(getApplication(), TravelSelectActivity.class));
                        TravelActivity.this.finish();
                    }
                    else {
                        ((App)getApplication()).setDownState(-1);
                        ((App)getApplication()).setUpState(-1);
                        startActivity(new Intent(getApplication(), ResultActivity.class));
                        TravelActivity.this.finish();
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
