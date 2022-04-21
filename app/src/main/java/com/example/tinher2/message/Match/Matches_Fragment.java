package com.example.tinher2.message.Match;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinher2.MainActivity;
import com.example.tinher2.R;
import com.example.tinher2.begin.login.Login;
import com.example.tinher2.special.like.AdapterLike;
import com.example.tinher2.special.like.Like_Fragment;
import com.example.tinher2.users_manager.UserInfor;

import java.util.ArrayList;
import java.util.List;

public class Matches_Fragment extends Fragment {
    RecyclerView a;


    List<UserInfor> list = new ArrayList<>();
    AdapterLike adapterLike;

    public static Matches_Fragment newInstanceMatch() {

        Bundle args = new Bundle();

        Matches_Fragment fragment = new Matches_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.matches_fragment, container, false);
        String idi = String.valueOf(Login.ID+1);
        String id = "0"+idi;
        for(int i=0;i<MainActivity.all_User.size();i++){
            if(MainActivity.all_User.get(Login.ID).getIdLove().contains(MainActivity.all_User.get(i).getId())){
                list.add(MainActivity.all_User.get(i));
            }
        }

        adapterLike = new AdapterLike(list);
        a = view.findViewById(R.id.rvMatchesItem);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(
                getContext(), 2, RecyclerView.VERTICAL, false);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        a.setLayoutManager(layoutManager);
        a.setAdapter(adapterLike);


        return view;
    }
}