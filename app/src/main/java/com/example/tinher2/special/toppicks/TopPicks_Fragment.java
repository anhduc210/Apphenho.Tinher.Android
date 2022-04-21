package com.example.tinher2.special.toppicks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinher2.MainActivity;
import com.example.tinher2.R;
import com.example.tinher2.special.like.AdapterLike;
import com.example.tinher2.special.like.Like_Fragment;
import com.example.tinher2.users_manager.UserInfor;

import java.util.ArrayList;
import java.util.List;

public class TopPicks_Fragment extends Fragment {
    RecyclerView a;


    List<UserInfor> list=new ArrayList<>();
    AdapterLike adapterLike;

    public static TopPicks_Fragment newInstanceTop() {

        Bundle args = new Bundle();

        TopPicks_Fragment fragment = new TopPicks_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.toppicks_fragment,container,false);

        adapterLike=new AdapterLike(MainActivity.all_User);
        a = view.findViewById(R.id.rvTopItem);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(
                getContext(), 2, RecyclerView.VERTICAL, false);
        a.setLayoutManager(layoutManager);
        a.setAdapter(adapterLike);



        return view;
    }
}