package jim.initiation;

import javax.swing.*;

public class MonTP2 {

    public static void main(String[] args) {

        String msg;
        String nom,prenom;

        msg = "Entre votre nom :";
        nom = JOptionPane.showInputDialog(null, msg, "Saisie", JOptionPane.QUESTION_MESSAGE);
        msg = "Entre votre prenom :";
        prenom = JOptionPane.showInputDialog(null, msg, "Saisie", JOptionPane.QUESTION_MESSAGE);

        nom = nom.toUpperCase();
        prenom = prenom.toLowerCase();

        msg = "Bonjour " + prenom + " " + nom + ", et bienvenue sur cette application !";

        JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
