package jim.initiation;

public class MonTP4 {

    // méthode statique pour remettre en forme les prénoms
    public static String transformeEnPrenom(String laChaine) {
        String partie1; // la partie 1 du résultat (Première Majuscule)
        String partie2; // la partie 2 du résultat (minuscules et tiret)
        String partie3; // la partie 3 du résultat (Deuxième majuscule)
        String partie4; // la partie 4 du résultat (minuscules)
        int longueur; // longueur de la chaîne saisie
        int positionTiret; // position du tiret

        laChaine = laChaine.trim(); // supprime les espaces inutiles à gauche et à droite
        longueur = laChaine.length();

        if (longueur < 2) {
            return laChaine.toUpperCase();
        }

        positionTiret = laChaine.indexOf("-");

        if (positionTiret == -1) {
            partie1 = laChaine.substring(0, 1);
            partie2 = laChaine.substring(1, longueur);
            return partie1.toUpperCase() + partie2.toLowerCase();
        } else {
            partie1 = laChaine.substring(0, 1);
            partie2 = laChaine.substring(1, positionTiret);
            partie3 = laChaine.substring(positionTiret + 1, positionTiret + 2);
            partie4 = laChaine.substring(positionTiret + 2, longueur);
            return partie1.toUpperCase() + partie2.toLowerCase() + "-" + partie3.toUpperCase() + partie4.toLowerCase();
        }
    }

    public static void main(String[] args) {

        String nom = (Outils.saisir("Entrez votre nom").toUpperCase());
        String prenom = transformeEnPrenom(Outils.saisir("Entrez votre prenom"));

        Outils.afficher("Bonjour " + prenom + " " + nom + ", et bienvenue sur cette application !");

    }
}
