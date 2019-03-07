package com.example.ruthelpc.traplare;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllTravelFragment extends Fragment {
    TextView textView_promo_offer;
    TextView textView_categories;
    TextView textView_all_travels;
    private ApiInterface apiInterface;
    List<Voyage> voyages;

    private RecyclerView recyclerView_voyagesList;
    private RecyclerView.Adapter adapter_plannings;
    private RecyclerView.LayoutManager layoutManager_phoneCode;

    public AllTravelFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_travel, container, false);
        recyclerView_voyagesList = view.findViewById(R.id.recycleView_voyagesList);
        recyclerView_voyagesList.setLayoutManager(new LinearLayoutManager(view.getContext()));

        getAll(view.getContext());

        return view;
    }

    public  void getAll(final Context context) {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Voyage>> call = apiInterface.getVoyage2();
        call.enqueue(new Callback<List<Voyage>>() {
            @Override
            public void onResponse(@NonNull Call<List<Voyage>> call, @NonNull Response<List<Voyage>> response) {
                voyages = response.body();
                ArrayList<Date> dates = new ArrayList<>();
                for (Voyage v : voyages) {
                    int day = v.getDate_depart().getDate();
                    int month = v.getDate_depart().getMonth();
                    int year = v.getDate_depart().getYear();
                    Date date = new Date(year, month, day);
                    Date toDay = new Date();
                    if ((dates.isEmpty() || !dates.contains(date)) && date.compareTo(toDay) >= 0)
                        dates.add(date);
                }
                adapter_plannings = new PlanningsVerticalAdapter(dates, context, (ArrayList<Voyage>) voyages);
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
