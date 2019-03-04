package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    TextView textView_Logo;
    TextView textView_already_has_account;
    EditText editView_first_name;
    EditText editView_identity_piece_value;
    EditText editView_telephone;
    EditText editView_address;
    EditText editView_user_account;
    EditText editView_password;
    Button btnsignup;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //getSupportActionBar().hide();

        textView_Logo = findViewById(R.id.textView_Logo);
        textView_already_has_account = findViewById(R.id.textView_already_has_account);
        editView_first_name = findViewById(R.id.editView_first_name);
        editView_identity_piece_value = findViewById(R.id.editView_identity_piece_value);
        editView_telephone = findViewById(R.id.editView_telephone);
        editView_address = findViewById(R.id.editView_address);
        editView_user_account = findViewById(R.id.editView_user_account);
        editView_password = findViewById(R.id.editView_password);
        btnsignup=findViewById(R.id.button_sign_up);

        textView_Logo.setTypeface(DataComplement.ProductSans);
        textView_already_has_account.setTypeface(DataComplement.RobotoReg);
        editView_first_name.setTypeface(DataComplement.RobotoReg);
        editView_identity_piece_value.setTypeface(DataComplement.RobotoReg);
        editView_telephone.setTypeface(DataComplement.RobotoReg);
        editView_address.setTypeface(DataComplement.RobotoReg);
        editView_user_account.setTypeface(DataComplement.RobotoReg);
        editView_password.setTypeface(DataComplement.RobotoReg);

            textView_already_has_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign_in = new Intent(RegisterActivity.this, LoginActivity.class);
                sign_in.putExtra("account", editView_user_account.getText().toString());
                finishActivity(RESULT_OK);
                startActivityForResult(sign_in, 0);

            }
        });

            btnsignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String username=editView_user_account.getText().toString();
                    String name=editView_first_name.getText().toString();
                    String cni=editView_identity_piece_value.getText().toString();
                    String password=editView_password.getText().toString();
                    String phone=editView_telephone.getText().toString();
                    String email=editView_address.getText().toString();
                    Inscription(username,name,cni,password);
                }
            });
    }
    public void Inscription(final String username,final String  name,final String cni,final String password
   // final String email,String phone
    )
    {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<users> call=apiInterface.login(username,password);
        call.enqueue(new Callback<users>() {
            @Override
            public void onResponse(@NonNull Call<users> call, @NonNull Response<users> response) {
                String m =  response.body().getMessage();
                int v=response.body().getSuccess();
                String u=response.body().getUsername();
                if (v == 1)
                {
                    Toast.makeText(RegisterActivity.this,response.body().getMessage(),
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this,PlanningActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,response.body().getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<users> call, @NonNull Throwable t) {

                Toast.makeText(RegisterActivity.this,t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

}
