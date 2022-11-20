package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConsumeFragment extends Fragment {

    //    RecyclerView recyclerView = getView(R.id.recyclerViewActions);
//    ArrayList<ContactModel> arrAction= new ArrayList<>();
    private ArrayList<ApplianceModel> applianceModelArrayList ;
    private String[] textview;
    private String[] textview1;
    private String[] textview2;

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_consume, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        dataInit();
        recyclerView = view.findViewById(R.id.rvapp);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        ApplianceAdapter applianceAdapter = new ApplianceAdapter(getContext(), applianceModelArrayList);
//        set RecyclerView with OnClick Listener Feature
//        ApplianceAdapter.setListener(new ApplianceAdapter.Listener() {
//            @Override
//            public void onClick(int position) {
//                Intent i =new Intent(getContext(), Action2Activity.class);
//            }
//        });

        recyclerView.setAdapter(applianceAdapter);
        applianceAdapter.notifyDataSetChanged();
    }

    private void dataInit() {
        applianceModelArrayList = new ArrayList<>();
        textview= new String[]{
                getString(R.string.appl1),
                "Kettle",
                "Fan",
                "Microwave",
                "AC",
                "Air Cooler",
                "TV",
        };
        textview1= new String[]{
                getString(R.string.t1),
                "2",
                "10",
                "1",
                "5",
                "16",
                "9",
        };

        textview2= new String[]{
                getString(R.string.w1),
                "280",
                "50",
                "630",
                "100",
                "90",
                "50",
        };

        for(int i=0;i<textview1.length;i++)
        {

            ApplianceModel applianceModel = new ApplianceModel(getString(R.string.name), textview[i],getString(R.string.time),textview1[i],getString(R.string.watts), textview2[i]);
            applianceModelArrayList.add(applianceModel);
        }
    }
}