package com.example.fisioapp;

import static com.example.fisioapp.R.id.agenda_activity;
import static com.example.fisioapp.R.id.bottom_appbar;
import static com.example.fisioapp.R.id.consultaEt;
import static com.example.fisioapp.R.id.consultaTv;
import static com.example.fisioapp.R.id.save;

import android.content.Context;
import android.content.Intent;
import android.media.metrics.Event;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

    private int currentDay, currentMonth, currentYear, index = 0;
    private String horario;

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
        EditText horarioEt = findViewById(R.id.horarioEt);

        //textview
        TextView consultaTv = findViewById(R.id.consultaTv);
        TextView horarioTv = findViewById(R.id.horarioTv);

        //imageview
        ImageView adicionar = findViewById(R.id.adicionar);

        //daycontent
        View dayContent = findViewById(R.id.dayContent);

        List<String> calendarStrings = new ArrayList<>();
        List<String> timeStrings = new ArrayList<>();
        final int numberOfDays = 2000;
        final int[] days = new int[numberOfDays];
        final int[] months = new int[numberOfDays];
        final int[] years = new int[numberOfDays];

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

                for(int h = 0; h < index; h++){
                    if(years[h] == currentYear){
                        for(int i = 0; i < index; i++){
                            if(days[i] == currentDay){
                                for(int j = 0; j < index; j++){
                                    if(months[j] == currentMonth && days[j] == currentDay && years[j] == currentYear){
                                        consultaTv.setText(calendarStrings.get(j));
                                        horarioTv.setText(timeStrings.get(j));
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                horarioTv.setText("    ");
                consultaTv.setText("Sem consultas hoje!");
            }
        });

        //listener imageview botao
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                days[index] = currentDay;
                months[index] = currentMonth;
                years[index] = currentYear;

                calendarStrings.add(index, consultaEt.getText().toString());
                timeStrings.add(index, horarioEt.getText().toString());

                horarioEt.setText("");
                consultaEt.setText("");
                index++;
                dayContent.setVisibility(View.GONE);
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
