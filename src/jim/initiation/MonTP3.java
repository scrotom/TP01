package jim.initiation;

public class MonTP3 {

    public static void main(String[] args) {
        String msg;
        String nom,prenom;

        nom = Outils.saisir("Entrez votre nom");
        prenom = Outils.saisir("Entrez votre prenom");

        nom = nom.toUpperCase();
        prenom = prenom.toLowerCase();

        msg = "Bonjour " + prenom + " " + nom + ", et bienvenue sur cette application !";

        Outils.afficher(msg);
    }
}
