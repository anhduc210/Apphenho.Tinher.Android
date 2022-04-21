package com.example.tinher2.user;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tinher2.MainActivity;
import com.example.tinher2.R;
import com.example.tinher2.begin.Begin;
import com.example.tinher2.begin.login.Login;
import com.example.tinher2.database.SQLHelperUser;
import com.example.tinher2.users_manager.ApiUtils;
import com.example.tinher2.users_manager.Json_off;
import com.example.tinher2.users_manager.SOService;
import com.example.tinher2.users_manager.UserInfor;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class User_Fragment extends Fragment {

    ImageView image;
    TextView name;

    private SOService mService;
    List<UserInfor> a= new ArrayList<>();
    SQLHelperUser sqlHelper;

    public static User_Fragment newInstanceUser() {

        Bundle args = new Bundle();

        User_Fragment fragment = new User_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment,container,false);
        mService = ApiUtils.getSOService();
        sqlHelper = new SQLHelperUser(getContext());

        image = view.findViewById(R.id.im_avatar);
        name = view.findViewById(R.id.tv_name);

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .circleCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        name.setText(MainActivity.all_User.get(Login.ID).getName()+", "+MainActivity.all_User.get(Login.ID).getAge());


        Glide.with(this).load(MainActivity.all_User.get(Login.ID).getImage1()).apply(options).into(image);


        view.findViewById(R.id.bt_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlHelper.deleteAll();



                new MyAsyncTask().execute();


//                mService.getUsersInfor().enqueue(new Callback<List<UserInfor>>() {
//                    @Override
//                    public void onResponse(Call<List<UserInfor>> call, Response<List<UserInfor>> response) {
//                        a= response.body();
//                    }
//                    @Override
//                    public void onFailure(Call<List<UserInfor>> call, Throwable t) {
//                        Toast.makeText(getActivity().getBaseContext(), "khong lay dc dulieu", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                for(int i =0;i<a.size();i++){
//                    sqlHelper.insertUsers(a.get(i));
//                }
            }
        });

        view.findViewById(R.id.bt_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Edit_User.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.bt_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Begin.class);
                startActivity(intent);
            }
        });

        return view;
    }
    private class MyAsyncTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... params) {
            mService.getUsersInfor().enqueue(new Callback<List<UserInfor>>() {
                @Override
                public void onResponse(Call<List<UserInfor>> call, Response<List<UserInfor>> response) {
                    a= response.body();
                }
                @Override
                public void onFailure(Call<List<UserInfor>> call, Throwable t) {
                    Toast.makeText(getActivity().getBaseContext(), "khong lay dc dulieu", Toast.LENGTH_SHORT).show();
                    Get_data_off();
                    Toast.makeText(getActivity().getBaseContext(), "lay data off ", Toast.LENGTH_SHORT).show();

                }
            });
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            for(int i =0;i<a.size();i++){
                sqlHelper.insertUsers(a.get(i));
                Toast.makeText(getActivity().getBaseContext(), "reset thanh cong", Toast.LENGTH_SHORT).show();
            }
        }
    }
    void Get_data_off(){
        try {
            JSONArray jsonArray = new JSONArray(Json_off.json_ob);
            for (int i=0; i<jsonArray.length();i++){
                JSONObject jsonObject =  jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String phone = jsonObject.getString("phone");
                String password = jsonObject.getString("password");
                String name = jsonObject.getString("name");
                String age = jsonObject.getString("age");
                String sex = jsonObject.getString("sex");
                String preface = jsonObject.getString("preface");
                String tdx = jsonObject.getString("tdx");
                String tdy = jsonObject.getString("tdy");
                String user_search = jsonObject.getString("user_search");
                String id_loves = jsonObject.getString("id_love");
                String id_likes = jsonObject.getString("id_like");
                String id_unlikes = jsonObject.getString("id_unlike");
                String id_likebacks = jsonObject.getString("id_likeback");
                String image1 = jsonObject.getString("image1");
                String image2 = jsonObject.getString("image2");
                String image3 = jsonObject.getString("image3");
                String image4 = jsonObject.getString("image4");
                UserInfor user = new UserInfor(id,phone,password,name,age,sex,preface,tdx,tdy,user_search,id_loves,id_likes,id_unlikes,id_likebacks,image1,image2,image3,image4);
                a.add(user);
            }
            for(int i =0;i<a.size();i++){
                sqlHelper.insertUsers(a.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
