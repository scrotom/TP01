/**
 * Classe offrant différents services courants sous forme de méthodes statiques
 * @version 2018
 * @author dPlanchet
 */

package jim.initiation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DecimalFormat; 
import javax.swing.JOptionPane;

/**
 * <b>Cette classe offre différents services courants sous forme de méthodes à portée classe.</b>
 * <p>
 * Ces services sont de différents types :
 * <ul>
 * <li>des outils de saisie et d'affichage sous forme de boîtes de dialogue</li>
 * <li>des outils concernant le traitement des nombres</li>
 * <li>des outils concernant le traitement des dates</li>
 * <li>des outils concernant le traitement des chaines</li>
 * </ul>
 * @version 1.2
 * @author dP
 */
public class Outils {

	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils de saisie et d'affichage-----------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------

	/**
	 * affiche une boite de dialogue pour saisir une donnée.
	 * @param msg   le message indiquant ce qu'il faut saisir (String)
	 * @param titre le titre de la boite de dialogue (String)
	 * @return      la chaine saisie (String)
	 */
	public static String saisir(String msg, String titre) {
		return JOptionPane.showInputDialog(null, msg, titre, JOptionPane.QUESTION_MESSAGE);
	}
	
	/**
	 * affiche une boite de dialogue pour saisir une donnée (avec un titre par défaut : "Saisie").
	 * @param msg   le message indiquant ce qu'il faut saisir (String)
	 * @return      la chaine saisie (String)
	 */
	public static String saisir(String msg) {
		return JOptionPane.showInputDialog(null, msg, "Saisie", JOptionPane.QUESTION_MESSAGE);
	}
	
	/**
	 * affiche un message dans une boite de dialogue.
	 * @param msg   le message à afficher (String)
	 * @param titre le titre de la boite de dialogue (String)
	 */
	public static void afficher(String msg, String titre) {
		JOptionPane.showMessageDialog(null, msg, titre, JOptionPane.INFORMATION_MESSAGE);
	}	
	
	/**
	 * affiche un message dans une boite de dialogue (avec un titre par défaut : "Message").
	 * @param msg   le message à afficher (String)
	 */
	public static void afficher(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils concernant le traitement des nombres-----------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * teste si une chaine est bien numérique.
	 * @param laChaine la chaine à tester (String)
	 * @return         booléen - true si la chaine représente un nombre correct
	 *                           false dans les autres cas
	 */
	public static boolean isNumeric (String laChaine) {
		if (laChaine == null) return false;
		try {
			laChaine = laChaine.replace(",", ".");
			@SuppressWarnings("unused")
			double Nombre = Double.parseDouble(laChaine);
			// new java.math.BigDecimal(laChaine);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * convertit un nombre en chaine formatée.
	 * @param unNombre le nombre à formater (double)
	 * @param unFormat le format de conversion (String) (exemples : "00", "0.00", "###,###,##0.00", ...)
	 * @return une chaine numérique formatée
	 */
	public static String formaterNombre(double unNombre, String unFormat) {
	    DecimalFormat df = new DecimalFormat(unFormat);	
		return df.format(unNombre);
	}	
	
	
	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils concernant le traitement des dates-------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------	

	/**
	 * teste si une chaine est bien une date.
	 * @param laChaine la chaine à tester (String)
	 * @return         booléen - true si la chaine représente une date correcte
	 *                             false dans les autres cas
	 */
	public static boolean isDate (String laChaine) throws ParseException {
		if (laChaine == null) return false;
		try {
			@SuppressWarnings("unused")
			Date uneDate;
			uneDate = Outils.convertirEnDate(laChaine);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}  
	
	/**
	 * convertit une chaine date en un objet Date.
	 * @param uneChaineDate   la chaine à convertir (String)
	 * @return                l'objet Date obtenu par la conversion de la chaine
	 * @throws ParseException la chaine ne peut pas être convertie en date
	 */
	public static Date convertirEnDate(String uneChaineDate) throws ParseException {
		SimpleDateFormat leFormat = new SimpleDateFormat("dd/MM/yyyy");
		return leFormat.parse(uneChaineDate);
	}

	/**
	 * convertit une date en une chaine formatée.
	 * @param uneDate la date à formater (Date)
	 * @return        la chaine formatée (String)
	 */
	public static String formaterDate(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("dd/MM/yyyy");
		return leFormat.format(uneDate);
	}

	/**
	 * convertit une date en une chaine formatée comprenant également l'heure.
	 * @param uneDate la date et l'heure à formater (Date)
	 * @return        la chaine formatée (String)
	 */
	public static String formaterDateHeure(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return leFormat.format(uneDate);
	}
	
	/**
	 * fournit le jour de la semaine à partir d'une date.
	 * @param uneDate la date étudiée (Date)
	 * @return        le jour de la semaine (exemples : "dimanche", "lundi", ...) (String)
	 */
	public static String getJourDeLaSemaine(Date uneDate)	{
		SimpleDateFormat leFormat = new SimpleDateFormat("EEEE");	// "EEEE" : jour de la semaine
		return leFormat.format(uneDate);
	}
	
	/**
	 * fournit l'année à partir d'une date.
	 * @param uneDate la date étudiée (Date)
	 * @return        l'année sur 4 chiffres (int)
	 */
	public static int getAnnee(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("yyyy");	// "yyyy" : année sur 4 chiffres
		return Integer.parseInt(leFormat.format(uneDate));
	}
	
	/**
	 * fournit une date en ajoutant des jours à une autre date.
	 * @param uneDate   la date de départ (Date)
	 * @param nbDeJours le nombre de jours à ajouter (ce nombre peut être négatif) (int)
	 * @return          la nouvelle date obtenue (Date)
	 */
	public static Date ajouterDesJours(Date uneDate, int nbDeJours) {
		Calendar calendrier = Calendar.getInstance();
		calendrier.setTime(uneDate);
		calendrier.add(Calendar.DATE, nbDeJours);
		return calendrier.getTime();
	}
	
	/**
	 * La fonction getDateUS convertit une date française (j/m/a) au format US (a-m-j).
	 * par exemple, le paramètre '16/05/2007' donnera '2007-05-16'.
	 * @param laDate la date à transformer (String)
	 * @return       la date transformée (String)
	 */
	public static String getDateUS (String laDate)
	{	String[] tableau = laDate.split ("/");		// on extrait les segments de la chaine laDate séparés par des "/"
		String J = tableau[0];
		String M = tableau[1];
		String A = tableau[2];
		return (A + "-" + M + "-" + J);				// on les reconcatène dans un ordre différent
	}

	/**
	 * La fonction getDateFR convertit une date US (a-m-j) au format Français (j/m/a).
	 * par exemple, gle paramètre '2007-05-16' donnera '16/05/2007'.
	 * @param laDate la date à transformer (String)
	 * @return       la date transformée (String)
	 */
	public static String getDateFR (String laDate)
	{	String[] tableau = laDate.split ("-");		// on extrait les segments de la chaine laDate séparés par des "-"
		String A = tableau[0];
		String M = tableau[1];
		String J = tableau[2];
		return (J + "/" + M + "/" + A);				// on les reconcatène dans un ordre différent
	}

	
	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils concernant le traitement des chaines ----------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------	

	/**
	 * complète la chaine fournie par des espaces jusqu'à la longueur désirée.
	 * @param laChaine la chaine à compléter (String)
	 * @param longueur la longueur à obtenir (int)
	 * @return         la chaine complétée (String)
	 */
	public static String completerChaine(String laChaine, int longueur) {
		while ( laChaine.length() < longueur ) {
			laChaine = laChaine + " ";
		}
		return laChaine;
	}
	
	/**
	 * complète la chaine fournie par un caractère choisi jusqu'à la longueur désirée.
	 * @param laChaine    la chaine à compléter (String)
	 * @param longueur    la longueur à obtenir (int)
	 * @param leCaractere le caractère utilisé pour compléter la chaine (char)
	 * @return            la chaine complétée (String)
	 */
	public static String completerChaine(String laChaine, int longueur, char leCaractere) {
		while ( laChaine.length() < longueur ) {
			laChaine = laChaine + leCaractere;
		}
		return laChaine;
	}	
	
	
	
}
