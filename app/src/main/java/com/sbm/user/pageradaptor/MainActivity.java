package com.sbm.user.pageradaptor;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Debug;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Myadaptor myadaptor;

    ArrayList<PageWrapper> countries = new ArrayList<>();
    MyAsynctask ma;
    Random random=new Random();
    ViewPager viewpager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager= (ViewPager) findViewById(R.id.viewpager);
        ma= new MyAsynctask();
         ma.execute();

    }

    private void initilizecountry() {
        PageWrapper iran = new PageWrapper();
        PageWrapper germany = new PageWrapper();
        PageWrapper England = new PageWrapper();

        iran.county = "iran";
        iran.capital = "Tehran";
        iran.imageId = R.drawable.imagesiran;

        germany.county = "Germany";
        germany.capital = "Berlin";
        germany.imageId = R.drawable.imagesgermany;

        England.county = "England";
        England.capital = "London";
        England.imageId = R.drawable.imagesengland;

        countries.add(iran);
        countries.add(germany);
        countries.add(England);

    }

    private void addExtra() {
        for (int i = 1; i <= 5000; i++) {
            PageWrapper fictionCountry = new PageWrapper();
            countries.add(fictionCountry);
            fictionCountry.county = "fictioncountry" + "  " + i;
            fictionCountry.capital = "fictionCApital" + "   " + i;
            fictionCountry.imageId = R.drawable.imagesengland;

          //  fictionCountry.spinnerposition=3;
            SystemClock.sleep(1);
        }

    }



    private class MyAsynctask extends AsyncTask<String,Integer,String > {
        LinearLayout lnprogressbar = (LinearLayout) findViewById(R.id.progressbar);

        @Override
        protected String doInBackground(String... params) {
            //Debug.waitForDebugger();
            initilizecountry();
            addExtra();
            myadaptor = new Myadaptor(getSupportFragmentManager(), countries);
           return null;

        }

        @Override
        protected void onPreExecute() {
            lnprogressbar.setVisibility(View.VISIBLE);
        }


        @Override
        protected void onPostExecute(String aVoid) {
            lnprogressbar.setVisibility(View.GONE);
            viewpager.setAdapter(myadaptor);
        }
    }
}
