package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView textView_Logo;
    TextView textView_forgotten_password;
    EditText editView_login;
    EditText editView_password;
    Button button_sign_in;
    Button button_sign_up;
    Intent parent;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (2 == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent
            parent = data.getSelector();
            startActivity(parent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        textView_Logo = findViewById(R.id.textView_Logo);
        textView_forgotten_password = findViewById(R.id.textView_forgotten_password);
        editView_login = findViewById(R.id.editView_login);
        editView_password = findViewById(R.id.editView_password);
        button_sign_in = findViewById(R.id.button_sign_in);
        button_sign_up = findViewById(R.id.button_sign_up);

        Typeface  RobotoReg = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");

        Typeface  ProductSans= Typeface.createFromAsset(getAssets(),"fonts/Product Sans Bold.ttf");
        textView_Logo.setTypeface(ProductSans);
        textView_forgotten_password.setTypeface(RobotoReg);
        editView_login.setTypeface(RobotoReg);
        editView_password.setTypeface(RobotoReg);
        button_sign_in.setTypeface(RobotoReg);
        button_sign_up.setTypeface(RobotoReg);


        button_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(parent==null)
                {
                    Intent intent = new Intent(LoginActivity.this,PlanningActivity.class);
                    startActivity(intent);
                }
                else{
                    startActivity(parent);
                }

            }
        });


    }
}
