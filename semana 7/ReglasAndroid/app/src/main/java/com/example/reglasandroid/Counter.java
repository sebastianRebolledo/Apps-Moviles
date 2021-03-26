package com.example.reglasandroid;

import android.widget.TextView;

public class Counter extends Thread {
    private boolean isAlive=true;
    private int counter=0;

    private onCounterChange observer;
    @Override
    public void run() {
        while(isAlive){
            try {
                Thread.sleep(1000);
                observer.onCounterValue(counter);
                counter++;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void setObserver(onCounterChange observer){
        this.observer=observer;
    }

    public interface onCounterChange{
        void onCounterValue(int value);
    }




}
