package com.deepshikhayadav.Foodie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.HashMap;

public class SingleViewActivity extends AppCompatActivity  {
    ArrayList<cart_model> mExampleList;
    ImageView imageView,shimage;
    TextView text,offer,description,payment,shtitle,shprice,shdec,shinc,shcost;
    Button add_cart,cancel,bottom_addcart;
    EditText editText;
    int pos;
    HashMap<Integer,ArrayList<cart_model>> hashMap;
LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleview);
        pos=1;
        final Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        final int img = bundle.getInt("image");
        final String price = bundle.getString("offer");
        final String name = bundle.getString("text");
        final String des=bundle.getString("desc");
        final int pay=bundle.getInt("pay");
        mExampleList=new ArrayList<cart_model>();


       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);


//this line shows back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        imageView=findViewById(R.id.imageView);
        text=findViewById(R.id.name);
        offer=findViewById(R.id.dash_price);
        description=findViewById(R.id.desc);
        add_cart=findViewById(R.id.cart);
        payment=findViewById(R.id.price);
        linearLayout=findViewById(R.id.but);
        cancel=findViewById(R.id.cancel);
        shdec=findViewById(R.id.decrement);
        shinc=findViewById(R.id.increment);
        shimage=findViewById(R.id.simage);
        shtitle=findViewById(R.id.stitle);
        shprice=findViewById(R.id.sprice);
        editText=findViewById(R.id.sedit);
        shcost=findViewById(R.id.cost);
        bottom_addcart=findViewById(R.id.addcart);

            description.setText(des);
            imageView.setImageResource(img);
            text.setText(name);
            offer.setText(price);
            payment.setText("Rs. "+pay);


View bottomsheet=findViewById(R.id.bottomSheet);

final BottomSheetBehavior bottomSheetBehavior=BottomSheetBehavior.from(bottomsheet);

bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
    @Override
    public void onStateChanged(@NonNull View bottomSheet, int newState) {

        

       if(newState==BottomSheetBehavior.STATE_DRAGGING){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }

            }

    @Override
    public void onSlide(@NonNull View bottomSheet, float slideOffset) {

    }
});
         bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        add_cart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

      bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

      shimage.setImageResource(img);
      shtitle.setText(name);
      shprice.setText("Rs. "+pay);
      shcost.setText("Rs. "+pay);

    }
});


cancel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }
});

shdec.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int a=Integer.parseInt(editText.getText().toString());
     if(a>1) {
         a -= 1;
         editText.setText("" + a);
         shcost.setText("Rs. "+a*pay);

     }
    }
});

shinc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int a=Integer.parseInt(editText.getText().toString());
        a+=1;
        editText.setText(String.valueOf(a));

        shcost.setText("Rs. "+a*pay);
    }
});



       // loadData();
    bottom_addcart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int a=Integer.parseInt(editText.getText().toString());
            String res= (String) shcost.getText();
            int r= Integer.parseInt(res.substring(4));

        Intent i=new Intent(getApplicationContext(),Cart.class);

            Bundle bundle = new Bundle();
           // bundle.putStringArrayList("array",mExampleList);
            bundle.putInt("ii", img);
            bundle.putString("nn", name);
            bundle.putInt("pp", r);
            bundle.putInt("qq",a);
            bundle.putInt("position",pos-1);
            i.putExtras(bundle);

           Toast.makeText(getApplicationContext(),"Added to cart successfully",Toast.LENGTH_SHORT).show();

            startActivity(i);
            finish();

        }
    });

    }

}
