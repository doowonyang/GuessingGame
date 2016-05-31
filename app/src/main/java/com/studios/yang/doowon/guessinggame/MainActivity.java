package com.studios.yang.doowon.guessinggame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    int upperLimit = 100;
    int lowerLimit = 1;
    int initialValue = average(upperLimit,lowerLimit);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public int average(int firstNumber, int secondNumber) {
        return (firstNumber + secondNumber)/2;
    }

    public void yesButton(View view){
        lowerLimit = average(upperLimit,lowerLimit) + 1;
        Log.d(TAG,"upperLimit=" + upperLimit + " lowerLimit=" + lowerLimit);
        displayValue(average(upperLimit,lowerLimit));
        checkValue();
    }

    public void noButton(View view){
        upperLimit = average(upperLimit,lowerLimit);
        Log.d(TAG,"upperLimit=" + upperLimit + " lowerLimit=" + lowerLimit);
        displayValue(average(upperLimit,lowerLimit));
        checkValue();
    }

    public void checkValue(){
        if(upperLimit == lowerLimit){
            displayFinalStatement();
            displayValue(upperLimit);
        }
    }

    public void resetButton(View view){
        upperLimit = 100;
        lowerLimit = 1;
        initialValue = average(upperLimit, lowerLimit);
        Log.d(TAG,"upperLimit=" + upperLimit + " lowerLimit=" + lowerLimit);
        displayValue(50);
        displayInitialStatement();
    }

    public void displayValue(int number){
        TextView averageView = (TextView) findViewById(R.id.displayValue);
        averageView.setText(String.valueOf(number));
    }

    public void displayInitialStatement(){
        TextView initialStatement = (TextView) findViewById(R.id.outputStatement);
        initialStatement.setText(String.valueOf("Is your number greater than"));
    }

    public void displayFinalStatement(){
        TextView finalStatement = (TextView) findViewById(R.id.outputStatement);
        finalStatement.setText(String.valueOf("Your value is"));
    }

}
