package com.example.ruthelpc.traplare;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RechercheFragment extends Fragment {
    TextView textView_promo_offer;
    TextView textView_categories;
    TextView textView_all_travels;
    private static ApiInterface apiInterface;
    public static List<Voyage> voyages;
    public static String destination;
    private static RecyclerView recyclerView_voyagesList;
    private static RecyclerView.Adapter adapter_Recherches;
    private static SwipeRefreshLayout swiperefresh;
    Timer chrono = new Timer();

    public RechercheFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recherche, container, false);
        recyclerView_voyagesList = view.findViewById(R.id.recycleView_voyagesList);
        recyclerView_voyagesList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        swiperefresh = view.findViewById(R.id.swiperefresh);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            swiperefresh.setColorSchemeColors(getResources().getColor(R.color.colorBlue));
        }
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swiperefresh.setRefreshing(true);
                //getAll(view.getContext());
            }
        });

        return view;
    }

    public static void getAll(final Context context, String destination) {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Voyage>> call = apiInterface.findVoyage(destination);
        final ArrayList<Date> dates = new ArrayList<>();
        call.enqueue(new Callback<List<Voyage>>() {
            @Override
            public void onResponse(@NonNull Call<List<Voyage>> call, @NonNull Response<List<Voyage>> response) {
                voyages = response.body();
                for (Voyage v : voyages) {
                    int day = v.getDate_debut_voy().getDate();
                    int month = v.getDate_debut_voy().getMonth();
                    int year = v.getDate_debut_voy().getYear();
                    Date date = new Date(year, month, day);
                    Date toDay = new Date();
                    if ((dates.isEmpty() || !dates.contains(date)) && date.compareTo(toDay) >= 0)
                        dates.add(date);
                }
                adapter_Recherches = new RechercheVerticalAdapter(dates, context, (ArrayList<Voyage>) voyages, true);
                recyclerView_voyagesList.setAdapter(adapter_Recherches);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swiperefresh.setRefreshing(false);
                    }
                }, 5000);
            }

            @Override
            public void onFailure(@NonNull Call<List<Voyage>> call, @NonNull Throwable t) {
                voyages = new ArrayList<>();
                voyages.add(new Voyage());
                dates.add(new Date());
                adapter_Recherches = new PlanningsVerticalAdapter(dates, context, (ArrayList<Voyage>) voyages, false);
                recyclerView_voyagesList.setAdapter(adapter_Recherches);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swiperefresh.setRefreshing(false);
                    }
                }, 5000);
            }
        });
    }

}
