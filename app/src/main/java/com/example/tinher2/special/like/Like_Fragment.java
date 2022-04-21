package com.example.tinher2.special.like;

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
import com.example.tinher2.begin.login.Login;
import com.example.tinher2.database.SQLHelperUser;
import com.example.tinher2.special.Special_Fragment;
import com.example.tinher2.users_manager.UserInfor;

import java.util.ArrayList;
import java.util.List;

public class Like_Fragment extends Fragment {
    RecyclerView a;



    List<UserInfor> list=new ArrayList<>();
    AdapterLike adapterLike;
    SQLHelperUser sqlHelper;

    public static Like_Fragment newInstanceLike() {

        Bundle args = new Bundle();

        Like_Fragment fragment = new Like_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.like_fragment,container,false);
        String idi = String.valueOf(Login.ID+1);
        String id = "0"+idi;
        sqlHelper = new SQLHelperUser(getActivity());

        for(int i=0;i<MainActivity.all_User.size();i++){
            if(MainActivity.all_User.get(Login.ID).getIdLike().contains(MainActivity.all_User.get(i).getId())){
                list.add(MainActivity.all_User.get(i));
            }
        }
        MainActivity.all_User.clear();
        MainActivity.all_User = sqlHelper.getAllUsers();


        adapterLike=new AdapterLike(list);
        a = view.findViewById(R.id.rvLikeItem);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(
                getContext(), 2, RecyclerView.VERTICAL, false);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        a.setLayoutManager(layoutManager);
        a.setAdapter(adapterLike);



        return view;
    }
}
