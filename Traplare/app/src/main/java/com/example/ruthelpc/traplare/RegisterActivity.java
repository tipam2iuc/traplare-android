package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    TextView textView_Logo;
    TextView textView_already_has_account;
    EditText editView_first_name;
    EditText editView_identity_piece_value;
    EditText editView_telephone;
    EditText editView_address;
    EditText editView_user_account;
    EditText editView_password;

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
    }
}
