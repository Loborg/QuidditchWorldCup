package com.example.loborg.quidditchworldcup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Loborg on 2017. 12. 16..
 */

public class MainActicity_Test extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displaySeasonCount(int seasonCount){
        TextView season_count = findViewById(R.id.season_counter);
        season_count.setText("Season: " + seasonCount);
    }

    public void displayGameInSeasonCount(int gameInSeasonCount){
        TextView season_count = findViewById(R.id.gameInSeason_counter);
        season_count.setText(gameInSeasonCount);
    }

    public void displayPointA(int pointsACount){
        TextView season_count = findViewById(R.id.pointsA);
        season_count.setText(pointsACount);
    }

    public void displayPointB(int pointsBCount){
        TextView season_count = findViewById(R.id.pointsB);
        season_count.setText(pointsBCount);
    }

    public void displayWiningCountA(int winCounterA){
        TextView season_count = findViewById(R.id.win_countA);
        season_count.setText(winCounterA);
    }

    public void displayWiningCountB(int winCounterB){
        TextView season_count = findViewById(R.id.win_countB);
        season_count.setText(winCounterB);
    }
}


