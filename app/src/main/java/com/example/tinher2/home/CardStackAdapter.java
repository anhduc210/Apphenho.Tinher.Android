package com.example.tinher2.home;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tinher2.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static java.security.AccessController.getContext;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    private List<ItemModel> items;

    public CardStackAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name, age, bio,distance;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.item_name);
            age = itemView.findViewById(R.id.item_age);
            bio = itemView.findViewById(R.id.item_city);
            distance = itemView.findViewById(R.id.item_distance);
            if (mClickListener != null)
                mClickListener.onItemClick(itemView.getRootView(),getAdapterPosition());
        }


        void setData(ItemModel data) {

                Picasso.get()
                        .load(data.getImage())
                        .fit()
                        .centerCrop()
                        .into(image);
            name.setText(data.getName());
            age.setText(data.getAge());
            bio.setText(data.getPreface());
            distance.setText(data.getDistance());
        }
    }


    private static OnItemClickListener mClickListener;
//...other overriden methods

    // allows clicks events to be caught
    void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setimage(ItemModel data, ImageView image){
        Picasso.get()
                        .load(new File(data.getImage()))
                        .fit()
                        .centerCrop()
                        .into(image);
    }


    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }
}

