package com.example.ruthelpc.traplare;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    private RetrofitAdapter retrofitAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recycler);

        fetchJSON();
    }

    private void fetchJSON(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RecyclerInterface.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RecyclerInterface api = retrofit.create(RecyclerInterface.class);

        Call<String> call = api.getString();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse( @NonNull Call<String> call, @NonNull Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                String jsonresponse = response.body().toString();
                writeRecycler(jsonresponse);

            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity2.this,t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void writeRecycler(String response){

        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
          //  if(obj.optString("status").equals("true")){

                ArrayList<Voyage> modelRecyclerArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    Voyage modelRecycler = new Voyage();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                  //  modelRecycler.setImgURL(dataobj.getString("imgURL"));
                    modelRecycler.setCompagnie(dataobj.getString("compagnie"));
                 //   modelRecycler.setCountry(dataobj.getString("country"));
                  //  modelRecycler.setCity(dataobj.getString("city"));

                    modelRecyclerArrayList.add(modelRecycler);

              //  }

                retrofitAdapter = new RetrofitAdapter(this,modelRecyclerArrayList);
                recyclerView.setAdapter(retrofitAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

           // }else {
             //   Toast.makeText(MainActivity2.this, obj.optString("message")+"", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
