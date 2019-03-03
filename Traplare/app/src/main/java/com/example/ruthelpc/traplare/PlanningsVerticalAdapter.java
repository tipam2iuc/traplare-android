package com.example.ruthelpc.traplare;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ruthelpc.traplare.modele.voyage;

import java.util.ArrayList;
import java.util.List;

public class PlanningsVerticalAdapter extends RecyclerView.Adapter<PlanningsVerticalAdapter.PlanningsHolder>{
    private ArrayList<voyage> voyagesListe;
    private Context context;

    public PlanningsVerticalAdapter(ArrayList<voyage> voyagesListe, Context context){
        this.voyagesListe = voyagesListe;
        this.context = context;
    }

    @NonNull
    @Override
    public PlanningsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext().getApplicationContext());
        view = inflater.inflate(R.layout.planning_option,viewGroup,false);
        Log.i("CreateHolder","Holder Created");
        return new PlanningsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlanningsHolder planningsHolder, final int position) {
        //String iso = voyagesListe.get(position).getIso2();
        //if(iso != "cm"){
        //   planningsHolder.imageView_flag.setImageResource(context.getResources().getIdentifier(iso,"drawable",context.getApplicationContext().getPackageName()));
        //}
//        planningsHolder.textView_agence.setText(voyagesListe.get(position).agence_depart.compagnie.nom);
        planningsHolder.textView_provenance.setText(voyagesListe.get(position).depart);
        planningsHolder.textView_destination.setText(voyagesListe.get(position).destination);
        //Log.i("BindingHolder","Holder Binded"+voyagesListe.get(position).getCountry()+" "+voyagesListe.get(position).getCode());
    }

    @Override
    public int getItemCount() {
        return voyagesListe.size();
    }

    public static class PlanningsHolder extends RecyclerView.ViewHolder {
        private LinearLayout layout;
        private ImageView imageView_flag;
        private TextView textView_agence;
        private TextView textView_provenance;
        private TextView textView_destination;

        public PlanningsHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            //layout = itemView.findViewById(R.id.layout_template_travel);
            imageView_flag = itemView.findViewById(R.id.imageView_main_container);
            textView_agence = itemView.findViewById(R.id.textView_agency_value);
            textView_provenance = itemView.findViewById(R.id.textView_agency_provenance_value);
            textView_destination = itemView.findViewById(R.id.textView_agency_destination_value);
        }
    }


}
