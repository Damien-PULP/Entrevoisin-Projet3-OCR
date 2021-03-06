package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.AddNeighbourEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListNeighbourActivity extends AppCompatActivity {

    // UI Components
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.activity_floating_button)
    FloatingActionButton mFloatingActionButton;

    public ListNeighbourPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_neighbour);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mPagerAdapter = new ListNeighbourPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        configureFloatingActionButton();

    }
    private void configureFloatingActionButton(){

        mFloatingActionButton.setOnClickListener(v -> EventBus.getDefault().post(new AddNeighbourEvent()));
    }


}
