package com.example.ruthelpc.traplare;

import android.app.Activity;
import android.content.Intent;
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

    TextView textView_Logo;
    TextView textView_etape1;
    EditText editView_first_name;
    EditText editView_last_name;
    EditText editView_identity_piece_value;
    EditText editView_telephone;
    EditText editView_address;
    Button button_next;
    TextView textView_already_has_account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_register);

        textView_Logo = findViewById(R.id.textView_Logo);
        textView_etape1 = findViewById(R.id.textView_etape1);
        editView_first_name = findViewById(R.id.editView_first_name);
        editView_last_name = findViewById(R.id.editView_last_name);
        textView_already_has_account = findViewById(R.id.textView_already_has_account);
        editView_identity_piece_value = findViewById(R.id.editView_identity_piece_value);
        editView_telephone = findViewById(R.id.editView_telephone);
        editView_address = findViewById(R.id.editView_address);
        button_next = findViewById(R.id.button_next);

        textView_Logo.setTypeface(DataComplement.ProductSans);
        textView_etape1.setTypeface(DataComplement.ProductSans);
        textView_already_has_account.setTypeface(DataComplement.RobotoReg);
        editView_last_name.setTypeface(DataComplement.RobotoReg);
        editView_first_name.setTypeface(DataComplement.RobotoReg);
        editView_identity_piece_value.setTypeface(DataComplement.RobotoReg);
        editView_telephone.setTypeface(DataComplement.RobotoReg);
        editView_address.setTypeface(DataComplement.RobotoReg);

        TextWatcher change = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                button_next.setEnabled((editView_first_name.getText().length()>0
                        && editView_last_name.getText().length() >0
                        && editView_address.getText().length() >0
                        && editView_identity_piece_value.getText().length() >0
                        && editView_telephone.getText().length() >0));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        editView_first_name.addTextChangedListener(change);
        editView_last_name.addTextChangedListener(change);
        editView_address.addTextChangedListener(change);
        editView_identity_piece_value.addTextChangedListener(change);
        editView_telephone.addTextChangedListener(change);

        button_next.setEnabled(false);
        textView_already_has_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent sign_in = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(sign_in);
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, RegisterStep2.class);
                Bundle b = new Bundle();
                b.putString("first", editView_first_name.getText().toString());
                b.putString("last", editView_last_name.getText().toString());
                b.putString("adresse", editView_address.getText().toString());
                b.putString("cni", editView_identity_piece_value.getText().toString());
                b.putString("phone", editView_telephone.getText().toString());
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}
