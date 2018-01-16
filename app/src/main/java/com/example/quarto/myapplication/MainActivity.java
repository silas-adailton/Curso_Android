package com.example.quarto.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String STATE_FRAGMENT = "state_of_fragment";
    private Button mButton;
    private boolean isFragmentDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button_open_fragment);
        mButton.setOnClickListener(new buttonOpenFragment());

        if (savedInstanceState != null) {
            isFragmentDisplayed = savedInstanceState.getBoolean(STATE_FRAGMENT);

            if (isFragmentDisplayed) {
                mButton.setText(R.string.close);
            }
        }


    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(STATE_FRAGMENT, isFragmentDisplayed);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void displayFragment() {
        SimpleFragment simpleFragment = SimpleFragment.newInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, simpleFragment)
                .addToBackStack(null)
                .commit();

        mButton.setText(R.string.close);

        isFragmentDisplayed = true;
    }

    public void closeFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager
                .findFragmentById(R.id.fragment_container);

        if (simpleFragment != null) {

            FragmentTransaction fragmentTransaction = fragmentManager
                    .beginTransaction();

            fragmentTransaction.remove(simpleFragment).commit();
        }

        mButton.setText(R.string.open);

        isFragmentDisplayed = false;


    }

    private class buttonOpenFragment implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (!isFragmentDisplayed) {
                displayFragment();
            }else {
                closeFragment();
            }
        }
    }

}
