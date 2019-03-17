package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainClientActivity extends AppCompatActivity {
    TextView textView_Help;
    TextView textView_Parametre;
    TextView textView_NoteAvis;
    TextView textView_Signaler;
    TextView textView_Notification;
    TextView textView_ActiviteRecente;
    TextView textView_Panier;
    TextView textView_Planning;
    TextView textView_Abonement;
    TextView textView_Profile;
    TextView textView_AbonementNum;
    TextView textView_NotificationNum;
    TextView textView_PanierNum;
    TextView textView_Profile_name;
    TextView textView_Profile_first;

    CardView cardView_Help;
    CardView cardView_Parametre;
    CardView cardView_NoteAvis;
    CardView cardView_Signaler;
    CardView cardView_Notification;
    CardView cardView_ActiviteRecente;
    CardView cardView_Panier;
    CardView cardView_Planning;
    CardView cardView_Abonement;

    ConstraintLayout constraintLayout_Help;
    ConstraintLayout constraintLayout_Parametre;
    ConstraintLayout constraintLayout_NoteAvis;
    ConstraintLayout constraintLayout_Signaler;
    ConstraintLayout constraintLayout_Notification;
    ConstraintLayout constraintLayout_ActiviteRecente;
    ConstraintLayout constraintLayout_Panier;
    ConstraintLayout constraintLayout_Planning;
    ConstraintLayout constraintLayout_Abonement;
    ImageView imageView_Help;
    ImageView imageView_Parametre;
    ImageView imageView_NoteAvis;
    ImageView imageView_Signaler;
    ImageView imageView_Notification;
    ImageView imageView_ActiviteRecente;
    ImageView imageView_Panier;
    ImageView imageView_Planning;
    ImageView imageView_Abonement;
    ImageView imageView_Profile;

    LinearLayout linearLayout_infos;
    CircleImageView imageView_Profile2;
    String first;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);
        //getSupportActionBar().hide();
        textView_Help = findViewById(R.id.textView_Help);
        textView_Parametre = findViewById(R.id.textView_Parametre);
        textView_NoteAvis = findViewById(R.id.textView_NoteAvis);
        textView_Signaler = findViewById(R.id.textView_Signaler);
        textView_Notification = findViewById(R.id.textView_Notification);
        textView_ActiviteRecente = findViewById(R.id.textView_ActiviteRecente);
        textView_Panier = findViewById(R.id.textView_Panier);
        textView_Planning = findViewById(R.id.textView_Planning);
        textView_Abonement = findViewById(R.id.textView_Abonement);
        textView_Profile = findViewById(R.id.textView_Profile_name);
        textView_AbonementNum = findViewById(R.id.textView_AbonementNum);
        textView_NotificationNum = findViewById(R.id.textView_NotificationNum);
        textView_PanierNum = findViewById(R.id.textView_PanierNum);
        textView_Profile_first = findViewById(R.id.textView_Profile_first);
        textView_Profile_name = findViewById(R.id.textView_Profile_name);
        imageView_Profile = findViewById(R.id.imageView_Profile);
        imageView_Profile2 = findViewById(R.id.cicleImageView_Profile2);

        cardView_Help = findViewById(R.id.cardView_Help);
        cardView_Parametre = findViewById(R.id.cardView_Parametre);
        cardView_NoteAvis = findViewById(R.id.cardView_NoteAvis);
        cardView_Signaler = findViewById(R.id.cardView_Signaler);
        cardView_Notification = findViewById(R.id.cardView_Notification);
        cardView_ActiviteRecente = findViewById(R.id.cardView_ActiviteRecente);
        cardView_Panier = findViewById(R.id.cardView_Panier);
        cardView_Planning = findViewById(R.id.cardView_Planning);
        cardView_Abonement = findViewById(R.id.cardView_Abonement);
        linearLayout_infos = findViewById(R.id.linearLayout_infos);
        constraintLayout_Help = findViewById(R.id.constraintLayout_Help);
        constraintLayout_Parametre = findViewById(R.id.constraintLayout_Parametre);
        constraintLayout_NoteAvis = findViewById(R.id.constraintLayout_NoteAvis);
        constraintLayout_Signaler = findViewById(R.id.constraintLayout_Signaler);
        constraintLayout_Notification = findViewById(R.id.constraintLayout_Notification);
        constraintLayout_ActiviteRecente = findViewById(R.id.constraintLayout_ActiviteRecente);
        constraintLayout_Panier = findViewById(R.id.constraintLayout_Panier);
        constraintLayout_Planning = findViewById(R.id.constraintLayout_Planning);
        constraintLayout_Abonement = findViewById(R.id.constraintLayout_Abonement);

        imageView_Help = findViewById(R.id.imageView_Help);
        imageView_Parametre = findViewById(R.id.imageView_Parametre);
        imageView_NoteAvis = findViewById(R.id.imageView_NoteAvis);
        imageView_Signaler = findViewById(R.id.imageView_Signaler);
        imageView_Notification = findViewById(R.id.imageView_Notification);
        imageView_ActiviteRecente = findViewById(R.id.imageView_ActiviteRecente);
        imageView_Panier = findViewById(R.id.imageView_Panier);
        imageView_Planning = findViewById(R.id.imageView_Planning);
        imageView_Abonement = findViewById(R.id.imageView_Abonement);

        imageView_Profile2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent i = new Intent(MainClientActivity.this, AccountActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainClientActivity.this, v, "profile");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    startActivity(i, options.toBundle());
                }
                else
                    startActivity(i);
                return false;
            }
        });
        imageView_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainClientActivity.this, imageView_Profile);
                popupMenu.getMenuInflater().inflate(R.menu.menu_user, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

            String f_name;
            String u_name;

 //        if(u != null) {
   //          if (u.firstname.length() <= 20)
          //       f_name = u.firstname;
     //        else
       //          f_name = u.firstname.substring(0, 19) + " ...";
         //    if (u.username.length() <= 20)
           //      u_name = u.username;
             //else
               //  u_name = u.username.substring(0, 19) + " ...";

      //       textView_Profile_first.setText(f_name);
        //     textView_Profile_name.setText(u_name);
        // }
        textView_Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpClick();
            }
        });
        imageView_Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpClick();
            }
        });
        constraintLayout_Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpClick();
            }
        });

        textView_Planning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanningClick();
            }
        });
        imageView_Planning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanningClick();
            }
        });
        constraintLayout_Planning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanningClick();
            }
        });





        textView_Parametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParametreClick();
            }
        });
        imageView_Parametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParametreClick();
            }
        });
        constraintLayout_Parametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParametreClick();
            }
        });

        Typeface roboto_Regular = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");
        textView_Help.setTypeface(roboto_Regular);
        textView_Parametre.setTypeface(roboto_Regular);
        textView_NoteAvis.setTypeface(roboto_Regular);
        textView_Signaler.setTypeface(roboto_Regular);
        textView_Notification.setTypeface(roboto_Regular);
        textView_ActiviteRecente.setTypeface(roboto_Regular);
        textView_Panier.setTypeface(roboto_Regular);
        textView_Planning.setTypeface(roboto_Regular);
        textView_Abonement.setTypeface(roboto_Regular);
        textView_Profile.setTypeface(roboto_Regular);
        textView_AbonementNum.setTypeface(roboto_Regular);
        textView_NotificationNum.setTypeface(roboto_Regular);
        textView_PanierNum.setTypeface(roboto_Regular);
    }

    private void HelpClick(){
        Intent help = new Intent(MainClientActivity.this, HelpActivity.class);
        startActivity(help);
    }

    private void PlanningClick(){
        Intent plann = new Intent(MainClientActivity.this, PlanningActivity.class);
        startActivity(plann);
    }

    private void ParametreClick(){
        cardView_Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
