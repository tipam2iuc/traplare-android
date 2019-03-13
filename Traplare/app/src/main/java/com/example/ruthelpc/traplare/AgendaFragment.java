package com.example.ruthelpc.traplare;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;

public class AgendaFragment extends Fragment {
    public static RecyclerView recycler_reservation;
    public static int indexaujourd;
    private RecyclerView.Adapter adapter_agenda;
    private FloatingActionButton button_add_reposition;
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
        button_add_reposition = view.findViewById(R.id.button_add_reposition);
        recycler_reservation.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter_agenda = new AgendaAdapter(31, view.getContext());
        recycler_reservation.setAdapter(adapter_agenda);
        Date d = new Date();
        final int toDay = d.getDate();
        recycler_reservation.scrollToPosition(toDay);

        button_add_reposition.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                recycler_reservation.scrollToPosition(toDay);
                int x =
                        recycler_reservation.getScrollY();
                return false;
            }
        });


        return view;
    }
}
    class SnappingLinearLayoutManager extends LinearLayoutManager {

    public SnappingLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state,
                                       int position) {
        RecyclerView.SmoothScroller smoothScroller = new TopSnappedSmoothScroller(recyclerView.getContext());
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

    private class TopSnappedSmoothScroller extends LinearSmoothScroller {
        public TopSnappedSmoothScroller(Context context) {
            super(context);

        }

        @Override
        public PointF computeScrollVectorForPosition(int targetPosition) {
            return SnappingLinearLayoutManager.this
                    .computeScrollVectorForPosition(targetPosition);
        }

        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;
        }
    }
}
