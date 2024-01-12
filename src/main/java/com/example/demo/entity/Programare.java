package com.example.demo.entity;

import java.util.Date;
import java.util.Objects;

public class Programare {

    private int idProgramare;
    private String client;
    private String medic;
    private Date ora;
    private int cabinetul;

    public Programare() {
    }

    public Programare(int idProgramare, String client, String medic, Date ora, int cabinetul) {
        this.idProgramare = idProgramare;
        this.client = client;
        this.medic = medic;
        this.ora = ora;
        this.cabinetul = cabinetul;
    }

    // Getters and setters

    public int getIdProgramare() {
        return idProgramare;
    }

    public void setIdProgramare(int idProgramare) {
        this.idProgramare = idProgramare;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMedic() {
        return medic;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }

    public Date getOra() {
        return ora;
    }

    public void setOra(Date ora) {
        this.ora = ora;
    }

    public int getCabinetul() {
        return cabinetul;
    }

    public void setCabinetul(int cabinetul) {
        this.cabinetul = cabinetul;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programare that = (Programare) o;
        return idProgramare == that.idProgramare &&
                cabinetul == that.cabinetul &&
                Objects.equals(client, that.client) &&
                Objects.equals(medic, that.medic) &&
                Objects.equals(ora, that.ora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProgramare, client, medic, ora, cabinetul);
    }

    @Override
    public String toString() {
        return "Programare{" +
                "idProgramare=" + idProgramare +
                ", client='" + client + '\'' +
                ", medic='" + medic + '\'' +
                ", ora=" + ora +
                ", cabinetul=" + cabinetul +
                '}';
    }
}
