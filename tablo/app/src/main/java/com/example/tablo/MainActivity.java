package com.example.tablo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int Counter1 = 0;
    int Counter2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void setScoreToZero(View view){
        Counter1 = 0;
        Counter2 = 0;
        resetUI();
    }
    public void addPointToLeftTeam(View view){
        TextView leftScore = findViewById(R.id.leftscore);
        Counter1++;
        leftScore.setText(String.valueOf(Counter1));
    }
    public void addPointToRightTeam(View view){
        TextView rightScore = findViewById(R.id.rightscore);
        Counter2++;
        rightScore.setText(String.valueOf(Counter2));
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("Scores", new int[] {Counter1, Counter2});
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("Scores")) {
            int[] scores = savedInstanceState.getIntArray("Scores");
            Counter1 = scores[0];
            Counter2 = scores[1];
            resetUI();
        }
    }
    protected void resetUI(){
        TextView leftScore = findViewById(R.id.leftscore);
        leftScore.setText(String.valueOf(Counter1));
        TextView rightScore = findViewById(R.id.rightscore);
        rightScore.setText(String.valueOf(Counter2));
    }

}