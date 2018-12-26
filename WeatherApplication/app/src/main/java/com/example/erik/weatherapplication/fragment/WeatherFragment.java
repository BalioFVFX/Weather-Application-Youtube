package com.example.erik.weatherapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.erik.weatherapplication.R;
import com.example.erik.weatherapplication.fragment.base.IWeatherUpdate;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment
implements IWeatherUpdate {

    private TextView temperatureTextView;

    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        this.init(view);
        return view;
    }


    private void init(View view){
        this.temperatureTextView = (TextView)view.findViewById(R.id.tv_degrees);
    }

    @Override
    public void updateTemperatureTextView(String text) {
        this.temperatureTextView.setText(text + "°");
    }

}
