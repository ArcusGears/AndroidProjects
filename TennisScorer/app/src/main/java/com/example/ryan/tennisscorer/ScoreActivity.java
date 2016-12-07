package com.example.ryan.tennisscorer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int gameTeamA = 0;
    int gameTeamB = 0;
    int setTeamA = 0;
    int setTeamB = 0;
    public void viewReset() {
        TextView setViewb = (TextView) findViewById(R.id.TeamBSet);
        setViewb.setText(String.valueOf(setTeamB));
        TextView setViewa = (TextView) findViewById(R.id.TeamASet);
        setViewa.setText(String.valueOf(setTeamA));
        loveA();
        loveB();
        TextView gameViewa = (TextView) findViewById(R.id.TeamAGame);
        gameViewa.setText(String.valueOf(gameTeamA));
        TextView gameViewb = (TextView) findViewById(R.id.TeamBGame);
        gameViewb.setText(String.valueOf(gameTeamB));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        if (savedInstanceState != null) {
            scoreTeamA=savedInstanceState.getInt("scoreTeamA");
            scoreTeamB=savedInstanceState.getInt("scoreTeamB");
            gameTeamA=savedInstanceState.getInt("TeamAGame");
            gameTeamB=savedInstanceState.getInt("TeamBGame");
            setTeamA=savedInstanceState.getInt("setTeamA");
            setTeamB=savedInstanceState.getInt("setTeamB");

            viewReset();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_score, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("scoreTeamA", scoreTeamA);
        savedInstanceState.putInt("scoreTeamB", scoreTeamB);
        savedInstanceState.putInt("TeamAGame", gameTeamA);
        savedInstanceState.putInt("TeamBGame", gameTeamB);
        savedInstanceState.putInt("setTeamA", setTeamA);
        savedInstanceState.putInt("setTeamB", setTeamB);

    }

    public void scoreForTeamA(View v) {
        //0=Love 1=15 2=30 3=40 4=game/advantage
        scoreTeamA += 1;
        if(scoreTeamA==1){
            score_point_a(15);
        }
        if(scoreTeamA==2){
            score_point_a(30);
        }
        if(scoreTeamA==3){
            if(scoreTeamA==scoreTeamB){
                displayDeuce();
            }else {
                score_point_a(40);
            }
        }
        if (scoreTeamA >= 4) {
            if(scoreTeamA>=(scoreTeamB+2)){
                gameWinA();
            }else{
                if(scoreTeamA==(scoreTeamB+1)){
                    displayAdvantageA();
                }//if
                else{
                    if(scoreTeamA==scoreTeamB)
                        displayDeuce();

                }//else
            }//else

        }

    }

    public void scoreForTeamB(View v) {
        //0=Love 1=15 2=30 3=40 4=game/advantage
        scoreTeamB += 1;
        if(scoreTeamB==1){
            score_point_b(15);
        }
        if(scoreTeamB==2){
            score_point_b(30);
        }
        if(scoreTeamB==3){
            if(scoreTeamB==scoreTeamA){
                displayDeuce();
            }else {
                score_point_b(40);
            }
        }
        if (scoreTeamB >= 4) {
            if(scoreTeamB>=(scoreTeamA+2)){
                gameWinB();
            }else{
                if(scoreTeamB==(scoreTeamA+1)){
                    displayAdvantageB();
                }//if
                else{
                    if(scoreTeamB==scoreTeamA)
                        displayDeuce();

                }//else
            }//else

        }
    }

    public void displayDeuce() {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_view);
        scoreView.setText(String.valueOf("Deuce"));
        TextView scoreViewB = (TextView) findViewById(R.id.team_b_score_view);
        scoreViewB.setText(String.valueOf("Deuce"));
    }

    public void displayAdvantageB() {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_view);
        scoreView.setText(String.valueOf("Advantage"));
    }

    public void displayAdvantageA() {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_view);
        scoreView.setText(String.valueOf("Advantage"));
    }

    public void score_point_a(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_view);
        scoreView.setText(String.valueOf(score));
        TextView victoryViewa = (TextView) findViewById(R.id.TeamAWin);
        victoryViewa.setText(String.valueOf(" "));
        TextView victoryViewb = (TextView) findViewById(R.id.TeamBWin);
        victoryViewb.setText(String.valueOf(" "));
    }

    public void score_point_b(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_view);
        scoreView.setText(String.valueOf(score));
        TextView victoryViewa = (TextView) findViewById(R.id.TeamAWin);
        victoryViewa.setText(String.valueOf(" "));
        TextView victoryViewb = (TextView) findViewById(R.id.TeamBWin);
        victoryViewb.setText(String.valueOf(" "));
    }

    public void win_game_a(int gameTeamA) {
        TextView gameViewa = (TextView) findViewById(R.id.TeamAGame);
        gameViewa.setText(String.valueOf(gameTeamA));
        loveA();
        loveB();
    }

    public void win_game_b(int gameTeamB) {
        TextView gameViewb = (TextView) findViewById(R.id.TeamBGame);
        gameViewb.setText(String.valueOf(gameTeamB));
        loveA();
        loveB();
    }

    public void set_win_a(int setTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.TeamASet);
        scoreView.setText(String.valueOf(setTeamA));
        loveA();
        loveB();
        TextView gameViewa = (TextView) findViewById(R.id.TeamAGame);
        gameViewa.setText(String.valueOf(gameTeamA));
        TextView gameViewb = (TextView) findViewById(R.id.TeamBGame);
        gameViewb.setText(String.valueOf(gameTeamB));
    }

    public void set_win_b(int setTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.TeamBSet);
        scoreView.setText(String.valueOf(setTeamB));
        loveA();
        loveB();
        TextView gameViewa = (TextView) findViewById(R.id.TeamAGame);
        gameViewa.setText(String.valueOf(gameTeamA));
        TextView gameViewb = (TextView) findViewById(R.id.TeamBGame);
        gameViewb.setText(String.valueOf(gameTeamB));
    }

    public void victory_a() {
        TextView victoryView = (TextView) findViewById(R.id.TeamAWin);
        victoryView.setText(String.valueOf("Winner"));
        TextView setViewb = (TextView) findViewById(R.id.TeamBSet);
        setViewb.setText(String.valueOf(setTeamB));
        TextView setViewa = (TextView) findViewById(R.id.TeamASet);
        setViewa.setText(String.valueOf(setTeamA));
        loveA();
        loveB();
        TextView gameViewa = (TextView) findViewById(R.id.TeamAGame);
        gameViewa.setText(String.valueOf(gameTeamA));
        TextView gameViewb = (TextView) findViewById(R.id.TeamBGame);
        gameViewb.setText(String.valueOf(gameTeamB));
    }

    public void victory_b() {
        TextView victoryView = (TextView) findViewById(R.id.TeamBWin);
        victoryView.setText(String.valueOf("Winner"));
        TextView setViewb = (TextView) findViewById(R.id.TeamBSet);
        setViewb.setText(String.valueOf(setTeamB));
        TextView setViewa = (TextView) findViewById(R.id.TeamASet);
        setViewa.setText(String.valueOf(setTeamA));
        loveA();
        loveB();
        TextView gameViewa = (TextView) findViewById(R.id.TeamAGame);
        gameViewa.setText(String.valueOf(gameTeamA));
        TextView gameViewb = (TextView) findViewById(R.id.TeamBGame);
        gameViewb.setText(String.valueOf(gameTeamB));
    }

    public void loveA() {
        if (scoreTeamA == 0) {
            TextView scoreViewa = (TextView) findViewById(R.id.team_a_score_view);
            scoreViewa.setText(String.valueOf("Love"));
        } else {
            if(scoreTeamA==1){
                score_point_a(15);
            }
            if(scoreTeamA==2){
                score_point_a(30);
            }
            if(scoreTeamA==3){
                if(scoreTeamA==scoreTeamB){
                    displayDeuce();
                }else {
                    score_point_a(40);
                }
            }
            if (scoreTeamA >= 4) {
                if(scoreTeamA>=(scoreTeamB+2)){
                    gameWinA();
                }else{
                    if(scoreTeamA==(scoreTeamB+1)){
                        displayAdvantageA();
                    }//if
                    else{
                        if(scoreTeamA==scoreTeamB)
                            displayDeuce();

                    }//else
                }//else

            }
        }
    }

    public void loveB() {
        if (scoreTeamB ==0) {
            TextView scoreViewb = (TextView) findViewById(R.id.team_b_score_view);
            scoreViewb.setText(String.valueOf("Love"));
        } else {
            if(scoreTeamB==1){
                score_point_b(15);
            }
            if(scoreTeamB==2){
                score_point_b(30);
            }
            if(scoreTeamB==3){
                if(scoreTeamB==scoreTeamA){
                    displayDeuce();
                }else {
                    score_point_b(40);
                }
            }
            if (scoreTeamB >= 4) {
                if(scoreTeamB>=(scoreTeamA+2)){
                    gameWinB();
                }else{
                    if(scoreTeamB==(scoreTeamA+1)){
                        displayAdvantageB();
                    }//if
                    else{
                        if(scoreTeamB==scoreTeamA)
                            displayDeuce();

                    }//else
                }//else

            }
        }
    }

    public void gameWinA() {
        gameTeamA = gameTeamA + 1;
        scoreTeamA = 0;
        scoreTeamB = 0;
        win_game_a(gameTeamA);

        if (gameTeamA >= 6) {
            if (gameTeamA >= (gameTeamB + 2)) {
                setWin();
            } else {
                //gameTeamA = gameTeamA + 1;
            }
        }
    }

    public void gameWinB() {
        gameTeamB = gameTeamB + 1;
        scoreTeamA = 0;
        scoreTeamB = 0;
        win_game_b(gameTeamB);

        if (gameTeamB >= 6) {
            if (gameTeamB >= (gameTeamA + 2)) {
                setWin();
            } else {
                //gameTeamB = gameTeamB + 1;
            }
        }
    }
    public void setWin() {
        if (gameTeamA >= 6) {
            setTeamA = setTeamA + 1;
            gameTeamA = 0;
            gameTeamB = 0;
            scoreTeamA = 0;
            scoreTeamB = 0;
            set_win_a(setTeamA);
        }
        if (gameTeamB >=6) {
            setTeamB = setTeamB + 1;
            gameTeamA = 0;
            gameTeamB = 0;
            scoreTeamA = 0;
            scoreTeamB = 0;
            set_win_b(setTeamB);
        }
        if (setTeamA == 2) {
            matchWin();
        }
        if (setTeamB == 2) {
            matchWin();
        }
    }
    public void matchWin() {
        if (setTeamA == 2) {
            setTeamA = 0;
            setTeamB = 0;
            gameTeamA = 0;
            gameTeamB = 0;
            scoreTeamA = 0;
            scoreTeamB = 0;
            victory_a();
        }
        if (setTeamB == 2) {
            setTeamA = 0;
            setTeamB = 0;
            gameTeamA = 0;
            gameTeamB = 0;
            scoreTeamA = 0;
            scoreTeamB = 0;
            victory_b();
        }
    }
}
