package com.example.tinher2.home;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import com.example.tinher2.MainActivity;
import com.example.tinher2.R;

import com.example.tinher2.begin.login.Login;
import com.example.tinher2.begin.register.register1;
import com.example.tinher2.database.SQLHelperUser;
import com.example.tinher2.profile.Profile;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {

    private static final String TAG = "Home";
    private CardStackLayoutManager manager;
    private CardStackAdapter adapter;
    private int stt =1;
    SQLHelperUser sqlHelper;

    private String t1,t2,t3,t4;
    String id;

    public  static  Home_Fragment newInstance_Home(){
        Bundle args = new Bundle();

        Home_Fragment fragment = new Home_Fragment();
        fragment.setArguments(args);

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        sqlHelper = new SQLHelperUser(getActivity());


        t1 = "https://i.imgur.com/FNOWdnj.jpg";
        t2 ="https://1.bp.blogspot.com/-NAPxUTyE4ck/X-BYOWpnevI/AAAAAAAAAAk/CycNeeZzZxguMKgDwNgPs8yRKkYy88bdwCLcBGAsYHQ/s320/118700516_1431729907023289_8342398042851561562_n.jpg";
        t3 ="https://1.bp.blogspot.com/-aAtO91156L4/X-BYOb-xGvI/AAAAAAAAAAg/WIeGg70eeEcNLOeA642IJreBMr0CEXMkACLcBGAsYHQ/s320/119462118_1439440289585584_2957313339657499337_n.jpg";
        t4 ="https://1.bp.blogspot.com/-jnd-F9zt1eg/X-BYO831rOI/AAAAAAAAAAo/q3t4dvpMUyUmwlLMRVpsghe5O43nOiz-gCLcBGAsYHQ/s320/126503588_1498668543662758_1042015763998594401_o.jpg";




        final CardStackView cardStackView = view.findViewById(R.id.card_stack_view);
        manager = new CardStackLayoutManager(getActivity(), new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
                Log.d(TAG, "onCardDragging: d=" + direction.name() + " ratio=" + ratio);
            }

            @Override
            public void onCardSwiped(Direction direction) {
                Log.d(TAG, "onCardSwiped: p=" + manager.getTopPosition() + " d=" + direction);
                id = adapter.getItems().get(manager.getTopPosition()).getId();
                int idi = Integer.parseInt(id);
                if (direction == Direction.Right){
                    MainActivity.all_User.get(Login.ID).setIdLike( MainActivity.all_User.get(Login.ID).getIdLike()+";"+id);
                    MainActivity.all_User.get(idi).setIdLikeback( MainActivity.all_User.get(idi).getIdLikeback()+";"+Login.ID);
                    Toast.makeText(getActivity().getBaseContext(), "Direction Right", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Top){
                    MainActivity.all_User.get(Login.ID).setIdLike( MainActivity.all_User.get(Login.ID).getIdLike()+";*"+id);
                    Toast.makeText(getActivity().getBaseContext(), "Direction Top", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Left){
                    MainActivity.all_User.get(Login.ID).setIdUnlike( MainActivity.all_User.get(Login.ID).getIdUnlike()+";"+id);
                    Toast.makeText(getActivity().getBaseContext(), "Direction Left", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Bottom){
                    Toast.makeText(getActivity().getBaseContext(), "Direction Bottom", Toast.LENGTH_SHORT).show();
                }
                MainActivity.capnhat(sqlHelper);
                // Paginating
                if (manager.getTopPosition() == adapter.getItemCount() - 4){
                    paginate();
                }

            }


            @Override
            public void onCardRewound() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardCanceled() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardAppeared(View view, int position) {
                TextView tv = view.findViewById(R.id.item_name);
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                TextView tv = view.findViewById(R.id.item_name);
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());
            }
        });
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.FREEDOM);
        manager.setCanScrollHorizontal(true);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        manager.setOverlayInterpolator(new LinearInterpolator());
        adapter = new CardStackAdapter(addList());
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());


//        adapter.setOnItemClickListener(new CardStackAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//                Toast.makeText(getActivity().getBaseContext(), "clicked", Toast.LENGTH_SHORT).show();
//            }
//        });




        view.findViewById(R.id.tim_Home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = adapter.getItems().get(manager.getTopPosition()).getId();
                int idi = Integer.parseInt(id);
                MainActivity.all_User.get(Login.ID).setIdLike( MainActivity.all_User.get(Login.ID).getIdLike()+";"+id);
                MainActivity.all_User.get(idi).setIdLikeback( MainActivity.all_User.get(idi).getIdLikeback()+";"+Login.ID);
                manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Right)
                        .setDuration(Duration.Normal.duration)
                        .build();
                manager.setSwipeAnimationSetting(setting);
                cardStackView.swipe();
                MainActivity.capnhat(sqlHelper);
            }
        });
        view.findViewById(R.id.nope_Home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = adapter.getItems().get(manager.getTopPosition()).getId();
                MainActivity.all_User.get(Login.ID).setIdUnlike( MainActivity.all_User.get(Login.ID).getIdUnlike()+";"+id);
                MainActivity.capnhat(sqlHelper);
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Left)
                        .setDuration(Duration.Normal.duration)
                        .build();
                manager.setSwipeAnimationSetting(setting);
                cardStackView.swipe();
            }
        });
        view.findViewById(R.id.back_Home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardStackView.rewind();
            }
        });
        view.findViewById(R.id.like_Home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = adapter.getItems().get(manager.getTopPosition()).getId();
                MainActivity.all_User.get(Login.ID).setIdLike( MainActivity.all_User.get(Login.ID).getIdLike()+";*"+id);
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Top)
                        .setDuration(Duration.Normal.duration)
                        .build();
                manager.setSwipeAnimationSetting(setting);
                cardStackView.swipe();
                MainActivity.capnhat(sqlHelper);
            }
        });


        view.findViewById(R.id.save_Home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Bottom)
                        .setDuration(Duration.Normal.duration)
                        .build();
                manager.setSwipeAnimationSetting(setting);
                cardStackView.swipe();
            }
        });


        view.findViewById(R.id.next_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a,b;
                a = adapter.getItems().get(manager.getTopPosition()).getImage();
                b = adapter.getItems().get(manager.getTopPosition()).getImage1();
                if(a==b){
                    stt =1;
                }
                if(stt <4 ){
                    stt ++;
                }
                setimage(stt,adapter.getItems().get(manager.getTopPosition()));
                cardStackView.setAdapter(adapter);
                Toast.makeText(getActivity().getBaseContext(), "Next image", Toast.LENGTH_SHORT).show();
            }
        });


        view.findViewById(R.id.show_infor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a= adapter.getItems().get(manager.getTopPosition()).getId();
                int idi = Integer.parseInt(a);

                Intent intent = new Intent(getActivity(), Profile.class);
                intent.putExtra("Key_1", idi);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.back_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a,b;
                a = adapter.getItems().get(manager.getTopPosition()).getImage();
                b = adapter.getItems().get(manager.getTopPosition()).getImage1();
                if(a==b){
                    stt =1;
                }
                if(stt >0 ){
                    stt --;
                }
                setimage(stt,adapter.getItems().get(manager.getTopPosition()));

                cardStackView.setAdapter(adapter);
                Toast.makeText(getActivity().getBaseContext(), "Back image", Toast.LENGTH_SHORT).show();
            }
        });

        MainActivity.capnhat(sqlHelper);


        return view;
    }


    private void setimage(int stt, ItemModel model ){

        switch(stt){

            case 1 :
                model.setImage(model.getImage1());
                break;
            case 2:
                model.setImage(model.getImage2());
                break;
            case 3:
                model.setImage(model.getImage3());
                break;
            case 4:
                model.setImage(model.getImage4());
                break;
            default:

                break;
        }

    }


    private void paginate() {
        List<ItemModel> old = adapter.getItems();
        List<ItemModel> baru = new ArrayList<>(addList());
        CardStackCallback callback = new CardStackCallback(old, baru);
        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
        adapter.setItems(baru);
        hasil.dispatchUpdatesTo(adapter);
    }



    private List<ItemModel> addList() {

        List<ItemModel> items = new ArrayList<>();

        for(int i =0; i< MainActivity.all_User.size();i++){
            boolean a= true,b=true,c=true,d = true;
            String id = String.valueOf(Login.ID);
            if(MainActivity.all_User.get(Login.ID).getIdUnlike().contains( MainActivity.all_User.get(i).getId())){
                a = false;
            }

            if(MainActivity.all_User.get(Login.ID).getIdLike().contains( MainActivity.all_User.get(i).getId())){
                b = false;
            }
            if(MainActivity.all_User.get(Login.ID).getIdLove().contains( MainActivity.all_User.get(i).getId())){
                c = false;
            }
            if( MainActivity.all_User.get(i).getId().contains(id)){
                d= false;
            }
            if(MainActivity.all_User.get(Login.ID).getUserSearch().equals(MainActivity.all_User.get(i).getSex())){
                if(a && b && c && d){
                    items.add(new ItemModel(MainActivity.all_User.get(i).getId(),MainActivity.all_User.get(i).getImage1(),MainActivity.all_User.get(i).getImage1(),MainActivity.all_User.get(i).getImage2(),MainActivity.all_User.get(i).getImage3(),MainActivity.all_User.get(i).getImage4(),
                            MainActivity.all_User.get(i).getName(),MainActivity.all_User.get(i).getAge(), MainActivity.all_User.get(i).getPreface(),"1km"));

                }
            }

        }



        return items;
    }
}
