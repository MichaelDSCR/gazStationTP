package com.formation.poe.java.gaz.station;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        menu.lancerMenu();
        scanner.close();
    }
}
