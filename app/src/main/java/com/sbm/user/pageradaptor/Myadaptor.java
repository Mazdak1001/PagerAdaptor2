package com.sbm.user.pageradaptor;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;


// ...

    public  class Myadaptor extends FragmentStatePagerAdapter {
        ArrayList<PageWrapper> countries= new ArrayList();
        int mCount;

        public Myadaptor(FragmentManager fm, ArrayList<PageWrapper> countries) {
            super(fm);
            this.countries = countries;
        }

        @Override
        public int getCount() {
            //notifyDataSetChanged();
          mCount=countries.size();
            return mCount;
        }

        public Fragment getItem(int ps) {
            return Firstfragment.newInstance(countries.get(ps));
        }
       /* @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_NONE;
        }*/



    }

