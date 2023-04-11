package com.example.fisioapp;

public class Constants {
    public static final String DATABASE_NAME = "FISIO_DB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "FISIO_TABLE";

    public static final String F_ID = "ID";
    public static final String F_NOME = "NOME";
    public static final String F_TEL = "TEL";
    public static final String F_NASC = "NASC";
    public static final String F_SEXO = "SEXO";
    public static final String F_ALT = "ALT";
    public static final String F_PESO = "PESO";
    public static final String F_QUEIXA = "QUEIXA";
    public static final String F_DOENCAAT = "DOENCAAT";
    public static final String F_DOENCAPRG = "DOENCAPRG";
    public static final String F_HABIT = "HABIT";
    public static final String F_MEDIC = "MEDIC";
    public static final String F_DOR = "DOR";
    public static final String F_PRESSAO = "PRESSAO";
    public static final String F_CARDIO = "CARDIO";
    public static final String F_RESP = "RESP";
    public static final String F_OBS = "OBS";
    public static final String F_ADDED_TIME = "ADDED_TIME";
    public static final String F_UPDATED_TIME = "UPDATED_TIME";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            F_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            F_NOME + " TEXT, " +
            F_TEL + " TEXT, " +
            F_NASC + " TEXT, " +
            F_SEXO + " TEXT, " +
            F_ALT + " TEXT, " +
            F_PESO + " TEXT, " +
            F_QUEIXA + " TEXT, " +
            F_DOENCAAT + " TEXT, " +
            F_DOENCAPRG + " TEXT, " +
            F_HABIT + " TEXT, " +
            F_MEDIC + " TEXT, " +
            F_DOR + " TEXT, " +
            F_PRESSAO + " TEXT, " +
            F_CARDIO + " TEXT, " +
            F_RESP + " TEXT, " +
            F_OBS + " TEXT, " +
            F_ADDED_TIME + " TEXT, " +
            F_UPDATED_TIME + " TEXT" +
            "); ";
}
