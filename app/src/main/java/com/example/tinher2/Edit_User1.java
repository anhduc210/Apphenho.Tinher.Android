package com.example.tinher2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tinher2.begin.login.Login;
import com.example.tinher2.begin.register.Register;
import com.example.tinher2.begin.register.register1;
import com.example.tinher2.database.SQLHelperUser;
import com.example.tinher2.databinding.ActivityEditUser1Binding;
import com.example.tinher2.databinding.ActivityEditUserBinding;
import com.example.tinher2.user.Edit_User;
import com.example.tinher2.users_manager.UserInfor;

public class Edit_User1 extends AppCompatActivity {

    public static String preface;
    public static String image1,image2,image3,image4;
    SQLHelperUser sqlHelper;

    ActivityEditUser1Binding binding;

    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_edit__user1);
        sqlHelper = new SQLHelperUser(this);


        binding.imageAva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });





        binding.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit_User1.this, Edit_User.class);
                startActivity(intent);
            }
        });
        binding.btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preface = binding.etPreface.getText().toString();
                image1 = binding.etImage1.getText().toString();
                image2 = binding.etImage2.getText().toString();
                image3 = binding.etImage3.getText().toString();
                image4 = binding.etImage4.getText().toString();

                if(preface.length() <2 ||image3.length() <2||image2.length() <2||image1.length() <2||image4.length() <2){

                    Toast.makeText(getBaseContext(), "Điền đủ thông tin bạn ơi", Toast.LENGTH_SHORT).show();
                }else{
                    int id = Login.ID+1;
                    UserInfor userInfor = new UserInfor("0"+id,Edit_User.phone,Edit_User.password,Edit_User.name,Edit_User.age,Edit_User.sex,
                            preface,"0","0",Edit_User.reseach,"000","000","000","000",image1,image2,image3,image4);
                    sqlHelper.updateUsers(userInfor);

                    Toast.makeText(getBaseContext(), "thay đổi thông tin thành công ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Edit_User1.this, MainActivity.class);
                    startActivity(intent);
                }


            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.image_ava);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}

