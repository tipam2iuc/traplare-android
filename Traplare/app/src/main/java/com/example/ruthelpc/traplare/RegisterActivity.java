package com.example.ruthelpc.traplare;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
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

public class RegisterActivity extends AppCompatActivity {
    EditText editView_user_account;
    TextView textView_already_has_account;
    EditText editView_confirm_password;
    EditText editView_password;
    EditText editView_telephone;
    Button button_sign_up;
    ProgressDialog mProgressDialog;
    client client;

    private ApiInterface apiInterface;

    String prenom = "";
    String nom = "";
    String cni = "";
    String telephone = "";
    String email = "";
    String photo = "";
    String mot_de_passe = "";
    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editView_confirm_password = findViewById(R.id.editView_confirm_password);
        editView_password = findViewById(R.id.editView_password);
        editView_user_account = findViewById(R.id.editView_user_account);
        textView_already_has_account = findViewById(R.id.textView_already_has_account);
        button_sign_up = findViewById(R.id.button_sign_up);
        editView_telephone = findViewById(R.id.editView_telephone);

        Typeface RobotoReg = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");
        Typeface ProductSans = Typeface.createFromAsset(LoginActivity.asset,"fonts/Product Sans Bold.ttf");
        Typeface RobotoBoldCondensed = Typeface.createFromAsset(LoginActivity.asset, "fonts/Roboto-BoldCondensed.ttf");
        editView_user_account.setTypeface(RobotoReg);
        editView_confirm_password.setTypeface(RobotoReg);
        textView_already_has_account.setTypeface(RobotoReg);
        editView_password.setTypeface(RobotoReg);
        button_sign_up.setTypeface(RobotoReg);

        textView_already_has_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        TextWatcher change = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              // if(editView_user_account.getText().toString().length() > 0
              //    && editView_telephone.getText().toString().length() > 8
              //    && editView_password.getText().toString().length() > 8
              //    && editView_confirm_password.getText().toString() ==
              //    editView_password.getText().toString())
              // button_sign_up.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        editView_user_account.addTextChangedListener(change);
        editView_password.addTextChangedListener(change);
        editView_confirm_password.addTextChangedListener(change);
        editView_telephone.addTextChangedListener(change);

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
                //    Toast.makeText(RegisterActivity.this,response.body().getMessage(),
                //    Toast.LENGTH_SHORT).show();
                    login(username, mot_de_passe, RegisterActivity.this, PlanningActivity.class, mProgressDialog);
                    Intent intent = new Intent(RegisterActivity.this,PlanningActivity.class);
                    startActivity(intent);
                }
                else
                {
                    mProgressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this,response.body().getMessage(),
                    Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<client> call, @NonNull Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(RegisterActivity.this,t.getLocalizedMessage(),
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

    public void login(final String telephone_cli,
                      final String mot_de_passe_cli,
                      final Context context,
                      final Class classe,
                      final ProgressDialog mProgressDialog)
    {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<client>call=apiInterface.login(telephone_cli, mot_de_passe_cli);
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
  //  private void chooseFile() {
  //      Intent intent = new Intent();
  //      intent.setType("image/*");
  //      intent.setAction(Intent.ACTION_GET_CONTENT);
  //      startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
  //  }

  //  public String getStringImage(){
  //      ByteArrayOutputStream baos = new ByteArrayOutputStream();
  //      Bitmap bitmap = new Bitmap();
  //      bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
  //      byte[] imageBytes = baos.toByteArray();
  //      String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
  //      return encodedImage;
   // }
}
