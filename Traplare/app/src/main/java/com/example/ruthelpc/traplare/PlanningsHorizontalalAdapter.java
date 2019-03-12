package com.example.ruthelpc.traplare;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanningsHorizontalalAdapter extends RecyclerView.Adapter<PlanningsHorizontalalAdapter.PlanningsHolder>{
    private ArrayList<Voyage> voyagesListe;
    private Context context;


    public PlanningsHorizontalalAdapter(ArrayList<Voyage> voyagesListe, Context context){
        this.voyagesListe = voyagesListe;
        this.context = context;
    }

    @NonNull
    @Override
    public PlanningsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
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
                    v.getContext().startActivity(i);
                }
            });
        }
        else{
            planningsHolder.textView_agence.setBackgroundColor(planningsHolder.textView_agence.getResources().getColor(R.color.colorBlue));
            planningsHolder.textView_agence.setText(voyagesListe.get(position).getDepart());
            planningsHolder.textView_provenance.setText(voyagesListe.get(position).getDepart());
            planningsHolder.textView_provenance.setBackgroundColor(planningsHolder.textView_agence.getResources().getColor(R.color.colorBlue));
            planningsHolder.textView_destination.setText(voyagesListe.get(position).getDestination());
            planningsHolder.textView_destination.setBackgroundColor(planningsHolder.textView_agence.getResources().getColor(R.color.colorBlue));
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

        public PlanningsHolder(@NonNull final View itemView) {
            super(itemView);

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
