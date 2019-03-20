package com.example.ruthelpc.traplare;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RechercheVerticalAdapter extends RecyclerView.Adapter<RechercheVerticalAdapter.PlanningsHolder>{
    private ArrayList<Voyage> voyagesList;
    private List<Date> dayList;
    private Context context;
    public static boolean wellLoad;
    View view;

    public RechercheVerticalAdapter(List<Date> dayList, Context context, ArrayList<Voyage> voyages, boolean wellLoad){
        this.dayList = dayList;
        this.context = context;
        this.wellLoad = wellLoad;
        voyagesList = voyages;
    }

    @NonNull
    @Override
    public PlanningsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext().getApplicationContext());
        view = inflater.inflate(R.layout.planning_days,viewGroup,false);
        Log.i("CreateHolder","Holder Created "+ i);
        return new PlanningsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlanningsHolder planningsHolder, final int position) {
        if(wellLoad) {
            RecyclerView r;
            PlanningsHorizontalalAdapter adapter_plannings;
            ArrayList<Voyage> voyageArrayList = new ArrayList<Voyage>();
            for (Voyage v : voyagesList) {
                int year = v.getDate_debut_voy().getYear();
                int month = v.getDate_debut_voy().getMonth();
                int day = v.getDate_debut_voy().getDate();
                Date d = new Date(year, month, day);
                if (dayList.get(position).compareTo(d) == 0)
                    voyageArrayList.add(v);
            }
            r = view.findViewById(R.id.recycler_hotizontal);
            r.setLayoutManager(new LinearLayoutManager(context));
            adapter_plannings = new PlanningsHorizontalalAdapter(voyageArrayList, context);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            ((LinearLayoutManager) layoutManager).setOrientation(LinearLayout.HORIZONTAL);
            r.setLayoutManager(layoutManager);
            r.setAdapter(adapter_plannings);
            SimpleDateFormat sdf = new SimpleDateFormat("E d MMM yy", Locale.getDefault());
            String dJour = sdf.format(dayList.get(position));
            planningsHolder.textView_Date.setText(dJour);
        }
        else
        {
            RecyclerView r;
            PlanningsHorizontalalAdapter adapter_plannings;
            ArrayList<Voyage> voyageArrayList = new ArrayList<Voyage>();
            for (Voyage v : voyagesList) {
                voyageArrayList.add(v);
            }
            r = view.findViewById(R.id.recycler_hotizontal);
            r.setLayoutManager(new LinearLayoutManager(context));
            adapter_plannings = new PlanningsHorizontalalAdapter(voyageArrayList, context);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            ((LinearLayoutManager) layoutManager).setOrientation(LinearLayout.HORIZONTAL);
            r.setLayoutManager(layoutManager);
            r.setAdapter(adapter_plannings);
            planningsHolder.textView_Date.setText("Erreur de connexion");
            planningsHolder.textView_Date.setPadding(5,2,0,0);
            planningsHolder.textView_Date.setCompoundDrawablePadding(10);
            planningsHolder.textView_Date.setCompoundDrawablesWithIntrinsicBounds(planningsHolder.view.getResources().
                    getDrawable(R.drawable.ic_error),null,null,null);
        }
    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }

    public static class PlanningsHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout layout;
        View view;
        private TextView textView_Date;
        public PlanningsHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            layout = itemView.findViewById(R.id.layout_template_travel);
            //imageView_flag = itemView.findViewById(R.id.imageView_main_container);
            textView_Date = itemView.findViewById(R.id.textView_Date);
            //textView_provenance = itemView.findViewById(R.id.textView_agency_provenance_value);
            //textView_destination = itemView.findViewById(R.id.textView_agency_destination_value);
        }
    }


}
