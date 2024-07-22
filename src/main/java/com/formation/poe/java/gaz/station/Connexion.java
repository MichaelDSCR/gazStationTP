package com.formation.poe.java.gaz.station;

public class Connexion {

    private boolean isConnected;

    public void connect() {
        // Simuler la connexion à une base de données
        isConnected = true;
        System.out.println("Connexion à la base de données établie.");
    }

    public void disconnect() {
        // Simuler la déconnexion de la base de données
        isConnected = false;
        System.out.println("Déconnexion de la base de données.");
    }

    public boolean isConnected() {
        return isConnected;
    }
}
