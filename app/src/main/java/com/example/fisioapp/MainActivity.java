package com.example.fisioapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.fisioapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    //private FloatingActionButton fab;

    private RecyclerView pacienteRv;

    //db
    private DbHelper dbHelper;

    private AdapterPaciente adapterPaciente;

    //ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization
        //fab = findViewById(R.id.fab);
        pacienteRv = findViewById(R.id.pacienteRv);

        //init db
        dbHelper = new DbHelper(this);

        //appbar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_appbar);

        pacienteRv.setHasFixedSize(true);

        //listener bottomnavigationview
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.novo:
                    Intent novo = new Intent(MainActivity.this, AddEditPaciente.class);
                    novo.putExtra("isEditMode", false);
                    startActivity(novo);

                    return true;

                case R.id.agenda:
                    Intent agenda = new Intent(MainActivity.this, AgendaActivity.class);
                    startActivity(agenda);

                    return true;

                case R.id.financas:
                    Intent financas = new Intent(MainActivity.this, FinancasActivity.class);
                    startActivity(financas);

                    return true;

                case R.id.home:
                    //home
                    return true;
            }
            return false;
        });

        /*add listener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //move to new activity
                Intent intent = new Intent(MainActivity.this, AddEditPaciente.class);
                intent.putExtra("isEditMode", false);
                startActivity(intent);
            }
        });*/
        loadData();
    }

    private void loadData() {
        adapterPaciente = new AdapterPaciente(this, dbHelper.getAllData());
        pacienteRv.setAdapter(adapterPaciente);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
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
                Intent novo = new Intent(MainActivity.this, AddEditPaciente.class);
                novo.putExtra("isEditMode", false);
                startActivity(novo);

                break;

            case R.id.agenda:
                Intent agenda = new Intent(MainActivity.this, AgendaActivity.class);
                startActivity(agenda);

                break;

            case R.id.financas:
                Intent financas = new Intent(MainActivity.this, FinancasActivity.class);
                startActivity(financas);

                break;

            case R.id.home:
                //home
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}