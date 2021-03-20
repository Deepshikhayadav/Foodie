package com.deepshikhayadav.Foodie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<model> {
public ImageAdapter(@NonNull Context context, ArrayList<model> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
        }

@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
        // Layout Inflater inflates each item to be displayed in GridView.
        listitemView = LayoutInflater.from(getContext()).inflate(R.layout.dash_resource, parent, false);
        }
        model classmodel = getItem(position);
        TextView text = listitemView.findViewById(R.id.dashtext);
        ImageView img = listitemView.findViewById(R.id.dashimageView);
        TextView offer=listitemView.findViewById(R.id.dash_price);
       text.setText(classmodel.getText());
       img.setImageResource(classmodel.getImgid());
       offer.setText(classmodel.getOffer());
        return listitemView;
        }
        }