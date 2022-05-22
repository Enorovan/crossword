package pobj.motx.tme2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Un ensemble de mots.
 * @author Enorovan + [REDACTED]
 */
public class Dictionnaire {

	//Attributes
	/** Une liste de chaine de caractères. */
	private List<String> mots = new ArrayList<>();
	/** Un cache*/
	private EnsembleLettre[] cache = null;
	
	//Methods
	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}
	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}
	/**
	 * Accès au i-eme mot du dictionnaire.
	 * @param i l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}
	/**
	 * Rend une copie de ce Dictionnaire.
	 * @return une copie identique de ce Dictionnaire.
	 */
	public Dictionnaire copy () {
		Dictionnaire copy = new Dictionnaire();
		EnsembleLettre[] newCache = null;
		if (cache != null) {
			newCache = new EnsembleLettre[cache.length];
			for (int i = 0; i < cache.length; i++) {
				if (cache[i] != null)
					newCache[i] = cache[i].copy();
			}
		}
		copy.mots.addAll(mots);
		copy.cache = newCache;
		return copy;
	}

	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param len, la longueur voulue.
	 * @return le, nombre de mots supprimés.
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt = 0;
		for (String mot: mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}
	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size ="+size();
		}
	}
	/**
	 * Convertit un fichier texte en un objet Dictionnaire.
	 * @param path, le fichier texte en entrée.
	 * @return un dictionnaire composé des mots lus dans le fichier.
	 */
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dico = new Dictionnaire();
		// Try-with-resource : cette syntaxe permet d’accéder au contenu du fichier ligne par ligne.
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			for(String line = br.readLine() ; line != null; line = br.readLine() ) {
				// Utiliser "line".
				dico.add(line);
			}
		}catch(IOException e) {
			// Problème d’accès au fichier.
			e.printStackTrace();
		}
		return dico;
	}
	
	/**
	 * Modifie le dictionnaire pour ne garder que les mots dont la ième lettre est égale au caractère de l’argument c.
	 * @param c, le caractère avec lequel on filtre.
	 * @param i, la lettre de la chaine que l'on veut égale à c.
	 * @return le nombre de mots qui ont été supprimés du dictionnaire.
	 */
	public int filtreParLettre(char c, int i) {
		int nbMotsDel = 0;
		List<String> cible = new ArrayList<>();
		for (String mot: mots) {
			if (mot.charAt(i) == c)
				cible.add(mot);
			else
				nbMotsDel++;
		}
		mots = cible;
		return nbMotsDel;
	}
	/**
	 * Modifie le dictionnaire pour ne garder que les mots EnsembleLettre qui contiennent la ième lettre du mot courant du dictionnaire.
	 * @param el, l'ensemble de lettres avec lequel on filtre.
	 * @param i, la lettre de la chaine sur laquelle on teste.
	 * @return le nombre de mots qui ont été supprimés du dictionnaire.
	 */
	public int filtreParEnsemble(EnsembleLettre el, int i) {
		int nbMotsDel = 0;
		List<String> cible = new ArrayList<>();
		for (String mot: mots) {
			if (el.contains(mot.charAt(i)))
				cible.add(mot);
			else
				nbMotsDel++;
		}
		mots = cible;
		return nbMotsDel;
	}
	/**
	 * Renvoie la liste de chaines de caractères correspondant aux mots du dictionnaire.
	 * @return la liste de chaines de caractères correspondant aux mots du dictionnaire.
	 */
	public List<String> getMots() {
		return mots;
	}
	
	public int remove(String mot) {
		int i = 0;
		for (String s: mots) {
			if (mots.get(i).equals(mot)) {
				mots.remove(s);
				return 1;
			}
		}
		return 0;
	}
}
