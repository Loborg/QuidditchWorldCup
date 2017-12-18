package com.example.loborg.quidditchworldcup;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Loborg on 2017. 12. 16..
 */

public class MainActicity_Test extends AppCompatActivity {

    public boolean snich_clicked = false;
    public Integer pointsA = 0;
    public Integer pointsB = 0;
    public Integer win_countA = 0;
    public Integer win_countB = 0;
    public Integer season_count = 1;
    public Integer gameInSeason_counter = 1;
    public Typeface font_family;
    public String season_count_text;
    public String game_count_text;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        font_family = Typeface.createFromAsset(getAssets(), "ParryHotter.ttf");

        displaySeasonCount(season_count);

        displayGameInSeasonCount(gameInSeason_counter);

        displayWiningCountA(win_countA);

        displayWiningCountB(win_countB);
    }

    public void displaySeasonCount(Integer seasonCount){
        TextView season_count = findViewById(R.id.season_counter);
        season_count_text = getResources().getString(R.string.season_counter_text);
        season_count.setTypeface(font_family);
        season_count.setText(season_count_text + " " + seasonCount.toString());
    }

    public void displayGameInSeasonCount(Integer gameInSeasonCount){
        TextView gaemeInSeasonCount_text = findViewById(R.id.gameInSeason_counter);
        game_count_text = getResources().getString(R.string.gmae_count_text);
        gaemeInSeasonCount_text.setTypeface(font_family);
        gaemeInSeasonCount_text.setText(game_count_text + " " + gameInSeasonCount.toString());
    }

    public void displayPointA(Integer pointsACount){
        TextView pointsA_text = findViewById(R.id.pointsA);
        pointsA_text.setTypeface(font_family);
        pointsA_text.setText(pointsACount.toString());
    }

    public void displayPointB(Integer pointsBCount){
        TextView pointsB_text = findViewById(R.id.pointsB);
        pointsB_text.setTypeface(font_family);
        pointsB_text.setText(pointsBCount.toString());
    }

    public void displayWiningCountA(Integer winCounterA){
        TextView wining_countA_text = findViewById(R.id.win_countA);
        //wining_countA_text.setTypeface(font_family);
        wining_countA_text.setText(winCounterA.toString() + "\nWin");
    }

    public void displayWiningCountB(Integer winCounterB){
        TextView wining_countB_text = findViewById(R.id.win_countB);
        //wining_countB_text.setTypeface(font_family);
        wining_countB_text.setText(winCounterB.toString() + "\nWin");
    }

    public void displayFeedbackMassages(int winingMassageAVisibility, int winingMassageBVisibility, int alreadyWinMassageVisibility){
        TextView wining_messageA = findViewById(R.id.wining_messageA);
        wining_messageA.setTypeface(font_family);
        wining_messageA.setVisibility(winingMassageAVisibility);

        TextView wining_massageB = findViewById(R.id.wining_messageB);
        wining_massageB.setTypeface(font_family);
        wining_massageB.setVisibility(winingMassageBVisibility);

        TextView already_win_massage = findViewById(R.id.already_win_message);
        already_win_massage.setTypeface(font_family);
        already_win_massage.setVisibility(alreadyWinMassageVisibility);
    }

    public void quaffleA_clicked(View v){
        if (snich_clicked != true){
            pointsA = pointsA + 10;
            displayPointA(pointsA);
        } else {
            pointsA = 10;
            pointsB = 0;
            gameInSeason_counter++;
            snich_clicked = false;
            displayPointA(pointsA);
            displayPointB(pointsB);
            displayGameInSeasonCount(gameInSeason_counter);
            displayFeedbackMassages(View.GONE, View.GONE, View.GONE);
        }
    }

    public void quaffleB_clicked(View v){
        if (snich_clicked != true){
            pointsB = pointsB + 10;
            displayPointB(pointsB);
        } else {
            pointsB = 10;
            pointsA = 0;
            gameInSeason_counter++;
            snich_clicked = false;
            displayPointA(pointsA);
            displayPointB(pointsB);
            displayGameInSeasonCount(gameInSeason_counter);
            displayFeedbackMassages(View.GONE, View.GONE, View.GONE);
        }
    }

    public void snichA_clicked(View v){
        if (snich_clicked == false){
            pointsA = pointsA + 150;
            displayPointA(pointsA);
        }

        if (snich_clicked == true){
            displayFeedbackMassages(View.GONE, View.GONE, View.VISIBLE);
        } else if (pointsA >= pointsB){
            snich_clicked = true;
            win_countA++;
            displayWiningCountA(win_countA);
            displayFeedbackMassages(View.VISIBLE, View.GONE, View.GONE);
        } else if (pointsA < pointsB){
            snich_clicked = true;
            win_countB++;
            displayWiningCountB(win_countB);
            displayFeedbackMassages(View.GONE, View.VISIBLE, View.GONE);
        }
    }

    public void snichB_clicked(View v){
        if (snich_clicked == false){
            pointsB = pointsB + 150;
            displayPointB(pointsB);
        }

        if (snich_clicked == true){
            displayFeedbackMassages(View.GONE, View.GONE, View.VISIBLE);
        } else if (pointsA > pointsB){
            snich_clicked = true;
            win_countA++;
            displayWiningCountA(win_countA);
            displayFeedbackMassages(View.VISIBLE, View.GONE, View.GONE);
        } else if (pointsA <= pointsB){
            snich_clicked = true;
            win_countB++;
            displayWiningCountB(win_countB);
            displayFeedbackMassages(View.GONE, View.VISIBLE, View.GONE);
        }
    }

    public  void newSeason_button_clicked(View v){
        season_count++;
        displaySeasonCount(season_count);
        gameInSeason_counter = 1;
        displayGameInSeasonCount(gameInSeason_counter);
        win_countA = 0;
        displayWiningCountA(win_countA);
        win_countB = 0;
        displayWiningCountB(win_countB);
        pointsA = 0;
        displayPointA(pointsA);
        pointsB = 0;
        displayPointB(pointsB);
        displayFeedbackMassages(View.GONE, View.GONE, View.GONE);
    }
}


