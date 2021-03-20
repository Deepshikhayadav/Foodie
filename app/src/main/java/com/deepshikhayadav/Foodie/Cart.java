package com.deepshikhayadav.Foodie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {
    
    private ArrayList<cart_model> mExampleList=new ArrayList<>();
    

    ImageView del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        Toolbar toolbar = (Toolbar) findViewById(R.id.cart_tool);
        toolbar.setTitle("Cart");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        del=findViewById(R.id.del);
        final Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        if(bundle!=null){

            final int img = bundle.getInt("ii");
            final String name = bundle.getString("nn");
            final int pay = bundle.getInt("pp");
            final int quantity=bundle.getInt("qq");
            final int pos=bundle.getInt("position");

  //      HashMap<Integer,ArrayList<cart_model>> hashMap=(HashMap<Integer, ArrayList<cart_model>>) intent.getSerializableExtra("hashmap");
               /* Cart_adapter adapter = new Cart_adapter(mExampleList);
                adapter.notifyItemInserted(pos);*/

                initData(pos,img,name,pay,quantity);
                recyclerView.setAdapter(new Cart_adapter(mExampleList));

        }
    }

    private List<cart_model> initData(int pos, int img, String name, int pay, int quantity) {

        mExampleList.add(pos, new cart_model(img, name, pay, quantity));
        return mExampleList;
    }


}