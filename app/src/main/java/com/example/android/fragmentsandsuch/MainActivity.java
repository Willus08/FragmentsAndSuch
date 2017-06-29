package com.example.android.fragmentsandsuch;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RedFragment.OnFragmentInteractionListener, BlueFragment.OnFragmentInteractionListener, YellowFragment.OnFragmentInteractionListener {

    private TextView textView;
    private final static String RED_TAG ="Red Tag";
    private final static String BLUE_TAG ="Blue Tag";
    private final static String YELLOW_TAG ="Yellow Tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tvRedOut);
    }

    public void blueflag(View view) {
        BlueFragment blueFragment = new BlueFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", "I'm Blue: da ba de da");
        blueFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.SecondFragment,blueFragment,BLUE_TAG).commit();

    }

    public void yellowflag(View view) {
        YellowFragment yellowFragment = YellowFragment.newInstance("Will","Baldes");
        getSupportFragmentManager().beginTransaction().replace(R.id.flFirstFragment,yellowFragment,YELLOW_TAG).commit();
    }

    public void redflag(View view) {
        RedFragment redFragment= new RedFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.flFirstFragment,redFragment,RED_TAG).commit();

    }

    @Override
    public void onBlueFragmentInteraction(String str) {
        textView.setText(str);

    }


    public void onYellowFragmentInteraction(String str) {

    }

    @Override
    public void onFragmentInteraction(String str) {

    }


    public void removeRedFragments(View view) {
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag(RED_TAG);
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }

    public void removeBlueFragments(View view) {
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag(BLUE_TAG);
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }

    public void removeYellowFragments(View view) {
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag(YELLOW_TAG);
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }
}
