package com.formation.poe.java.gaz.station;

import java.util.Scanner;

public class Voiture {

    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    // Initialisation
    private static int nombreDeVoitures = 0;
    private static Voiture voitureEnregistree = null;
    private static Scanner scanner = new Scanner(System.in);
    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    // Attributs d'instance
    private int compteurKm;
    private final int idVoiture;
    private final Moteur moteur;
    private final String identificationUnique;
    private final Pneus pneus;


    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    // Constructeur
    public Voiture(int compteurKm, double consommationMoteur, String identificationUnique, double pressionPneusAvant, double pressionPneusArriere) {
        this.compteurKm = compteurKm;
        this.idVoiture = ++nombreDeVoitures;
        this.moteur = new Moteur(consommationMoteur);
        this.identificationUnique = identificationUnique;
        this.pneus = new Pneus(pressionPneusAvant, pressionPneusArriere);
        voitureEnregistree = this; // Enregistrement de l'instance actuelle
    }
    public static void setScanner(Scanner scanner) {
        Voiture.scanner = scanner;
    }

    // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    // Méthodes statiques
    public static void enregistrerDetailsVoiture() {
        // Méthode statique qui enregistre les détails de la voiture
        if (scanner == null) {
            System.out.println("Scanner non initialisé.");
            return;
        }

        System.out.print("Entrez le compteur kilométrique : ");
        int compteurKm = scanner.nextInt();
        System.out.print("Entrez la consommation du moteur (litres/100 km) : ");
        double consommationMoteur = scanner.nextDouble();
        scanner.nextLine();  // Consommer la nouvelle ligne
        System.out.print("Entrez l'identification unique : ");
        String identificationUnique = scanner.nextLine();
        System.out.print("Entrez la pression des pneus avant (bar) : ");
        double pressionPneusAvant = scanner.nextDouble();
        System.out.print("Entrez la pression des pneus arrière (bar) : ");
        double pressionPneusArriere = scanner.nextDouble();

        // Créer une nouvelle instance de Voiture et afficher ses détails
        Voiture voiture = new Voiture(compteurKm, consommationMoteur, identificationUnique, pressionPneusAvant, pressionPneusArriere);
        System.out.println("Voiture enregistrée avec succès !");
        voiture.afficherDetailsVoitureInstance();
    }

    public static void afficherDetailsVoiture() {
        // Assurez-vous d'avoir une instance de voiture pour afficher ses détails
        if (scanner == null) {
            System.out.println("Scanner non initialisé.");
            return;
        }
        if (voitureEnregistree != null) {
            voitureEnregistree.afficherDetailsVoitureInstance();
        } else {
            System.out.println("Aucune voiture enregistrée.");
        }
    }

    public static void laverVoiture() {
        System.out.println("Lavage de la voiture en cours...");
        int chargement = 0;
        while (chargement <= 100) {
            try {
                Thread.sleep(100); // 0.1 seconde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String bar = new String(new char[chargement / 5]).replace("\0", "█");
            String spaces = new String(new char[20 - chargement / 5]).replace("\0", " ");
            System.out.print("\r" + bar + spaces + " " + chargement + "%");
            chargement++;
        }
        System.out.println("\nLa voiture est maintenant propre.");
    }

    public static void gonflerPneus() {
        if (scanner == null) {
            System.out.println("Scanner non initialisé.");
            return;
        }

        if (voitureEnregistree != null) {
            // Utiliser les valeurs des pneus déjà enregistrées pour les gonfler
            voitureEnregistree.gonflerPneusInstance(voitureEnregistree.pneus.getPressionPneusAvant(), voitureEnregistree.pneus.getPressionPneusArriere());
        } else {
            // Demander les valeurs au scanner
            System.out.print("Entrez la pression des pneus avant (bar) : ");
            double pressionAvant = scanner.nextDouble();
            System.out.print("Entrez la pression des pneus arrière (bar) : ");
            double pressionArriere = scanner.nextDouble();

            // Gonfler les pneus avec les valeurs saisies
            Voiture voitureTemporaire = new Voiture(0, 0, "Temporaire", pressionAvant, pressionArriere);
            voitureTemporaire.gonflerPneusInstance(pressionAvant, pressionArriere);
        }
    }

    private static void afficherBarreChargement(int dureeMillis, String message) {
        int interval = dureeMillis / 100; // Nombre d'intervalles pour 100%
        for (int chargement = 0; chargement <= 100; chargement++) {
            try {
                Thread.sleep(interval); // Pause à chaque intervalle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String bar = new String(new char[chargement / 5]).replace("\0", "█");
            String spaces = new String(new char[20 - chargement / 5]).replace("\0", " ");
            System.out.print("\r" + message + " [" + bar + spaces + "] " + chargement + "%");
        }
        System.out.println();
    }

    public static void calculerConsommation() {
        // Code pour gonfler les pneus
        if (scanner == null) {
            System.out.println("Scanner non initialisé.");
            return;
        }

        System.out.print("Entrez la distance à parcourir (km) : ");
        double distance = scanner.nextDouble();

        if (voitureEnregistree != null) {
            double consommation = voitureEnregistree.calculerConsommationTotale(distance);
            System.out.println("La consommation pour " + distance + " km est de " + consommation + " litres.");
        } else {
            System.out.print("Entrez la consommation du moteur (litres/100 km) : ");
            double consommation = scanner.nextDouble();
            Voiture voitureGenerique = new Voiture((int) distance, consommation, "Générique", 0, 0);
            double consommationTotale = voitureGenerique.calculerConsommationTotale(distance);
            System.out.println("La consommation pour " + distance + " km est de " + consommationTotale + " litres.");
        }
    }

    // Méthodes d'instance
    public void afficherDetailsVoitureInstance() {
        System.out.println("Voiture " + idVoiture + " (" + identificationUnique + "):");
        System.out.println("Kilomètres parcourus : " + compteurKm + " km");
        System.out.println("Consommation du moteur : " + moteur.getConsommation() + " litres/100 km");
        System.out.println("Pression des pneus avant : " + pneus.getPressionPneusAvant() + " bar");
        System.out.println("Pression des pneus arrière : " + pneus.getPressionPneusArriere() + " bar");
    }

    public void gonflerPneusInstance(double nouvellePressionAvant, double nouvellePressionArriere) {
        System.out.println("Gonflage des pneus avant en cours...");
        afficherBarreChargement(5000, "Gonflage des pneus avant");
        pneus.setPressionPneusAvant(nouvellePressionAvant);
        System.out.println("Les pneus avant sont maintenant gonflés à " + pneus.getPressionPneusAvant() + " bar.");

        System.out.println("Gonflage des pneus arrière en cours...");
        afficherBarreChargement(5000, "Gonflage des pneus arrière");
        pneus.setPressionPneusArriere(nouvellePressionArriere);
        System.out.println("Les pneus arrière sont maintenant gonflés à " + pneus.getPressionPneusArriere() + " bar.");
    }


    public double calculerConsommationTotale(double distance) {
        return (distance / 100.0) * moteur.getConsommation();
    }
}
