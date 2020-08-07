package com.example.quiztime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText userNmae;
    private EditText password;
    private Button login;
    private int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNmae = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(userNmae.getText().toString(), password.getText().toString());
            }
        });

    }
    private void validate(String name, String userPassword){
        if((name.equals("sreshtha")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(this, ThirdActivity.class);
            intent.putExtra(keystore.USER_NAME, name);
            startActivity(intent);
        }else{
            count--;
            String m = "Invalid Username or password";
            Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
            userNmae.setText(null);
            password.setText(null);

            if(count == 0){
                login.setEnabled(false);
            }
        }
    }
}