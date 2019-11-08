package com.example.travelsimulation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView txtMoney;
    int money;
    ImageView stateImg[];
    int state[];

    RelativeLayout layout;
    TextView txtResult;
    int index, placeIndex, upState, downState, up, down;
    int place[][] = {{R.drawable.casa, R.drawable.cathedral, R.drawable.ronda},{R.drawable.botin, R.drawable.lamiventa}};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        index = ((App)getApplication()).getPlace();
        placeIndex = ((App)getApplication()).getPlaceIndex();
        upState = ((App)getApplication()).getUpState();
        downState = ((App)getApplication()).getDownState();

        layout = (RelativeLayout) findViewById(R.id.layout_result);
        txtResult = (TextView) findViewById(R.id.txtResult);

        state = new int[3];
        stateImg = new ImageView[3];
        txtMoney = (TextView) findViewById(R.id.txtMoney);
        stateImg[0] = (ImageView) findViewById(R.id.imgHungry);
        stateImg[1] = (ImageView) findViewById(R.id.imgJoy);
        stateImg[2] = (ImageView) findViewById(R.id.imgStamina);

        layout.setBackgroundResource(place[index][placeIndex]);
        setMsg();
        getState();
        txtResult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int dayIndex = ((App)getApplication()).getDayIndex();
                dayIndex++;
                if (dayIndex == 3)
                    startActivity(new Intent(getApplication(),DayNextActivity.class));
                else{
                    ((App)getApplication()).setDayIndex(dayIndex);
                    startActivity(new Intent(getApplication(), ScheduleActivity.class));
                }

            }
        });
    }

    void setMsg(){
        int joy = ((App)getApplication()).getJoy();
        int stamina = ((App)getApplication()).getStamina();
        int hungry = ((App)getApplication()).getHungry();
        int money = ((App)getApplication()).getMoney();

            switch (index){
                case 0:         //관광지
                    if (upState != -1 || downState != -1){

                        String str = ((App)getApplication()).getResult();

                        up = ((App)getApplication()).getUp();
                        down = ((App)getApplication()).getDown();

                        if (upState != -1){
                            if (upState == 0){
                                ((App)getApplication()).setHungry(hungry+up);
                                str += "배부름이 " + String.valueOf(up) + " 상승했습니다.\n\n";
                            }else if (upState == 1){
                                ((App)getApplication()).setJoy(joy+up);
                                str += "즐거움이 " + String.valueOf(up) + " 상승했습니다.\n\n";

                            }else if (upState == 2){
                                ((App)getApplication()).setStamina(stamina+up);
                                str += "체력이 " + String.valueOf(up) + " 상승했습니다.\n\n";

                            }else if (upState == 3){
                                ((App)getApplication()).setMoney(money+up);
                                str += "경비를 " + String.valueOf(up) + "만원 얻었습니다.\n\n";

                            }
                        }

                        if (downState != -1){
                            if (downState == 0){
                                ((App)getApplication()).setHungry(hungry-down);
                                str += "배부름이 " + String.valueOf(down) + " 하락했습니다.\n";
                            }else if (downState == 1){
                                ((App)getApplication()).setJoy(joy-down);
                                str += "즐거움이 " + String.valueOf(down) + " 하락했습니다.\n";

                            }else if (downState == 2){
                                ((App)getApplication()).setStamina(stamina-down);
                                str += "체력이 " + String.valueOf(down) + " 하락했습니다.\n";

                            }else if (downState == 3){
                                ((App)getApplication()).setMoney(money-down);
                                str += "경비를 " + String.valueOf(down) + "만원 사용했습니다.\n";

                            }
                        }

                        txtResult.setText(str);
                    }
                    else {
                        ((App)getApplication()).setJoy(joy+1);
                        ((App)getApplication()).setHungry(hungry-1);
                        ((App)getApplication()).setStamina(stamina-1);
                        txtResult.setText("즐거움이 1 상승했습니다. \n\n" +
                                "체력이 1 하락했습니다.\n\n" +
                                "배부름이 1 하락했습니다.");
                    }
                    break;

                case 1:         //관광지
                    if (upState != -1 || downState != -1){

                        String str = "";

                        up = ((App)getApplication()).getUp();
                        down = ((App)getApplication()).getDown();

                        if (upState != -1){
                            if (upState == 0){
                                ((App)getApplication()).setHungry(hungry+up);
                                str += "배부름이 " + String.valueOf(up) + " 상승했습니다.\n\n";
                            }else if (upState == 1){
                                ((App)getApplication()).setJoy(joy+up);
                                str += "즐거움이 " + String.valueOf(up) + " 상승했습니다.\n\n";

                            }else if (upState == 2){
                                ((App)getApplication()).setStamina(stamina+up);
                                str += "체력이 " + String.valueOf(up) + " 상승했습니다.\n\n";

                            }else if (upState == 3){
                                ((App)getApplication()).setMoney(money+up);
                                str += "경비를 " + String.valueOf(up) + "만원 얻었습니다.\n\n";

                            }
                        }

                        if (downState != -1){
                            if (downState == 0){
                                ((App)getApplication()).setHungry(hungry-down);
                                str += "배부름이 " + String.valueOf(down) + " 하락했습니다.\n";
                            }else if (downState == 1){
                                ((App)getApplication()).setJoy(joy-down);
                                str += "즐거움이 " + String.valueOf(down) + " 하락했습니다.\n";

                            }else if (downState == 2){
                                ((App)getApplication()).setStamina(stamina-down);
                                str += "체력이 " + String.valueOf(down) + " 하락했습니다.\n";

                            }else if (downState == 3){
                                ((App)getApplication()).setMoney(money-down);
                                str += "경비를 " + String.valueOf(down) + "만원 사용했습니다.\n";

                            }
                        }

                        txtResult.setText(str);
                    }
                    break;
            }

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
