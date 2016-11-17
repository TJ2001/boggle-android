package com.example.guest.bogglesolitaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.resetGame) Button mResetGameButton;
    @Bind(R.id.submit) Button mSubmitButton;
    @Bind(R.id.submission) EditText mSubmission;
    @Bind(R.id.letter0) TextView mLetter0;
    @Bind(R.id.letter1) TextView mLetter1;
    @Bind(R.id.letter2) TextView mLetter2;
    @Bind(R.id.letter3) TextView mLetter3;
    @Bind(R.id.letter4) TextView mLetter4;
    @Bind(R.id.letter5) TextView mLetter5;
    @Bind(R.id.letter6) TextView mLetter6;
    @Bind(R.id.letter7) TextView mLetter7;

    private String mRandomCharacters = "";
    private ArrayList<String> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        setViews();

        mResetGameButton.setOnClickListener(this);
        mSubmitButton.setOnClickListener(this);
    }

    private void setViews(){
        mRandomCharacters = generateString();
        Log.d("Your random string is", mRandomCharacters);
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            characters.add(mRandomCharacters.charAt(i));
        }
        mLetter0.setText(characters.get(0).toString());
        mLetter1.setText(characters.get(1).toString());
        mLetter2.setText(characters.get(2).toString());
        mLetter3.setText(characters.get(3).toString());
        mLetter4.setText(characters.get(4).toString());
        mLetter5.setText(characters.get(5).toString());
        mLetter6.setText(characters.get(6).toString());
        mLetter7.setText(characters.get(7).toString());
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

    @Override
    public void onClick(View v) {
        if(v == mResetGameButton) {
            setViews();
        }else if( v == mSubmitButton){
            String word = mSubmission.getText().toString().toUpperCase();
            mSubmission.setText("");
            if (word.length() > 2 &&  word.length() < 9) {
                boolean valid = true;
                Character x;
                Log.d("info", "word we are looking at is" + mRandomCharacters);
                for (int i = 0; i < word.length(); i++) {
                    x = word.charAt(i);
                    Log.d("info", "looking at " + x.toString());
                    if (!(mRandomCharacters.contains(x.toString()))) {
                        Log.d("info", x.toString() + " is illegal");
                        valid = false;
                    }
                }
                if (valid) {
                    if (!containsWord(mRandomCharacters,word)) {
                        Toast.makeText(GameActivity.this, "Word contains extra characters", Toast.LENGTH_LONG).show();
                    }else{
                        words.add(word);
                        Intent intent = new Intent(GameActivity.this, WordListActivity.class);
                        intent.putStringArrayListExtra("words", words);
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(GameActivity.this, "Word contains illegal characters", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(GameActivity.this, "Word is not correct length", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean containsWord(String random, String word) {
        List<Character> list = new LinkedList<>();
        for (char latter : random.toCharArray()) {
            list.add(latter);
        }
        for (Character latter : word.toCharArray()) {
            if (!list.remove(latter)) {
                return false;
            }
        }
        return true;
    }
}
