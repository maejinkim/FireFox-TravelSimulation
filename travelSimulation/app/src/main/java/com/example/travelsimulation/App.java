package com.example.travelsimulation;

import android.app.Application;
import android.os.StrictMode;

public class App extends Application {

    private int stamina;    //체력
    private int hungry;     //배부름
    private int money;      //여행경비
    private int joy;        //즐거움
    private int day;        //날짜
    private int room;       //숙소 선택
    private int place;      //활동 선택
    private int placeIndex; //그 중 어떤 활동?
    private int msgIndex;   //msgIndex
    private int up;         //올릴 값
    private int down;       //내릴 값
    private int upState;         //올릴 상태
    private int downState;       //내릴 상태
    private int bad;
    private String result;

    @Override
    public void onCreate() {
        super.onCreate();
        stamina = 5;
        hungry = 5;
        joy = 5;
        day = 1;
        money = 0;
        msgIndex = 0;
        upState = -1;
        downState = -1;
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

    public int getUpState() {
        return upState;
    }

    public void setUpState(int upState) {
        this.upState = upState;
    }

    public int getDownState() {
        return downState;
    }

    public void setDownState(int downState) {
        this.downState = downState;
    }

    public int getPlaceIndex() {
        return placeIndex;
    }

    public void setPlaceIndex(int placeIndex) {
        this.placeIndex = placeIndex;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getMsgIndex() {
        return msgIndex;
    }

    public void setMsgIndex(int msgIndex) {
        this.msgIndex = msgIndex;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;

        if (this.stamina > 5)
            this.stamina = 5;
    }

    public int getHungry() {
        return hungry;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;

        if (this.hungry > 5)
            this.hungry = 5;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getJoy() {
        return joy;
    }

    public void setJoy(int joy) {
        this.joy = joy;

        if (this.joy > 5)
            this.joy = 5;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
