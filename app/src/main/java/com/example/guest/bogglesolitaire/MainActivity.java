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
        String y;
        for (int i = 0; i < 8; i++) {
            x = rndChar();
            y = x.toString();
            Log.d("random char:", y);
        }
    }

    private static char rndChar () {
        int rnd = (int) (Math.random() * 26); // or use Random or whatever
        char base = 'A';
        return (char) (base + rnd % 26);

    }
}
