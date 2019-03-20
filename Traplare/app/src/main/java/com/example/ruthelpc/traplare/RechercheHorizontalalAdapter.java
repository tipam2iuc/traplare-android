package com.example.ruthelpc.traplare;

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

public class RechercheHorizontalalAdapter extends RecyclerView.Adapter<RechercheHorizontalalAdapter.PlanningsHolder>{
    public static ArrayList<Voyage> voyagesListe;
    private Context context;
    View view = null;


    public RechercheHorizontalalAdapter(ArrayList<Voyage> voyagesListe, Context context){
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
            planningsHolder.textView_agence.setText(voyagesListe.get(position).getNom_com());
            planningsHolder.textView_provenance.setText(voyagesListe.get(position).getVille_depart());
            planningsHolder.textView_destination.setText(voyagesListe.get(position).getVille_arrive());
            planningsHolder.textView_categorie.setText(voyagesListe.get(position).getCategorie_cla());
            planningsHolder.textView_agency_tarif_value.setText(String.valueOf(voyagesListe.get(position).getPrix_voy())+ " XAF");

            planningsHolder.imageView_rseerve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), ReservationActivity.class);
                    final int idv = voyagesListe.get(position).getId_voy();
                    for (Voyage voy: voyagesListe) {
                        if (voy.getId_voy() == idv){
                            i.putExtra("depart", voy.getAgence_depart());
                            i.putExtra("matricule", voy.getMatricule_bus());
                            i.putExtra("depart_ville", voy.getVille_depart());
                            i.putExtra("compagnie", voy.getNom_com());
                            i.putExtra("destination", voy.getAgence_arrivee());
                            i.putExtra("destination_ville", voy.getVille_arrive());
                            i.putExtra("date_depart", voy.getDate_debut_voy());
                            i.putExtra("date_arrive", voy.getDate_arrivee_voy());
                            i.putExtra("classe", voy.getCategorie_cla());
                            i.putExtra("tarif", voy.getPrix_voy());
                            i.putExtra("id", voy.getId_voy());
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
