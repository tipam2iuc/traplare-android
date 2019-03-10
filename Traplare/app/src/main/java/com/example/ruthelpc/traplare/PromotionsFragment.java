package com.example.ruthelpc.traplare;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class PromotionsFragment extends Fragment {

    RelativeLayout relativeLayout_card_empiled;

    public PromotionsFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_promotion, container, false);
        relativeLayout_card_empiled = view.findViewById(R.id.relativeLayout_card_empiled);
        for (int i = 0 ; i < 4 ; i++){
            View view1 = inflater.inflate(R.layout.template_card, container,false);
            CardView cardView = view1.findViewById(R.id.card_view_carte);

            CardView.LayoutParams layoutParams = new CardView.LayoutParams(toDp(150),toDp(150));

            layoutParams.setMargins((i+1)*3,(i+1)*3,0,0);

            if(i == 0)
                cardView.setCardBackgroundColor(getResources().getColor(R.color.colorCard1));
            else if (i == 1)
                cardView.setCardBackgroundColor(getResources().getColor(R.color.colorCard2));
            else if (i == 3)
                cardView.setCardBackgroundColor(getResources().getColor(R.color.colorCard3));
            relativeLayout_card_empiled.addView(cardView, layoutParams);
        }
        return view;

    }
    public static int toDp(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
    private MotionEvent swapXY(MotionEvent ev, View view) {
        float width = view.getWidth();
        float height = view.getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = ev.getY();

        ev.setLocation(newX, newY);
        return ev;
    }
}