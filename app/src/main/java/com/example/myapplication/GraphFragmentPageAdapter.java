package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class GraphFragmentPageAdapter extends FragmentStatePagerAdapter {

    public GraphFragmentPageAdapter(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if(position < 2) {
        BarGraph_f barGraph_f = new BarGraph_f();
        Bundle args = new Bundle();

        switch (position) {
            case 0: {
                args.putString(new String("Name"),new String("Consuming"));
                break;
            }
            case 1 : {
                args.putString(new String("Name"),new String("Reducing"));
                break;
            }
            default:
                try {
                    throw new Exception("Invalid Position Number");
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }

        args.putInt(new String("Position"),position);

        barGraph_f.setArguments(args);
        return barGraph_f;
        }else {
            PieGraph_f pieGraph_f = new PieGraph_f();
            Bundle args  = new Bundle();

            switch (position) {
                case 2: {
                    args.putString(new String("Name"),new String("Consuming"));
                    break;
                }
                case 3 : {
                    args.putString(new String("Name"),new String("Reducing"));
                    break;
                }
                default:
                    try {
                        throw new Exception("Invalid Position Number");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }

            args.putInt(new String("Position"),position);

            pieGraph_f.setArguments(args);
            return pieGraph_f;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return String.format("Title %d",position);
    }
}
