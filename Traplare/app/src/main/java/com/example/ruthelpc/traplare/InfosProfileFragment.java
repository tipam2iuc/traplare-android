package com.example.ruthelpc.traplare;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

public class InfosProfileFragment extends Fragment {
    public InfosProfileFragment(){}
    public  client ur;
    TextView textView_nom_user_value;
    TextView textView_nom_famille_value;
    TextView textView_prenom_value;
    TextView textView_num_identity_value;
    TextView textView_email_value;
    TextView textView_phone_value;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        SharedPreferences sharedPreferences = view.getContext().getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("client",null);
        ur = null;
        if(json != null)
            ur = gson.fromJson(json,client.class);

        textView_nom_user_value = view.findViewById(R.id.textView_nom_user_value);
        textView_nom_famille_value = view.findViewById(R.id.textView_nom_famille_value);
        textView_prenom_value = view.findViewById(R.id.textView_prenom_value);
        textView_num_identity_value = view.findViewById(R.id.textView_num_identity_value);
        textView_email_value = view.findViewById(R.id.textView_email_value);
        textView_phone_value = view.findViewById(R.id.textView_phone_value);

        if(ur.getUsername_cli() != "")
            textView_nom_user_value.setText(ur.getUsername_cli());
        else
            textView_nom_user_value.setText("n/a");

        if(ur.getNom_cli() != "")
            textView_nom_famille_value.setText(ur.getNom_cli());
        else
            textView_nom_famille_value.setText("n/a");

        if(ur.getPrenom_cli() != "")
            textView_prenom_value.setText(ur.getPrenom_cli());
        else
            textView_prenom_value.setText("n/a");

        if(ur.getEmail_cli() != "")
            textView_email_value.setText(ur.getEmail_cli());
        else
            textView_email_value.setText("n/a");

        if(ur.getTelephone_cli() != "")
            textView_phone_value.setText(ur.getTelephone_cli().charAt(0)+" XX XX XX "+ur.getTelephone_cli().substring(7));
        else
            textView_phone_value.setText("n/a");

        if(ur.getCni_cli() != "")
            textView_num_identity_value.setText(ur.getTelephone_cli());
        else
            textView_num_identity_value.setText("n/a");
        return view;
    }
}
