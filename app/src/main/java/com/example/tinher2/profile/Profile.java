package com.example.tinher2.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tinher2.MainActivity;
import com.example.tinher2.R;
import com.example.tinher2.begin.Begin;
import com.example.tinher2.begin.login.Login;
import com.example.tinher2.database.SQLHelperUser;
import com.example.tinher2.databinding.ActivityProfileBinding;
import com.example.tinher2.home.ItemModel;
import com.example.tinher2.users_manager.UserInfor;
import com.squareup.picasso.Picasso;

public class Profile extends AppCompatActivity {
    ActivityProfileBinding binding;
    SQLHelperUser sqlHelper;


    private int stt = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        Intent intent = getIntent();
        int ida= intent.getIntExtra("Key_1", 1);
        int id= ida-1;
        sqlHelper = new SQLHelperUser(this);

        Picasso.get()
                .load(MainActivity.all_User.get(id).getImage1())
                .fit()
                .centerCrop()
                .into(binding.imHt);

        binding.itemName.setText(MainActivity.all_User.get(id).getName());
        binding.itemAge.setText(MainActivity.all_User.get(id).getAge());
        binding.itemPreface.setText(MainActivity.all_User.get(id).getPreface());
        binding.itemDistance.setText("2km");

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, MainActivity.class);
                startActivity(intent);
            }
        });


        binding.nopeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.all_User.get(Login.ID).setIdUnlike( MainActivity.all_User.get(Login.ID).getIdUnlike()+";0"+id);
            }
        });
        binding.timProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.all_User.get(Login.ID).setIdLike( MainActivity.all_User.get(Login.ID).getIdLike()+";0"+id);
                MainActivity.all_User.get(id).setIdLikeback( MainActivity.all_User.get(id).getIdLikeback()+";0"+Login.ID);

            }
        });
        binding.likeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.all_User.get(Login.ID).setIdLike( MainActivity.all_User.get(Login.ID).getIdLike()+";*0"+id);
            }
        });


        binding.nextImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a, b;

                if (stt < 4) {
                    stt++;
                }
                setimage(stt, MainActivity.all_User.get(id));

                Toast.makeText(getBaseContext(), "Next image", Toast.LENGTH_SHORT).show();
            }
        });
        binding.backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a, b;

                if (stt > 0) {
                    stt--;
                }
                setimage(stt, MainActivity.all_User.get(id));

                Toast.makeText(getBaseContext(), "Back image", Toast.LENGTH_SHORT).show();
            }
        });
        MainActivity.capnhat(sqlHelper);

    }


    private void setimage(int stt, UserInfor model) {

        switch (stt) {

            case 1:
                Picasso.get()
                        .load(model.getImage1())
                        .fit()
                        .centerCrop()
                        .into(binding.imHt);
                break;
            case 2:
                Picasso.get()
                        .load(model.getImage2())
                        .fit()
                        .centerCrop()
                        .into(binding.imHt);
                break;
            case 3:
                Picasso.get()
                        .load(model.getImage3())
                        .fit()
                        .centerCrop()
                        .into(binding.imHt);
                break;
            case 4:
                Picasso.get()
                        .load(model.getImage4())
                        .fit()
                        .centerCrop()
                        .into(binding.imHt);
                break;
            default:

                break;
        }

    }
}
