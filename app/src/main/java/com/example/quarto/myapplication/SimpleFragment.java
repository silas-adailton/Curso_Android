package com.example.quarto.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleFragment extends android.support.v4.app.Fragment {
    private static final int YES = 0;
    private static final int NO = 1;

    public SimpleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_simple,container, false);

        final RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radio_group);
        final RatingBar ratingBar = (RatingBar) rootView.findViewById(R.id.ratingbar);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                View radioButton = radioGroup.findViewById(checkedId);

                int index = radioGroup.indexOfChild(radioButton);
                Log.d("teste", "onCheckedChanged: "+index);

                TextView textView = (TextView) rootView.findViewById(R.id.fragment_header);

                switch (index) {
                    case YES:
                        textView.setText(R.string.yes_message);
                        break;

                    case NO:
                        textView.setText(R.string.no_message);
                        break;

                    default:
                        break;
                }

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getActivity(), "Minhas estrelas: "+v, Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }

    public static SimpleFragment newInstance() {

        return new SimpleFragment();
    }
}
