package com.example.fisioapp;

import static com.example.fisioapp.R.id.bottom_appbar;
import static com.example.fisioapp.R.id.save;

import android.content.Intent;
import android.media.metrics.Event;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AgendaActivity extends AppCompatActivity{

    private int currentDay, currentMonth, currentYear = 0;

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        //inicialization
        //appbar
        BottomNavigationView bottomNavigationView = findViewById(R.id.agenda_bottom_appbar);

        //calendar
        CalendarView calendarView = findViewById(R.id.calendarView);

        //edittext
        EditText consultaEt = findViewById(R.id.consultaEt);

        //textview
        TextView consultaTv = findViewById(R.id.consultaTv);

        //imageview
        ImageView adicionar = findViewById(R.id.adicionar);

        //daycontent
        View dayContent = findViewById(R.id.dayContent);

        List<String> calendarStrings = new ArrayList<>();
        int[] days = new int[30];

        //listener imageview
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                days[0] = currentDay;
                calendarStrings.add(String.valueOf(calendarView.getDate()));
                calendarStrings.add(consultaEt.getText().toString());
                consultaEt.setText("");
            }
        });

        //listener calendar
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day){
                currentDay = day;
                currentMonth = month;
                currentYear = year;
                if(dayContent.getVisibility() == View.GONE){
                    dayContent.setVisibility(View.VISIBLE);
                }

                if(currentDay == days[0]){
                    consultaTv.setText(calendarStrings.get(0).toString());
                }
            }
        });

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
