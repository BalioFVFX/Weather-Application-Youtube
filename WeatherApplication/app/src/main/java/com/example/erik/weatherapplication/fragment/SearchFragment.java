package com.example.erik.weatherapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.erik.weatherapplication.R;
import com.example.erik.weatherapplication.fragment.base.IHistoryUpdate;
import com.example.erik.weatherapplication.fragment.base.IWeatherUpdate;
import com.example.network.DataManager;
import com.example.network.IData;
import com.example.network.Weather;
import com.example.network.WeatherMain;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    private final static String API_KEY = "10885e4a556baaa10a716567518c894e";
    private Button searchButton;
    private EditText townEditText;
    private EditText lettersEditText;
    private IWeatherUpdate iWeatherUpdate;
    private IHistoryUpdate iHistoryUpdate;

    public void setWeatherCallBack(IWeatherUpdate iWeatherUpdate){
        this.iWeatherUpdate = iWeatherUpdate;
    }

    public void setHistoryCallBack(IHistoryUpdate iHistoryUpdate){
        this.iHistoryUpdate = iHistoryUpdate;
    }


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        this.init(view);
        this.setupButtonListener();
        return view;
    }

    private void init(View view){
        this.searchButton = (Button)view.findViewById(R.id.btn_search);
        this.townEditText = (EditText)view.findViewById(R.id.et_town);
        this.lettersEditText = (EditText)view.findViewById(R.id.et_country_2_letters);
    }

    private void setupButtonListener(){
        this.searchButton.setOnClickListener(v -> {
            final String townName = this.townEditText.getText().toString().trim();
            final String country_two_letters = this.lettersEditText.getText().toString().trim();
            final String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s,%s&APPID=%s&units=metric",
                    townName, country_two_letters, API_KEY);
            IData<WeatherMain> dataManager = new DataManager<WeatherMain>(url, WeatherMain.class);
            dataManager.getData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(weatherMain -> {
                        weatherMain.getWeather().setCountryLetters(country_two_letters);
                        weatherMain.getWeather().setTownName(townName);
                        iWeatherUpdate.updateTemperatureTextView(weatherMain.getWeather().getTemp().toString());
                        iHistoryUpdate.updateListView(weatherMain.getWeather());
                        Toast.makeText(getContext(), "Weather data received successfully", Toast.LENGTH_SHORT).show();
                    });
        });
    }

}
