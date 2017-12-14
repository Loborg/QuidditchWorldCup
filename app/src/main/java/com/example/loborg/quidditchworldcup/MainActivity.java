package com.example.loborg.quidditchworldcup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView win_countA_text, win_countB_text, season_counter_text, gameInSeason_counter_text, pointsA_text, pointsB_text, winning_messageA, winning_messageB, already_win_message;

    public Integer pointsA = 0, pointsB = 0, win_countA, win_countB, season_count, gameInSeason_counter;

    public boolean snich_pressed = false;

    String season_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointsA_text = findViewById(R.id.pointsA);
        pointsA_text.setText("");

        pointsB_text = findViewById(R.id.pointsB);
        pointsB_text.setText("");

        win_countA_text = findViewById(R.id.win_countA_text);
        win_countA = 0;
        win_countA_text.setText(win_countA.toString());

        win_countB_text = findViewById(R.id.win_countB_text);
        win_countB = 0;
        win_countB_text.setText(win_countB.toString());

        gameInSeason_counter_text = findViewById(R.id.gameInSeason_counter);
        gameInSeason_counter = 1;
        gameInSeason_counter_text.setText("Game\n" + gameInSeason_counter);

        season_counter_text = findViewById(R.id.season_counter);
        season_title = season_counter_text.getText().toString();
        season_count = 1;
        season_counter_text.setText(season_title + " " + season_count);

        winning_messageA = findViewById(R.id.wining_messageA);

        winning_messageB = findViewById(R.id.wining_messageB);

        already_win_message = findViewById(R.id.already_win_message);
    }

    public void snichA_clicked(View v){
        if (snich_pressed != true){
            snich_pressed = true;
            pointsA = pointsA +150;
            win_countA++;
            win_countA_text.setText(win_countA.toString());
            pointsA_text.setText(pointsA.toString());
            winning_messageA.setVisibility(View.VISIBLE);
            winning_messageB.setVisibility(View.GONE);
            gameInSeason_counter++;
            gameInSeason_counter_text.setText("Game\n" + gameInSeason_counter);
        } else {
            already_win_message.setVisibility(View.VISIBLE);
            winning_messageA.setVisibility(View.GONE);
            winning_messageB.setVisibility(View.GONE);
        }
    }

    public void snichB_clicked(View v){
        if (snich_pressed != true){
            snich_pressed = true;
            pointsB = pointsB +150;
            win_countB++;
            win_countB_text.setText(win_countB.toString());
            pointsB_text.setText(pointsB.toString());
            winning_messageB.setVisibility(View.VISIBLE);
            winning_messageA.setVisibility(View.GONE);
            gameInSeason_counter++;
            gameInSeason_counter_text.setText("Game\n" + gameInSeason_counter);
        } else {
            already_win_message.setVisibility(View.VISIBLE);
            winning_messageA.setVisibility(View.GONE);
            winning_messageB.setVisibility(View.GONE);
        }
    }

    public void quaffleA_clicked(View v){
        if (snich_pressed != true){
            pointsA = pointsA +10;
            pointsA_text.setText(pointsA.toString());
        } else {
            pointsA = 10;
            pointsB = 0;
            pointsA_text.setText(pointsA.toString());
            pointsB_text.setText(pointsB.toString());
            snich_pressed = false;
            already_win_message.setVisibility(View.GONE);
            winning_messageA.setVisibility(View.GONE);
            winning_messageB.setVisibility(View.GONE);
        }
    }

    public void quaffleB_clicked(View v){
        if (snich_pressed != true){
            pointsB = pointsB +10;
            pointsB_text.setText(pointsB.toString());
        } else {
            pointsB = 10;
            pointsA = 0;
            pointsB_text.setText(pointsB.toString());
            pointsA_text.setText(pointsA.toString());
            snich_pressed = false;
            already_win_message.setVisibility(View.GONE);
            winning_messageA.setVisibility(View.GONE);
            winning_messageB.setVisibility(View.GONE);

        }
    }

    public void newSeason_button_clicked(View v){
        season_count++;
        season_counter_text.setText(season_title + " " + season_count.toString());
        pointsA_text.setText("");
        pointsB_text.setText("");
        win_countA = 0;
        win_countA_text.setText(win_countA.toString());
        win_countB_text = findViewById(R.id.win_countB_text);
        win_countB = 0;
        win_countB_text.setText(win_countB.toString());
        gameInSeason_counter = 1;
        gameInSeason_counter_text.setText("Game\n" + gameInSeason_counter);

        if (winning_messageA.getVisibility() == View.VISIBLE){
            winning_messageA.setVisibility(View.GONE);
        }

        if (winning_messageB.getVisibility() == View.VISIBLE){
            winning_messageB.setVisibility(View.GONE);
        }
    }
}
