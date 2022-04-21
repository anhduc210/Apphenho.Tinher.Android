package com.example.tinher2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tinher2.users_manager.UserInfor;

import java.util.ArrayList;
import java.util.List;

public class SQLHelperUser extends SQLiteOpenHelper {
    static final  String DB_NAME ="Users.db";
    static final  String DB_TABLE_Users ="Users";
   public static  int DB_VERSION = 1;

    private String USER_ID ="id";
    private String USER_PHONE ="phone";
    private String USER_PASS ="password";
    private String USER_NAME ="name";
    private String USER_AGE ="age";
    private String USER_SEX ="sex";
    private String USER_PREFACE ="preface";
    private String USER_TDX ="tdx";
    private String USER_TDY ="tdy";
    private String USER_SEARCH ="user_search";
    private String USER_IDLOVE ="id_love";
    private String USER_IDLIKE ="id_like";
    private String USER_IDUNLIKE ="id_unlike";
    private String USER_IDLIKEBACK="id_likeback";
    private String USER_IMAGE1 ="image1";
    private String USER_IMAGE2 ="image2";
    private String USER_IMAGE3 ="image3";
    private String USER_IMAGE4="image4";

    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;
    Cursor cursor;

    public SQLHelperUser( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateTable= "CREATE TABLE Users("+
                "id TEXT ,"+
                "phone TEXT,"+
                "password TEXT,"+
                "name TEXT,"+
                "age TEXT,"+
                "sex TEXT,"+
                "preface TEXT,"+
                "tdx TEXT,"+
                "tdy TEXT,"+
                "user_search TEXT,"+
                "id_love TEXT,"+
                "id_like TEXT,"+
                "id_unlike TEXT,"+
                "id_likeback TEXT,"+
                "image1 TEXT,"+
                "image2 TEXT,"+
                "image3 TEXT,"+
                "image4 TEXT)";
        db.execSQL(queryCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS "+ DB_NAME);
            onCreate(db);
        }

    }

    public  void insertUsers(UserInfor contact){
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(USER_ID,contact.getId());
        contentValues.put(USER_PHONE,contact.getPhone());
        contentValues.put(USER_PASS,contact.getPassword());
        contentValues.put(USER_NAME,contact.getName());
        contentValues.put(USER_AGE,contact.getAge());
        contentValues.put(USER_SEX,contact.getSex());
        contentValues.put(USER_PREFACE,contact.getPreface());
        contentValues.put(USER_TDX,contact.getTdx());
        contentValues.put(USER_TDY,contact.getTdy());
        contentValues.put(USER_SEARCH,contact.getUserSearch());
        contentValues.put(USER_IDLOVE,contact.getIdLove());
        contentValues.put(USER_IDLIKE,contact.getIdLike());
        contentValues.put(USER_IDUNLIKE,contact.getIdUnlike());
        contentValues.put(USER_IDLIKEBACK,contact.getIdLikeback());
        contentValues.put(USER_IMAGE1,contact.getImage1());
        contentValues.put(USER_IMAGE2,contact.getImage2());
        contentValues.put(USER_IMAGE3,contact.getImage3());
        contentValues.put(USER_IMAGE4,contact.getImage4());

        sqLiteDatabase.insert(DB_TABLE_Users, null,contentValues);

    }

    public  void updateUsers(UserInfor contact){
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
       contentValues.put(USER_ID,contact.getId());
        contentValues.put(USER_PHONE,contact.getPhone());
        contentValues.put(USER_PASS,contact.getPassword());
        contentValues.put(USER_NAME,contact.getName());
        contentValues.put(USER_AGE,contact.getAge());
        contentValues.put(USER_SEX,contact.getSex());
        contentValues.put(USER_PREFACE,contact.getPreface());
        contentValues.put(USER_TDX,contact.getTdx());
        contentValues.put(USER_TDY,contact.getTdy());
        contentValues.put(USER_SEARCH,contact.getUserSearch());
        contentValues.put(USER_IDLOVE,contact.getIdLove());
        contentValues.put(USER_IDLIKE,contact.getIdLike());
        contentValues.put(USER_IDUNLIKE,contact.getIdUnlike());
        contentValues.put(USER_IDLIKEBACK,contact.getIdLikeback());
        contentValues.put(USER_IMAGE1,contact.getImage1());
        contentValues.put(USER_IMAGE2,contact.getImage2());
        contentValues.put(USER_IMAGE3,contact.getImage3());
        contentValues.put(USER_IMAGE4,contact.getImage4());

        sqLiteDatabase.update(DB_TABLE_Users,contentValues,"id=?",
                new String[]{String.valueOf(contact.getId())});

    }
    public  void deleteUsers(int id){
        sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.delete(DB_TABLE_Users,"id=?",
                new String[]{String.valueOf(id)});

    }
    public  void deleteAll(){
        sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.delete(DB_TABLE_Users,null,
                null);

    }

    public List<UserInfor> getAllUsers(){
        List<UserInfor> contactList = new ArrayList<>() ;
        sqLiteDatabase = getReadableDatabase();

        UserInfor contact ;
        cursor = sqLiteDatabase.query(false,DB_TABLE_Users,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext() ){

            String id = cursor.getString(cursor.getColumnIndex(USER_ID));
            String phone = cursor.getString(cursor.getColumnIndex(USER_PHONE));
            String pass = cursor.getString(cursor.getColumnIndex(USER_PASS));
            String name = cursor.getString(cursor.getColumnIndex(USER_NAME));
            String age = cursor.getString(cursor.getColumnIndex(USER_AGE));
            String sex = cursor.getString(cursor.getColumnIndex(USER_SEX));
            String preface = cursor.getString(cursor.getColumnIndex(USER_PREFACE));
            String tdx = cursor.getString(cursor.getColumnIndex(USER_TDX));
            String tdy = cursor.getString(cursor.getColumnIndex(USER_TDY));
            String search = cursor.getString(cursor.getColumnIndex(USER_SEARCH));
            String love = cursor.getString(cursor.getColumnIndex(USER_IDLOVE));
            String like = cursor.getString(cursor.getColumnIndex(USER_IDLIKE));
            String unlike = cursor.getString(cursor.getColumnIndex(USER_IDUNLIKE));
            String likeback = cursor.getString(cursor.getColumnIndex(USER_IDLIKEBACK));
            String image1 = cursor.getString(cursor.getColumnIndex(USER_IMAGE1));
            String image2 = cursor.getString(cursor.getColumnIndex(USER_IMAGE2));
            String image3 = cursor.getString(cursor.getColumnIndex(USER_IMAGE3));
            String image4 = cursor.getString(cursor.getColumnIndex(USER_IMAGE4));



            contact = new UserInfor(id,phone,pass,name,age,sex,preface,tdx,tdy,search,love,like,unlike,likeback,image1,image2,image3,image4);
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
