package com.example.tinher2.begin.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.tinher2.MainActivity;
import com.example.tinher2.R;
import com.example.tinher2.begin.Begin;
import com.example.tinher2.begin.login.Login;
import com.example.tinher2.databinding.ActivityRegisterBinding;
import com.example.tinher2.home.Home_Fragment;

public class Register extends AppCompatActivity {

    ActivityRegisterBinding binding;

    public static String id,phone,password;
    public static String name,age,sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_register);


        binding.cbFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        binding.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Begin.class);
                startActivity(intent);
            }
        });
        binding.btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = binding.etPass.getText().toString();
                password = binding.etPass.getText().toString();
                name = binding.etName.getText().toString();
                age = binding.etAge.getText().toString();
                if( binding.cbFemale.isChecked()){
                    sex = "nữ";
                }else {
                    sex= "nam";
                }

                if(phone.length() <2 ||age.length() <2||name.length() <2||password.length() <2){

                    Toast.makeText(getBaseContext(), "Điền đủ thông tin bạn ơi", Toast.LENGTH_SHORT).show();
                }else{
                    int idi = MainActivity.all_User.size()+1;
                    id ="0"+String.valueOf(idi);
                    Intent intent = new Intent(Register.this, register1.class);
                    startActivity(intent);
                }
            }
        });
    }

}