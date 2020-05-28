package com.example.showVerse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "com.example.showVerse.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.showVerse.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.showVerse.MESSAGE3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the send button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayScriptureActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String message1 = editText.getText().toString();
        String message2 = editText2.getText().toString();
        String message3 = editText3.getText().toString();

        String message = editText.getText().toString() + " " + editText2.getText().toString() + ":" + editText3.getText().toString();
        Log.d(TAG, "About to create intent with " + message);
        intent.putExtra(EXTRA_MESSAGE, message1);
        intent.putExtra(EXTRA_MESSAGE2, message2);
        intent.putExtra(EXTRA_MESSAGE3, message3);

        startActivity(intent);
    }

    /**
     * Called when the user taps the save button
     */
    public void loadScripture(View view) {
        SharedPreferences sharedPref = getSharedPreferences(
                "myScripturePref", Context.MODE_PRIVATE);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String book = sharedPref.getString("preference_scripture_book", "Isaiah");
        editText.setText(book);
        String chapter = sharedPref.getString("preference_scripture_chapter", "1");
        editText2.setText(chapter);
        String verse = sharedPref.getString("preference_scripture_verse", "18");
        editText3.setText(verse);
    }
}