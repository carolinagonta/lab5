package com.example.demo.entity;

import java.util.Objects;

public class Spital {

    private int id;
    private String denumire;
    private String adresa;

    public Spital() {
    }

    public Spital(int id, String denumire, String adresa) {
        this.id = id;
        this.denumire = denumire;
        this.adresa = adresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spital spital = (Spital) o;
        return id == spital.id && Objects.equals(denumire, spital.denumire) && Objects.equals(adresa, spital.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, denumire, adresa);
    }

    @Override
    public String toString() {
        return "Spital{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
