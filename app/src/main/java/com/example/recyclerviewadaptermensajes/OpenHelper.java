package com.example.recyclerviewadaptermensajes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OpenHelper extends SQLiteOpenHelper {
    private String createTableMessages="CREATE TABLE Messages(idMessage INTEGER PRIMARY KEY,Message TEXT ,User TEXT,Receptor TEXT)";

    public OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableMessages);
        insertarMensajes(db,1);
        insertarMensajes(db,2);
        insertarMensajes(db,3);
        insertarMensajes(db,4);
        insertarMensajes(db,5);
        insertarMensajes(db,6);
        insertarMensajes(db,7);
        insertarMensajes(db,8);
        insertarMensajes(db,9);
        insertarMensajes(db,10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    private void insertarMensajes(SQLiteDatabase db,int id){
        ContentValues cv=new ContentValues();
        cv.put("idMessage",id);
        cv.put("Message","Message de prueba");
        cv.put("User","User "+id);
        cv.put("Receptor","Receptor "+id);
        db.insert("Messages",null,cv);
    }
}
