package pobj.motx.tme1;
import java.util.List;
import java.util.ArrayList;
/**
 * Classe de représentation des emplacements des mots dans une grille.
 * @author Enorovan + [REDACTED]
 */
public class Emplacement{
	//Attributes
	/** Liste des cases (contigües) qui composent l'emplacement du mot. */
	private List<Case> lettres = new ArrayList<>();
	
	//Constructor
	/**
	 * Construit un Emplacement de mot avec une liste de cases.
	 * @param lettres, la liste de cases.
	 */
	public Emplacement(List<Case> lettres) {
		for (int i = 0; i < lettres.size(); i++) {
			this.getLettres().add(lettres.get(i));
		}
	}
	
	//Methods
	/**
	 * Affiche le mot de l'Emplacement.
	 * @return la chaine de caractères correspondant au mot.
	 */
	@Override
	public String toString(){
		String s = "";
		for(Case elmt: getLettres()){
			s += elmt.getChar();
		}
		return s;
	}
	/**
	 * Renvoie la taille de la liste de cases.
	 * @return la taille de la liste de cases.
	 */
	public int size(){
		return getLettres().size();
	}
	/**
	 * Renvoie la liste des cases.
	 * @return la liste des cases.
	 */
	public List<Case> getLettres() {
		return lettres;
	}
	/**
	 * Indique s'il existe au moins une case vide dans l'Emplacement.
	 * @return le booléen (true s'il en exuste au moins une.
	 */
	public boolean hasCaseVide() {
		boolean aCaseVide = false;
		for (Case c: lettres) {
			if (c.isVide()) aCaseVide = true;
		}
		return aCaseVide;
	}

}