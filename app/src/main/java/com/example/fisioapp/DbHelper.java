package com.example.fisioapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);

        onCreate(db);
    }

    //insert
    public long insertFisio(String nome, String tel, String nasc, String sexo, String alt, String peso, String queixa, String doencaAt, String doencaPrg, String habit, String medic, String dor, String pressao, String cardio, String resp, String obs, String addedTime, String updatedTime){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.F_NOME, nome);
        contentValues.put(Constants.F_TEL, tel);
        contentValues.put(Constants.F_NASC, nasc);
        contentValues.put(Constants.F_SEXO, sexo);
        contentValues.put(Constants.F_ALT, alt);
        contentValues.put(Constants.F_PESO, peso);
        contentValues.put(Constants.F_QUEIXA, queixa);
        contentValues.put(Constants.F_DOENCAAT, doencaAt);
        contentValues.put(Constants.F_DOENCAPRG, doencaPrg);
        contentValues.put(Constants.F_HABIT, habit);
        contentValues.put(Constants.F_MEDIC, medic);
        contentValues.put(Constants.F_DOR, dor);
        contentValues.put(Constants.F_PRESSAO, pressao);
        contentValues.put(Constants.F_CARDIO, cardio);
        contentValues.put(Constants.F_RESP, resp);
        contentValues.put(Constants.F_OBS, obs);
        //contentValues.put(Constants.F_ADDED_TIME, addedTime);
        //contentValues.put(Constants.F_UPDATED_TIME, updatedTime);

        long id = db.insert(Constants.TABLE_NAME, null, contentValues);
        db.close();
        return id;
    }

    //update
    public void updateFisio(String id, String nome, String tel, String nasc, String sexo, String alt, String peso, String queixa, String doencaAt, String doencaPrg, String habit, String medic, String dor, String pressao, String cardio, String resp, String obs, String addedTime, String updatedTime){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.F_NOME, nome);
        contentValues.put(Constants.F_TEL, tel);
        contentValues.put(Constants.F_NASC, nasc);
        contentValues.put(Constants.F_SEXO, sexo);
        contentValues.put(Constants.F_ALT, alt);
        contentValues.put(Constants.F_PESO, peso);
        contentValues.put(Constants.F_QUEIXA, queixa);
        contentValues.put(Constants.F_DOENCAAT, doencaAt);
        contentValues.put(Constants.F_DOENCAPRG, doencaPrg);
        contentValues.put(Constants.F_HABIT, habit);
        contentValues.put(Constants.F_MEDIC, medic);
        contentValues.put(Constants.F_DOR, dor);
        contentValues.put(Constants.F_PRESSAO, pressao);
        contentValues.put(Constants.F_CARDIO, cardio);
        contentValues.put(Constants.F_RESP, resp);
        contentValues.put(Constants.F_OBS, obs);
        //contentValues.put(Constants.F_ADDED_TIME, addedTime);
        //contentValues.put(Constants.F_UPDATED_TIME, updatedTime);

        db.update(Constants.TABLE_NAME, contentValues, Constants.F_ID + " =? ", new String[]{id});
        db.close();
    }

    //delete
    public void deletePaciente(String id){
        SQLiteDatabase db = getWritableDatabase();

        db.delete(Constants.TABLE_NAME, Constants.F_ID + " =? ", new String[]{id});
        db.close();
    }

    public ArrayList<ModelPaciente> getAllData(){
        ArrayList<ModelPaciente> arrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                ModelPaciente modelPaciente = new ModelPaciente(
                    "" + cursor.getInt(cursor.getColumnIndexOrThrow(Constants.F_ID)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_NOME)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_TEL)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_NASC)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_SEXO)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_ALT)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_PESO)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_QUEIXA)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_DOENCAAT)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_DOENCAPRG)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_HABIT)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_MEDIC)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_DOR)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_PRESSAO)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_CARDIO)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_RESP)),
                    "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_OBS)));
                    //"" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_ADDED_TIME)),
                    //"" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_UPDATED_TIME)));
                arrayList.add(modelPaciente);
            }while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }
}
