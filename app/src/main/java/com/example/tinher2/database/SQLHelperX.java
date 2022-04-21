package com.example.tinher2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tinher2.users_manager.UserInfor;

import java.util.ArrayList;
import java.util.List;

public class SQLHelperX extends SQLiteOpenHelper {
    static final  String DB_NAME ="X.db";
    static final  String DB_TABLE_X ="X";
    public static  int DB_VERSION = 1;

    private String USER_ID ="id";
    private String USER_VR ="vr";


    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    Cursor cursor;

    public SQLHelperX( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateTable= "CREATE TABLE X("+
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,"+
                "vr TEXT )";

        db.execSQL(queryCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS "+ DB_NAME);
            onCreate(db);
        }

    }

    public  void insertUsers(X contact){
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
//        contentValues.put(USER_ID,contact.getId());
        contentValues.put(USER_VR,contact.getVr());


        sqLiteDatabase.insert(DB_TABLE_X, null,contentValues);

    }

    public  void updateUsers(X contact){
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
//        contentValues.put(USER_ID,contact.getId());
        contentValues.put(USER_VR,contact.getVr());

        sqLiteDatabase.update(DB_TABLE_X,contentValues,"id=?",
                new String[]{String.valueOf(contact.getId())});

    }


    public List<X> getAllUsers(){
        List<X> contactList = new ArrayList<>() ;
        sqLiteDatabase = getReadableDatabase();

        X contact ;
        cursor = sqLiteDatabase.query(false,DB_TABLE_X,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext() ){
            int id = cursor.getInt(cursor.getColumnIndex(USER_ID));
            String vr = cursor.getString(cursor.getColumnIndex(USER_VR));

            contact = new X(id+"",vr);
            contactList.add(contact);
        }
        return contactList;
    }

    private  void closeDB(){
        if(contentValues != null)contentValues.clear();
        if(cursor!=null) cursor.close();
        if(sqLiteDatabase!=null) sqLiteDatabase.close();
    }
}
