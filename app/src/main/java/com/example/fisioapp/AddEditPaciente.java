package com.example.fisioapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddEditPaciente extends AppCompatActivity {

    private ImageView profileIv;
    private EditText nomeEt, telEt, nascEt, sexoEt, altEt, pesoEt, queixaEt, doencaAtEt, doencaPrgEt, habitosEt, medicEt, dorEt, pressaoEt, cardioEt, respEt, obsEt;
    //private FloatingActionButton fab;
    private String id, nome, tel, nasc, sexo, alt, peso, queixa, doencaAt, doencaPrg, habitos, medic, dor, pressao, cardio, resp, obs;
    private Boolean isEditMode;
    private ActionBar actionBar;

    private DbHelper dbHelper;

    /*/permission constant
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 200;
    private static final int IMAGE_FROM_GALLERY_CODE = 300;
    private static final int IMAGE_FROM_CAMERA_CODE = 400;

    //string array from permission
    private String[] cameraPermission;
    private String[] storagePermission;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_paciente);

        dbHelper = new DbHelper(this);

        actionBar = getSupportActionBar();

        //backbutton
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        profileIv = findViewById(R.id.profileIv);
        nomeEt = findViewById(R.id.nomeEt);
        telEt = findViewById(R.id.telEt);
        nascEt = findViewById(R.id.nascEt);
        sexoEt = findViewById(R.id.sexoEt);
        altEt = findViewById(R.id.altEt);
        pesoEt = findViewById(R.id.pesoEt);
        queixaEt = findViewById(R.id.queixaEt);
        doencaAtEt = findViewById(R.id.doencaAtEt);
        doencaPrgEt = findViewById(R.id.doencaPrgEt);
        habitosEt = findViewById(R.id.habitosEt);
        medicEt = findViewById(R.id.medicEt);
        dorEt = findViewById(R.id.dorEt);
        pressaoEt = findViewById(R.id.pressaoEt);
        cardioEt = findViewById(R.id.cardioEt);
        respEt = findViewById(R.id.respEt);
        obsEt = findViewById(R.id.obsEt);
        //fab = findViewById(R.id.fab);

        Intent intent = getIntent();
        isEditMode = intent.getBooleanExtra("isEditMode", false);

        if(isEditMode){
            actionBar.setTitle("Editar paciente");

            id = intent.getStringExtra("ID");
            nome = intent.getStringExtra("NOME");
            tel = intent.getStringExtra("TEL");
            nasc = intent.getStringExtra("NASC");
            sexo = intent.getStringExtra("SEXO");
            alt = intent.getStringExtra("ALT");
            peso = intent.getStringExtra("PESO");
            queixa = intent.getStringExtra("QUEIXA");
            doencaAt = intent.getStringExtra("DOENCA_AT");
            doencaPrg = intent.getStringExtra("DOENCA_PRG");
            habitos = intent.getStringExtra("HABIT");
            medic = intent.getStringExtra("MEDIC");
            dor = intent.getStringExtra("DOR");
            pressao = intent.getStringExtra("PRESSAO");
            cardio = intent.getStringExtra("CARDIO");
            resp = intent.getStringExtra("RESP");
            obs = intent.getStringExtra("OBS");

            nomeEt.setText(nome);
            telEt.setText(tel);
            nascEt.setText(nasc);
            sexoEt.setText(sexo);
            altEt.setText(alt);
            pesoEt.setText(peso);
            queixaEt.setText(queixa);
            doencaAtEt.setText(doencaAt);
            doencaPrgEt.setText(doencaPrg);
            habitosEt.setText(habitos);
            medicEt.setText(medic);
            dorEt.setText(dor);
            pressaoEt.setText(pressao);
            respEt.setText(resp);
            cardioEt.setText(cardio);
            obsEt.setText(obs);
        }else{
            actionBar.setTitle("Adicionar paciente");
        }

        /*//event handler
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });*/
    }

    //back button click
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    //action bar save e menu de 3 bolinhas
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.action_bar, menu);
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //opçoes menu
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.novo:
                //pagina novo
                break;

            case R.id.agenda:
                Intent agenda = new Intent(AddEditPaciente.this, AgendaActivity.class);
                startActivity(agenda);

                break;

            case R.id.financas:
                Intent financas = new Intent(AddEditPaciente.this, FinancasActivity.class);
                startActivity(financas);

                break;

            case R.id.home:
                Intent home = new Intent(AddEditPaciente.this, MainActivity.class);
                startActivity(home);
                break;

            case R.id.save:
                saveData();
                if (!nome.isEmpty() && !tel.isEmpty() && !nasc.isEmpty() && !sexo.isEmpty() && !alt.isEmpty() && !peso.isEmpty() && !queixa.isEmpty()) {
                    Intent intent = new Intent(AddEditPaciente.this, MainActivity.class);
                    startActivity(intent);
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /*//salvar
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.save:
                saveData();
                if (!nome.isEmpty() && !tel.isEmpty() && !nasc.isEmpty() && !sexo.isEmpty() && !alt.isEmpty() && !peso.isEmpty() && !queixa.isEmpty()) {
                    Intent intent = new Intent(AddEditPaciente.this, MainActivity.class);
                    startActivity(intent);
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }*/

    private void saveData() {
        nome = nomeEt.getText().toString();
        tel = telEt.getText().toString();
        nasc = nascEt.getText().toString();
        sexo = sexoEt.getText().toString();
        alt = altEt.getText().toString();
        peso = pesoEt.getText().toString();
        queixa = queixaEt.getText().toString();
        doencaAt = doencaAtEt.getText().toString();
        doencaPrg = doencaPrgEt.getText().toString();
        habitos = habitosEt.getText().toString();
        medic = medicEt.getText().toString();
        dor = dorEt.getText().toString();
        pressao = pressaoEt.getText().toString();
        cardio = cardioEt.getText().toString();
        resp = respEt.getText().toString();
        obs = obsEt.getText().toString();

        String timeStamp = "" + System.currentTimeMillis();

        if(!nome.isEmpty() && !tel.isEmpty() && !nasc.isEmpty() && !sexo.isEmpty() && !alt.isEmpty() && !peso.isEmpty() && !queixa.isEmpty()){
            if(isEditMode){
                //edit
                dbHelper.updateFisio(
                        "" + id,
                        "" + nome,
                        "" + tel,
                        "" + nasc,
                        "" + sexo,
                        "" + alt,
                        "" + peso,
                        "" + queixa,
                        "" + doencaAt,
                        "" + doencaPrg,
                        "" + habitos,
                        "" + medic,
                        "" + dor,
                        "" + pressao,
                        "" + cardio,
                        "" + resp,
                        "" + obs,
                        "" + timeStamp,
                        "" + timeStamp);
                Toast.makeText(this, nome + " atualizado...", Toast.LENGTH_SHORT).show();
            }else{
                //add
                long id = dbHelper.insertFisio(
                        "" + nome,
                        "" + tel,
                        "" + nasc,
                        "" + sexo,
                        "" + alt,
                        "" + peso,
                        "" + queixa,
                        "" + doencaAt,
                        "" + doencaPrg,
                        "" + habitos,
                        "" + medic,
                        "" + dor,
                        "" + pressao,
                        "" + cardio,
                        "" + resp,
                        "" + obs,
                        "" + timeStamp,
                        "" + timeStamp);
                Toast.makeText(this, nome + " inserido...", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(this, "Nome, telefone, nascimento, sexo, altura, peso e queixa, são informações obrigatórias", Toast.LENGTH_SHORT).show();
        }

    }
}