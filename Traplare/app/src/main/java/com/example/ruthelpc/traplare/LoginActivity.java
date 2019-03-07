package com.example.ruthelpc.traplare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView textView_Logo;
    TextView textView_forgotten_password;
    EditText editView_login;
    EditText editView_password;
    Button button_sign_in;
    TextView textView_sign_up;
    Intent parent;
    public static AssetManager asset;
    String username;
    String password;
    ProgressDialog mProgressDialog;


    private ApiInterface apiInterface;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (2 == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent
            parent = data.getSelector();
            startActivity(parent);
        }
        if (0 == resultCode){
            username = data.getStringExtra("account");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        asset = getAssets();

        textView_Logo = findViewById(R.id.textView_Logo);
        textView_forgotten_password = findViewById(R.id.textView_forgotten_password);
        editView_login = findViewById(R.id.editView_login);
        editView_password = findViewById(R.id.editView_password);
        button_sign_in = findViewById(R.id.button_sign_in);
        textView_sign_up = findViewById(R.id.textView_sign_up);

        Typeface ProductSans = Typeface.createFromAsset(LoginActivity.asset,"fonts/Product Sans Bold.ttf");
        Typeface RobotoReg = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");
        textView_Logo.setTypeface(ProductSans);
        textView_forgotten_password.setTypeface(RobotoReg);
        editView_login.setTypeface(RobotoReg);
        editView_password.setTypeface(RobotoReg);
        button_sign_in.setTypeface(RobotoReg);
        textView_sign_up.setTypeface(RobotoReg);

        if(username != null){
            editView_login.setText(username);
        }

        textView_forgotten_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot = new Intent(LoginActivity.this, ForgottenActivity.class);
                startActivity(forgot);
            }
        });

        button_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(parent==null)
            {
               // Intent intent = new Intent(LoginActivity.this,PlanningActivity.class);
                //startActivity(intent);
                username = editView_login.getText().toString();
                password = editView_password.getText().toString();
                if (username!="" && password!="")
                {
                    compute();
                    login(username,password);
                }
                else
                {
                    editView_login.setError("please enter your username");
                    editView_password.setError("please enter your password");
                }
            }
            else{
                startActivity(parent);
            }
            }
        });

        textView_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private void compute() {
        mProgressDialog = ProgressDialog.show(this, "",
                "Veuillez patienter ...", true);
        mProgressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        new Thread((new Runnable() {
            @Override
            public void run() {
                mProgressDialog.setMessage("Veuillez patienter ...");
            }
        })).start();
        // ...
    }
    public void login(final String username,final String password )
    {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<users> call=apiInterface.login(username,password);
        call.enqueue(new Callback<users>() {
            @Override
            public void onResponse(@NonNull Call<users> call, @NonNull Response<users> response) {
                String m =  response.body().getMessage();
                int v=response.body().getSuccess();

                String uf = response.body().getFirstname();
                String un = response.body().getUsername();
                users_connected User = new users_connected(un, uf);
                Serializer.Serilize("user_data", User, getApplicationContext());
                if (v == 1)
                {
                    Toast.makeText(LoginActivity.this,response.body().getMessage(),
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this,PlanningActivity.class);
                    mProgressDialog.dismiss();
                    startActivity(intent);
                }
                else
                {
                    mProgressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,response.body().getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<users> call, @NonNull Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(LoginActivity.this,t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }


}
