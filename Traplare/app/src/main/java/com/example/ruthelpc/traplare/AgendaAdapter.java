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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.AgendaHolder>{
    private Context context;
    int x;
    View view;

    public AgendaAdapter(int x,Context context){
        this.context = context;
        this.x = x;
    }

    @NonNull
    @Override
    public AgendaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext().getApplicationContext());
        view = inflater.inflate(R.layout.template_item_agenda,viewGroup,false);
        Log.i("CreateHolder","Holder Created "+ i);
        return new AgendaHolder(view);
    }
    Date date = new Date();
    @Override
    public void onBindViewHolder(@NonNull final AgendaHolder agendaHolder, final int position) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd",Locale.getDefault());
        int day= date.getDate();
        agendaHolder.textView_date.setText(String.valueOf(day));
        date.setDate(day+1);
    }

    @Override
    public int getItemCount() {
        return x;
    }

    public static class AgendaHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout layout;
        private ImageView imageView_flag;
        private TextView textView_date;
        private TextView textView_provenance;
        private TextView textView_destination;
        public AgendaHolder(@NonNull View itemView) {
            super(itemView);
            //layout = itemView.findViewById(R.id.layout_template_travel);
            //imageView_flag = itemView.findViewById(R.id.imageView_main_container);
           textView_date = itemView.findViewById(R.id.textView_date);
            //textView_provenance = itemView.findViewById(R.id.textView_agency_provenance_value);
            //textView_destination = itemView.findViewById(R.id.textView_agency_destination_value);
        }
    }


}
