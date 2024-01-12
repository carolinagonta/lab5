package com.example.demo.entity;

import java.util.Objects;

public class Client {

    private String id;
    private String nume;
    private String prenume;
    private String dataNasterii;
    private String telefon;
    private String medic;

    public Client() {
    }

    public Client(String id, String nume, String prenume, String dataNasterii, String telefon, String medic) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.telefon = telefon;
        this.medic = medic;
    }

    public String getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getDataNasterii() {
        return dataNasterii;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getMedic() {
        return medic;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setMedic(String medic) {
        this.medic = medic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNasterii='" + dataNasterii + '\'' +
                ", telefon='" + telefon + '\'' +
                ", medic='" + medic + '\'' +
                '}';
    }
}
