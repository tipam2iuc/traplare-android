package com.example.ruthelpc.traplare;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ResizeAnimation extends Animation {

    int originalWidth;
    int targetWidth;
    int offsetWidth;
    int adjacentWidthIncrement;
    View view, adjacentView;
    boolean down;

    //This constructor makes the animation start from width 0px
    public ResizeAnimation(View view, int offsetWidth, boolean down) {
        this.view           = view;
        this.originalWidth = 0;
        this.targetWidth   = 0;
        this.offsetWidth   = offsetWidth;
        this.down           = down;
    }

    //This constructor allow us to set a starting width
    public ResizeAnimation(View view, int originalWidth, int targetWidth, boolean down) {
        this.view           = view;
        this.originalWidth = originalWidth;
        this.targetWidth   = targetWidth;
        this.offsetWidth   = targetWidth - originalWidth;
        this.down           = down;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        int newWidth;
        if (down)
            newWidth = (int) (offsetWidth * interpolatedTime);

        else
            newWidth = (int) (offsetWidth * (1 - interpolatedTime));

        //The new view width is based on start width plus the width increment
        view.getLayoutParams().width = newWidth + originalWidth;
        view.requestLayout();

        if (adjacentView != null) {
            //This line is only triggered to animate and adjacent view
            adjacentView.getLayoutParams().width = view.getLayoutParams().width + adjacentWidthIncrement;
            adjacentView.requestLayout();
        }
    }

    @Override
    public void initialize(int height, int width, int parentHeight,
                           int parentWidth) {
        super.initialize(height, width, parentHeight, parentWidth);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }

    public void setAdjacentView(View adjacentView) {
        this.adjacentView = adjacentView;
    }

    public void setAdjacentWidthIncrement(int adjacentWidthIncrement) {
        this.adjacentWidthIncrement = adjacentWidthIncrement;
    }
}