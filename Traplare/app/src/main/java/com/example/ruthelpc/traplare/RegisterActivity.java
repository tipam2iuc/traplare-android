package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

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
    private Bitmap bitmap;


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

        Typeface RobotoReg = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");
        Typeface ProductSans = Typeface.createFromAsset(LoginActivity.asset,"fonts/Product Sans Bold.ttf");
        Typeface RobotoBoldCondensed = Typeface.createFromAsset(LoginActivity.asset, "fonts/Roboto-BoldCondensed.ttf");

        textView_Logo.setTypeface(ProductSans);
        textView_etape1.setTypeface(ProductSans);
        textView_already_has_account.setTypeface(RobotoReg);
        editView_last_name.setTypeface(RobotoReg);
        editView_first_name.setTypeface(RobotoReg);
        editView_identity_piece_value.setTypeface(RobotoReg);
        editView_telephone.setTypeface(RobotoReg);
        editView_address.setTypeface(RobotoReg);

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
    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    public String getStringImage(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
}
