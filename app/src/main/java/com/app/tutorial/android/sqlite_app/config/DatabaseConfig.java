package com.app.tutorial.android.sqlite_app.config;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.tutorial.android.sqlite_app.model.Student;

/**
 * Created by pranishres on 11/10/16.
 */

public class DatabaseConfig extends SQLiteOpenHelper {

    // Database property variables
    public static final String DATABASE_NAME = "student.db";
    public static final String DATABASE_TABLE = "student";
    public static final String COLN_ID = "id";
    public static final String COLN_FIRST_NAME = "first_name";
    public static final String COLN_LAST_NAME = "last_name";
    public static final String COLN_ADDRESS = "address";
    public static final String COLN_EMAIL = "email";


    public DatabaseConfig(Context context) {
        // Creating database
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create table

        System.out.println("onCreate()");

        sqLiteDatabase.execSQL("CREATE TABLE " + DATABASE_TABLE + "(" + COLN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COLN_FIRST_NAME + " VARCHAR(30) ," +COLN_LAST_NAME+" varchar(30) ," + COLN_ADDRESS+ " VARCHAR(30) , "+ COLN_EMAIL+ " VARCHAR(30));");
//        sqLiteDatabase.execSQL("CREATE TABLE student (ID INTEGER PRIMARY KEY , STUDENT VARCHAR(30));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Create a fresh table
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(sqLiteDatabase);
    }

    /**
     * Insert data
     * @param student - model object containing data to be inserted
     * @return success (true) / unsuccess (false)
     */
    public boolean insertData(Student student){
        Boolean b;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLN_FIRST_NAME , student.getFirstName());
        contentValues.put(COLN_LAST_NAME , student.getLastName());
        contentValues.put(COLN_ADDRESS , student.getAddress());
        contentValues.put(COLN_EMAIL , student.getEmail());

        long result = sqLiteDatabase.insert(DATABASE_TABLE , null , contentValues);

        b = result == -1 ? false : true;

        return b;
    }

    /**
     * Get all data from the database
     * @return data
     */
    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " +DATABASE_TABLE , null);
        return result;
    }
}
