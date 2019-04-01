package org.mahiti.recycler_frag;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Survey2.db";
    public static final String TABLE_NAME = "Register";
    public static final String COL1 = "ID";
    public static final String COL2 = "USERNAME";
    public static final String COL3 = "PHONENUMBER";
    public static final String COL4 = "GENDER";
    public static final String COL5 = "HOBBIES";
    public static final String COL6 = "DOB";
    public static final String COL7 = "ADDRESS";
    SQLiteDatabase db;
    DatabaseHelper mDatabaseHelper;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "USERNAME TEXT,PHONENUMBER TEXT,GENDER TEXT,HOBBIES TEXT,DOB TEXT,ADDRESS TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP  TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addData(String username, String phone_number, String gender, String hobbies, String dob, String address) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, username);
        contentValues.put(COL3, phone_number);
        contentValues.put(COL4, gender);
        contentValues.put(COL5, hobbies);
        contentValues.put(COL6, dob);
        contentValues.put(COL7, address);

        long result = db.insert(TABLE_NAME, null, contentValues);


        if (result == -1)
            return false;
        else
            return true;

    }


    public List<UserClass> getAllData() {
        List<UserClass> listUser = new ArrayList<>();
        db = this.getWritableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);
        //StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(DatabaseHelper.COL1);
            int index2 = cursor.getColumnIndex(DatabaseHelper.COL2);
            int index3 = cursor.getColumnIndex(DatabaseHelper.COL3);
            int index4 = cursor.getColumnIndex(DatabaseHelper.COL4);
            int index5 = cursor.getColumnIndex(DatabaseHelper.COL5);
            int index6 = cursor.getColumnIndex(DatabaseHelper.COL6);
            int index7 = cursor.getColumnIndex(DatabaseHelper.COL7);

            int id = cursor.getInt(index1);
            String username = cursor.getString(index2);
            String phone_number = cursor.getString(index3);
            String gender = cursor.getString(index4);
            String hobbies = cursor.getString(index5);
            String dob = cursor.getString(index6);
            String address = cursor.getString(index7);
            UserClass userClass = new UserClass(id, username, phone_number, gender, hobbies, dob, address);
            listUser.add(userClass);
        }
        return listUser;


    }

    public boolean updateData(String id, String username, String phone_number, String gender, String hobbies, String dob, String address) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, id);
        contentValues.put(COL2, username);
        contentValues.put(COL3, phone_number);
        contentValues.put(COL4, gender);
        contentValues.put(COL5, hobbies);
        contentValues.put(COL6, dob);
        contentValues.put(COL7, address);

        long result =  db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });


        if (result == -1)
            return false;
        else
            return true;
    }

}



