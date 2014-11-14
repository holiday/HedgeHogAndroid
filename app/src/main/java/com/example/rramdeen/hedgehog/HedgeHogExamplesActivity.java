package com.example.rramdeen.hedgehog;

import android.app.Activity;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by rramdeen on 11/14/14.
 */
public class HedgeHogExamplesActivity extends ActionBarActivity {

    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hedge_hog_examples);
        System.out.println("Second Activity Created");

        //grab the listview
        ListView hedgeHogExamplesListView = (ListView)findViewById(R.id.hedgeHogExamplesListView);

        String[] planets = {"Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};

        this.listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planets);

        hedgeHogExamplesListView.setAdapter(this.listAdapter);

    }

    @Override
    public void onStart(){
        super.onStart();
        System.out.println("Second Activity Started");
    }

    @Override
    public void onResume(){
        super.onResume();
        System.out.println("Second Activity Resuming");
    }

    @Override
    public void onPause(){
        super.onPause();
        System.out.println("Second Activity Paused");
    }

    @Override
    public void onStop(){
        super.onStop();
        System.out.println("Second Activity Stopped");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Second Activity Destroyed");
    }
}
