package com.example.ruthelpc.traplare;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfosProfileFragment extends Fragment {
    public InfosProfileFragment(){}
    public  user_reservation ur;
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

        textView_nom_user_value = view.findViewById(R.id.textView_nom_user_value);
        textView_nom_famille_value = view.findViewById(R.id.textView_nom_famille_value);
        textView_prenom_value = view.findViewById(R.id.textView_prenom_value);
        textView_num_identity_value = view.findViewById(R.id.textView_num_identity_value);
        textView_email_value = view.findViewById(R.id.textView_email_value);
        textView_phone_value = view.findViewById(R.id.textView_phone_value);

        textView_nom_user_value.setText(ur.getUsername());
        textView_nom_famille_value.setText(ur.getNom_user());
        textView_prenom_value.setText(ur.getPrenom_user());
        textView_email_value.setText(ur.getEmail());
        textView_phone_value.setText(ur.getTelephone_user());
        return view;
    }
}
