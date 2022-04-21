package com.example.tinher2.special;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tinher2.R;
import com.example.tinher2.special.like.Like_Fragment;
import com.example.tinher2.special.toppicks.TopPicks_Fragment;
import com.example.tinher2.user.User_Fragment;

public class Special_Fragment extends Fragment {
    Button like,top;


    public static Special_Fragment newInstanceSpecial() {

        Bundle args = new Bundle();

        Special_Fragment fragment = new Special_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_fragment,container,false);

        top = view.findViewById(R.id.bt_toppick);
        like =view.findViewById(R.id.bt_like);
        like.setTextColor(Color.parseColor("#FF000000"));
        getFragment(Like_Fragment.newInstanceLike());

        view.findViewById(R.id.bt_like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setcolorback(top,like);
                like.setTextColor(Color.parseColor("#FF000000"));
                getFragment(Like_Fragment.newInstanceLike());
            }
        });

        view.findViewById(R.id.bt_toppick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setcolorback(top,like);
                top.setTextColor(Color.parseColor("#FF000000"));
                getFragment(TopPicks_Fragment.newInstanceTop());
            }
        });



        return view;
    }

    void setcolorback(Button top , Button like){
        top.setTextColor(Color.parseColor("#B6B5B5"));
        like.setTextColor(Color.parseColor("#B6B5B5"));
    }

    public void getFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(R.id.child_fragmentLayout, fragment).commit();
    }

}
