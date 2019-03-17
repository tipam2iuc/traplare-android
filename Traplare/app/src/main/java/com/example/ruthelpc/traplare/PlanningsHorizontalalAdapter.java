package com.example.ruthelpc.traplare;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanningsHorizontalalAdapter extends RecyclerView.Adapter<PlanningsHorizontalalAdapter.PlanningsHolder>{
    public static ArrayList<Voyage> voyagesListe;
    private Context context;
    View view = null;


    public PlanningsHorizontalalAdapter(ArrayList<Voyage> voyagesListe, Context context){
        this.voyagesListe = voyagesListe;
        this.context = context;
    }

    @NonNull
    @Override
    public PlanningsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext().getApplicationContext());
        view = inflater.inflate(R.layout.planning_travels,viewGroup,false);
        Log.i("CreateHolder","Holder Created");
        return new PlanningsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlanningsHolder planningsHolder, final int position) {
        if(PlanningsVerticalAdapter.wellLoad) {
            planningsHolder.textView_agence.setText(voyagesListe.get(position).getCompagnie());
            planningsHolder.textView_provenance.setText(voyagesListe.get(position).getDepart());
            planningsHolder.textView_destination.setText(voyagesListe.get(position).getDestination());
            planningsHolder.textView_categorie.setText(voyagesListe.get(position).getClasse());
            planningsHolder.textView_agency_tarif_value.setText(String.valueOf(voyagesListe.get(position).getTarif())+ " XAF");

            planningsHolder.imageView_rseerve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), ReservationActivity.class);
                    final int idv = voyagesListe.get(position).getId();
                    for (Voyage voy: voyagesListe) {
                        if (voy.getId() == idv){
                            i.putExtra("depart", voy.getDepart());
                            i.putExtra("compagnie", voy.getCompagnie());
                            i.putExtra("destination", voy.getDestination());
                            i.putExtra("date_depart", voy.getDate_depart());
                            i.putExtra("date_arrive", voy.getDate_arrivee());
                            i.putExtra("classe", voy.getClasse());
                            i.putExtra("tarif", voy.getTarif());
                            i.putExtra("id", voy.getId());
                        }
                    }
                    v.getContext().startActivity(i);
                }
            });
        }
        else{
            planningsHolder.textView_agence.setBackgroundColor(planningsHolder.view.getResources().getColor(R.color.colorNonConnect));
            planningsHolder.textView_agence.setTextColor(planningsHolder.view.getResources().getColor(R.color.colorNonConnect));
            planningsHolder.textView_provenance.setBackgroundColor(planningsHolder.view.getResources().getColor(R.color.colorNonConnect));
            planningsHolder.textView_provenance.setTextColor(planningsHolder.view.getResources().getColor(R.color.colorNonConnect));
            planningsHolder.textView_destination.setBackgroundColor(planningsHolder.view.getResources().getColor(R.color.colorNonConnect));
            planningsHolder.textView_destination.setTextColor(planningsHolder.view.getResources().getColor(R.color.colorNonConnect));
            planningsHolder.textView_categorie.setBackgroundColor(planningsHolder.view.getResources().getColor(R.color.colorNonConnect));
            planningsHolder.textView_categorie.setTextColor(planningsHolder.view.getResources().getColor(R.color.colorNonConnect));
            planningsHolder.textView_agency_tarif_value.setBackgroundColor(planningsHolder.view.getResources().getColor(R.color.colorNonConnect));
            planningsHolder.textView_agency_tarif_value.setTextColor(planningsHolder.view.getResources().getColor(R.color.colorNonConnect));
        }
    }

    @Override
    public int getItemCount() {
        return voyagesListe.size();
    }

    public static class PlanningsHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout layout;
        private ImageView imageView_flag;
        private ImageView imageView_rseerve;
        private TextView textView_agence;
        private TextView textView_categorie;
        private TextView textView_provenance;
        private TextView textView_destination;
        private TextView textView_agency_tarif_value;
        View view;

        public PlanningsHolder(@NonNull final View itemView) {
            super(itemView);
            view = itemView;
            layout = itemView.findViewById(R.id.layout_template_travel2);
            textView_categorie = itemView.findViewById(R.id.textView_travel_classe_value);
            imageView_flag = itemView.findViewById(R.id.imageView_main_container);
            imageView_rseerve = itemView.findViewById(R.id.image_view_reserve);
            textView_agence = itemView.findViewById(R.id.textView_agency_value);
            textView_provenance = itemView.findViewById(R.id.textView_agency_provenance_value);
            textView_destination = itemView.findViewById(R.id.textView_agency_destination_value);
            textView_agency_tarif_value = itemView.findViewById(R.id.textView_agency_tarif_value);


        }
    }


}
