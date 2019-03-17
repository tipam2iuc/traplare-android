package com.example.ruthelpc.traplare;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterStep2 extends AppCompatActivity {
    EditText editView_user_account;
    TextView textView_etape2;
    TextView textView_already_has_account;
    EditText editView_confirm_password;
    EditText editView_password;
    Button button_precedent;
    Button button_sign_up;
    private Bitmap bitmap;


    private ApiInterface apiInterface;

    String first_name;
    String last_name;
    String cni;
    String phone;
    String email;
    String image;
    String password;
    String username;
    int principalViewId;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==0 && resultCode== Activity.RESULT_OK)
        {
            first_name = data.getStringExtra("first");
            last_name = data.getStringExtra("last");
            cni = data.getStringExtra("cni");
            phone = data.getStringExtra("phone");
            email = data.getStringExtra("adresse");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_step2);

        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("first"))
                first_name = intent.getStringExtra("first");
            if (intent.hasExtra("last"))
                last_name = intent.getStringExtra("last");
            if (intent.hasExtra("cni"))
                cni = intent.getStringExtra("cni");
            if (intent.hasExtra("phone"))
                phone = intent.getStringExtra("phone");
            if (intent.hasExtra("adresse"))
                email = intent.getStringExtra("adresse");
        }
        editView_confirm_password = findViewById(R.id.editView_confirm_password);
        editView_password = findViewById(R.id.editView_password);
        editView_user_account = findViewById(R.id.editView_user_account);
        button_precedent = findViewById(R.id.button_precedent);
        textView_already_has_account = findViewById(R.id.textView_already_has_account);
        button_sign_up = findViewById(R.id.button_sign_up);
        textView_etape2 = findViewById(R.id.textView_etape2);

        Typeface RobotoReg = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");
        Typeface ProductSans = Typeface.createFromAsset(LoginActivity.asset,"fonts/Product Sans Bold.ttf");
        Typeface RobotoBoldCondensed = Typeface.createFromAsset(LoginActivity.asset, "fonts/Roboto-BoldCondensed.ttf");
        textView_etape2.setTypeface(ProductSans);
        editView_user_account.setTypeface(RobotoReg);
        editView_confirm_password.setTypeface(RobotoReg);
        textView_already_has_account.setTypeface(RobotoReg);
        editView_password.setTypeface(RobotoReg);
        button_precedent.setTypeface(RobotoReg);
        button_sign_up.setTypeface(RobotoReg);

        button_precedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        textView_already_has_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterStep2.this, LoginActivity.class);
                startActivity(i);
            }
        });

        TextWatcher change_account = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            //   button_sign_up.setEnabled(editView_confirm_password.getText().length() >0
            //           && editView_password.getText().length() >0
            //           && editView_user_account.getText().length() >0
            //           && (editView_password.getText() == editView_confirm_password));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        editView_user_account.addTextChangedListener(change_account);
        editView_password.addTextChangedListener(change_account);
        editView_confirm_password.addTextChangedListener(change_account);

        button_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = editView_password.getText().toString();
                username = editView_user_account.getText().toString();


                Inscription(username,first_name, last_name,cni, phone, email,password);
            }
        });
        }

        public void Inscription(final String username, final String first_name,
                                final String last_name, final String cni,
                                final String  phone, final String email,
                                final String password)
        {
            apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
            Call<users> call=apiInterface.inscription(username,first_name,cni,password,last_name,email,phone);
            call.enqueue(new Callback<users>() {
            @Override
            public void onResponse(@NonNull Call<users> call, @NonNull Response<users> response) {
                String m =  response.body().getMessage();
                int v=response.body().getSuccess();
                String u=response.body().getUsername();
                    if (v == 1)
                {
                    Toast.makeText(RegisterStep2.this,response.body().getMessage(),
                    Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterStep2.this,LoginActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(RegisterStep2.this,response.body().getMessage(),
                    Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<users> call, @NonNull Throwable t) {
                Toast.makeText(RegisterStep2.this,t.getLocalizedMessage(),
                Toast.LENGTH_SHORT).show();
            }
        });
    }
}
