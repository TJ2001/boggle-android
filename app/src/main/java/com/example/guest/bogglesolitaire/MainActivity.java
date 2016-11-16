package com.example.guest.bogglesolitaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Character x;
        String y = "";
        String tmp;
        for (int i = 0; i < 8; i++) {
            if (i == 0 || i == 1) {
                do {
                    x = rndChar();
                    tmp = x.toString();
                    Log.d("randm string is", tmp);
                } while (!(tmp.equals("A") || tmp.equals("E") || tmp.equals("I") || tmp.equals("O") || tmp.equals("U")));
            } else{
                x = rndChar();
            }
            y += x.toString();
        }
        Log.d("random string:", y);
    }

    private static char rndChar () {
        return (char) ('A' + (Math.random() * 26) % 26);
    }
}
