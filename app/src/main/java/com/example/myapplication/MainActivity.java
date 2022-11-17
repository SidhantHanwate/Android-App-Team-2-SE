package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    bottomNavigation = findViewById(R.id.bottomNav);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_auto));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_action));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_consume));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_solar));
        bottomNavigation.add(new MeowBottomNavigation.Model(6, R.drawable.ic_person));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                Fragment fragment = null;

                if(item.getId()==6) {
                    fragment = new UserFragment();
                } else if(item.getId()==5) {
                    fragment = new SolarFragment();
                } else if(item.getId()==4) {
                    fragment = new ConsumeFragment();
                } else if(item.getId()==3) {
                    fragment = new ActionFragment();
                } else if(item.getId()==2) {
                    fragment = new AutoFragment();
                } else {
                    fragment = new HomeFragment();
                }
                loadFragment(fragment);
            }
        });
        bottomNavigation.show(1, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "You clicked " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "You reselected " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

//        bottomNavigation.setCount(3, "10");
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment_container, fragment, null)
                .commit();
    }

}