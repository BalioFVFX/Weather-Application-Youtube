package com.example.erik.weatherapplication.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.erik.weatherapplication.R;
import com.example.network.Weather;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class HistoryListViewAdapter extends ArrayAdapter<Weather> {

    private List<Weather> weatherData;
    private Context context;

    public HistoryListViewAdapter(Context context, List<Weather> weatherData) {
        super(context, R.layout.list_view_custom, weatherData);
        this.context = context;
        this.weatherData = weatherData;
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_view_custom, parent, false);
        }

        ((TextView) view.findViewById(R.id.tv_town_name)).setText("Town: " + getItem(position).getTownName());
        ((TextView) view.findViewById(R.id.tv_country_code)).setText("Country: " + getItem(position).getCountryLetters());
        ((TextView) view.findViewById(R.id.tv_temp)).setText("Temperature: " + getItem(position).getTemp().toString() + "°");

        return view;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public Weather getItem(int position) {
        return this.weatherData.get(position);
    }
}
