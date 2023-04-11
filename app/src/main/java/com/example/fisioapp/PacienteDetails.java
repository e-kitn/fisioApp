package com.example.fisioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PacienteDetails extends AppCompatActivity {

    private TextView nomeTv, telTv, nascTv, sexoTv, altTv, pesoTv, queixaTv, doencaAtTv, doencaPrgTv, habitosTv, medicTv, dorTv, pressaoTv, cardioTv, respTv, obsTv, addedTimeTv, updatedTimeTv;
    private String id;
    private DbHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_details);

        dbHelper = new DbHelper(this);

        //get data
        Intent intent = getIntent();
        id = intent.getStringExtra("pacienteId");

        //init
        nomeTv = findViewById(R.id.nomeTv);
        telTv = findViewById(R.id.telTv);
        nascTv = findViewById(R.id.nascTv);
        sexoTv = findViewById(R.id.sexoTv);
        altTv = findViewById(R.id.altTv);
        pesoTv = findViewById(R.id.pesoTv);
        queixaTv = findViewById(R.id.queixaTv);
        doencaAtTv = findViewById(R.id.doencaAtTv);
        doencaPrgTv = findViewById(R.id.doencaPrgTv);
        habitosTv = findViewById(R.id.habitosTv);
        medicTv = findViewById(R.id.medicTv);
        dorTv = findViewById(R.id.dorTv);
        pressaoTv = findViewById(R.id.pressaoTv);
        cardioTv = findViewById(R.id.cardioTv);
        respTv = findViewById(R.id.respTv);
        obsTv = findViewById(R.id.obsTv);
        //addedTimeTv = findViewById(R.id.addedTimeTv);
        //updatedTimeTv = findViewById(R.id.updatedTimeTv);


        loadDataById();
    }

    private void loadDataById() {
        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " WHERE " + Constants.F_ID + " =\"" + id + "\"";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                String nome = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_NOME));
                String tel = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_TEL));
                String nasc = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_NASC));
                String sexo = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_SEXO));
                String alt = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_ALT));
                String peso = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_PESO));
                String queixa = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_QUEIXA));
                String doencaAt = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_DOENCAAT));
                String doencaPrg = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_DOENCAPRG));
                String habit = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_HABIT));
                String medic = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_MEDIC));
                String dor = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_DOR));
                String pressao = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_PRESSAO));
                String cardio = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_CARDIO));
                String resp = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_RESP));
                String obs = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_OBS));
                String addedTime = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_ADDED_TIME));
                String updatedTime = "" + cursor.getString(cursor.getColumnIndexOrThrow(Constants.F_UPDATED_TIME));

                /*Calendar calendar = Calendar.getInstance(Locale.getDefault());
                calendar.setTimeInMillis(Long.parseLong(addedTime));
                DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
                String addTime = "" + dateFormat.format(calendar);
                String updateTime = "" + dateFormat.format(calendar);*/

                //set
                nomeTv.setText(nome);
                telTv.setText(tel);
                nascTv.setText(nasc);
                sexoTv.setText(sexo);
                altTv.setText(alt);
                pesoTv.setText(peso);
                queixaTv.setText(queixa);
                doencaAtTv.setText(doencaAt);
                doencaPrgTv.setText(doencaPrg);
                habitosTv.setText(habit);
                medicTv.setText(medic);
                dorTv.setText(dor);
                pressaoTv.setText(pressao);
                cardioTv.setText(cardio);
                respTv.setText(resp);
                obsTv.setText(obs);
                //addedTimeTv.setText(addTime);
                //updatedTimeTv.setText(updateTime);

            }while (cursor.moveToNext());
        }
        db.close();
    }
}