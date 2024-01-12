package com.example.demo.entity;

import java.util.Date;
import java.util.Objects;

public class Medic {

    private String id;
    private String nume;
    private String prenume;
    private Date dataNasterii;
    private String telefon;
    private int specializare;
    private int spital;
    private int experienta;  // Noua coloană

    public Medic() {
    }

    public Medic(String id, String nume, String prenume, Date dataNasterii, String telefon, int specializare, int spital, int experienta) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.telefon = telefon;
        this.specializare = specializare;
        this.spital = spital;
        this.experienta = experienta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getSpecializare() {
        return specializare;
    }

    public void setSpecializare(int specializare) {
        this.specializare = specializare;
    }

    public int getSpital() {
        return spital;
    }

    public void setSpital(int spital) {
        this.spital = spital;
    }

    public int getExperienta() {
        return experienta;
    }

    public void setExperienta(int experienta) {
        this.experienta = experienta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medic medic = (Medic) o;
        return Objects.equals(id, medic.id) &&
                Objects.equals(nume, medic.nume) &&
                Objects.equals(prenume, medic.prenume) &&
                Objects.equals(dataNasterii, medic.dataNasterii) &&
                Objects.equals(telefon, medic.telefon) &&
                specializare == medic.specializare &&
                spital == medic.spital &&
                experienta == medic.experienta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, prenume, dataNasterii, telefon, specializare, spital, experienta);
    }

    @Override
    public String toString() {
        return "Medic{" +
                "id='" + id + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNasterii=" + dataNasterii +
                ", telefon='" + telefon + '\'' +
                ", specializare=" + specializare +
                ", spital=" + spital +
                ", experienta=" + experienta +
                '}';
    }
}
