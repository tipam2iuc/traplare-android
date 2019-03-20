package com.example.ruthelpc.traplare;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
    TextView textView_bus_matricule;
    TextView textView_depart_ville_value;
    TextView textView_heure_depart_value;
    TextView textView_arrive_value;
    TextView textView_arrive_adresse_value;
    TextView textView_heure_arrive_value;
    TextView textView_classe_value;
    TextView textView_tarif_value;

    Button button_reserve;
    ImageView imageView_back_to_menu;
    FloatingActionButton flo_nom;

    EditText edt_nom;
    EditText edt_prenom;
    EditText edt_tel;
    EditText edt_cni;
    Button button_validate;
    TextView textView_heure_reservation_value;
    TextView textView_date_reservation_value;
    TextView textView_compagnie;

    private  ApiInterface apiInterface;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

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
        textView_depart_value = findViewById(R.id.textView_depart_value);
        textView_depart_ville_value = findViewById(R.id.textView_depart_ville_value);
        textView_heure_depart_value = findViewById(R.id.textView_heure_depart_value);
        textView_arrive_value = findViewById(R.id.textView_arrive_ville_value);
        textView_arrive_adresse_value = findViewById(R.id.textView_arrive_value);
        textView_heure_arrive_value = findViewById(R.id.textView_heure_arrive_value);
        textView_bus_matricule = findViewById(R.id.textView_bus_value);
        textView_classe_value = findViewById(R.id.textView_classe_value);
        textView_tarif_value = findViewById(R.id.textView_tarif_value);
        textView_compagnie = findViewById(R.id.textView_compagnie);
        button_reserve = findViewById(R.id.button_reserve);
        imageView_back_to_menu = findViewById(R.id.imageView_back_to_menu);

        final Date date = new Date();
        final SimpleDateFormat sdf = new SimpleDateFormat("MMM. dd yy", Locale.US);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM. yy", Locale.US);
        SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm", Locale.US);
        textView_heure_reservation_value.setText(sdf3.format(date));
        textView_date_reservation_value.setText(sdf.format(date));

        flo_nom = findViewById(R.id.flatbutton_edit_passager_nom);
        flo_nom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView_back_to_menu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

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
                    if(edt_cni.getText().length() > 0)
                        txt_cni.setText(edt_cni.getText().toString());
                    if(edt_nom.getText().length() > 0)
                        txt_nom.setText(edt_nom.getText().toString());
                    if(edt_prenom.getText().length() > 0)
                        txt_prenom.setText(edt_prenom.getText().toString());
                    if(edt_tel.getText().length() > 0)
                        txt_tel.setText(edt_tel.getText().toString());
                        dialog.cancel();
                    }
                });


            }
        });
        Intent i = getIntent();
        String depart = (String) i.getSerializableExtra("depart");
        String depart_ville = (String) i.getSerializableExtra("depart_ville");
        String matricule = (String) i.getSerializableExtra("matricule");
        String compagnie = (String) i.getSerializableExtra("compagnie");
        String destination = (String) i.getSerializableExtra("destination");
        String destination_ville = (String) i.getSerializableExtra("destination_ville");
        Date date_depart = (Date) i.getSerializableExtra("date_depart");
        Date date_arrive = (Date) i.getSerializableExtra("date_arrive");
        String classe = (String) i.getSerializableExtra("classe");
        double tarif = (double) i.getSerializableExtra("tarif");
        final int id = (int) i.getSerializableExtra("id");

        textView_compagnie.setText(compagnie.toUpperCase());
        textView_depart_value.setText(depart_ville);
        textView_bus_matricule.setText(matricule);
        textView_depart_ville_value.setText(depart);
        textView_arrive_value.setText(destination_ville);
        textView_arrive_adresse_value.setText(destination);
        textView_heure_arrive_value.setText(sdf1.format(date_arrive));
        textView_heure_depart_value.setText(sdf1.format(date_depart));
        textView_classe_value.setText(classe.toUpperCase());
        textView_tarif_value.setText(String.valueOf(tarif)+" XAF");
        button_reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                reservation(ReservationActivity.this,id,
                        1,
                        sf.format(date),
                        txt_cni.getText().toString(),
                        txt_prenom.getText().toString(),
                        txt_nom.getText().toString(),
                        txt_tel.getText().toString());
            }
        });
        //textView_bus_value.setText(sdf.format(date_depart));

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
