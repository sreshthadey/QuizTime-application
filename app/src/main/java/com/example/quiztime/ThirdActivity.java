package com.example.quiztime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();


        String message = intent.getStringExtra(keystore.USER_NAME);
        TextView tv = findViewById(R.id.tv_username);

        tv.setText("Hi, " + message);

    }
    @Override
    protected void onPause() {
        super.onPause();
        
        Log.d("onPause", "onPause is called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("onStop", "onStop is called");
    }


    public void openActivityMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openActivityTwo(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}