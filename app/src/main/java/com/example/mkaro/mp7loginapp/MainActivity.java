package com.example.mkaro.mp7loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Password;
    private EditText Username;
    private Button Login;
    private TextView Attempts;
    private int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Password = (EditText)findViewById(R.id.etPassword);
        Username = (EditText)findViewById(R.id.etUsername);
        Login = (Button)findViewById(R.id.btnLogin);
        Attempts = (TextView)findViewById(R.id.tvInfo);
        Attempts.setText("Attempts: 3");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(Username.getText().toString(), Password.getText().toString());
            }
        });
    }
    private void check(String name, String userPassword) {
        if ((name.equals("Student")) && (userPassword.equals("cs125"))) {
            Intent intention = new Intent(MainActivity.this, ActivityTwo.class);
            startActivity(intention);
        } else {
            count--;
            Attempts.setText("Attempts: " + String.valueOf(count));
            if (count == 0) {
                Login.setEnabled(false);
            }
        }
    }
}
