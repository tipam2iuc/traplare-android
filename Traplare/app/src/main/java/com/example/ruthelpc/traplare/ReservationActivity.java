package com.example.ruthelpc.traplare;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationActivity extends AppCompatActivity {
    int idvoyage;
    TextView txt_nom;
    TextView txt_prenom;
    TextView txt_tel;
    TextView txt_cni;
    TextView textView_depart_value;
    TextView textView_heure_depart_value;
    TextView textView_arrive_value;
    TextView textView_heure_arrive_value;

    FloatingActionButton flo_nom;

    EditText edt_nom;
    EditText edt_prenom;
    EditText edt_tel;
    EditText edt_cni;
    Button button_validate;
    TextView textView_heure_reservation_value;
    TextView textView_date_reservation_value;

    private  ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        txt_nom = findViewById(R.id.textView_passager_nom_value);
        txt_prenom = findViewById(R.id.textView_passager_prenom_value);
        txt_tel = findViewById(R.id.textView_telephone_value);
        txt_cni = findViewById(R.id.textView_CNI_value);
        textView_heure_reservation_value = findViewById(R.id.textView_heure_reservation_value);
        textView_date_reservation_value = findViewById(R.id.textView_date_reservation_value);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");
        textView_heure_reservation_value.setText(date.getHours()+" h " + date.getMinutes() + " min ");
        textView_date_reservation_value.setText(sdf.format(date));

        flo_nom = findViewById(R.id.flatbutton_edit_passager_nom);
        flo_nom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(ReservationActivity.this);
                dialog.setContentView(R.layout.dialog_nom_passager);
                dialog.setTitle("nom du passager");
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                edt_nom = dialog.findViewById(R.id.editText_nom);
                edt_prenom = dialog.findViewById(R.id.editText_prenom);
                edt_cni = dialog.findViewById(R.id.editText_cni);
                edt_tel = dialog.findViewById(R.id.editText_telephone);
                button_validate = dialog.findViewById(R.id.button_validate);
                button_validate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        txt_cni.setText(edt_cni.getText().toString());
                        txt_nom.setText(edt_nom.getText().toString());
                        txt_prenom.setText(edt_prenom.getText().toString());
                        txt_tel.setText(edt_tel.getText().toString());
                        dialog.cancel();
                    }
                });


            }
        });
        Intent i = getIntent();
        if(i != null){
            idvoyage = (int)i.getSerializableExtra("idvoyage");
            for (Voyage v: PlanningsHorizontalalAdapter.voyagesListe
                 ) {
                if(v.getId() == idvoyage){
//                    textView_arrive_value.setText(v.getDestination());
                    textView_depart_value.setText(v.getDepart());
                    textView_heure_arrive_value.setText(sdf.format(v.getDate_arrivee()));
                    textView_heure_depart_value.setText(sdf.format(v.getDate_depart()));
                }
            }
        }

        //Date d = new Date();
        //reservation(ReservationActivity.this, idvoyage,connected_bank.get().id, d.toString(), txt_cni.getText().toString(),txt_prenom.getText().toString()
        //, txt_nom.getText().toString(), txt_tel.getText().toString());
    }

    private void reservation(final Context context,int idvoyage, int iduser, String date_reservation, String cni, String prenom, String nom, String telephone)
    {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<Reservation> call=apiInterface.reservation(idvoyage, iduser, date_reservation,cni,prenom,nom,telephone);
        call.enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse( @NonNull Call<Reservation> call,@NonNull Response<Reservation> response) {
                int success=response.body().getSuccess();
                if (success==1)
                {
                    Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Reservation> call, @NonNull Throwable t) {
                Toast.makeText(context,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
