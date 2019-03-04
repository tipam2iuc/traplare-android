package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class testActivity extends AppCompatActivity {

    Button btngetcompagnie;
    private ApiInterface apiInterface;
    List<Voyage2> voyagelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        btngetcompagnie=findViewById(R.id.btncompagie);

        btngetcompagnie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAll();
            }
        });
    }

    public  void getAll()
    {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Voyage2>> call=apiInterface.getVoyage2();
        call.enqueue(new Callback<List<Voyage2>>() {
            @Override
            public void onResponse(@NonNull Call<List<Voyage2>> call, @NonNull Response<List<Voyage2>> response) {
                voyagelist=response.body();
                Log.i(testActivity.class.getSimpleName(), response.body().toString());

                //int v=response.body().getSuccess();
                //String u=response.body().getUsername();
                for (int i=0;i<voyagelist.size(); i++)
                {
                    Toast.makeText(testActivity.this, voyagelist.get(i).getCompagnie(),
                            Toast.LENGTH_SHORT).show();
                }
                /*if (m!="")
                {
                    Toast.makeText(testActivity.this,response.body().getCompagnie(),
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(testActivity.this,PlanningActivity.class);
                    startActivity(intent);

                    // finish();
                }
                else
                {
                    Toast.makeText(testActivity.this,response.body().getCompagnie(),
                            Toast.LENGTH_SHORT).show();
                }*/
            }
            @Override
            public void onFailure(@NonNull Call<List<Voyage2>> call, @NonNull Throwable t) {

                Toast.makeText(testActivity.this,t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }


}
