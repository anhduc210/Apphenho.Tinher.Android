package com.example.tinher2.begin;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.tinher2.MainActivity;
import com.example.tinher2.R;
import com.example.tinher2.begin.login.Login;
import com.example.tinher2.begin.register.Register;
import com.example.tinher2.database.SQLHelperUser;
import com.example.tinher2.database.SQLHelperX;
import com.example.tinher2.database.X;
import com.example.tinher2.databinding.ActivityBeginBinding;
import com.example.tinher2.user.User_Fragment;
import com.example.tinher2.users_manager.ApiUtils;
import com.example.tinher2.users_manager.Json_off;
import com.example.tinher2.users_manager.SOService;
import com.example.tinher2.users_manager.UserInfor;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Begin extends AppCompatActivity {
    ActivityBeginBinding binding ;


    List<UserInfor> userInfors= new ArrayList<>();
    List<X> x_list= new ArrayList<>();

    SQLHelperUser sqlHelper;
    SQLHelperX sqlHelperX;
    X x = new X("01","1");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_begin);


        sqlHelper = new SQLHelperUser(this);
        sqlHelperX = new SQLHelperX(this);

        sqlHelperX.insertUsers(x);
        x_list=sqlHelperX.getAllUsers();


       int a =Integer.parseInt(x_list.get(0).getVr());

        if(a==1){
            Get_data_off();
            X x2 = new X("01","2");
            sqlHelperX.updateUsers(x2);
            Toast.makeText(getBaseContext(), "lấy data off", Toast.LENGTH_SHORT).show();
        }

        MainActivity.all_User = sqlHelper.getAllUsers();

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Begin.this, Login.class);
                startActivity(intent);
            }
        });

        binding.btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Begin.this, Register.class);
                startActivity(intent);
            }
        });


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
                userInfors.add(user);
            }
            for(int i =0;i<userInfors.size();i++){

                sqlHelper.insertUsers(userInfors.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}