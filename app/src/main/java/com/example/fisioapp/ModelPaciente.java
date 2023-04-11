package com.example.fisioapp;

public class ModelPaciente {
    private String id, nome, tel, nasc, sexo, alt, peso, queixa, doencaAt, doencaPrg, habitos, medic, dor, pressao, cardio, resp, obs, addedTime, updatedTime;

    public ModelPaciente(String id, String nome, String tel, String nasc, String sexo, String alt, String peso, String queixa, String doencaAt, String doencaPrg, String habitos, String medic, String dor, String pressao, String cardio, String resp, String obs/*, String addedTime, String updatedTime*/) {
        this.id = id;
        this.nome = nome;
        this.tel = tel;
        this.nasc = nasc;
        this.sexo = sexo;
        this.alt = alt;
        this.peso = peso;
        this.queixa = queixa;
        this.doencaAt = doencaAt;
        this.doencaPrg = doencaPrg;
        this.habitos = habitos;
        this.medic = medic;
        this.dor = dor;
        this.pressao = pressao;
        this.cardio = cardio;
        this.resp = resp;
        this.obs = obs;
        this.addedTime = addedTime;
        this.updatedTime = updatedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getQueixa() {
        return queixa;
    }

    public void setQueixa(String queixa) {
        this.queixa = queixa;
    }

    public String getDoencaAt() {
        return doencaAt;
    }

    public void setDoencaAt(String doencaAt) {
        this.doencaAt = doencaAt;
    }

    public String getDoencaPrg() {
        return doencaPrg;
    }

    public void setDoencaPrg(String doencaPrg) {
        this.doencaPrg = doencaPrg;
    }

    public String getHabitos() {
        return habitos;
    }

    public void setHabitos(String habitos) {
        this.habitos = habitos;
    }

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public String getCardio() {
        return cardio;
    }

    public void setCardio(String cardio) {
        this.cardio = cardio;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(String addedTime) {
        this.addedTime = addedTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}
