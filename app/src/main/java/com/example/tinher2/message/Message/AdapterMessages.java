package com.example.tinher2.message.Message;

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
import com.example.tinher2.special.like.AdapterLike;
import com.example.tinher2.special.like.OnItemLikeClick;
import com.example.tinher2.users_manager.UserInfor;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterMessages extends RecyclerView.Adapter<AdapterMessages.ViewHolder> {
    List<UserInfor> list;
    OnItemLikeClick onItemClick;

    public AdapterMessages(List<UserInfor> list) {
        this.list = list;
    }

    public void setOnItemLikeClick(OnItemLikeClick onItemClick){
        this.onItemClick=onItemClick;
    }

    @NonNull
    @Override
    public AdapterMessages.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_message, parent, false);

        AdapterMessages.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final UserInfor hv=list.get(position);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .circleCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);


        Glide.with(holder.itemView.getContext()).load(hv.getImage1()).apply(options).into(holder.imageView);

//        Picasso.get()
//                .load(hv.getImage1())
//                .fit()
//                .centerCrop()
//                .into(holder.imageView);

        holder.tvname.setText(hv.getName());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvname ;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.im_ava);
            tvname=itemView.findViewById(R.id.tv_name);

        }
    }
}
