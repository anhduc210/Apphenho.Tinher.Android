package com.example.tinher2.message;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tinher2.R;
import com.example.tinher2.message.Match.Matches_Fragment;
import com.example.tinher2.message.Message.Messages_Fragment;
import com.example.tinher2.special.Special_Fragment;
import com.example.tinher2.special.like.Like_Fragment;

public class Message_Fragment extends Fragment {
    Button messages,matches;



    public static Message_Fragment newInstanceMessage() {

        Bundle args = new Bundle();

        Message_Fragment fragment = new Message_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_fragment,container,false);
        matches = view.findViewById(R.id.bt_match);
        messages =view.findViewById(R.id.bt_message);
        messages.setTextColor(Color.parseColor("#FF000000"));
       getFragment(Messages_Fragment.newInstanceMessages());

        view.findViewById(R.id.bt_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setcolorback(matches,messages);
                messages.setTextColor(Color.parseColor("#FF000000"));
                getFragment(Messages_Fragment.newInstanceMessages());

            }
        });
        view.findViewById(R.id.bt_match).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setcolorback(matches,messages);
                matches.setTextColor(Color.parseColor("#FF000000"));
                getFragment(Matches_Fragment.newInstanceMatch());
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