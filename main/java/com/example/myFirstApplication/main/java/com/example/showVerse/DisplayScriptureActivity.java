package com.example.showVerse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScriptureActivity extends AppCompatActivity {

    public static final String BOOK = "BOOK";
    public static final String CHAPTER = "CHAPTER";
    public static final String VERSE = "VERSE";

    private String message1;
    private String message2;
    private String message3;

    private static final String TAG = "DisplayScripture";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        message1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        message3 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        String message = message1 + " " + message2 + ":" + message3;
        Log.d(TAG, "AReceived intent with " + message);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView3);
        textView.setText(message);


    }

    public void saveScripture(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("myScripturePref", MODE_PRIVATE);


        //saves scripture to preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("preference_scripture_book", message1);
        editor.putString("preference_scripture_chapter", message2);
        editor.putString("preference_scripture_verse", message3);
        editor.commit();

        //notifies user that the scripture has been saved
        Context context = getApplicationContext();
        CharSequence text = "Scripture saved";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }
}

