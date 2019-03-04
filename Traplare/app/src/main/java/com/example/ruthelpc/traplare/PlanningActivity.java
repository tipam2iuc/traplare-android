package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruthelpc.traplare.modele.voyage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanningActivity extends AppCompatActivity {
    ImageView imageView_menu;
    EditText editText_your_destination;
    TextView textView_promo_offer;
    TextView textView_agencies_agenda;
    TextView textView_categories;
    TextView textView_all_travels;
    LinearLayout linearLayout_main_container;
    Intent i;
    ApiInterface apiInterface;
    RetrofitAdapter retrofitAdapter;
   private ArrayList<Voyage2> voyage2ArrayList;

    private RecyclerView recyclerView_voyagesList;
    private RecyclerView.Adapter adapter_plannings;
    private RecyclerView.LayoutManager layoutManager_phoneCode;

    ArrayList<voyage> voyageArrayList = new ArrayList<voyage>();
    voyage v11 =  new voyage("garoua", "yaoundé");
    voyage v2 = new voyage("douala", "bertoua");
    voyage v3 =  new voyage("salaga", "mbammayo");
    voyage v5 =   new voyage("garoua", "yaoundé");
    voyage v6 =   new voyage("tocko", "boulai");
    voyage v7 =   new voyage("ewon", "boulai");
    voyage v8 =   new voyage("gab", "fonj");
    voyage v9 =   new voyage("emn", "boulai");
    voyage v10 =   new voyage("tocko", "mbanga");
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        getSupportActionBar().hide();

        voyageArrayList.add(v2);
        voyageArrayList.add(v3);
        voyageArrayList.add(v5);
        voyageArrayList.add(v6);
        voyageArrayList.add(v2);
        voyageArrayList.add(v7);
        voyageArrayList.add(v8);
        voyageArrayList.add(v9);
        voyageArrayList.add(v10);
        voyageArrayList.add(v11);

        recyclerView_voyagesList = findViewById(R.id.recycleView_voyagesList);
        //recyclerView_voyagesList.setLayoutManager(new LinearLayoutManager(this));
       // adapter_plannings = new PlanningsVerticalAdapter(voyageArrayList,this);
       // recyclerView_voyagesList.setAdapter(adapter_plannings);


        imageView_menu = findViewById(R.id.imageView_menu);
        editText_your_destination = findViewById(R.id.editText_your_destination);
        textView_promo_offer = findViewById(R.id.textView_promo_offer);
        textView_agencies_agenda = findViewById(R.id.textView_agencies_agenda);
        textView_categories = findViewById(R.id.textView_categories);
        textView_all_travels = findViewById(R.id.textView_all_travels);

        Typeface RobotoBoldCondensed = Typeface.createFromAsset(getAssets(), "fonts/Roboto-BoldCondensed.ttf");
        Typeface RobotoBold = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        editText_your_destination.setTypeface(RobotoBoldCondensed);
        textView_promo_offer.setTypeface(RobotoBold);
        textView_agencies_agenda.setTypeface(RobotoBold);
        textView_categories.setTypeface(RobotoBold);
        textView_all_travels.setTypeface(RobotoBold);
       // getVoyage2();


        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanningActivity.this, MainClientActivity.class);
                startActivity(intent);
            }
        });
    }
/*
    public void getVoyage2(){
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Voyage2> call = apiInterface.getVoyage2();
        call.enqueue(new Callback<Voyage2>() {
            @Override
            public void onResponse(Call<Voyage2> call, Response<Voyage2> response) {
                String r=response.body().toString();
              // writeRecycler(r);
            }

            @Override
            public void onFailure(Call<Voyage2> call, Throwable t) {
                Toast.makeText(PlanningActivity.this, "rp :"+
                                t.getMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    */
/*
    private void writeRecycler(String response){

        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
       //     if(obj.optString("status").equals("true")){

                ArrayList<Voyage2> modelRecyclerArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    Voyage2 modelRecycler = new Voyage2();
                    JSONObject dataobj = dataArray.getJSONObject(i);


                    modelRecycler.setCompagnie(dataobj.getString("compagnie"));
                    modelRecyclerArrayList.add(modelRecycler);

                }

               retrofitAdapter = new RetrofitAdapter(this,modelRecyclerArrayList);
                recyclerView_voyagesList.setAdapter(retrofitAdapter);
                recyclerView_voyagesList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

           // }else {
         //       Toast.makeText(PlanningActivity.this, obj.optString("message")+"", Toast.LENGTH_SHORT).show();
       //     }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    */


}
