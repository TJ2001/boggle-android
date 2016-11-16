package com.example.guest.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {
    @Bind(R.id.resetGame) Button mResetGameButton;
    @Bind(R.id.letter0) TextView mLetter0;
    @Bind(R.id.letter1) TextView mLetter1;
    @Bind(R.id.letter2) TextView mLetter2;
    @Bind(R.id.letter3) TextView mLetter3;
    @Bind(R.id.letter4) TextView mLetter4;
    @Bind(R.id.letter5) TextView mLetter5;
    @Bind(R.id.letter6) TextView mLetter6;
    @Bind(R.id.letter7) TextView mLetter7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String randomCharacters;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        randomCharacters = generateString();
        Log.d("Your random string is", randomCharacters);
        Character x = randomCharacters.charAt(0);
        Character x1 = randomCharacters.charAt(1);
        Character x2 = randomCharacters.charAt(2);
        Character x3 = randomCharacters.charAt(3);
        Character x4 = randomCharacters.charAt(4);
        Character x5 = randomCharacters.charAt(5);
        Character x6 = randomCharacters.charAt(6);
        Character x7 = randomCharacters.charAt(7);
        mLetter0.setText(x.toString());
        mLetter1.setText(x1.toString());
        mLetter2.setText(x2.toString());
        mLetter3.setText(x3.toString());
        mLetter4.setText(x4.toString());
        mLetter5.setText(x5.toString());
        mLetter6.setText(x6.toString());
        mLetter7.setText(x7.toString());
    }

    private String generateString(){
        Character x;
        String y = "";
        String tmp;
        for (int i = 0; i < 8; i++) {
            if (i == 0 || i == 1) {
                do {
                    x = rndChar();
                    tmp = x.toString();
                } while (!(tmp.equals("A") || tmp.equals("E") || tmp.equals("I") || tmp.equals("O") || tmp.equals("U")));
            } else{
                x = rndChar();
            }
            y += x.toString();
        }
        return y;
    }

    private static char rndChar () {
        return (char) ('A' + (Math.random() * 26) % 26);
    }
}
