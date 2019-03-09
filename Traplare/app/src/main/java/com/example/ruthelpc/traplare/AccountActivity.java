package com.example.ruthelpc.traplare;

import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        viewPager = findViewById(R.id.viewpager_profile);
        setViewPager(viewPager);

        tabLayout = findViewById(R.id.mytabs_profile);
        tabLayout.setupWithViewPager(viewPager);

        Typeface RobotoBoldCondensed = Typeface.createFromAsset(getAssets(), "fonts/Roboto-BoldCondensed.ttf");
    }


    private void setViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new InfosProfileFragment(), "Mon profil");
        adapter.addFragment(new PreferenceFragment(),"Preférences");
        adapter.addFragment(new AgendaFragment(), "Agenda");
        adapter.addFragment(new StatistiqueFragment(), "Statistique");
        adapter.addFragment(new EditeurProfileFragment(), "Editer");
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
}
