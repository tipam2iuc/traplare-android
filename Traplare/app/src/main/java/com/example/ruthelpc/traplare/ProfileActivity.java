package com.example.ruthelpc.traplare;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
TextView textView_user_account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textView_user_account = findViewById(R.id.textView_user_account);

        Typeface roboto_Regular = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");
        textView_user_account.setTypeface(roboto_Regular);
    }
}
