package com.deepshikhayadav.Foodie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;

public class Dashboard extends AppCompatActivity  {


    String dText[]={"Double Burger","Burger","Noodles","French Aloo","Aloo Sabzi","Paneer Tikka","Butter Chicken","Frankie","Chaat","Pizza","Lunch","Pulao"};
    String dOffer[]={"32% off","3% off","6% off","12% off","21% off","5% off","32% off","12% off","12% off","8% off","13% off","17% off"};
    int dImages[]={R.drawable.f8,R.drawable.f9,R.drawable.f10,R.drawable.f11, R.drawable.f12, R.drawable.f13, R.drawable.f14, R.drawable.f15,R.drawable.f16, R.drawable.f17, R.drawable.f18, R.drawable.f19};
    String[] desc={"The McDonald's Double Cheeseburger features two 100% pure beef burger patties seasoned with just a pinch of salt and pepper. It's topped with tangy pickles, chopped onions, ketchup, mustard and two slices of melty American cheese. There are 450 calories in a McDonald's Double Cheeseburger.",
    "A hamburger is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled. ... A hamburger topped with cheese is called a cheeseburger.",
    "Noodles are a type of food made from unleavened dough which is rolled flat and cut, stretched or extruded, into long strips or strings. ... Noodles are usually cooked in boiling water, sometimes with cooking oil or salt added. ",
    "There are many dishes that are considered part of French national cuisine today. A meal often consists of three courses, hors d'œuvre or entrée , plat principal , fromage  or dessert, sometimes with a salad offered before the cheese or dessert.",
    "A baked potato, or jacket potato, is a potato that has been baked for eating. When well cooked, a baked potato has a fluffy interior and a crisp skin. It may be served with fillings and condiments such as butter, cheese, baked beans or even ground meat.",
    "paneer tikka masala literally translates to grilled chunks of Indian cheese in a spicy gravy. Paneer tikka masala is a vegetarian version of the world famous chicken tikka masala.",
    "It is a dish made by marinating a chicken overnight in a yoghurt and spice mixture. The chicken is then roasted or baked. A sauce is made from butter, tomatoes, almonds and various spices, usually including the famous tandoori masala spice mix, and sometimes cream.",
    "Introducing Frankies! India's flavorful street food, also known as the Mumbai Burrito, Bombay Burrito, or roti wrap – this vegan version is filled with curry mashed potatoes, roasted Indian cauliflower and chickpeas, fresh spinach, Cilantro Mint Chutney and Pickled onions, all wrapped up in a warm tortilla",
    "Chaat is an umbrella term for a wide range of roadside foods that usually feature some kind of fried dough with various ingredients that typically create a spicy, tangy, or salty flavour, though some chaat are sweet.",
    "Pizza, dish of Italian origin consisting of a flattened disk of bread dough topped with some combination of olive oil, oregano, tomato, olives, mozzarella or other cheese, and many other ingredients, baked quickly—usually, in a commercial setting, using a wood-fired oven heated to a very high temperature—and served hot ",
    "Lunch, an abbreviation for luncheon, is a meal eaten around midday. During the 20th century, the meaning gradually narrowed to a meal eaten midday. Lunch is commonly the second meal of the day, after breakfast.",
    "Pilaf, pilau, palaw, pulao or polao is a rice dish or, in some regions, a wheat dish, whose recipe usually involves cooking in stock or broth, adding spices, and other ingredients such as vegetables or meat, and employing some technique for achieving cooked grains that do not adhere."};
    int[] price={67,68,56,68,99,45,97,69,46,68,99,45};

Toolbar toolbar;
GridView gridView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        gridView = (GridView) findViewById(R.id.gridview);
         toolbar = (Toolbar) findViewById(R.id.tool);
        toolbar.setTitle("Foodie");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.inflateMenu(R.menu.menu);
        //setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.app_bar_search)
                {
                    // do something
                }
                else if(item.getItemId()== R.id.tool_cart)
                {
                    Intent i = new Intent(getApplicationContext(),Cart.class);
                    startActivity(i);
                    return true;

                }
                else{
                    SharedPreferences sharedPreferences
                            = getSharedPreferences(
                            "sharedPrefs", MODE_PRIVATE);
                    final SharedPreferences.Editor editor
                            = sharedPreferences.edit();
                    final boolean isDarkModeOn
                            = sharedPreferences
                            .getBoolean(
                                    "isDarkModeOn", true);

                    // When user reopens the app
                    // after applying dark/light mode
                    if (isDarkModeOn) {
                        AppCompatDelegate
                                .setDefaultNightMode(
                                        AppCompatDelegate
                                                .MODE_NIGHT_YES);

                    }
                   else {
                        AppCompatDelegate
                                .setDefaultNightMode(
                                        AppCompatDelegate
                                                .MODE_NIGHT_NO);

                    }

                    if (isDarkModeOn) {

                        // if dark mode is on it
                        // will turn it off
                        AppCompatDelegate
                                .setDefaultNightMode(
                                        AppCompatDelegate
                                                .MODE_NIGHT_NO);
                        // it will set isDarkModeOn
                        // boolean to false
                        editor.putBoolean(
                                "isDarkModeOn", false);
                        editor.apply();


                    }
                    else {

                        // if dark mode is off
                        // it will turn it on
                        AppCompatDelegate
                                .setDefaultNightMode(
                                        AppCompatDelegate
                                                .MODE_NIGHT_YES);
                        editor.putBoolean(
                                "isDarkModeOn", true);
                        editor.apply();
                    }


                }

                return false;

            }
        });



        ArrayList<model> ModelArrayList = new ArrayList<model>();
        ModelArrayList.add(new model("Double Burger", R.drawable.f8,"32% off"));
        ModelArrayList.add(new model("Burger", R.drawable.f9,"3% off"));
        ModelArrayList.add(new model("Noodles", R.drawable.f10,"6% off"));
        ModelArrayList.add(new model("French Aloo", R.drawable.f11,"12% off"));
        ModelArrayList.add(new model("Aloo sabzi", R.drawable.f12,"21% off"));
        ModelArrayList.add(new model("Paneer Tikka", R.drawable.f13,"5% off"));
        ModelArrayList.add(new model("Butter Chicken", R.drawable.f14,"32% off"));
        ModelArrayList.add(new model("Frankie", R.drawable.f15,"12% off"));
        ModelArrayList.add(new model("Chaat", R.drawable.f16,"12% off"));
        ModelArrayList.add(new model("Pizza", R.drawable.f17,"8% off"));
        ModelArrayList.add(new model("Lunch", R.drawable.f18,"13% off"));
        ModelArrayList.add(new model("Pulao", R.drawable.f19,"17% off"));
        ImageAdapter adapter = new ImageAdapter(this, ModelArrayList);
        gridView.setAdapter(adapter);


    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for(int i=0;i<dImages.length;i++){
                    if(position==i){
                        Intent intent = new Intent(getApplicationContext(), SingleViewActivity.class);
                        // this intent put our 0 index image to another activity
                        Bundle bundle = new Bundle();
                        bundle.putInt("image", dImages[i]);
                        bundle.putString("text", dText[i]);
                        bundle.putString("offer", dOffer[i]);
                        bundle.putString("desc",desc[i]);
                        bundle.putInt("pay",price[i]);
                        // also put your position
                        bundle.putString("position", ""+i);
                        intent.putExtras(bundle);
                        // now put title and description to another activity

                        startActivity(intent);
                    }
                }


            }

        });

    }

}