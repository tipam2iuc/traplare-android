package com.example.ruthelpc.traplare;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
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
    private List<voyage> voyagesListe;
    private Context context;

    public PlanningsVerticalAdapter(List<voyage> voyagesListe, Context context){
        this.voyagesListe = voyagesListe;
        this.context = context;
    }

    @NonNull
    @Override
    public PlanningsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext().getApplicationContext());
        view = inflater.inflate(R.layout.planning_option,viewGroup,false);

        RecyclerView r;
        PlanningsHorizontalalAdapter adapter_plannings;

        ArrayList<voyage> voyageArrayList = new ArrayList<voyage>();
        voyage v11 =  new voyage("garoua", "yaoundé");
        voyage v2 = new voyage("douala", "bertoua");
        voyage v3 =  new voyage("salaga", "mbammayo");
        voyage v5 =   new voyage("garoua", "yaoundé");
        voyage v6 =   new voyage("tocko", "boulai");
        voyage v7 =   new voyage("ewon", "boulai");
        voyage v8 =   new voyage("gab", "fonj");
        voyage v9 =   new voyage("emn", "boulai");
        voyage v10 =   new voyage("tocko", "mbanga");
        voyageArrayList.add(v2);
        voyageArrayList.add(v3);
        voyageArrayList.add(v5);
        voyageArrayList.add(v6);
        voyageArrayList.add(v2);
        voyageArrayList.add(v7);
        voyageArrayList.add(v8);
        voyageArrayList.add(v9);
        voyageArrayList.add(v10);
        voyageArrayList.add(v11);

        r = view.findViewById(R.id.recycler_hotizontal);
        r.setLayoutManager(new LinearLayoutManager(context));
        adapter_plannings = new PlanningsHorizontalalAdapter(voyageArrayList,context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayout.HORIZONTAL);
        r.setLayoutManager(layoutManager);
        r.setAdapter(adapter_plannings);

        Log.i("CreateHolder","Holder Created");
        return new PlanningsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlanningsHolder planningsHolder, final int position) {

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
            //imageView_flag = itemView.findViewById(R.id.imageView_main_container);
            //textView_agence = itemView.findViewById(R.id.textView_agency_value);
            //textView_provenance = itemView.findViewById(R.id.textView_agency_provenance_value);
            //textView_destination = itemView.findViewById(R.id.textView_agency_destination_value);
        }
    }


}
