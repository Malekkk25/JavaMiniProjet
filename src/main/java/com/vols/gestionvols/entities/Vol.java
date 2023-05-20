package com.vols.gestionvols.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Vol {
    private SimpleIntegerProperty idVol;
    private SimpleStringProperty numVol;
    private SimpleIntegerProperty capacite;

    Aeroport aeroportDepart,aeroportArrivee;



    public Vol() {
        this.idVol = new SimpleIntegerProperty();
        this.numVol = new SimpleStringProperty();
        this.capacite = new SimpleIntegerProperty();

    }

    public Vol(int idVol, String numVol,  int capcite) {
        this.idVol = new SimpleIntegerProperty(idVol);
        this.numVol = new SimpleStringProperty(numVol);
        this.capacite= new SimpleIntegerProperty(capcite);

    }

    public int getIdVol() {
        return idVol.get();
    }

    public SimpleIntegerProperty idVolProperty() {
        return idVol;
    }

    public void setIdVol(int idVol) {
        this.idVol.set(idVol);
    }

    public String getNumVol() {
        return numVol.get();
    }

    public SimpleStringProperty numVolProperty() {
        return numVol;
    }

    public void setNumVol(String numVol) {
        this.numVol.set(numVol);
    }

    public int getCapacite() {
        return capacite.get();
    }

    public SimpleIntegerProperty capaciteProperty() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite.set(capacite);
    }

    @Override
    public String toString() {
        return "Vol{" +
                "idVol=" + idVol +
                ", numVol=" + numVol +
                ", capacite=" + capacite +
                '}';
    }
}