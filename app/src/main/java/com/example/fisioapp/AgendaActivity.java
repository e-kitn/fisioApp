package com.example.fisioapp;

import static com.example.fisioapp.R.id.bottom_appbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AgendaActivity extends AppCompatActivity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        //inicialization
        //appbar
        BottomNavigationView bottomNavigationView = findViewById(R.id.agenda_bottom_appbar);

        //listener bottomnavigationview
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.novo:
                    Intent novo = new Intent(AgendaActivity.this, AddEditPaciente.class);
                    novo.putExtra("isEditMode", false);
                    startActivity(novo);

                    return true;
                case R.id.agenda:
                    //tela da agenda
                    return true;

                case R.id.financas:
                    Intent financas = new Intent(AgendaActivity.this, FinancasActivity.class);
                    startActivity(financas);
                    return true;

                case R.id.home:
                    Intent home = new Intent(AgendaActivity.this, MainActivity.class);
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
                Intent novo = new Intent(AgendaActivity.this, AddEditPaciente.class);
                novo.putExtra("isEditMode", false);
                startActivity(novo);

                break;

            case R.id.agenda:
                //agenda
                break;

            case R.id.financas:
                Intent financas = new Intent(AgendaActivity.this, FinancasActivity.class);
                startActivity(financas);

                break;

            case R.id.home:
                Intent home = new Intent(AgendaActivity.this, MainActivity.class);
                startActivity(home);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
