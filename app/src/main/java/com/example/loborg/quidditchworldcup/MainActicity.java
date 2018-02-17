package com.example.loborg.quidditchworldcup;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * <p>Created by Loborg on 2017. 12. 16..</p>
 * <p>
 * This game app is based on J.K. Rowling’s fictional sport game Quidditch which can be find in the Harry Potter novels and films.<br>
 * <p><b>Game App rules:</b></p>
 * <ul>
 * <li>You can score point for two Teams whit the large balls called quaffle. And whit the small balls called snich<br></li>
 * <li>Quaffles worth 10 point, and the snich worth 150</li>
 * <li>During a Game session you can score point whit the Quaffle multiple times for both Teams.</li>
 * <li>During a Game session you can score point whit the Snich only ones and only whit one Team.</li>
 * <li>If a Snich caught by a Team, it gives the Team 150 point and the Game session will end.</li>
 * <li>The Team whit the higher point will win the Game session.</li>
 * <li>The new Games session in the Season will start if one Team catches the first Quaffle</li>
 * <li>A new Season can be started if the New Season button is clicked.</li>
 * </ul>
 * <p><b>Technical features:</b></p>
 * <ul>
 * <li>The screen can be rotated to landscape mode and beck to vertical mode, and the data will preserved.</li>
 * <li>There is two layout xml, one for the landscape mode, and one for the vertical mode.</li>
 * <li>The app will start whit some predefined date such as season count, game count and win count.</li>
 * </ul>
 * <p><b>Known issues:</b></p>
 * <ul>
 * <li>The font type for the win counter is set to default because the font type I’m using is not to good,<br>
 * there is to much space between lines so in landscape mode the win counter text can move out of the screen.</li>
 * <li>In smaller screens, the win counter can disappear behind the circles.</li>
 * <li>In landscape mod the feedback message can be to small.</li>
 * <li>Because the snich color is yellow, sometimes it can be hard to see it on the screen.<br>
 * I can’t find a perfect background to solve the issue.</li>
 * </ul>
 */
public class MainActicity extends AppCompatActivity {

    public static final String SNICH_CLICKED_KEY = "snich_clicked_key";
    /**
     * Declaring the important global variables for the program
     */
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

    public TextView wining_messageA;
    public TextView wining_messageB;
    public TextView already_win_massage;

    /**
     * When the program starts the following methods will start<br>
     * with the predefined variables.<br>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        font_family = Typeface.createFromAsset(getAssets(), "ParryHotter.ttf");
        displaySeasonCount(season_count);
        displayGameInSeasonCount(gameInSeason_counter);
        displayWiningCountA(win_countA);
        displayWiningCountB(win_countB);

        wining_messageA = findViewById(R.id.wining_messageA);
        wining_messageB = findViewById(R.id.wining_messageB);
        already_win_massage = findViewById(R.id.already_win_message);
    }

    /**
     * This method will restore the variables,<br>
     * which is defined in the onSaveInstanceState method.<br>
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        snich_clicked = savedInstanceState.getBoolean(SNICH_CLICKED_KEY);
        pointsA = savedInstanceState.getInt("pointsA_key");
        displayPointA(pointsA);
        pointsB = savedInstanceState.getInt("pointsB_key");
        displayPointB(pointsB);
        win_countA = savedInstanceState.getInt("win_countA_key");
        displayWiningCountA(win_countA);
        win_countB = savedInstanceState.getInt("win_countB_key");
        displayWiningCountB(win_countB);
        season_count = savedInstanceState.getInt("season_count_key");
        displaySeasonCount(season_count);
        gameInSeason_counter = savedInstanceState.getInt("gameInSeason_counter_key");
        displayGameInSeasonCount(gameInSeason_counter);
        displayFeedbackMassages(savedInstanceState.getInt("wining_messageA_key"), savedInstanceState.getInt("wining_messageB_key"), savedInstanceState.getInt("already_win_massage_key"));
    }

    /**
     * Putting the selected variables in the savedInstanceState method for later usage.<br>
     * This method will be invoked in the onRestoreInstanceState method.<br>
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(SNICH_CLICKED_KEY, snich_clicked);
        savedInstanceState.putInt("pointsA_key", pointsA);
        savedInstanceState.putInt("pointsB_key", pointsB);
        savedInstanceState.putInt("win_countA_key", win_countA);
        savedInstanceState.putInt("win_countB_key", win_countB);
        savedInstanceState.putInt("season_count_key", season_count);
        savedInstanceState.putInt("gameInSeason_counter_key", gameInSeason_counter);
        savedInstanceState.putInt("wining_messageA_key", wining_messageA.getVisibility());
        savedInstanceState.putInt("wining_messageB_key", wining_messageB.getVisibility());
        savedInstanceState.putInt("already_win_massage_key", already_win_massage.getVisibility());
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Displaying the Season counter text at the top of the application screen.<br>
     * The method sets the static season count text, and the dynamic season number.<br>
     * The method waits one Integer parameter.<br>
     */
    public void displaySeasonCount(Integer seasonCount) {
        TextView season_count = findViewById(R.id.season_counter);
        season_count_text = getResources().getString(R.string.season_counter_text);
        season_count.setTypeface(font_family);
        season_count.setText(season_count_text + " " + seasonCount.toString());
    }

    /**
     * Displaying the Game count in any giving season.<br>
     * The method sets the static game count text and the dynamic game number.<br>
     * The method waits one Integer parameter.<br>
     */
    public void displayGameInSeasonCount(Integer gameInSeasonCount) {
        TextView gaemeInSeasonCount_text = findViewById(R.id.gameInSeason_counter);
        game_count_text = getResources().getString(R.string.gmae_count_text);
        gaemeInSeasonCount_text.setTypeface(font_family);
        gaemeInSeasonCount_text.setText(game_count_text + " " + gameInSeasonCount.toString());
    }

    /**
     * Displays the point of Team A.<br>
     * The method waits one Integer parameter.<br>
     */
    public void displayPointA(Integer pointsACount) {
        TextView pointsA_text = findViewById(R.id.pointsA);
        pointsA_text.setTypeface(font_family);
        pointsA_text.setText(pointsACount.toString());
    }

    /**
     * Displays the point of Team B.<br>
     * The method waits one Integer parameter.<br>
     */
    public void displayPointB(Integer pointsBCount) {
        TextView pointsB_text = findViewById(R.id.pointsB);
        pointsB_text.setTypeface(font_family);
        pointsB_text.setText(pointsBCount.toString());
    }

    /**
     * Displays the number of how many times Team A won a round.<br>
     * The method waits one Integer parameter.<br>
     */
    public void displayWiningCountA(Integer winCounterA) {
        TextView wining_countA_text = findViewById(R.id.win_countA);
        //wining_countA_text.setTypeface(font_family);
        wining_countA_text.setText(winCounterA.toString() + "\nWin");
    }

    /**
     * Displays the number of how many times Team B won a round.<br>
     * The method waits one Integer parameter.<br>
     */
    public void displayWiningCountB(Integer winCounterB) {
        TextView wining_countB_text = findViewById(R.id.win_countB);
        //wining_countB_text.setTypeface(font_family);
        wining_countB_text.setText(winCounterB.toString() + "\nWin");
    }

    /**
     * Displays three message in the bottom of the application screen.<br>
     * The messages gives feedback for the user if a team is won, or if the snich is caught.<br>
     * The method waits three Integer parameters which is representing the feedback messages TextView’s visibility status.<br>
     * The status can be GONE, VISIBLE, or INVISIBLE.<br>
     */
    public void displayFeedbackMassages(int winingMassageAVisibility, int winingMassageBVisibility, int alreadyWinMassageVisibility) {
        wining_messageA = findViewById(R.id.wining_messageA);
        wining_messageA.setTypeface(font_family);
        wining_messageA.setVisibility(winingMassageAVisibility);

        wining_messageB = findViewById(R.id.wining_messageB);
        wining_messageB.setTypeface(font_family);
        wining_messageB.setVisibility(winingMassageBVisibility);

        already_win_massage = findViewById(R.id.already_win_message);
        already_win_massage.setTypeface(font_family);
        already_win_massage.setVisibility(alreadyWinMassageVisibility);
    }

    /**
     * The method handles the click of Team A’s quaffle.<br>
     * The method waits one View parameter.<br>
     * <p></p>
     * If the quaffle clicked, it gives 10 point to Team A.<br>
     * If the snich was caught, the method:<br>
     * - Sets Team A’s point to 10, and Team B’s point to 0.<br>
     * - Increments the game count.<br>
     * - Sets all feedback message to gone.<br>
     */
    public void quaffleA_clicked(View v) {
        if (!snich_clicked) {
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

    /**
     * The method handles the click of Team B’s quaffle.<br>
     * The method waits one View parameter.<br>
     * <p></p>
     * If the quaffle clicked, it gives 10 point to Team B.<br>
     * If the snich was caught, the method:<br>
     * -    Sets Team B’s point to 10, and Team A’s point to 0.<br>
     * -    Increments the game count.<br>
     * -    Sets all feedback message to gone.<br>
     */
    public void quaffleB_clicked(View v) {
        if (!snich_clicked) {
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

    /**
     * The method handles the click of Team A’s snich.<br>
     * The method waits one View parameter.<br>
     * <p></p>
     * If the snich clicked it gives 150 points to Team A.<br>
     * If Team A points is larger or equal to Team B points then the method sets the visibility of wining_messageA TextView to Visible.<br>
     * If Team B points is larger then Team A’s then the method sets the visibility of wining_messageB TextView to Visible.<br>
     * If the snich A or B already clicked the method will set the already_win_massage TextView to Visible.<br>
     */
    public void snichA_clicked(View v) {
        if (!snich_clicked) {
            pointsA = pointsA + 150;
            displayPointA(pointsA);
        }

        if (snich_clicked) {
            displayFeedbackMassages(View.GONE, View.GONE, View.VISIBLE);
        } else if (pointsA >= pointsB) {
            snich_clicked = true;
            win_countA++;
            displayWiningCountA(win_countA);
            displayFeedbackMassages(View.VISIBLE, View.GONE, View.GONE);
        } else if (pointsA < pointsB) {
            snich_clicked = true;
            win_countB++;
            displayWiningCountB(win_countB);
            displayFeedbackMassages(View.GONE, View.VISIBLE, View.GONE);
        }
    }

    /**
     * The method handles the click of Team B’s snich.<br>
     * The method waits one View parameter.<br>
     * <p></p>
     * If the snich clicked it gives 150 points to Team B.<br>
     * If Team B points is larger or equal to Team A points then the method sets the visibility of wining_messageB TextView to Visible.<br>
     * If Team A points is larger then Team B’s then the method sets the visibility of wining_messageA TextView to Visible.<br>
     * If the snich A or B already clicked the method will set the already_win_massage TextView to Visible.<br>
     */
    public void snichB_clicked(View v) {
        if (!snich_clicked) {
            pointsB = pointsB + 150;
            displayPointB(pointsB);
        }

        if (snich_clicked) {
            displayFeedbackMassages(View.GONE, View.GONE, View.VISIBLE);
        } else if (pointsA > pointsB) {
            snich_clicked = true;
            win_countA++;
            displayWiningCountA(win_countA);
            displayFeedbackMassages(View.VISIBLE, View.GONE, View.GONE);
        } else if (pointsA <= pointsB) {
            snich_clicked = true;
            win_countB++;
            displayWiningCountB(win_countB);
            displayFeedbackMassages(View.GONE, View.VISIBLE, View.GONE);
        }
    }

    /**
     * The method:<br>
     * -	Increments the season counter<br>
     * -	Sets the game counter to 1<br>
     * -	Sets the win counter to 0 for both Team<br>
     * -	Sets the point counter to 0 for both Team<br>
     * -	Sets all of the feedback messages to GONE.<br>
     */
    public void newSeason_button_clicked(View v) {
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


