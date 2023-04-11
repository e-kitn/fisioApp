package com.example.fisioapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FinancasActivity extends AppCompatActivity {
    private Spinner spinner;
    private String[] items = {"Materias", "Transporte", "Consultas"};

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financas);

        //initialization
        //appbar
        BottomNavigationView bottomNavigationView = findViewById(R.id.financas_bottom_appbar);

        //spinner
        spinner = findViewById(R.id.spinner_gastos);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);

        //listener bottomnavigationview
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.novo:
                    Intent novo = new Intent(FinancasActivity.this, AddEditPaciente.class);
                    novo.putExtra("isEditMode", false);
                    startActivity(novo);

                    return true;

                case R.id.agenda:
                    Intent agenda = new Intent(FinancasActivity.this, AgendaActivity.class);
                    startActivity(agenda);

                    return true;

                case R.id.financas:
                    //financas
                    return true;

                case R.id.home:
                    Intent home = new Intent(FinancasActivity.this, MainActivity.class);
                    startActivity(home);
                    return true;
            }
            return false;
        });
    }

    //inflater menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //opçoes menu
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.novo:
                Intent novo = new Intent(FinancasActivity.this, AddEditPaciente.class);
                novo.putExtra("isEditMode", false);
                startActivity(novo);

                break;

            case R.id.agenda:
                Intent agenda = new Intent(FinancasActivity.this, AgendaActivity.class);
                startActivity(agenda);

                break;

            case R.id.financas:
                //financas
                break;

            case R.id.home:
                Intent home = new Intent(FinancasActivity.this, MainActivity.class);
                startActivity(home);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
