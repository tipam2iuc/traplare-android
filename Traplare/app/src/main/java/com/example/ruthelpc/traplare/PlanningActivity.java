package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ruthelpc.traplare.modele.voyage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PlanningActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView_menu;
    EditText editText_your_destination;
    TextView textView_promo_offer;
    TextView textView_agencies_agenda;
    TextView textView_categories;
    TextView textView_all_travels;
    LinearLayout linearLayout_main_container;
    Intent i;

    private RecyclerView recyclerView_voyagesList;
    private RecyclerView.Adapter adapter_plannings;
    private RecyclerView.LayoutManager layoutManager_phoneCode;

    List<voyage> voyageArrayList;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        //getSupportActionBar().hide();
        voyageArrayList.add(new voyage("ddddd","dddddddddd"));
        recyclerView_voyagesList = findViewById(R.id.recycleView_voyagesList);
        recyclerView_voyagesList.setLayoutManager(new LinearLayoutManager(this));
        adapter_plannings = new PlanningsVerticalAdapter(voyageArrayList,this);
        recyclerView_voyagesList.setAdapter(adapter_plannings);

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

        imageView_menu.hasFocus();

        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanningActivity.this, MainClientActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v != editText_your_destination){
            editText_your_destination.setFocusable(false);
        }
    }
}
