package com.example.fisioapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DecimalFormat;

public class FinancasActivity extends AppCompatActivity {
    private Spinner spinner;
    private String[] items = {"Materiais", "Transporte", "Consultas"};

    //var
    private double valorTotal = 0;
    private double valorMateriais = 0;
    private double valorTMateriais = 0;

    private double valorTransporte = 0;
    private double valorTTransporte = 0;

    private double valorConsulta = 0;
    private double valorTConsulta = 0;

    private String placeholder = "";

    //format
    DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financas);

        //initialization
        //appbar
        BottomNavigationView bottomNavigationView = findViewById(R.id.financas_bottom_appbar);

        //textview
        TextView gastosTv = findViewById(R.id.gastosTv);
        TextView materiaisTv = findViewById(R.id.materiaisTv);
        TextView transporteTv = findViewById(R.id.transporteTv);
        TextView consultaTv = findViewById(R.id.consultaTv);

        //imageview
        ImageView adicionar = findViewById(R.id.adicionar);

        //editText
        EditText gastosEt = findViewById(R.id.gastosEt);

        //spinner
        spinner = findViewById(R.id.spinner_gastos);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);

        //listener imageview botao
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String options = spinner.getSelectedItem().toString();

                switch (options){
                    case "Materiais":
                        if(TextUtils.isEmpty(gastosEt.getText())){
                            Toast.makeText(FinancasActivity.this, "O conteúdo não pode ser vazio!", Toast.LENGTH_SHORT).show();
                        } else {
                            placeholder = gastosEt.getText().toString();

                            valorMateriais = Double.parseDouble(placeholder);
                            valorTMateriais = valorTMateriais - valorMateriais;

                            placeholder = df.format(valorTMateriais);
                            materiaisTv.setText("R$ " + placeholder);

                            valorTotal = valorTotal - valorMateriais;

                            placeholder = df.format(valorTotal);
                            gastosTv.setText("R$" + placeholder);

                            if(valorTMateriais < 0){
                                materiaisTv.setTextColor(Color.rgb(255, 82, 82));
                            } else{
                                materiaisTv.setTextColor(Color.rgb(19, 178, 152));
                            }
                        }

                        break;
                    case "Transporte":
                        if(TextUtils.isEmpty(gastosEt.getText())){
                            Toast.makeText(FinancasActivity.this, "O conteúdo não pode ser vazio!", Toast.LENGTH_SHORT).show();
                        } else{
                            placeholder = gastosEt.getText().toString();

                            valorTransporte = Double.parseDouble(placeholder);
                            valorTTransporte = valorTTransporte - valorTransporte;

                            placeholder = df.format(valorTTransporte);
                            transporteTv.setText("R$ " + placeholder);

                            valorTotal = valorTotal - valorTransporte;

                            placeholder = df.format(valorTotal);
                            gastosTv.setText("R$" + placeholder);

                            if(valorTTransporte < 0){
                                transporteTv.setTextColor(Color.rgb(255, 82, 82));
                            } else{
                                transporteTv.setTextColor(Color.rgb(19, 178, 152));
                            }
                        }
                        break;
                    case "Consultas":
                        if(TextUtils.isEmpty(gastosEt.getText())){
                            Toast.makeText(FinancasActivity.this, "O conteúdo não pode ser vazio!", Toast.LENGTH_SHORT).show();
                        } else{
                            placeholder = gastosEt.getText().toString();

                            valorConsulta = Double.parseDouble(placeholder);
                            valorTConsulta = valorTConsulta + valorConsulta;

                            placeholder = df.format(valorTConsulta);
                            consultaTv.setText("R$ " + placeholder);

                            valorTotal = valorTotal + valorConsulta;

                            placeholder = df.format(valorTotal);
                            gastosTv.setText("R$" + placeholder);

                            if(valorTConsulta < 0){
                                consultaTv.setTextColor(Color.rgb(255, 82, 82));
                            } else{
                                consultaTv.setTextColor(Color.rgb(19, 178, 152));
                            }
                        }
                        break;
                }

                if(valorTotal < 0){
                    gastosTv.setTextColor(Color.rgb(255, 82, 82));
                } else{
                    gastosTv.setTextColor(Color.rgb(19, 178, 152));
                }
            }
        });

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
