package com.apptreak.convertx;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Farman on 10/22/2016.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    int noOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.noOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Length length = new Length();
                return length;
            case 1:
                Area area = new Area();
                return area;
            case 2:
                Temperature temperature = new Temperature();
                return temperature;
            case 3:
                Weight weight = new Weight();
                return weight;
            case 4:
                Time time = new Time();
                return time;
            case 5:
                Volume volume = new Volume();
                return volume;

            default:return null;
        }
    }


    @Override
    public int getCount() {
        return noOfTabs;
    }
}
