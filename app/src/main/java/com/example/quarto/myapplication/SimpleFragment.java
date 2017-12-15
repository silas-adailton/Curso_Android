package com.example.quarto.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SimpleFragment extends Fragment {
    private static final int YES = 0;
    private static final int NO = 1;

    public SimpleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_simple,container, false);

        final RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radioGroup.findViewById(checkedId);

                int index = radioGroup.indexOfChild(radioButton);

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

        return rootView;
    }
}
