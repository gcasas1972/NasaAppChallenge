package com.qpa.alg;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.Toolbar;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}