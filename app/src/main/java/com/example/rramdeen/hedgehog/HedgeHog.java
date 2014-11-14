package com.example.rramdeen.hedgehog;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
/*
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
*/


public class HedgeHog extends ActionBarActivity implements View.OnClickListener {

    ViewGroup factOne, factTwo, factThree;
    Button nextSectionButton;
    boolean isFactOneOpen, isFactTwoOpen, isFactThreeOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hedge_hog);
        System.out.println("Activity Created");

        // Facts that we will use in our ListView
        String[] hedgehogFacts = {
                "European hedgehogs in the UK hibernate throughout winter. They feed as much as " +
                        "possible during the autumn and in around October build its nest of " +
                        "leaves and grass in which to hibernate",
                "There are 15 species of hedgehog",
                "Hedgehogs in cold climate hibernate over the winter. In warmer climates such " +
                        "as deserts they sleep through heat and drought in a " +
                        "similar process called aestivation. In more temperate areas " +
                        "they remain active all year."};

        this.factOne = (ViewGroup)findViewById(R.id.firstFact);
        this.factTwo = (ViewGroup)findViewById(R.id.secondFact);
        this.factThree = (ViewGroup)findViewById(R.id.thirdFact);

        //Set the textView data
        TextView firstFactTextView = (TextView)findViewById(R.id.factOneTextView);
        TextView secondFactTextView = (TextView)findViewById(R.id.factTwoTextView);
        TextView thirdFactTextView = (TextView)findViewById(R.id.factThreeTextView);

        firstFactTextView.setText(hedgehogFacts[0]);
        secondFactTextView.setText(hedgehogFacts[1]);
        thirdFactTextView.setText(hedgehogFacts[2]);

        this.factOne.setOnClickListener(this);
        this.factTwo.setOnClickListener(this);
        this.factThree.setOnClickListener(this);

        isFactOneOpen = false;
        isFactTwoOpen = false;
        isFactThreeOpen = false;

        //listen for button click event
        this.nextSectionButton = (Button)findViewById(R.id.nextSectionButton);

        this.nextSectionButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                System.out.println("Clicked button");
                Intent getHedgeHogExamplesScreen = new Intent(HedgeHog.this, HedgeHogExamplesActivity.class);

                final int result = 1;

                startActivity(getHedgeHogExamplesScreen);
            }

        });
    }

    @Override
    public void onClick(View v) {
        System.out.println(v.toString());

        switch (v.getId()){

            case (R.id.firstFact):
                if (this.isFactOneOpen){
                    this.factOne.startAnimation(AnimationUtils.loadAnimation(HedgeHog.this, R.anim.slide_fact_in));
                }else{
                    this.factOne.startAnimation(AnimationUtils.loadAnimation(HedgeHog.this, R.anim.slide_fact_out));
                }
                this.isFactOneOpen = !isFactOneOpen;
                break;

            case (R.id.secondFact):
                if (this.isFactTwoOpen){
                    this.factTwo.startAnimation(AnimationUtils.loadAnimation(HedgeHog.this, R.anim.slide_fact_in));
                }else{

                    this.factTwo.startAnimation(AnimationUtils.loadAnimation(HedgeHog.this, R.anim.slide_fact_out));
                }
                this.isFactTwoOpen = !isFactTwoOpen;
                break;

            case (R.id.thirdFact):
                if (this.isFactThreeOpen){
                    this.factThree.startAnimation(AnimationUtils.loadAnimation(HedgeHog.this, R.anim.slide_fact_in));
                }else{
                    this.factThree.startAnimation(AnimationUtils.loadAnimation(HedgeHog.this, R.anim.slide_fact_out));
                }
                this.isFactThreeOpen = !isFactThreeOpen;
                break;

            default:
                break;

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hedge_hog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart(){
        super.onStart();
        System.out.println("Activity Started");
    }

    @Override
    public void onResume(){
        super.onResume();
        System.out.println("Activity Resuming");
    }

    @Override
    public void onPause(){
        super.onPause();
        System.out.println("Activity Paused");
    }

    @Override
    public void onStop(){
        super.onStop();
        System.out.println("Activity Stopped");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Activity Destroyed");
    }
}
