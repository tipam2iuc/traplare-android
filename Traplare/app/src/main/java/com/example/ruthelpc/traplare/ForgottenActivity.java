package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ForgottenActivity extends AppCompatActivity {

    TextView textView_Logo;
    EditText editView_user_account;
    EditText editView_user_phone;
    EditText editView_password;
    TextView textView_new_account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten);
//        getSupportActionBar().hide();
        textView_Logo = findViewById(R.id.textView_Logo);
        editView_user_account = findViewById(R.id.editView_user_account);
        editView_user_phone = findViewById(R.id.editView_user_phone);
        editView_password = findViewById(R.id.editView_password);
        textView_new_account = findViewById(R.id.textView_create_new_account);

        Typeface ProductSans = Typeface.createFromAsset(LoginActivity.asset,"fonts/Product Sans Bold.ttf");
        Typeface RobotoReg = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");

        textView_Logo.setTypeface(ProductSans);
        editView_user_account.setTypeface(RobotoReg);
        editView_user_phone.setTypeface(RobotoReg);
        editView_password.setTypeface(RobotoReg);
        textView_new_account.setTypeface(RobotoReg);

        textView_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign_up = new Intent(ForgottenActivity.this, RegisterActivity.class);
                startActivity(sign_up);
            }
        });


    }
}
