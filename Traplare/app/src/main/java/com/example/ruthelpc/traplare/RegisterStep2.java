package com.example.ruthelpc.traplare;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
    ProgressDialog mProgressDialog;
    client client;

    private ApiInterface apiInterface;

    String prenom;
    String nom;
    String cni;
    String telephone;
    String email;
    String photo;
    String mot_de_passe;
    String username;
    int principalViewId;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==0 && resultCode== Activity.RESULT_OK)
        {
            prenom = data.getStringExtra("first");
            nom = data.getStringExtra("last");
            cni = data.getStringExtra("cni");
            telephone = data.getStringExtra("phone");
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
                prenom = intent.getStringExtra("first");
            if (intent.hasExtra("last"))
                nom = intent.getStringExtra("last");
            if (intent.hasExtra("cni"))
                cni = intent.getStringExtra("cni");
            if (intent.hasExtra("phone"))
                telephone = intent.getStringExtra("phone");
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
                mot_de_passe = editView_password.getText().toString();
                username = editView_user_account.getText().toString();

                compute();
                register(username,nom,prenom,cni,email,telephone,photo,mot_de_passe);
            }
        });
        }

        public void register(final String username, final String nom,
                             final String prenom, final String cni,
                             final String  email, final String telephone,
                             final String photo, final String mot_de_passe)
        {
            apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
            Call<client> call=apiInterface.register(username,nom,prenom,cni,email,telephone,photo,mot_de_passe);
            call.enqueue(new Callback<client>() {
            @Override
            public void onResponse(@NonNull Call<client> call, @NonNull Response<client> response) {
                String m =  response.body().getMessage();
                int v=response.body().getSuccess();
                if (v == 1)
                {
                    Toast.makeText(RegisterStep2.this,response.body().getMessage(),
                    Toast.LENGTH_SHORT).show();
                    //login(username, mot_de_passe, RegisterStep2.this, PlanningActivity.class, mProgressDialog);
                    Intent intent = new Intent(RegisterStep2.this,PlanningActivity.class);
                    startActivity(intent);
                }
                else
                {
                    mProgressDialog.dismiss();
                    Toast.makeText(RegisterStep2.this,response.body().getMessage(),
                    Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<client> call, @NonNull Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(RegisterStep2.this,t.getLocalizedMessage(),
                Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void compute() {
        mProgressDialog = ProgressDialog.show(this, "",
                "Veuillez patienter ...", true);
        mProgressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        new Thread((new Runnable() {
            @Override
            public void run() {
                mProgressDialog.setMessage("Veuillez patienter ...");
            }
        })).start();
        // ...
    }

    public void login(final String username_cli,
                      final String mot_de_passe_cli,
                      final Context context,
                      final Class classe,
                      final ProgressDialog mProgressDialog)
    {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<client>call=apiInterface.login(username_cli, mot_de_passe_cli);
        call.enqueue(new Callback<client>() {

            @Override
            public void onResponse(@NonNull Call<client> call,
                                   @NonNull Response<client> response) {
                client =response.body();
                if(client.getSuccess() == 1) {
                    Intent intent = new Intent(context, classe);
                    mProgressDialog.dismiss();
                    finish();
                    startActivity(intent);
                }
                else
                {
                    mProgressDialog.dismiss();
                    Toast.makeText(context,client.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<client> call, @NonNull Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(context,t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

}
