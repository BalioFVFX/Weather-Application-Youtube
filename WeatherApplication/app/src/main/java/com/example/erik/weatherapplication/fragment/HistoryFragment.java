package com.example.erik.weatherapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.erik.weatherapplication.R;
import com.example.erik.weatherapplication.fragment.adapter.HistoryListViewAdapter;
import com.example.erik.weatherapplication.fragment.base.IHistoryUpdate;
import com.example.network.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements IHistoryUpdate {

    private ListView listView;
    private HistoryListViewAdapter historyListViewAdapter;
    private List<Weather> weatherData;


    public HistoryFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_history, container, false);
        this.init(view);
        this.listView.setAdapter(historyListViewAdapter);

        return view;
    }

    public void init(View view){
        this.weatherData = new ArrayList<>();
        this.listView = view.findViewById(R.id.list_view);
        this.historyListViewAdapter = new HistoryListViewAdapter(getContext(), this.weatherData);

    }

    @Override
    public void updateListView(Weather weather) {
        this.weatherData.add(weather);
        this.listView.invalidateViews();
    }
}
