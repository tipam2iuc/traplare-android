package com.example.ruthelpc.traplare;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.ruthelpc.traplare.R;

import java.util.ArrayList;

public class AgendaFragment extends Fragment {
    RecyclerView recycler_reservation;
    private RecyclerView.Adapter adapter_plannings;
    public AgendaFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_agenda, container, false);
        recycler_reservation = view.findViewById(R.id.recycler_reservation);
        recycler_reservation.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter_plannings = new AgendaAdapter(15, view.getContext());
        recycler_reservation.setAdapter(adapter_plannings);
        return view;
    }
}
