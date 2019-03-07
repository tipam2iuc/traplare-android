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
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    List<Voyage> voyages;

    private RecyclerView recyclerView_voyagesList;
    private RecyclerView.Adapter adapter_plannings;
    private RecyclerView.LayoutManager layoutManager_phoneCode;

    ArrayList<Voyage> voyageArrayList = new ArrayList<Voyage>();
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
//        getSupportActionBar().hide();

        recyclerView_voyagesList = findViewById(R.id.recycleView_voyagesList);
        recyclerView_voyagesList.setLayoutManager(new LinearLayoutManager(PlanningActivity.this));
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
        Call<List<Voyage>> call=apiInterface.getVoyage2();
        call.enqueue(new Callback<List<Voyage>>() {
            @Override
            public void onResponse(@NonNull Call<List<Voyage>> call, @NonNull Response<List<Voyage>> response) {
                voyages =response.body();
                ArrayList<Date> dates = new ArrayList<>();
                for (Voyage v : voyages){
                    int day = v.getDate_depart().getDate();
                    int month = v.getDate_depart().getMonth();
                    int year = v.getDate_depart().getYear();
                    Date date = new Date(year,month,day);
                    Date toDay = new Date();
                    if((dates.isEmpty() || !dates.contains(date)) && date.compareTo(toDay) >= 0)
                        dates.add(date);
                }
                adapter_plannings = new PlanningsVerticalAdapter(dates,PlanningActivity.this, (ArrayList<Voyage>) voyages);
                recyclerView_voyagesList.setAdapter(adapter_plannings);
            }
            @Override
            public void onFailure(@NonNull Call<List<Voyage>> call, @NonNull Throwable t) {
                //Toast.makeText(PlanningActivity.this,t.getLocalizedMessage(),
                //}   Toast.LENGTH_SHORT).show();
            }
        });
    }


}