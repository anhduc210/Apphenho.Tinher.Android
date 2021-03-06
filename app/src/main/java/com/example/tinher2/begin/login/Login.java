package com.example.tinher2.begin.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Toast;

import com.example.tinher2.MainActivity;
import com.example.tinher2.R;
import com.example.tinher2.begin.Begin;
import com.example.tinher2.databinding.ActivityLoginBinding;
import com.example.tinher2.users_manager.Json_off;
import com.example.tinher2.users_manager.UserInfor;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;
    public static String id;
    public static int ID= 000 ;

    private String phone,password;
    int biendem = 2;

    String a = "001 003 ";
    String b = a+" "+a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);


        binding.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Begin.class);
                startActivity(intent);
            }
        });

        binding.ivEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(biendem%2 ==0){
                    binding.ivEye.setImageResource(R.drawable.visibility);
                    binding.edPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    binding.ivEye.setImageResource(R.drawable.invisible);
                    binding.edPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
                biendem +=1;
            }
        });

        binding.btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = binding.edPhone.getText().toString();
                password = binding.edPassword.getText().toString();
                int kt = login(phone,password, MainActivity.all_User);
                if(kt ==1){
                    binding.tvTb.setText("S??? ??i???n tho???i c???a b???n ch??a ????ng k?? t??i kho???n");
                }else if(kt ==2){
                    binding.tvTb.setText("M???t kh???u sai nh?? b???n y??u ");
                }else if(kt ==3){
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    int login(String phone, String password, List<UserInfor> list){

        int kq=0;
        int idi = 999;
        for(int i =0; i< list.size();i++){
            if(phone.equals(list.get(i).getPhone())){
                id = list.get(i).getId();
            }
        }
        if(id != null){
            idi = Integer.parseInt(id);
        }
        if(idi!= 999 ){
            if(password.equals(list.get(idi).getPassword())){
                ID = idi-1;
                // ????ng nh???p th??nh c??ng
                kq =3;
            }else {
                // m???t kh???u sai
                kq=2;
            }
        }else{
            // ch??a c?? t??i kho???n
            kq=1;
        }
        return kq;
    }


}