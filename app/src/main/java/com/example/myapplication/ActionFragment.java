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

public class ActionFragment extends Fragment {

//    RecyclerView recyclerView = getView(R.id.recyclerViewActions);
//    ArrayList<ContactModel> arrAction= new ArrayList<>();
    private ArrayList<ContactModel> ActionArraylist;
    private String[] Actions;
    private int[] ImageResource;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        recyclerView.setLayoutManager(new LinearLayoutManager(ActionFragment));

//        arrAction.add(new ContactModel(R.drawable.ic_thermostat, "Reduce your heating and cooling"));
//        arrAction.add(new ContactModel(R.drawable.ic_thermostat, "Drive less"));
//        arrAction.add(new ContactModel(R.drawable.ic_thermostat, "Eat a plant-based meal"));
//        arrAction.add(new ContactModel(R.drawable.ic_thermostat, "Take the train instead of a plane"));
//        arrAction.add(new ContactModel(R.drawable.ic_thermostat, "Cut your food waste"));
//        arrAction.add(new ContactModel(R.drawable.ic_thermostat, "Try Zero-waste Fashion"));
//        arrAction.add(new ContactModel(R.drawable.ic_thermostat, "Buy Local"));
//        arrAction.add(new ContactModel(R.drawable.ic_thermostat, "Speak up"));
//        arrAction.add(new ContactModel(R.drawable.ic_thermostat, "Buy energy from renewable sources"));
//        arrAction.add(new ContactModel(R.drawable.ic_thermostat, "Switch to an electric vehicle"));

//        RecyclerActionAdapter adapter = new RecyclerActionAdapter(this, arrAction);
//        recyclerView.setAdapter(adapter);

        return inflater.inflate(R.layout.fragment_action, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        dataInitialise();
        recyclerView = view.findViewById(R.id.recyclerViewActions);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        RecyclerActionAdapter recyclerActionAdapter = new RecyclerActionAdapter(getContext(), ActionArraylist);
//        set RecyclerView with OnClick Listener Feature
        RecyclerActionAdapter.setListener(new RecyclerActionAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent i =new Intent(getContext(), Action2Activity.class);
            }
        });

        recyclerView.setAdapter(recyclerActionAdapter);
        recyclerActionAdapter.notifyDataSetChanged();
    }

    private void dataInitialise() {
        ActionArraylist = new ArrayList<>();
        Actions = new String[]{
                getString(R.string.action1),
                getString(R.string.action2),
                getString(R.string.action3),
                getString(R.string.action4),
                getString(R.string.action5),
                getString(R.string.action6),
                getString(R.string.action7),
                getString(R.string.action8),
                getString(R.string.action9),
                getString(R.string.action10),
        };
        ImageResource= new int[]{
                R.drawable.ic_thermostat,
                R.drawable.ic_thermostat,
                R.drawable.ic_thermostat,
                R.drawable.ic_thermostat,
                R.drawable.ic_thermostat,
                R.drawable.ic_thermostat,
                R.drawable.ic_thermostat,
                R.drawable.ic_thermostat,
                R.drawable.ic_thermostat,
                R.drawable.ic_thermostat,
        };

        for(int i=0;i<Actions.length;i++)
        {
            ContactModel contactModel = new ContactModel(ImageResource[i], Actions[i]);
            ActionArraylist.add(contactModel);
        }
    }
}
