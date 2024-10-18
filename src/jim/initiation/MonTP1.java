package jim.initiation;

import java.util.Scanner;

public class MonTP1 {
    public static void main(String[ ] args) {
    String msg;
    String nom, prenom;

    Scanner clavier = new Scanner(System.in);
    System.out.print("Entrez votre nom :");
    nom = clavier.nextLine();
    System.out.print("Entrez votre prenom :");
    prenom = clavier.nextLine();

    nom = nom.toUpperCase();
    prenom = prenom.toLowerCase();

    msg = "Bonjour " + prenom + " " + nom + ", et bienvenue sur cette application !";

    System.out.println(msg);

    clavier.close();
    }
}

