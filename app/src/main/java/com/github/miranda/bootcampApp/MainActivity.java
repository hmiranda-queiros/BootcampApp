package com.github.miranda.bootcampApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.mainGoButton);
        button.setOnClickListener((View v) -> {
            Intent intent = new Intent(MainActivity.this, GreetingActivity.class);
            EditText txtName = findViewById(R.id.MainName);
            String name = txtName.getText().toString();
            intent.putExtra("name", name);
            MainActivity.this.startActivity(intent);
        });
    }


}