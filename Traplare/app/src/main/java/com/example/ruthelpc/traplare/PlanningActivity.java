package com.example.ruthelpc.traplare;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlanningActivity extends AppCompatActivity {
    ImageView imageView_menu;
    TextView editText_your_destination;
    SearchView searchView_find;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        viewPager = findViewById(R.id.viewpager);
        searchView_find = findViewById(R.id.searchView_find_travel);
        setViewPager(viewPager);
        tabLayout = findViewById(R.id.mytabs);
        tabLayout.setupWithViewPager(viewPager);
        Typeface RobotoBoldCondensed = Typeface.createFromAsset(getAssets(), "fonts/Roboto-BoldCondensed.ttf");
        imageView_menu = findViewById(R.id.imageView_menu);
        editText_your_destination = findViewById(R.id.editText_your_Title);
        editText_your_destination.setTypeface(RobotoBoldCondensed);
        imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanningActivity.this, MainClientActivity.class);
                startActivity(intent);
            }
        });

        searchView_find.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                    viewPager.setCurrentItem(1, true);
                    RechercheFragment.getAll(PlanningActivity.this, query);
                    searchView_find.setIconified(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
    private void setViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AllTravelFragment(), "Accueil");
        adapter.addFragment(new RechercheFragment(),"Mes modèles");
        adapter.addFragment(new PromotionsFragment(), "Offres promotionnels");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    public int ToDp(int px) {
        return px / ((int)getApplicationContext().getResources().getDisplayMetrics().density);
    }
}