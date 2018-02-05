package com.example.android.tennisapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int pointsPlayer1 = 0;
    int pointsPlayer2 = 0;
    int acesPlayer1 = 0;
    int acesPlayer2 = 0;
    int faultsPlayer1 = 0;
    int faultsPlayer2 = 0;
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayPointsForPlayer1() {
        TextView pointsPlayer1TextView = (TextView) findViewById(R.id.points_player1);
        pointsPlayer1TextView.setText(String.valueOf(pointsPlayer1));
    }

    public void displayPointsForPlayer2() {
        TextView pointsPlayer2TextView = (TextView) findViewById(R.id.points_player2);
        pointsPlayer2TextView.setText(String.valueOf(pointsPlayer2));
    }
    public void displayScorePlayer1() {
        TextView scorePlayer1TextView = (TextView) findViewById(R.id.score_player1);
        TextView score1TextView=(TextView)findViewById(R.id.score1);
        scorePlayer1TextView.setText(String.valueOf(scorePlayer1));
        score1TextView.setText(String.valueOf(scorePlayer1));
    }
    public void displayScorePlayer2() {
        TextView scorePlayer2TextView = (TextView) findViewById(R.id.score_player2);
        scorePlayer2TextView.setText(String.valueOf(scorePlayer2));
        TextView score2TextView=(TextView)findViewById(R.id.score2);
        score2TextView.setText(String.valueOf(scorePlayer2));
    }


    public void displayAcePlayer1() {
        TextView acesPlayer1TextView = (TextView) findViewById(R.id.aces_player1);
        acesPlayer1TextView.setText(String.valueOf(acesPlayer1));
    }

    public void displayAcePlayer2() {
        TextView acesPlayer2TextView = (TextView) findViewById(R.id.aces_player2);
        acesPlayer2TextView.setText(String.valueOf(acesPlayer2));
    }

    public void displayDoubleFaultPlayer1() {
        TextView faultsPlayer1TextView = (TextView) findViewById(R.id.faults_player1);
        faultsPlayer1TextView.setText(String.valueOf(faultsPlayer1));
    }

    public void displayDoubleFaultPlayer2() {
        TextView faultsPlayer2TextView = (TextView) findViewById(R.id.faults_player2);
        faultsPlayer2TextView.setText(String.valueOf(faultsPlayer2));
    }


    public void addPointsForPlayer1(View view) {
        if (pointsPlayer1 < 30) {
            pointsPlayer1 = pointsPlayer1 + 15;
            displayPointsForPlayer1();
        } else if (pointsPlayer1 == 30) {
            pointsPlayer1 = 40;
            displayPointsForPlayer1();
            if(pointsPlayer2 == 40){
                Context context = getApplicationContext();
                CharSequence text = "Deuce";
                int duration = Toast.LENGTH_SHORT;
                Toast toastDeuce = Toast.makeText(context, text, duration);
                toastDeuce.show();}
        } else {
                if (pointsPlayer1 == 40 && pointsPlayer1 > pointsPlayer2) {
                    newGame();
                    if(scorePlayer1<10)
                    {scorePlayer1 = scorePlayer1 + 1;
                        displayScorePlayer1();}
                    if(scorePlayer1==10){
                        Context context = getApplicationContext();
                        CharSequence text = getText(R.string.player1)+ " won!";
                        int duration = Toast.LENGTH_LONG;
                        Toast toastWinner = Toast.makeText(context, text, duration);
                        toastWinner.show();
                        reset();
                    }
                }
                if (pointsPlayer1 == pointsPlayer2 && pointsPlayer1 == 40) {
                    pointsPlayer1 = R.string.advantage;
                    TextView pointsPlayer1TextView = (TextView) findViewById(R.id.points_player1);
                    pointsPlayer1TextView.setText(getText(R.string.advantage));
                } else if (pointsPlayer1 == R.string.advantage) {
                    newGame();
                    if(scorePlayer1<10)
                    {scorePlayer1 = scorePlayer1 + 1;
                    displayScorePlayer1();}
                    if(scorePlayer1==10){
                        Context context = getApplicationContext();
                        CharSequence text = getText(R.string.player1)+ " won!";
                        int duration = Toast.LENGTH_LONG;
                        Toast toastWinner = Toast.makeText(context, text, duration);
                        toastWinner.show();
                        reset();
                    }


                } else if (pointsPlayer2 == R.string.advantage) {
                    pointsPlayer1 = 40;
                    pointsPlayer2 = 40;
                    displayPointsForPlayer2();
                    displayPointsForPlayer1();
                        Context context = getApplicationContext();
                        CharSequence text = "Deuce";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toastDeuce = Toast.makeText(context, text, duration);
                        toastDeuce.show();
                    }
                }

            }
    public void addPointsForPlayer2(View view) {
        if (pointsPlayer2 < 30) {
            pointsPlayer2 = pointsPlayer2 + 15;
            displayPointsForPlayer2();
        } else if (pointsPlayer2 == 30) {
            pointsPlayer2 = 40;
            displayPointsForPlayer2();
            if(pointsPlayer1 == 40){
                Context context = getApplicationContext();
                CharSequence text = "Deuce";
                int duration = Toast.LENGTH_SHORT;
                Toast toastDeuce = Toast.makeText(context, text, duration);
                toastDeuce.show();
            }
        } else {
            if (pointsPlayer2 == 40 && pointsPlayer1 < pointsPlayer2) {
                newGame();
                if(scorePlayer2<10)
                {scorePlayer2 = scorePlayer2 + 1;
                    displayScorePlayer2();}
                if(scorePlayer2==10){
                    Context context = getApplicationContext();
                    CharSequence text = getText(R.string.player2)+ " won!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toastWinner = Toast.makeText(context, text, duration);
                    toastWinner.show();
                    reset();
                }

            }
            if (pointsPlayer1 == pointsPlayer2 && pointsPlayer2 == 40) {
                pointsPlayer2= R.string.advantage;
                TextView pointsPlayer2TextView = (TextView) findViewById(R.id.points_player2);
                pointsPlayer2TextView.setText(getText(R.string.advantage));
                Context context = getApplicationContext();
                CharSequence text = "Advantage for "+ getText(R.string.player2);
                int duration = Toast.LENGTH_SHORT;
                Toast toastAD = Toast.makeText(context, text, duration);
                toastAD.show();
            } else if (pointsPlayer2 == R.string.advantage) {
                newGame();
                if(scorePlayer2<10)
                {scorePlayer2 = scorePlayer2 + 1;
                    displayScorePlayer2();}
                if(scorePlayer2==10){
                    Context context = getApplicationContext();
                    CharSequence text = getText(R.string.player2)+ " won!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toastWinner = Toast.makeText(context, text, duration);
                    toastWinner.show();
                    reset();
                }

            } else if (pointsPlayer1 == R.string.advantage) {
                pointsPlayer1 = 40;
                pointsPlayer2 = 40;
                displayPointsForPlayer1();
                displayPointsForPlayer2();
                    Context context = getApplicationContext();
                    CharSequence text = "Deuce";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toastDeuce = Toast.makeText(context, text, duration);
                    toastDeuce.show();
            }
        }
    }

    public void newGame() {
        pointsPlayer1 = 0;
        pointsPlayer2 = 0;
        displayPointsForPlayer1();
        displayPointsForPlayer2();
    }

    public void addPointsForPlayer1() {
        if (pointsPlayer1 < 30) {
            pointsPlayer1 = pointsPlayer1 + 15;
            displayPointsForPlayer1();
        } else if (pointsPlayer1 == 30) {
            pointsPlayer1 = 40;
            displayPointsForPlayer1();
            if(pointsPlayer2 == 40){
                Context context = getApplicationContext();
                CharSequence text = "Deuce";
                int duration = Toast.LENGTH_SHORT;
                Toast toastDeuce = Toast.makeText(context, text, duration);
                toastDeuce.show();
            }
        } else {
            if (pointsPlayer1 == 40 && pointsPlayer1 > pointsPlayer2) {
                newGame();
                if(scorePlayer1<10)
                {scorePlayer1 = scorePlayer1 + 1;
                    displayScorePlayer1();}
                if(scorePlayer1==10){
                    Context context = getApplicationContext();
                    CharSequence text = getText(R.string.player1)+ " won!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toastWinner = Toast.makeText(context, text, duration);
                    toastWinner.show();
                    reset();
                }
            }
            if (pointsPlayer1 == pointsPlayer2 && pointsPlayer1 == 40) {
                pointsPlayer1 = R.string.advantage;
                TextView pointsPlayer1TextView = (TextView) findViewById(R.id.points_player1);
                pointsPlayer1TextView.setText(getText(R.string.advantage));
                Context context = getApplicationContext();
                CharSequence text = "Advantage for "+ getText(R.string.player1);
                int duration = Toast.LENGTH_SHORT;
                Toast toastAD = Toast.makeText(context, text, duration);
                toastAD.show();
            } else if (pointsPlayer1 == R.string.advantage) {
                newGame();
                if(scorePlayer1<10)
                {scorePlayer1 = scorePlayer1 + 1;
                    displayScorePlayer1();}
                if(scorePlayer1==10){
                    Context context = getApplicationContext();
                    CharSequence text = getText(R.string.player1)+ " won!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toastWinner = Toast.makeText(context, text, duration);
                    toastWinner.show();
                    reset();
                }
            } else if (pointsPlayer2 == R.string.advantage) {
                pointsPlayer1 = 40;
                pointsPlayer2 = 40;
                displayPointsForPlayer2();
                displayPointsForPlayer1();
                    Context context = getApplicationContext();
                    CharSequence text = "Deuce";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toastDeuce = Toast.makeText(context, text, duration);
                    toastDeuce.show();
            }
        }
    }

    public void addPointsForPlayer2() {
        if (pointsPlayer2 < 30) {
            pointsPlayer2 = pointsPlayer2 + 15;
            displayPointsForPlayer2();
        } else if (pointsPlayer2 == 30) {
            pointsPlayer2 = 40;
            displayPointsForPlayer2();
            if(pointsPlayer1 == 40){
                Context context = getApplicationContext();
                CharSequence text = "Deuce";
                int duration = Toast.LENGTH_SHORT;
                Toast toastDeuce = Toast.makeText(context, text, duration);
                toastDeuce.show();
            }
        } else {
            if (pointsPlayer2 == 40 && pointsPlayer1 < pointsPlayer2) {
                newGame();
                if(scorePlayer2<10)
                {scorePlayer2 = scorePlayer2 + 1;
                    displayScorePlayer2();}
                if(scorePlayer2==10){
                    Context context = getApplicationContext();
                    CharSequence text = getText(R.string.player2)+ " won!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toastWinner = Toast.makeText(context, text, duration);
                    toastWinner.show();
                    reset();
                }
            }
            if (pointsPlayer1 == pointsPlayer2 && pointsPlayer2 == 40) {
                pointsPlayer2 = R.string.advantage;
                TextView pointsPlayer2TextView = (TextView) findViewById(R.id.points_player2);
                pointsPlayer2TextView.setText(getText(R.string.advantage));
                Context context = getApplicationContext();
                CharSequence text = "Advantage for "+ getText(R.string.player2);
                int duration = Toast.LENGTH_SHORT;
                Toast toastAD = Toast.makeText(context, text, duration);
                toastAD.show();
            } else if (pointsPlayer2 == R.string.advantage) {
                newGame();
                if(scorePlayer2<10)
                {scorePlayer2 = scorePlayer2 + 1;
                    displayScorePlayer2();}
                if(scorePlayer2==10){
                    Context context = getApplicationContext();
                    CharSequence text = getText(R.string.player2)+ " won!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toastWinner = Toast.makeText(context, text, duration);
                    toastWinner.show();
                    reset();

                }

            } else if (pointsPlayer1 == R.string.advantage) {
                pointsPlayer1 = 40;
                pointsPlayer2 = 40;
                displayPointsForPlayer1();
                displayPointsForPlayer2();
                    Context context = getApplicationContext();
                    CharSequence text = "Deuce";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toastDeuce = Toast.makeText(context, text, duration);
                    toastDeuce.show();

            }
        }
    }

    public void acePlayer1(View view) {
        acesPlayer1++;
        displayAcePlayer1();
        addPointsForPlayer1();
    }

    public void acePlayer2(View view) {
        acesPlayer2++;
        displayAcePlayer2();
        addPointsForPlayer2();
    }

    public void doubleFaultPlayer1(View view) {
        faultsPlayer1++;
        displayDoubleFaultPlayer1();
        addPointsForPlayer2();
    }

    public void doubleFaultPlayer2(View view) {
        faultsPlayer2++;
        displayDoubleFaultPlayer2();
        addPointsForPlayer1();
    }

    public void reset(View view) {
        pointsPlayer1 = 0;
        displayPointsForPlayer1();
        pointsPlayer2 = 0;
        displayPointsForPlayer2();
        acesPlayer1 = 0;
        displayAcePlayer1();
        acesPlayer2 = 0;
        displayAcePlayer2();
        faultsPlayer1 = 0;
        displayDoubleFaultPlayer1();
        faultsPlayer2 = 0;
        displayDoubleFaultPlayer2();
        scorePlayer1 = 0;
        displayScorePlayer1();
        scorePlayer2 = 0;
        displayScorePlayer2();
    }
    public void reset() {
        pointsPlayer1 = 0;
        displayPointsForPlayer1();
        pointsPlayer2 = 0;
        displayPointsForPlayer2();
        acesPlayer1 = 0;
        displayAcePlayer1();
        acesPlayer2 = 0;
        displayAcePlayer2();
        faultsPlayer1 = 0;
        displayDoubleFaultPlayer1();
        faultsPlayer2 = 0;
        displayDoubleFaultPlayer2();
        scorePlayer1 = 0;
        displayScorePlayer1();
        scorePlayer2 = 0;
        displayScorePlayer2();
    }
}

