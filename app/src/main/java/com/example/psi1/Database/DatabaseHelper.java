package com.example.psi1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.psi1.Model.ModelUser;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "USER";
    private static final String TABLE_LOGIN= "tbl_login";
    private static final String KEY_ID = "id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "PASSWORD";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createDB = "CREATE TABLE " +TABLE_LOGIN+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+USERNAME+" TEXT,"+PASSWORD+" TEXT)";
        sqLiteDatabase.execSQL(createDB);
    }
    public void SaveLogin(ModelUser USER){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERNAME,USER.getUsername());
        cv.put(PASSWORD,USER.getPassword());
        db.insert(TABLE_LOGIN, null,cv);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }
}
