package com.apptreak.convertx;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Context context;


    EditText textIn;
    TextView textOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.length);
        //Pushing drawable
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_icon_length));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_icon_area));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_icon_temperature2));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_icon_weight1));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_icon_time1));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab_volume1));
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(5).getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (tabLayout.getSelectedTabPosition()) {


                    case 0:
                        textIn = (EditText) findViewById(R.id.txtInputLength);
                        textOp = (TextView) findViewById(R.id.txtOpLength);
                        textIn.getText().clear();
                        textOp.setText(R.string.txt_default);
                        break;
                    case 1:
                        textIn = (EditText) findViewById(R.id.txtInputArea);
                        textOp = (TextView) findViewById(R.id.txtOpArea);
                        textIn.getText().clear();
                        textOp.setText(R.string.txt_default);
                        break;
                    case 2:
                        textIn = (EditText) findViewById(R.id.tempInput);
                        textOp = (TextView) findViewById(R.id.tempOut);
                        textIn.getText().clear();
                        textOp.setText(R.string.txt_default);
                        break;
                    case 3:
                        textIn = (EditText) findViewById(R.id.textWeightInput);
                        textOp = (TextView) findViewById(R.id.textWeightOut);
                        textIn.getText().clear();
                        textOp.setText(R.string.txt_default);
                        break;
                    case 4:
                        textIn = (EditText) findViewById(R.id.timeInput);
                        textOp = (TextView) findViewById(R.id.timeOutput);
                        textIn.getText().clear();
                        textOp.setText(R.string.txt_default);
                        break;
                    case 5:
                        textIn = (EditText) findViewById(R.id.textVolumeInput);
                        textOp = (TextView) findViewById(R.id.textVolumeOut);
                        textIn.getText().clear();
                        textOp.setText(R.string.txt_default);
                        break;
                }


            }
        });
        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {


                return false;
            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {


            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }catch (Exception r){}

                    viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        viewPager.setCurrentItem(0);
                        toolbar.setTitle(R.string.length);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);

                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        toolbar.setTitle(R.string.area);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 2:
                        viewPager.setCurrentItem(2);
                        toolbar.setTitle(R.string.temp);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 3:
                        viewPager.setCurrentItem(3);
                        toolbar.setTitle(R.string.weight);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 4:
                        viewPager.setCurrentItem(4);
                        toolbar.setTitle(R.string.time);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;
                    case 5:
                        viewPager.setCurrentItem(5);
                        toolbar.setTitle(R.string.vol);
                        tab.getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
                        break;


                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#1a237e"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

    }
}