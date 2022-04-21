package com.example.tinher2.capquyen;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.tinher2.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class permission {

    MainActivity activity;

//    private   void checkAndRequestPermissions() {
//        String[] permissions = new String[]{
//                Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                Manifest.permission.READ_EXTERNAL_STORAGE
//        };
//        List<String> listPermissionsNeeded = new ArrayList<>();
//        for (String permission : permissions) {
//            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
//                listPermissionsNeeded.add(permission);
//            }
//        }
//        if (!listPermissionsNeeded.isEmpty()) {
//            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
//        }
//    }


}
