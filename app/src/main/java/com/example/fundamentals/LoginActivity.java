package com.example.fundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

   TextView enlaceSup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        enlaceSup = findViewById(R.id.enlaceSup);
        enlaceSup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            openSignUp();
            }
        });


    }

    public void openSignUp(){
        Intent intent = new Intent(this, SignupActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);


        startActivity(intent);







    }
}