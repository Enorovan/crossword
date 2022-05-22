package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

/**
 * Un ensemble de lettres.
 * @author Enorovan + [REDACTED]
 */
public class EnsembleLettre {
	//Attributes
	/** Une liste de char. */
	private List<Character> ensemble = new ArrayList<>();
	
	//Constructors
	/**
	 * Construit un ensemble de lettre à partir d'un dictionnaire et d'un index.
	 * @param dico, le dictionnaire.
	 * @param index, l'indice.
	 */
	public EnsembleLettre(Dictionnaire dico, int index) {
		char c;
		for (int i = 0; i < dico.size(); i++) {
			c = dico.get(i).charAt(index);
			if (!ensemble.contains(c)) {
				ensemble.add(c);
			}
		}
	}
	
	/**
	 * Construit un ensemble de lettre à partir d'une liste de caractères.
	 * @param ensemble, la liste de caractères.
	 */
	public EnsembleLettre(List<Character> ensemble) {
		List<Character> e = new ArrayList<>();
		for (char c: ensemble) {
			e.add(c);
		}
		this.ensemble = e;
	}
	
	//Methods
	/**
	 * Créer un ensemble de lettres qui est l'intersection de l'ensemble donné en argument et de l'ensemble courant.
	 * @param ensemble2, un ensemble de lettres.
	 * @return l'emsemble qui est l'intersection.
	 */
	public EnsembleLettre intersection(EnsembleLettre ensemble2) {
		EnsembleLettre ensTmp = new EnsembleLettre(this.ensemble);
		ensTmp.retainAll(ensemble2);
		return ensTmp;
	}
	/**
	 * Ajoute le caractère c à la liste de caractères.
	 * @param c, le caractère.
	 */
	public void add(char c) {
		ensemble.add(c);
	}
	/**
	 * Renvoie la taille de la liste de caractères.
	 * @return la taille de la liste de caractères.
	 */
	public int size() {
		return ensemble.size();
	}
	/**
	 * Renvoie le booléen du test qui veut savoir si la liste de caractères contient le caractère c.
	 * @param c, un caractère.
	 * @return le booléen du test qui veut savoir si la liste de caractères contient le caractère c.
	 */
	public boolean contains(char c) {
		return ensemble.contains(c);
	}
	/**
	 * Supprime les éléments de la liste courante qui ne sont pas dans l'ensemble donné en argument.
	 * @param el, un ensemble de lettres.
	 * @return le booléen (true si la liste a été modifiée).
	 */
	public boolean retainAll(EnsembleLettre el) {
		return this.ensemble.retainAll(el.ensemble);
	}
	/**
	 * Renvoie la liste de caractères.
	 * @return la liste de caractères.
	 */
	public List<Character> getEnsemble(){
		return ensemble;
	}
	
	/**
	 * Rend une copie de cet ensemble de lettres.
	 * @return une copie identique de cet EnsembleLettre.
	 */
	public EnsembleLettre copy() {
		EnsembleLettre elCopy = new EnsembleLettre(ensemble);
		
		for(char c: ensemble) {
			elCopy.add(c);
		}
		return elCopy;
	}
}
