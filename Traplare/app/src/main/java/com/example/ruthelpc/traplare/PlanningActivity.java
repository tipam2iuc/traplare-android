package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
    private ApiInterface apiInterface;
    List<Voyage2> voyagelist;

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
//        getSupportActionBar().hide();

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
       // recyclerView_voyagesList.setLayoutManager(new LinearLayoutManager(this));
      //  adapter_plannings = new PlanningsVerticalAdapter(voyageArrayList,this);
      //  recyclerView_voyagesList.setAdapter(adapter_plannings);
        getAll();

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

        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanningActivity.this, MainClientActivity.class);
                startActivity(intent);
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
                recyclerView_voyagesList.setLayoutManager(new LinearLayoutManager(PlanningActivity.this));
                adapter_plannings = new PlanningsVerticalAdapter(voyagelist,PlanningActivity.this);
                recyclerView_voyagesList.setAdapter(adapter_plannings);

                for (int i=0;i<voyagelist.size(); i++)
                {
                    Toast.makeText(PlanningActivity.this, voyagelist.get(i).getCompagnie(),
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

                Toast.makeText(PlanningActivity.this,t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }


}
