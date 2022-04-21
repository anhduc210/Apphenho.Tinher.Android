package com.example.tinher2.special.like;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tinher2.MainActivity;
import com.example.tinher2.R;
import com.example.tinher2.begin.login.Login;
import com.example.tinher2.users_manager.UserInfor;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterLike extends RecyclerView.Adapter<AdapterLike.ViewHolder> {
    List<UserInfor> list;
    OnItemLikeClick onItemClick;

    public AdapterLike(List<UserInfor> list) {
        this.list = list;
    }

    public void setOnItemLikeClick(OnItemLikeClick onItemClick){
        this.onItemClick=onItemClick;
    }

    @NonNull
    @Override
    public AdapterLike.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_special, parent, false);

        AdapterLike.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLike.ViewHolder holder, int position) {
        final UserInfor hv=list.get(position);

        Picasso.get()
                .load(hv.getImage1())
                .fit()
                .centerCrop()
                .into(holder.imageView);
        holder.tvname.setText(hv.getName());
        holder.tvage.setText(hv.getAge());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvage;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_image);
            tvname=itemView.findViewById(R.id.item_name);
            tvage=itemView.findViewById(R.id.item_age);
        }
    }
}
