package com.example.flowers_k;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_screen);
        final MediaPlayer cse = MediaPlayer.create(this, R.raw.tootoo);
        Button playsound = (Button) this.findViewById(R.id.btn_sound);
        playsound.setVisibility(View.VISIBLE);
        playsound.setBackgroundColor(Color.TRANSPARENT);
        playsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cse.start();
            }
        });
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}