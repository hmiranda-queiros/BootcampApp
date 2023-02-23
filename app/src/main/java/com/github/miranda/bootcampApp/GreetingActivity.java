package com.github.miranda.bootcampApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        if (name == null) {
            name = "";
        }
        TextView txtMessage = findViewById(R.id.greetingMessage);
        String message = "Hello " + name + "!";
        txtMessage.setText(message);

    }
}