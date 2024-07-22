package com.formation.poe.java.gaz.station;

public class Pneus {
    private double pressionPneusAvant;
    private double pressionPneusArriere;

    public Pneus(double pressionPneusAvant, double pressionPneusArriere) {
        this.pressionPneusAvant = pressionPneusAvant;
        this.pressionPneusArriere = pressionPneusArriere;
    }

    public double getPressionPneusAvant() {
        return pressionPneusAvant;
    }

    public void setPressionPneusAvant(double pressionPneusAvant) {
        this.pressionPneusAvant = pressionPneusAvant;
    }

    public double getPressionPneusArriere() {
        return pressionPneusArriere;
    }

    public void setPressionPneusArriere(double pressionPneusArriere) {
        this.pressionPneusArriere = pressionPneusArriere;
    }
}
