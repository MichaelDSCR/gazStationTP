package com.formation.poe.java.gaz.station;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        Voiture.setScanner(scanner); // Passer le scanner à la classe Voiture
    }

    public void afficherMenu() {
        System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
        System.out.println("★            Menu Station Service              ★");
        System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
        System.out.println("★ 1. Enregistrer les détails de la voiture     ★");
        System.out.println("★ 2. Afficher les détails de la voiture        ★");
        System.out.println("★ 3. Laver la voiture                          ★");
        System.out.println("★ 4. Gonfler les pneus de la voiture           ★");
        System.out.println("★ 5. Calculer la consommation sur une distance ★");
        System.out.println("★ 6. Quitter                                   ★");
        System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
    }

    public void afficherSousMenu() {
        System.out.println("Menu (m) ou Quitter (q) ?");
        System.out.print("Choisissez une option : ");
    }

    public void lancerMenu() {
        boolean quitter = false;
        while (!quitter) {
            afficherMenu();
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la nouvelle ligne

            switch (choix) {
                case 1 -> Voiture.enregistrerDetailsVoiture();
                case 2 -> Voiture.afficherDetailsVoiture();
                case 3 -> Voiture.laverVoiture();
                case 4 -> Voiture.gonflerPneus();
                case 5 -> Voiture.calculerConsommation();
                case 6 -> quitter = true;
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }

            if (choix != 6) {
                afficherSousMenu();
                String sousChoix = scanner.nextLine().trim().toLowerCase();
                if (sousChoix.equals("q")) {
                    quitter = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.lancerMenu();
    }
}
