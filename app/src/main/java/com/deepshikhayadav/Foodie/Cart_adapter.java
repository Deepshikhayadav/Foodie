package com.deepshikhayadav.Foodie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Cart_adapter extends RecyclerView.Adapter<Cart_adapter.CartViewHolder> {
    private ArrayList<cart_model> mExampleList;

    public Cart_adapter(ArrayList<cart_model> mExampleList) {
        this.mExampleList = mExampleList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listitem=layoutInflater.inflate((R.layout.cart_resource),parent,false);
        CartViewHolder cartViewHolder=new CartViewHolder(listitem);

        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {



        cart_model currentItem = mExampleList.get(position);

        holder.imageView.setImageResource(currentItem.getCart_img());
        holder.title.setText(currentItem.getCart_title());
        holder.price.setText(String.valueOf(currentItem.getCart_price()));
        holder.quantity.setText(String.valueOf(currentItem.getCart_quantity()));

    }


        @Override
        public int getItemCount () throws NullPointerException{

        return mExampleList.size();
    }


    public class CartViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title, price, quantity;
        public RelativeLayout relativeLayout;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView=(ImageView)itemView.findViewById(R.id.cart_img);
            this.title=(TextView) itemView.findViewById(R.id.cart_title);
            this.price=(TextView) itemView.findViewById(R.id.cart_price_no);
            this.quantity=(TextView) itemView.findViewById(R.id.cart_quantity_no);
            relativeLayout=itemView.findViewById(R.id.relative);


        }
    }


}
