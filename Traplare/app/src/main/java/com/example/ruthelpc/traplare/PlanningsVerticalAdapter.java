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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PlanningsVerticalAdapter extends RecyclerView.Adapter<PlanningsVerticalAdapter.PlanningsHolder>{
    private ArrayList<Voyage> voyagesList;
    private List<Date> dayList;
    private Context context;
    View view;

    public PlanningsVerticalAdapter(List<Date> dayList, Context context, ArrayList<Voyage> voyages){
        this.dayList = dayList;
        this.context = context;
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
        RecyclerView r;
        PlanningsHorizontalalAdapter adapter_plannings;
        ArrayList<Voyage> voyageArrayList = new ArrayList<Voyage>();
        for (Voyage v : voyagesList) {
            int year  = v.getDate_depart().getYear();
            int month = v.getDate_depart().getMonth();
            int day = v.getDate_depart().getDate();
            Date d = new Date(year,month,day);
            if(dayList.get(position).compareTo(d) == 0)
                voyageArrayList.add(v);
        }
        r = view.findViewById(R.id.recycler_hotizontal);
        r.setLayoutManager(new LinearLayoutManager(context));
        adapter_plannings = new PlanningsHorizontalalAdapter(voyageArrayList,context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayout.HORIZONTAL);
        r.setLayoutManager(layoutManager);
        r.setAdapter(adapter_plannings);
        SimpleDateFormat sdf = new SimpleDateFormat("E d MMM yy",Locale.getDefault());
        String dJour = sdf.format(dayList.get(position));
        planningsHolder.textView_Date.setText(dJour);
    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }

    public static class PlanningsHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout layout;
        private ImageView imageView_flag;
        private TextView textView_Date;
        private TextView textView_provenance;
        private TextView textView_destination;
        public PlanningsHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_template_travel);
            //imageView_flag = itemView.findViewById(R.id.imageView_main_container);
            textView_Date = itemView.findViewById(R.id.textView_Date);
            //textView_provenance = itemView.findViewById(R.id.textView_agency_provenance_value);
            //textView_destination = itemView.findViewById(R.id.textView_agency_destination_value);
        }
    }


}
