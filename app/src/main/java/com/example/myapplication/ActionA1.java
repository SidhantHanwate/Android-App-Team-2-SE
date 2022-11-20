package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ActionA1 extends Fragment {
    @Nullable

    public static String name;
    public static int image;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.action_a1, container, false);
        TextView  titleAction = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.Img1);
        titleAction.setText(name);
        imageView.setImageResource(image);
        return view;
    }

    public static ActionA1 newInstance(String a, int b) {
        ActionA1 fragment = new ActionA1();
        Bundle args = new Bundle();
        if((a.equals("Reduce your heating and cooling"))){
            a= " Almost half of the energy we use in our homes goes to heating and cooling. Lower your thermostat by 1°Farenheit (0.5°Celsius) in the winter and 3°Farenheit (1.5°Celsius) in the summer. You can save about 0.4 kg of carbon emissions each day! In addition, you will also save a lot on your electricity bill. Log this action every day you keep your indoor temperature lower in the winter and higher in the summer.\n\nAssumption\nIf al the households in the US adjust their thermostats by 1°Farenheit (0.5°Celsius) in the winter and 3°Farenheit (1.5°Celsius) in the summer, we can save 1.5 billion kg of carbon emissions per year. That amounts to savings of 0.4 kg of CO2 emissions every day for an average household of 2.57 persons.";
            b= R.drawable.ic_thermostat;
        }
        else if((a.equals("Drive less"))){
            a ="The world's roadways are clogged with vehicles, most of them burning fossil fuels. Not only will driving less be easier on our climate, but it contributes to your overall health and wellbeing. Walking or riding your bike can be your exercise for the day and the subway is a great time to finish that book you've been wanting to read. Leaving your car in the garage and cycling or walking instead for 2.5 miles (4 km) can save 1 kg of CO2 emissions.\n" +
                    "\n" +
                    "Assumptions\n" +
                    "\n" +
                    "The average vehicle in the U.S. emits about 404 g of CO2 per mile. Based on this assumption, you can save about 1 kg of CO2 every time you avoid driving 2.5 miles (4 km).";
            b = R.drawable.ic_car;
        }
        else if((a.equals("Eat a plant-based meal"))){
            a = "Did you know that eating less meat and dairy and more plant-based foods -- such as vegetables, fruits, whole grains, legumes, nuts, and seeds -- can significantly lower your environmental impact? Plant-based foods produce less greenhouse gas emissions and use less energy, land, and water. Food makes up the largest part of a person's water footprint, even when compared to taking long showers or flushing the toilet every time it's used. By replacing one meat-rich meal with a vegetarian meal, you can save about 1.46 kg of CO2 emissions and over 1,000 liters of water. Give it a try!\n" +
                    "\n" +
                    "Assumptions\n" +
                    "\n" +
                    "According to the UN carbon footprint calculator, an average meat lover's diet has an environmental impact of 3.3 metric tonnes of CO2 equivalent per year, while a vegetarian diet emits about 1.7 metric tonnes of CO2 equivalent per year.";
            b= R.drawable.ic_plants;
        }
        else if ((a.equals("Take the train instead of a plane"))){
           a= "Airplanes produce carbon dioxide emissions by burning fuel. Taking fewer flights is one of the best ways to dramatically reduce your carbon pollution. The average length of a direct flight from London to Manchester is one hour. If you take the train instead of the plane from London to Manchester (262 km by train; 240 km by plane) for instance, you can save about 48.95 kg of CO2. Every time you take the train instead of a roughly one-hour plane trip, log this action.\n" +
                   "\n" +
                   "Assumptions:\n" +
                   "\n" +
                   "According to DEFRA, for an average passenger, a domestic flight within the UK has 0.2443 kg of CO2 emission per kilometer, while it only emits 0.03694 kg of CO2 per kilometer if you take the national rail. If you take the train instead of the plane, you will save 48.95 kg of CO2 for a trip from London to Manchester.";
           b= R.drawable.ic_planes;
        }
        else if ((a.equals("Cut your food waste"))){
            a= "An estimated 931 million tonnes of food - 17% of all food available to consumers, or the equivalent of about 23 million fully loaded 40-tonne trucks - went into trash bins in 2019, while 690 million people around the world go hungry. Let's stop the waste. When you throw food away, you're also wasting the energy that was used in growing, producing, packaging and transporting it. Only buy what you need.\n" +
                    "\n" +
                    "Assumptions:\n" +
                    "\n" +
                    "According to the U.S. data below, the CO2 emissions associated with an average meal are 2.28 kg per person. About 17% (a bit more than a sixth) of all food available to consumers is wasted. Each time you waste an amount of food equal to about a sixth of a meal, you waste 0.39 kg of CO2 (17% of 2.28 kg).\n" +
                    "\n" +
                    "Meat: 3,3 metric tonnes emission per year, 0,003013699 metric tonnes emission per meal per person\n";
            b= R.drawable.ic_food;
        }
        else if ((a.equals("Try Zero-waste Fashion"))){
            a= "The fashion industry produces more than 8% of the greenhouse gases and 20% of global wastewater annually. And 85% of textiles end up in landfills or are incinerated, although most of these materials could be reused. Being stylish does not mean being wasteful. Buying fewer clothes, shopping second- hand, or upcycling, i.e. creating new clothes out of old ones, helps save water and reduce waste. Every time you chose to buy a used t-shirt, swap one with a friend, or see a new t-shirt that you love in a store but chose not to buy it - log your action!\n" +
                    "\n" +
                    "Assumptions\n" +
                    "\n" +
                    "One metric tonne of new clothing produces 22.31 metric tonnes CO2 equivalent, while reusing clothing is associated with 0.152 metric tonne CO2e (just considering sorting and transportation).";
            b = R.drawable.ic_cloth;
        }
        else if ((a.equals("Buy Local"))){
           a= "Our global food system is a maddening mess. Lots of fruit comes from far away, while our local farmers struggle to make enough money to keep producing. Not only is it important to support our local economies so that they are resilient when things like Covid-19 come along, but local food seriously reduces the climate impact and lowers the carbon emitted to get that food on your table.\n" +
                   "\n" +
                   "Assumptions\n" +
                   "\n" +
                   "According to the UN carbon footprint calculator, buying local produce and meats can reduce your carbon footprint by 21%. Assuming an omnivore diet (meat in some meals, which is associated with 2.5 metric tonnes CO2 e/year), you can save 1.44 kg of CO2 a day by buying local.";
           b=R.drawable.ic_virus;
        }
        else if ((a.equals("Speak up"))){
           a= "Getting others involved in climate action is one of the fastest ways to multiply your impact. Talk to your friends and family and encourage them to act now and track their habits through this app. Together we will make change at a bigger scale. And if we are to avoid the worst of climate change, we need our governments to do their part. You can help by letting leaders know you want them to create the projects, laws and incentives that will deliver bold and rapid changes we all need. Every time you speak up for climate action, log this habit.";
           b=R.drawable.ic_speak;
        }
        else if ((a.equals("Buy energy from renewable sources"))){
           a= "Ask your utility company if your home energy comes from oil, coal, or gas. If so, switch to an electricity supplier that provides energy from renewable sources, such as wind or solar. Or install solar panels on your own roof to generate energy for your home. It will make a big difference in your carbon footprint. Compared to getting electricity produced with coal, you will save about 2.64 kg of CO2 emissions every day.\n" +
                   "\n" +
                   "Assumptions\n" +
                   "\n" +
                   "On average, a medium household in the UK consumes 2,900 kWh of electricity per year (Ofgem), which is equivalent to 8 kWh of electricity per day. When coal is used as the energy source, about 2.64 kg of CO2 is produced every day. The most commonly used renewable energy sources are wind, hydropower, and solar (EIA), which emit zero- carbon in electricity generation.";
           b=R.drawable.ic_energy;
        }
        else if ((a.equals("Switch to an electric vehicle"))){
            a= "If you plan to buy a car, consider going electric. More and cheaper models are coming on the market. Even if they still run on electricity produced from fossil fuels, electric cars help reduce air pollution and cause significantly fewer greenhouse gas emissions than gas or diesel-powered vehicles. Compared to an average car using diesel or petrol, you can save about 0.48 kg of CO2 every time you drive 4 km (2.5 miles) in an electric car.\n" +
                    "\n" +
                    "Assumptions\n" +
                    "\n" +
                    "According to UK DEFRA, an average car using diesel or petrol produces about 0.17 kg of CO2 per km, while an average battery electric car only produces 0.05 kg of CO2 per km. If you switch to an electric car, you can save 0.48 kg of CO2 every time you drive 4 km (2.5 miles).";
            b= R.drawable.ic_ecar;
        }
//        fragment.setArguments(args);
        name=a;
        image=b;
        args.putString("a", a);
        args.putInt("b", b);
        fragment.setArguments(args);
        return fragment;
    }
}