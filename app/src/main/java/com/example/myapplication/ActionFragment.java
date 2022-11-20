package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActionFragment extends Fragment implements RecyclerActionAdapter.ItemClickListener {

//    RecyclerView recyclerView = getView(R.id.recyclerViewActions);
//    ArrayList<ContactModel> arrAction= new ArrayList<>();
    private ArrayList<ContactModel> ActionArraylist = new ArrayList<>();
    private String[] Actions;
    private int[] ImageResource;
    int check=0;
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
        View view = inflater.inflate(R.layout.fragment_action, container, false);
        buildListData();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        dataInitialise();
        recyclerView = view.findViewById(R.id.recyclerViewActions);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        RecyclerActionAdapter adapter = new RecyclerActionAdapter(getContext(), ActionArraylist);
        recyclerView.setHasFixedSize(true);
        RecyclerActionAdapter recyclerActionAdapter = new RecyclerActionAdapter(getContext(), ActionArraylist, this);
//        set RecyclerView with OnClick Listener Feature
//        RecyclerActionAdapter.setListener(new RecyclerActionAdapter.Listener() {
//            @Override
//            public void onClick(int position) {
//                Intent intent = new Intent(getContext(), ActionsA1.class);
//                if(check==0)
//                {
//                    intent.putExtra("Action", Actions[position]);
//                    intent.putExtra("Image", ImageResource[position]);
//                }
//                else
//                {
//                    intent.putExtra("Action", Actions[position]);
//                    intent.putExtra("Image", ImageResource[position]);
//                }
//
//                startActivity(intent);
//            }
//        });

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
                R.drawable.ic_car,
                R.drawable.ic_plants,
                R.drawable.ic_planes,
                R.drawable.ic_food,
                R.drawable.ic_cloth,
                R.drawable.ic_virus,
                R.drawable.ic_speak,
                R.drawable.ic_energy,
                R.drawable.ic_ecar,
        };

        for(int i=0;i<Actions.length;i++)
        {
            ContactModel contactModel = new ContactModel(ImageResource[i], Actions[i]);
            ActionArraylist.add(contactModel);
        }
    }
    private void buildListData()
    {
        ActionArraylist.add(new ContactModel(R.drawable.ic_thermostat, "Reduce your heating and cooling"));
        ActionArraylist.add(new ContactModel(R.drawable.ic_car, "Drive less"));
        ActionArraylist.add(new ContactModel(R.drawable.ic_plants, "Eat a plant-based meal"));
        ActionArraylist.add(new ContactModel(R.drawable.ic_food, "Cut your food waste"));
        ActionArraylist.add(new ContactModel(R.drawable.ic_cloth, "Try Zero-waste Fashion"));
        ActionArraylist.add(new ContactModel(R.drawable.ic_virus, "Buy Local"));
        ActionArraylist.add(new ContactModel(R.drawable.ic_speak, "Speak up"));
        ActionArraylist.add(new ContactModel(R.drawable.ic_planes, "Take the train instead of a plane"));
        ActionArraylist.add(new ContactModel(R.drawable.ic_energy, "Buy energy from renewable sources"));
        ActionArraylist.add(new ContactModel(R.drawable.ic_ecar, "Switch to an electric vehicle"));

    }

    @Override
    public void onItemClick(ContactModel contactModel,int pos) {

        ArrayList<ContactModel> arr=RecyclerActionAdapter.arrAction;
        Fragment fragment = ActionA1.newInstance(arr.get(pos).name,arr.get(pos).img);
//        Fragment fragment = new ActionA1();


        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
