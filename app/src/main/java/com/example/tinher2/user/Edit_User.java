package com.example.tinher2.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.tinher2.Edit_User1;
import com.example.tinher2.MainActivity;
import com.example.tinher2.R;
import com.example.tinher2.begin.Begin;
import com.example.tinher2.begin.register.Register;
import com.example.tinher2.begin.register.register1;
import com.example.tinher2.databinding.ActivityEditUserBinding;
import com.example.tinher2.databinding.ActivityRegisterBinding;

public class Edit_User extends AppCompatActivity {
    ActivityEditUserBinding binding;

    public static String id,phone,password;
    public static String name,age,sex,reseach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_edit__user);
        binding.cbFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        binding.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit_User.this, MainActivity.class);
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
                if( binding.cbFemales.isChecked()){
                    reseach = "nữ";
                }else {
                    reseach= "nam";
                }

                if(phone.length() <2 ||age.length() <2||name.length() <2||password.length() <2){

                    Toast.makeText(getBaseContext(), "Điền đủ thông tin bạn ơi", Toast.LENGTH_SHORT).show();
                }else{

                    Intent intent = new Intent(Edit_User.this, Edit_User1.class);
                    startActivity(intent);
                }
            }
        });
    }

}