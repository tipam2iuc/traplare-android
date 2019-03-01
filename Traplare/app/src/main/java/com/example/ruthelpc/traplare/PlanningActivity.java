package com.example.ruthelpc.traplare;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlanningActivity extends AppCompatActivity {
    ImageView imageView_menu;
    EditText editText_your_destination;
    TextView textView_promo_offer;
    TextView textView_agencies_agenda;
    TextView textView_categories;
    TextView textView_all_travels;
    LinearLayout linearLayout_main_container;
    Intent i;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        getSupportActionBar().hide();
        imageView_menu = findViewById(R.id.imageView_menu);
        editText_your_destination = findViewById(R.id.editText_your_destination);
        textView_promo_offer = findViewById(R.id.textView_promo_offer);
        textView_agencies_agenda = findViewById(R.id.textView_agencies_agenda);
        textView_categories = findViewById(R.id.textView_categories);
        textView_all_travels = findViewById(R.id.textView_all_travels);

        Typeface RobotoBoldCondensed = Typeface.createFromAsset(getAssets(),"fonts/Roboto-BoldCondensed.ttf");
        Typeface RobotoBold = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Bold.ttf");
        editText_your_destination.setTypeface(RobotoBoldCondensed);
        textView_promo_offer.setTypeface(RobotoBold);
        textView_agencies_agenda.setTypeface(RobotoBold);
        textView_categories.setTypeface(RobotoBold);
        textView_all_travels.setTypeface(RobotoBold);

        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanningActivity.this, MainClientActivity.class);
                startActivity(intent);
            }
        });

        linearLayout_main_container = findViewById(R.id.linearLayout_main_container);
        int i;
        for (i = 0; i < 10; i++) {
            LinearLayout layout = new LinearLayout(this);
            layout.setBackground(getResources().getDrawable(R.drawable.ombre));
            layout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = dpToPx(5);
            params.rightMargin = dpToPx(5);
            params.bottomMargin = dpToPx(10);

            LinearLayout.LayoutParams params_textView = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params_textView.leftMargin = dpToPx(8);
            params_textView.rightMargin = dpToPx(5);
            params_textView.topMargin = dpToPx(10);

            TextView option_name = new TextView(this);
            option_name.setText("option " + (i+1));
            option_name.setTypeface(RobotoBold);

                    HorizontalScrollView value_scroll = new HorizontalScrollView(this);
            value_scroll.setHorizontalScrollBarEnabled(false);
            value_scroll.setPadding(0,0,0,0);

            LinearLayout.LayoutParams params_horizontalScrollView = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params_horizontalScrollView.topMargin = dpToPx(5);
            params_horizontalScrollView.leftMargin = dpToPx(0);
            params_horizontalScrollView.rightMargin = dpToPx(0);

            LinearLayout value_package = new LinearLayout(this);
            value_package.setPadding(5,0,0,20);
            LinearLayout.LayoutParams params_package = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            int a;
            for (a = 0 ; a < 12 ; a++){
                LinearLayout.LayoutParams params_values = new LinearLayout.LayoutParams
                        (140, 150);
                params_values.leftMargin = dpToPx(2);
                params_values.rightMargin = dpToPx(2);
                params_values.topMargin = dpToPx(2);
                params_values.bottomMargin = dpToPx(2);

                TextView option_valeurs = new TextView(this);
                option_valeurs.setText("valeur " + (i+1));
                option_valeurs.setTypeface(RobotoBold);
                option_valeurs.setPadding(5,0,5,0);
                option_valeurs.setBackgroundColor(getResources().getColor(R.color.colorSpecial1));
                value_package.addView(option_valeurs, params_values);
            }

            value_scroll.addView(value_package, params_package);
            layout.addView(option_name, params_textView);
            layout.addView(value_scroll, params_horizontalScrollView);
            linearLayout_main_container.addView(layout, params);
        }
    }

    public int dpToPx(int dp) {
        float density = this.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }
}
