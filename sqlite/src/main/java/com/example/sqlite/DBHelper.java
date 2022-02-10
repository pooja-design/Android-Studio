package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper  extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "UserData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table UserDetails(name text primary key,age text,contact text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table  if exists UserDetails");
    }

    public boolean insetData(String name, String age, String contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("age",age);
        contentValues.put("contact",contact);

        long result = db.insert("UserDetails",null,contentValues);
        if (result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean updateData(String name, String age, String contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = db.rawQuery("Select * from UserDetails where name= ?",new String[] {name});
        if(cursor.getCount()>0){
            contentValues.put("age",age);
            contentValues.put("contact",contact);
            long result = db.update("UserDetails",contentValues,"name=?",new String[] {name});
            if(result==-1){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    public boolean deleteData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from UserDetails where name=?",new String[] {name});

        if(cursor.getCount()>0){
            long result = db.delete("UserDetails","name=?",new String[] {name});
            if(result==-1){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return true;
        }
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from UserDetails",null);
        return cursor;
    }
}
