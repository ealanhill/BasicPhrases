package com.example.ahill.basicphrases;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class BasicPhrasesActivity extends AppCompatActivity {

    public void playPhrase(View view) {
        String fileName = "";

        try {
            // attempt to retrieve the name of the file associated with the id
            fileName = view.getResources().getResourceEntryName(view.getId());
        } catch(Resources.NotFoundException e) {
            Log.e("Error", "Could not file resource");
            return;
        }

        // retrieve the android resource id associated with the file name
        int resourceId = getResources().getIdentifier(fileName, "raw", "com.example.ahill.basicphrases");

        // create a new media player to play the file
        MediaPlayer mediaPlayer = MediaPlayer.create(this, resourceId);
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basi_phrases);
    }
}
