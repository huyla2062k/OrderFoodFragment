package com.laduchuy.oderfood;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText etUser,etPass;
    Button btnLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        btnLogIn = findViewById(R.id.btnLog);
        etUser = findViewById(R.id.tvUser);
        etPass = findViewById(R.id.tvPass);

        final String user = etUser.getText().toString();
        final String pass = etPass.getText().toString();
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user==null||pass==null) {
                    Toast.makeText(getBaseContext(), "Log in failed", Toast.LENGTH_LONG).show();
                }
                else  {
                    startActivity(new Intent(getBaseContext(),MainActivity.class));
                }
            }
        });




    }

}