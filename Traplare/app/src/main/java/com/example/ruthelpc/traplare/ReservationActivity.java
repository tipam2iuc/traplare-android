package com.example.ruthelpc.traplare;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationActivity extends AppCompatActivity {

    private  ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
    }

    private void reservation(final Context context, String date_reservation, String cni, String prenom, String nom, String telephone)
    {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<Reservation> call=apiInterface.reservation(date_reservation,cni,prenom,nom,telephone);
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
