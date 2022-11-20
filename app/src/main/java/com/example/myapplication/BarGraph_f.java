package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

public class BarGraph_f extends Fragment {

    private BarChart barChart;
    private ArrayList<Integer> barXAxisLabels;

    public BarGraph_f() {
       super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bar_graph_f, container, false);
        TextView textview = v.findViewById(R.id.frag_bar_text);

        Bundle args = getArguments();
        assert args != null;
        textview.setText(String.format("%s",args.getString("Name")));

        barXAxisLabels = new ArrayList<Integer>();
        return v;
    }

    private Integer GetYValue(int xvalue) {
        Random random = new Random();
        return Math.round(xvalue*random.nextFloat())+random.nextInt(100);
    }

    // Get Values Based on the arguments passed from the class
    private ArrayList<BarEntry> GetGraphEntries() {
        ArrayList<BarEntry> barData = new ArrayList<>();

        assert getArguments() != null;
        int value = getArguments().getInt("Position");

        for(int i=0;i<barXAxisLabels.size();i++) {
            BarEntry barEntry = new BarEntry(i,GetYValue(i));
            barData.add(barEntry);
        }

        return barData;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        barChart = view.findViewById(R.id.bar_chart);

        final int maxValue = 5;

        for(int i=0;i<maxValue;i++) {
            barXAxisLabels.add(i+1);
        }

        ArrayList<BarEntry> barData = GetGraphEntries();

        BarDataSet dataSet = new BarDataSet(barData,"MyClimate");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setDrawValues(false);

        barChart.setData(new BarData(dataSet));
        barChart.animateY(2000);

        barChart.setTouchEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setScaleXEnabled(true);
        barChart.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.dark_background));

        // Highlight Labels
        barChart.setEnabled(true);

        XAxis xaxis = barChart.getXAxis();
        xaxis.setEnabled(true);
        xaxis.setLabelCount(barXAxisLabels.size());
        xaxis.setValueFormatter(new ValueFormatter() {
            @SuppressLint("DefaultLocale")
            @Override
            public String getFormattedValue(float value) {
                return String.format("%.1f",value);
            }
        }
        );
        xaxis.setXOffset(0);
        xaxis.setTextColor(Color.rgb(255,255,255));
        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        barChart.getAxisLeft().setTextColor(Color.rgb(255,255,255));
        barChart.getAxisRight().setTextColor(Color.rgb(255,255,255));

        barChart.getDescription().setText("time vs temperature");
        barChart.getDescription().setTextColor(Color.rgb(150,70,100));
        barChart.getDescription().setPosition(0,0);
    }
}