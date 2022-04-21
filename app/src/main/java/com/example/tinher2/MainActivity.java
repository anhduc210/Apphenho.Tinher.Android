package com.example.tinher2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tinher2.begin.login.Login;
import com.example.tinher2.capquyen.permission;
import com.example.tinher2.database.SQLHelperUser;
import com.example.tinher2.databinding.ActivityMainBinding;
import com.example.tinher2.home.Home_Fragment;
import com.example.tinher2.home.ItemModel;
import com.example.tinher2.message.Message_Fragment;
import com.example.tinher2.special.Special_Fragment;
import com.example.tinher2.user.User_Fragment;
import com.example.tinher2.users_manager.UserInfor;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SQLHelperUser sqlHelper;
    public static List<UserInfor> all_User = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        sqlHelper = new SQLHelperUser(this);

        checkAndRequestPermissions();
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }else{
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
        all_User = sqlHelper.getAllUsers();



//        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        double longitude = location.getLongitude();
//        double latitude = location.getLatitude();
//
//        all_User.get(Login.ID).setTdx(longitude+"");
//        all_User.get(Login.ID).setTdx(latitude+"");
//        sqlHelper.updateUsers(all_User.get(Login.ID));




    getFragment(Home_Fragment.newInstance_Home());


        binding.logoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setbackcolor(v);
                binding.logoMenu.setColorFilter(R.color.tab_menu, android.graphics.PorterDuff.Mode.MULTIPLY);
                getFragment(Home_Fragment.newInstance_Home());
            }
        });
        binding.specialMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setbackcolor(v);
                binding.specialMenu.setColorFilter(R.color.tab_menu, android.graphics.PorterDuff.Mode.MULTIPLY);
                getFragment(Special_Fragment.newInstanceSpecial());
            }
        });

        binding.messageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setbackcolor(v);
                binding.messageMenu.setColorFilter(R.color.tab_menu, android.graphics.PorterDuff.Mode.MULTIPLY);
                getFragment(Message_Fragment.newInstanceMessage());
            }
        });

        binding.userMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setbackcolor(v);
                binding.userMenu.setColorFilter(R.color.tab_menu, android.graphics.PorterDuff.Mode.MULTIPLY);
                getFragment(User_Fragment.newInstanceUser());
            }
        });


    }

    public void setbackcolor(View v) {
        binding.logoMenu.setColorFilter(v.getContext().getResources().getColor(R.color.original_menu));
        binding.specialMenu.setColorFilter(v.getContext().getResources().getColor(R.color.original_menu));
        binding.messageMenu.setColorFilter(v.getContext().getResources().getColor(R.color.original_menu));
        binding.userMenu.setColorFilter(v.getContext().getResources().getColor(R.color.original_menu));
    }

    public void getFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentLayout, fragment).commit();
    }

    public static void capnhat(SQLHelperUser sqlHelper){

        for(int i =0;i<all_User.size();i++){
            sqlHelper.updateUsers(all_User.get(i));
        }
    }


    private void checkAndRequestPermissions() {
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults){
        switch (requestCode){
            case 1: {
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }







}