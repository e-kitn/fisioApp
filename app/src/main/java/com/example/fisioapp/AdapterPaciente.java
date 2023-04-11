package com.example.fisioapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPaciente extends RecyclerView.Adapter<AdapterPaciente.PacienteViewHolder>{
    private Context context;
    private ArrayList<ModelPaciente> pacienteList;
    private DbHelper dbHelper;

    public AdapterPaciente(Context context, ArrayList<ModelPaciente> pacienteList) {
        this.context = context;
        this.pacienteList = pacienteList;
        dbHelper = new DbHelper(context);
    }

    @NonNull
    @Override
    public PacienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_paciente_item, parent, false);
        PacienteViewHolder vh = new PacienteViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PacienteViewHolder holder, int position) {
        ModelPaciente modelPaciente = pacienteList.get(position);

        String id = modelPaciente.getId();
        String nome = modelPaciente.getNome();
        String tel = modelPaciente.getTel();
        String nasc = modelPaciente.getNasc();
        String sexo = modelPaciente.getSexo();
        String alt = modelPaciente.getAlt();
        String peso = modelPaciente.getPeso();
        String queixa = modelPaciente.getQueixa();
        String doencaAt = modelPaciente.getDoencaAt();
        String doencaPrg = modelPaciente.getDoencaPrg();
        String habit = modelPaciente.getHabitos();
        String medic = modelPaciente.getMedic();
        String dor = modelPaciente.getPressao();
        String pressao = modelPaciente.getPressao();
        String cardio = modelPaciente.getCardio();
        String resp = modelPaciente.getResp();
        String obs = modelPaciente.getObs();

        holder.pacienteName.setText(nome);
        holder.pacienteImage.setImageResource(R.drawable.baseline_person_24);

        //paciente edit
        holder.pacienteEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddEditPaciente.class);
                intent.putExtra("ID", id);
                intent.putExtra("NOME", nome);
                intent.putExtra("TEL", tel);
                intent.putExtra("NASC", nasc);
                intent.putExtra("SEXO", sexo);
                intent.putExtra("ALT", alt);
                intent.putExtra("PESO", peso);
                intent.putExtra("QUEIXA", queixa);
                intent.putExtra("DOENCA_AT", doencaAt);
                intent.putExtra("DOENCA_PRG", doencaPrg);
                intent.putExtra("HABIT", habit);
                intent.putExtra("MEDIC", medic);
                intent.putExtra("DOR", dor);
                intent.putExtra("PRESSAO", pressao);
                intent.putExtra("CARDIO", cardio);
                intent.putExtra("RESP", resp);
                intent.putExtra("OBS", obs);

                intent.putExtra("isEditMode", true);

                context.startActivity(intent);
            }
        });

        //paciente delete
        holder.pacienteDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deletePaciente(id);
                ((MainActivity)context).onResume();
            }
        });

        //paciente details
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PacienteDetails.class);
                intent.putExtra("pacienteId",id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pacienteList.size();
    }

    class PacienteViewHolder extends RecyclerView.ViewHolder {
        ImageView pacienteImage, pacienteEdit, pacienteDelete;
        TextView pacienteName;

        public PacienteViewHolder(@NonNull View itemView) {
            super(itemView);

            pacienteImage = itemView.findViewById(R.id.paciente_image);
            pacienteEdit = itemView.findViewById(R.id.paciente_edit);
            pacienteDelete = itemView.findViewById(R.id.paciente_delete);
            pacienteName = itemView.findViewById(R.id.paciente_name);
        }
    }
}
